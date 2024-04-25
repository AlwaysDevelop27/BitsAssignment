package com.languagelearningApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.languagelearningApp.model.UserRegisterModel;

@Repository
public interface UserRepository extends JpaRepository<UserRegisterModel, Long>{

	

}
