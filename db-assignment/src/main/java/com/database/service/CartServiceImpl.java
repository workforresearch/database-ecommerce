package com.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.database.entity.Cart;
import com.database.exceptions.ResourceNotFoundException;
import com.database.repo.CartRepo;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartRepo cartRepo;

	@Override
	public ResponseEntity<Cart> getCartById(String id) {
		// TODO Auto-generated method stub
		Cart cart = cartRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart is no present with id: "+id));
		return ResponseEntity.ok(cart);
	}

	@Override
	public void saveCartDetail(Cart cart) {
		// TODO Auto-generated method stub
		try {
		cartRepo.save(cart);
		}catch(Exception e) {
			throw new ResourceNotFoundException("Database error: "+e.getMessage());
		}
	}

	@Override
	public void deleteCartById(String id) {
		// TODO Auto-generated method stub
		try {
			cartRepo.deleteById(id);
		}catch(Exception e) {
			throw new ResourceNotFoundException("delete error: "+e.getMessage());
		}
	}

	@Override
	public String updateCartDetail(Cart cart) {
		// TODO Auto-generated method stub
		try {
			cartRepo.updateCart(cart);
		}catch(Exception e) {
			throw new ResourceNotFoundException("update error: "+e.getMessage());
		}
		return null;
	}

}
