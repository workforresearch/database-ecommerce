package com.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.database.entity.Notification;
import com.database.exceptions.ResourceNotFoundException;
import com.database.repo.NotificationRepo;

@Service
public class NotificationServiceImpl implements NotificationService{
	@Autowired
	private NotificationRepo notificationRepo;

	@Override
	public ResponseEntity<Notification> getNotificationById(String id) {
		// TODO Auto-generated method stub
		Notification notification = notificationRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notification is not present with this user id: "+id));
		return ResponseEntity.ok(notification);
	}

	@Override
	public void saveNotificationDetail(Notification notification) {
		// TODO Auto-generated method stub
		try {
			notificationRepo.save(notification);
		}catch(Exception e) {
			throw new ResourceNotFoundException("notification save error: "+e.getMessage()); 
		}
	}

	@Override
	public void deleteNotificationById(String id) {
		// TODO Auto-generated method stub
		try {
			notificationRepo.deleteById(id);
		}catch(Exception e) {
			throw new ResourceNotFoundException("delete error: "+e.getMessage());
		}
		
	}

	@Override
	public String updateNotificationDetail(Notification notification) {
		// TODO Auto-generated method stub
		try {
			notificationRepo.updateNotification(notification);
		}catch(Exception e) {
			throw new ResourceNotFoundException("update error: "+e.getMessage());
		}
		return "Successfully updated";
	}

}
