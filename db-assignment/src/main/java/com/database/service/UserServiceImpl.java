package com.database.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.database.entity.UserDetail;
import com.database.exceptions.ResourceNotFoundException;
import com.database.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public ResponseEntity<UserDetail> getUserById(String id) {
		// TODO Auto-generated method stub
		try {
			UserDetail userDetail = userRepo.findById(id).get();
			return ResponseEntity.ok(userDetail);
		}catch(Exception e) {
			throw new ResourceNotFoundException("User details is not present with id: "+id);
		}
	}

	@Override
	public void saveUserDetail(UserDetail userDetail) {
		// TODO Auto-generated method stub
		ResponseEntity.ok(userRepo.save(userDetail));
	}

	@Override
	public void deleteUserById(String id) {
		// TODO Auto-generated method stub
		try {
			logger.info("This is calling for delete methods");
			userRepo.deleteById(id);	
		}catch(Exception er) {
			logger.info("This is calling for delete methods");
			throw new ResourceNotFoundException("User not exist with id: "+id);
		}
	}

	@Override
	public String updateUserDetail(UserDetail userDetail) {
		// TODO Auto-generated method stub
	    userRepo.updateUserDetail(userDetail);
	    return "User updated Successfully!!";
	}

}
