package com.example.dna.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dna.entity.DNA;
import com.example.dna.entity.Human;
import com.example.dna.entity.Stats;
import com.example.dna.repository.HumanRepository;
import com.example.dna.service.DNAService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class DNAController {

	@Autowired
	private DNAService dnaService;
	
	@Autowired
	private HumanRepository humanRepository;
	
	@GetMapping("/stats")
	public ResponseEntity<?> getStats() {
		int countMutation = 0;
		int countNoMutation = 0;
		double ratio = 0.0;
		
		List<Human> humanList = humanRepository.findAll();
		for (int i = 0; i < humanList.size(); i++) {
			if (humanList.get(i).isMutation())
				countMutation++;
			else
				countNoMutation++;
		}
		
		ratio = countMutation / (countNoMutation == 0 ? 1 : countNoMutation);
		
		Stats stats = new Stats(countMutation, countNoMutation, ratio);
		
		return ResponseEntity.status(200).body(stats);
	}
	
	@PostMapping("/mutation")
	public ResponseEntity<?> hasMutation(@RequestBody DNA dna) {
		
		return dnaService.checkMutation(dna) ? 
				ResponseEntity.status(200).body("Has mutation.") : 
				ResponseEntity.status(403).body("Does not have mutation.");
	}
	
	
}
