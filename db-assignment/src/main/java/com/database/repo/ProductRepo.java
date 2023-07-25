package com.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.database.entity.Product;

import jakarta.transaction.Transactional;

public interface ProductRepo extends JpaRepository<Product, String> {

	@Transactional
	@Query(value = "Update product set specification=:specification, price=:price, discount=:discount, skus=:skus, image=:image where product_ID=:product_ID ", nativeQuery = true)
	String updateProduct(String image, String product_ID, String specification, float price, float discount,
			String skus);

}
