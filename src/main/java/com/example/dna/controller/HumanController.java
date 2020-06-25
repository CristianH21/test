package com.example.dna.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dna.entity.Human;
import com.example.dna.repository.HumanRepository;
import com.example.dna.service.DNAService;

@Controller
@CrossOrigin
@RequestMapping("/api/v1")
public class HumanController {

	@Autowired
	private HumanRepository humanRepository;
	
	@Autowired
	private DNAService dnaService;
	
	
	@GetMapping("/humans")
	public ResponseEntity<?> getAllHumans() {
		
		List<Human> humanList = humanRepository.findAll();
		return ResponseEntity.ok(humanList);
	}
	
	@PostMapping("/humans")
	public ResponseEntity<?> createHuman(@Validated @RequestBody Human human) {
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		
		human.setCreatedOn(date);
		human.setMutation(dnaService.generateDNA());
		
		Human createdHuman = humanRepository.save(human);
		
		return ResponseEntity.ok(createdHuman);
	}
	
}
