package com.database.service;

import java.util.Base64;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.database.entity.Product;
import com.database.exceptions.ResourceNotFoundException;
import com.database.repo.ProductRepo;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public ResponseEntity<Product> getProductById(String id) {
		// TODO Auto-generated method stub
		Product product = productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product is not found with id: "+id));
		return ResponseEntity.ok(product);
	}

	@Override
	public void deleteProductById(String id) {
		// TODO Auto-generated method stub
		try {
			productRepo.deleteById(id);	
		}catch(Exception e) {
			throw new ResourceNotFoundException("Already product not present with ID: "+id);
		}
	}

	@Override
	public void saveProduct(MultipartFile file, String product_ID, String specification, float price, float discount,
			String skus) {
		// TODO Auto-generated method stub
		Product product = new Product();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) {
			System.out.println("not a valid file name");
		}else {
			product.setImage(Base64.getEncoder().encodeToString(fileName.getBytes()));
			product.setProduct_ID(UUID.randomUUID().toString());
			product.setSpecification(specification);
			product.setSkus(skus);
			product.setPrice(price);
			product.setDiscount(discount);
		}
		productRepo.save(product);
		
	}

	@Override
	public String updateProductDetails(MultipartFile file, String product_ID, String specification, float price,
			float discount, String skus) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) {
			System.out.println("not a valid file name");
		}else {
			fileName= Base64.getEncoder().encodeToString(fileName.getBytes());
		}
		// TODO Auto-generated method stub
		return productRepo.updateProduct(fileName, product_ID, specification, price, discount, skus);
	}

}
