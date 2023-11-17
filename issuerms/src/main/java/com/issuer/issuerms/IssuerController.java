package com.issuer.issuerms;


import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.issuer.issuerms.model.Book;
import com.issuer.issuerms.model.Issuer;


@RestController
public class IssuerController {
	
	@Autowired
	IssuerRepository issuerRepository;
	
	@Autowired
	WebClient.Builder webClientBuilder;
	
	@GetMapping("fetchAllIssuerDetails")
	public ResponseEntity<List<Issuer>> fetchAllIssueDetails(){
		
		return ResponseEntity.ok(issuerRepository.findAll());
	}
	@GetMapping("/fetchSingleRecord/{isbn}")
	public ResponseEntity<Issuer>fetchSingleIssuer(@PathVariable(value="isbn") String isbn){


        if (issuerRepository.findById(isbn).isPresent())
        {
			return ResponseEntity.ok(issuerRepository.findById(isbn).get());

        }
       else
        {
            return ResponseEntity.badRequest().body(null);
        }
}
	@PostMapping("/createNewIssuerRecord")
	public ResponseEntity<String> createNewIssuer(@RequestBody Issuer Issuer){
		
		issuerRepository.save(Issuer);
		return ResponseEntity.ok("Created Issuer record successfully:");
	}
	@DeleteMapping("/CancelIssueOrder/{isbn}")
	public String deleteIssuer(@PathVariable(value="isbn") String isbn){
		
		 if (issuerRepository.findById(isbn) != null)   {
			 issuerRepository.deleteById(isbn);
			 return "Deleted Issuer record successfully";
	        }
		 else
	        {
	            return null;
	        }
	}
	@PutMapping("/updateIssuer/{isbn}/{custId}")
	public Issuer updateIssuer(@RequestBody Issuer issuer,@PathVariable(value="isbn") String isbn,@PathVariable(value="custId") String custId){
		Issuer issuerUpdate=issuerRepository.findById(isbn).get();
		if( issuer.getCustId()== issuerUpdate.getCustId()) {
			issuerUpdate.setNoOfCopiesNote(issuer.getNoOfCopiesNote());
		}
		return this.issuerRepository.save(issuerUpdate);
	}
    
	@GetMapping("/bookms/checkBookAvailability")
	public String checkBookAvailability(){
		
		String str=null;
		JsonNode node=null;
		Book book;
		
		str= webClientBuilder.build().get().uri("http://localhost:8081/fetchSingleRecord/ISBN 24688")
				.retrieve().bodyToMono(String.class).block();
		
		//Integer availableCopies=Integer.parseInt(book.getTotalCopies())-Integer.parseInt(book.getIssuedCopies());
		//JSONArray jo=new JSONArray(str);
		 
		// System.out.println(availableCopies);
		
		
		ObjectMapper objectMapper=new ObjectMapper();
		
		try {
			book=objectMapper.readValue(str, Book.class);
			System.out.println(book);
			System.out.println(book.getTotalCopies()-book.getIssuedCopies());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
		
	}

	

}
