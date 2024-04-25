package com.languagelearningApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.languagelearningApp.model.UserLanguageQuizModel;
import com.languagelearningApp.model.UserLanguageStructureModel;
import com.languagelearningApp.model.UserLanguagesModel;
import com.languagelearningApp.repository.UserLanguageRepository;
import com.languagelearningApp.service.UserLanguageServiceImpl;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class UserLanguageController {
	
	@Autowired
	private UserLanguageRepository langRepo;
	
	@Autowired
	private UserLanguageServiceImpl langSer;
	
	/*
	 * @PostMapping("/language") public String saveUserLang(@RequestBody
	 * UserLanguagesModel userLanguagesModel) { langRepo.save(userLanguagesModel);
	 * 
	 * return "User language added successfully"; }
	 */
	
	@GetMapping("/languages")
	public ResponseEntity<List<UserLanguagesModel>> getAllLanguages(){
		    List<UserLanguagesModel> langg = langSer.getAllLanguages();
	        return ResponseEntity.ok(langg);
	
	}
	
	@GetMapping("/languages_structure")
	public ResponseEntity<List<UserLanguageStructureModel>> getAllLanguageStructure(){
	    List<UserLanguageStructureModel> lang_stru = langSer.getAllLanguageStructure();
        return ResponseEntity.ok(lang_stru);

}
	
	@GetMapping("/languages_quiz")
	public ResponseEntity<List<UserLanguageQuizModel>> getAllLanguageQuiz(){
	    List<UserLanguageQuizModel> lang_quiz = langSer.getAllLanguageQuiz();
        return ResponseEntity.ok(lang_quiz);

}
	
	

}
