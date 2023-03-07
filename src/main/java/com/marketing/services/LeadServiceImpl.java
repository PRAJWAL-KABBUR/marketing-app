package com.marketing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.entity.Lead;
import com.marketing.repository.LeadRepository;

@Service
	public class LeadServiceImpl implements LeadService {

		@Autowired
		private LeadRepository leadRepo;
		
		@Override
		public void saveOneLead(Lead lead) {
			
			leadRepo.save(lead);
		}

		@Override
		public List<Lead> getAllLeads() {
			
			List<Lead> gotLead = leadRepo.findAll();  // findAll() is in JPARepository which we have implemented
			
			return gotLead;
		}

		@Override
		public void deleteLead(long id) {
			
			leadRepo.deleteById(id);
			
		}

		@Override
		public Lead getLeadById(long id) {

			Optional<Lead> findById = leadRepo.findById(id);
			Lead lead = findById.get();
			
			return lead;
		}


	}


