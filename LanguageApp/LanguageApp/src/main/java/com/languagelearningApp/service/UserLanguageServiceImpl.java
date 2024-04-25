package com.languagelearningApp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.languagelearningApp.model.UserLanguageQuizModel;
import com.languagelearningApp.model.UserLanguageStructureModel;
import com.languagelearningApp.model.UserLanguagesModel;
import com.languagelearningApp.repository.UserLanguageQuizRepository;
import com.languagelearningApp.repository.UserLanguageRepository;
import com.languagelearningApp.repository.UserLanguageStructureRepo;

@Service
public class UserLanguageServiceImpl implements UserLanguageService{
	
	@Autowired
	private UserLanguageRepository langrepos;
	
	@Autowired
	private UserLanguageStructureRepo langstrurepo;
	
	@Autowired
	private UserLanguageQuizRepository langquizrepo;

	@Override
	public List<UserLanguagesModel> getAllLanguages() {
		List<UserLanguagesModel> langs = langrepos.findAll();
		
		return langs.stream().map((lan)->mapTolang(lan)).collect(Collectors.toList());
	}

	
	private UserLanguagesModel mapTolang(UserLanguagesModel langMod){
        UserLanguagesModel langsMod = new UserLanguagesModel();
        langsMod.setLanguages(langMod.getLanguages());
        return langsMod;
    }


	@Override
	public UserLanguagesModel saveLang(UserLanguagesModel userLanMod) {
		// TODO Auto-generated method stub
		return langrepos.save(userLanMod);
	}


	@Override
	public List<UserLanguageStructureModel> getAllLanguageStructure() {
		List<UserLanguageStructureModel> langStru = langstrurepo.findAll();
		
		return langStru.stream().map((l)->mapToLangs(l)).collect(Collectors.toList());
	}
	
	private UserLanguageStructureModel mapToLangs(UserLanguageStructureModel langstruMod) {
		UserLanguageStructureModel langs_stru_Mod = new UserLanguageStructureModel();
		langs_stru_Mod.setLanguages(langstruMod.getLanguages());
		langs_stru_Mod.setLevel(langstruMod.getLevel());
		langs_stru_Mod.setEnglish_word(langstruMod.getEnglish_word());
		langs_stru_Mod.setLanguage_word(langstruMod.getLanguage_word());
		langs_stru_Mod.setWord_spell_in_english(langstruMod.getWord_spell_in_english());
		return langstruMod;
		
	}


	@Override
	public List<UserLanguageQuizModel> getAllLanguageQuiz() {
		List<UserLanguageQuizModel> langQuiz = langquizrepo.findAll();
		
		return langQuiz.stream().map(this::mapToLangs).collect(Collectors.toList());
	}
	
	private UserLanguageQuizModel mapToLangs(UserLanguageQuizModel langquizMod) {
		UserLanguageQuizModel langs_quiz_Mod = new UserLanguageQuizModel();
		langs_quiz_Mod.setLevel(langquizMod.getLevel());
		langs_quiz_Mod.setLanguage(langquizMod.getLanguage());
		langs_quiz_Mod.setQuestion(langquizMod.getQuestion());
		langs_quiz_Mod.setOptions(langquizMod.getOptions());
		langs_quiz_Mod.setAnswer(langquizMod.getAnswer());
		return langquizMod;
		
	}
}
