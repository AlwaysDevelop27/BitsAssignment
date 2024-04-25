package com.languagelearningApp.service;

import java.util.List;

import com.languagelearningApp.model.UserLanguageQuizModel;
import com.languagelearningApp.model.UserLanguageStructureModel;
import com.languagelearningApp.model.UserLanguagesModel;


public interface UserLanguageService {
	
	 public UserLanguagesModel saveLang(UserLanguagesModel userLangMod);
	   List<UserLanguagesModel> getAllLanguages();
	   List<UserLanguageStructureModel> getAllLanguageStructure();
	   List<UserLanguageQuizModel> getAllLanguageQuiz();
	 

}
