package com.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.database.entity.Notification;

import jakarta.transaction.Transactional;

public interface NotificationRepo extends JpaRepository<Notification, String> {

	@Transactional
	@Query(value = "Update Notification set status=:notification.status, mobileNumber=:notification.mobileNumber where userID=:notification.userID", nativeQuery = true)
	void updateNotification(Notification notification);

}
