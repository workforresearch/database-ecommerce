package com.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserDetail {
	@Id
	private String userId;
	private String name;
	private String email;
	private String password;
	private String access;
	@Column(length = 13)
	private String mobileNumber;
}
