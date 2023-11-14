package com.issuer.issuerms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.issuer.model.Issuer;


@RestController
public class IssuermsController {
	
	@Autowired
	private IssuerRepository issuerRepository;
	
	@Value("{$server.port}")
	private String port;
	
	@GetMapping("/fetchIssuerIssueDetails/{isbn}")
	public ResponseEntity<Issuer>fetchSingleRecord(@PathVariable(value="isbn") String isbn){


        if (issuerRepository.findById(isbn).isPresent())
        {
			return ResponseEntity.ok(issuerRepository.findById(isbn).get());

        }
       else
        {
            return ResponseEntity.badRequest().body(null);
        }
}
	@PostMapping("createIssuerRecord")
	public ResponseEntity<String> createNewIssuerRecord(@RequestBody Issuer Issuer){
		
		issuerRepository.save(Issuer);
		return ResponseEntity.ok("Created Issuer record successfully:"+ port);
	}
	
	@PutMapping("updateIssuer/{custid}/{isbn}")
	public Issuer updateStudent(@RequestBody Issuer issuer,@PathVariable(value="isbn") String isbn,@PathVariable(value="custid") String custid){
		Issuer issuerUpdate=issuerRepository.findById(isbn).get();
		if(issuerUpdate.getIsbn().equals(isbn) && issuerUpdate.getCustId().equals(custid)) {
			issuerUpdate.setNoOfCopies(issuer.getNoOfCopies());
		}
		 return this.issuerRepository.save(issuerUpdate);
	}
		
		
}
