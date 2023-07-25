package com.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.database.entity.UserDetail;

import jakarta.transaction.Transactional;

public interface UserRepo extends JpaRepository<UserDetail, String> {

	@Transactional
	@Query(value="update User_Detail set name=:userDetail.name, email=:userDetail.email, password=:userDetail.password, access=:userDetail.access, mobileNumber=:userDetail.mobileNumber where userId=:userDetail.userId", nativeQuery=true)
	void updateUserDetail(UserDetail userDetail);

}
