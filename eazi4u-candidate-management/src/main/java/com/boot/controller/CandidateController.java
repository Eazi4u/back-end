package com.boot.controller;

import java.util.List;

import com.boot.model.Candidate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.repository.CandidateRepository;

@RestController
@RequestMapping("api/v1/")
public class CandidateController {
	
	@Autowired
	private CandidateRepository candidateRepository;

	@RequestMapping(value = "get-all-candidates", method = RequestMethod.GET)
	public List<Candidate> list() {
		return candidateRepository.findAll();
	}

	@RequestMapping(value = "create-candidate", method = RequestMethod.POST)
	public Candidate create(@RequestBody Candidate candidate) {
		return candidateRepository.saveAndFlush(candidate);
	}

	@RequestMapping(value = "get-candidate/{id}", method = RequestMethod.GET)
	public Candidate get(@PathVariable Long id) {
		return candidateRepository.findOne(id);
	}

	@RequestMapping(value = "update-candidate/{id}", method = RequestMethod.PUT)
	public Candidate update(@PathVariable Long id, @RequestBody Candidate candidate) {
		Candidate existingCandidate = candidateRepository.findOne(id);
		BeanUtils.copyProperties(candidate, existingCandidate);
		return candidateRepository.saveAndFlush(existingCandidate);
	}

	@RequestMapping(value = "remove-candidate/{id}", method = RequestMethod.DELETE)
	public Candidate delete(@PathVariable Long id) {
		Candidate existingCandidate = candidateRepository.findOne(id);
		candidateRepository.delete(existingCandidate);
		return existingCandidate;
	}
	
}
