package com.marketing.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entity.Lead;
import com.marketing.repository.LeadRepository;

// This layer gives API

@RestController       // makes as web-service layer
@RequestMapping("/api/leads")         // http://localhost:8080/api/leads
public class LeadRestController {

	@Autowired
	private LeadRepository leadRepo;
	
	 @GetMapping      // get all methods from DataBase and put it in json objects
	public List<Lead> getAllLeads()
	{
		List<Lead> leads = leadRepo.findAll();  // findAll() from repo takes data from DB
		return leads;
	}
	
	
	@PostMapping    // saves the data  
	public void saveOneLead(@RequestBody Lead leaddd) { // @RequestBody converts json to java object
		
		leadRepo.save(leaddd);
	}
	
	@PutMapping    // update the data  
	public void updateOneLead(@RequestBody Lead lead) {     
		
		leadRepo.save(lead);
	}
	
	@DeleteMapping("/delete/{id}")         // PathParameter type of URL  
	public void deleteOneLead(@PathVariable("id") long idd) {     // @PathVariable 
		
		leadRepo.deleteById(idd);
	}
	
	
	@RequestMapping("/find/{id}")        // @GetMapping()  can also be used      
	public Lead getOneLead(@PathVariable("id") long idddd) {     // @PathVariable 
		
		Optional<Lead> gotLead = leadRepo.findById(idddd);
		Lead lead = gotLead.get();                               // get() to convert optional class to required class
		
		return lead;
	}
	
}
