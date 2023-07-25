package com.database.service;

import org.springframework.http.ResponseEntity;

import com.database.entity.Cart;

public interface CartService {

	ResponseEntity<Cart> getCartById(String id);

	void saveCartDetail(Cart cart);

	void deleteCartById(String id);

	String updateCartDetail(Cart cart);

}
