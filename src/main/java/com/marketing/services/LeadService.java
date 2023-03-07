package com.marketing.services;

import java.util.List;

import com.marketing.entity.Lead;

public interface LeadService {

	void saveOneLead(Lead lead);
	
	List<Lead> getAllLeads();

	void deleteLead(long id);

	Lead getLeadById(long id);

}
