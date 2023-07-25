package com.database.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.database.entity.Product;

public interface ProductService {

	ResponseEntity<Product> getProductById(String id);

	void deleteProductById(String id);

	void saveProduct(MultipartFile file, String product_ID, String specification, float price, float discount,
			String skus);

	String updateProductDetails(MultipartFile file, String product_ID, String specification, float price,
			float discount, String skus);

}
