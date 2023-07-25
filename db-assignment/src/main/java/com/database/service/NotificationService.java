package com.database.service;

import org.springframework.http.ResponseEntity;

import com.database.entity.Notification;

public interface NotificationService {

	ResponseEntity<Notification> getNotificationById(String id);

	void saveNotificationDetail(Notification notification);

	void deleteNotificationById(String id);

	String updateNotificationDetail(Notification notification);

}
