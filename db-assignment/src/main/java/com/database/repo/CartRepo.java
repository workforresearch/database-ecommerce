package com.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.database.entity.Cart;

import jakarta.transaction.Transactional;

public interface CartRepo extends JpaRepository<Cart, String> {

	@Transactional
	@Query(value = "Update Cart set productCount=:cart.productCount where productId=:cart.productId and userId=:cart.userId", nativeQuery = true)
	void updateCart(Cart cart);
}
