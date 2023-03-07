package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.entity.Lead;
import com.marketing.services.LeadService;
import com.marketing.util.EmailService;

@Controller
public class LeadContoller {

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private LeadService leadService;

	
	// http://localhost:8080/create
	@RequestMapping("/create")
	public String viewCreateLeadForm() {
		return "create_lead";
	}

//	@RequestMapping("/saveLead")
//	public String saveLead(Lead lead, ModelMap model) { // To display message on .jsp page
//
//		model.addAttribute("msg", "congratulation....Record has been Saved...");
//		leadService.saveOneLead(lead); // pass this to Service layer
//		return "create_lead";
//	}
	
	
	@RequestMapping("/saveLead")
	public String saveLead(Lead lead, ModelMap model) { // To display message on .jsp page

		model.addAttribute("msg", "Congratulation....Record has been Saved...");
		emailService.sendEmail(lead.getEmail(), "Welcome Email", "Test");  // To send mail
		leadService.saveOneLead(lead); // pass this to Service layer
		return "create_lead";
	}
	
	// Add jstl dependency to show msg on jsp 
	// Modelmap is similar to request.setAttribute and request.getAttribute
	
	
	// Upon clicking SAVE button on .jsp data comes here
	// http://localhost:8080/saveLead

// ---------1st way of reading data from form-----------

//	@RequestMapping("/saveLead")
//	public String saveLead(Lead lead) { 
//
//		leadService.saveOneLead(lead);  // pass this to Service layer
//		return "create_lead";
//	}

//       ----------2nd way of reading data from form-------------

//	@RequestMapping("/saveLead")
//	public String saveLead(@RequestParam("firstName") String fName, 
//							@RequestParam("lastName") String lName,
//							@RequestParam("email") String email, 
//							@RequestParam("mobile") long mobile)

	/*
	 * here 'fname' is local variable whereas 'firstName' should be same as .jsp
	 * 'name' attribute which is equal to Entity property
	 */
	
//	{
//       System.out.println(fName); 
//       System.out.println(lName);
//       System.out.println(email);
//       System.out.println(mobile);
//     
//       // only Entity class object goes to DB  
//       
//       Lead lead = new Lead();
//       lead.setFirstName(fName);
//       lead.setLastName(lName);
//       lead.setEmail(email);
//       lead.setMobile(mobile);
//       
//       leadService.saveOneLead(lead);  // pass this to Service layer
//       
//		return "create_lead";
//	}
	
//  ----------3rd way of reading data from form-------------
    // Data Transfer Object 
	
//	@RequestMapping("/saveLead")
//    public String saveLead(LeadData leadData) {
//		System.out.println(leadData.getFirstName());
//		System.out.println(leadData.getLastName());
//		System.out.println(leadData.getEmail());
//		System.out.println(leadData.getMobile());
		
	// From Non-entity class to Entity Class so to store data into DB
		
//		Lead lead = new Lead();
//		lead.setFirstName(leadData.getFirstName());
//		lead.setLastName(leadData.getLastName());
//		lead.setEmail(leadData.getEmail());
//		lead.setMobile(leadData.getMobile());
//		
//		leadService.saveOneLead(lead);  // pass this to Service layer
//		
//		return "create_lead";
//		
//	}

	// http:localhost:8080/listall

	// To get details of all records of DB

	@RequestMapping("/listall")
	public String listLeads(ModelMap model) {

		List<Lead> gotLead = leadService.getAllLeads();
		model.addAttribute("leads", gotLead); // all records(obj address) of gotLeads transfered to leads
		return "list_leads";
	}

	@RequestMapping("/delete")
	public String deleteOneLeads(@RequestParam("id") long id, ModelMap model) {

		leadService.deleteLead(id);

		List<Lead> gotLead = leadService.getAllLeads();
		model.addAttribute("leads", gotLead);

		return "list_leads";
	}

	@RequestMapping("/update")
	public String updateOneLeads(@RequestParam("id") long id, ModelMap model) {

		Lead lead = leadService.getLeadById(id);

		model.addAttribute("lead", lead);

		return "update_lead";
	}

	@RequestMapping("/updateLead")
	public String updateLeads(Lead lead, ModelMap model) {

		leadService.saveOneLead(lead); // TO save the record after the update

		// After update to redirect back to list_all page
		List<Lead> gotLead = leadService.getAllLeads();
		model.addAttribute("leads", gotLead);

		return "list_leads";
	}
	

}
