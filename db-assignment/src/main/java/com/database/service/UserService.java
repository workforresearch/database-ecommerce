package com.database.service;

import org.springframework.http.ResponseEntity;

import com.database.entity.UserDetail;

public interface UserService {

	ResponseEntity<UserDetail> getUserById(String id);

	void saveUserDetail(UserDetail userDetail);

	void deleteUserById(String id);

	String updateUserDetail(UserDetail userDetail);

}
