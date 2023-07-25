package com.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.database.entity.Cart;
import com.database.entity.Notification;
import com.database.entity.Product;
import com.database.entity.UserDetail;
import com.database.service.CartService;
import com.database.service.NotificationService;
import com.database.service.ProductService;
import com.database.service.UserService;

@RestController
public class WebDBController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CartService cartService;
	@Autowired
	private NotificationService notificationService;
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String home() {
		return "Application is running";
	}
	
	@PostMapping("/product")
	public void saveProduct(@RequestParam("file") MultipartFile file,
			@RequestParam("product_ID") String product_ID,
			@RequestParam("specification") String specification,
			@RequestParam("price") float price,
			@RequestParam("discount") float discount,
			@RequestParam("skus") String skus) {
		productService.saveProduct(file, product_ID, specification, price, discount, skus);		
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductByID(@PathVariable String id) {
		return  productService.getProductById(id);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteProductById(@PathVariable("id") String id) {
		productService.deleteProductById(id);
	}
	
	@PutMapping("/update")
	public String updateProductById(@RequestParam("file") MultipartFile file,
			@RequestParam("product_ID") String product_ID,
			@RequestParam("specification") String specification,
			@RequestParam("price") float price,
			@RequestParam("discount") float discount,
			@RequestParam("skus") String skus) {
		return productService.updateProductDetails(file, product_ID, specification, price, discount, skus);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserDetail> getUserById(@PathVariable("id") String id){
		return userService.getUserById(id);
	}
	
	@PostMapping("user")
	public void saveUser(@RequestBody UserDetail userDetail) {
		userService.saveUserDetail(userDetail);
	}
	
	@DeleteMapping("user/delete/{id}")
	public void deleteUserById(@PathVariable("id") String id) {
		userService.deleteUserById(id);
	}
	
	@PutMapping("/user/update")
	public String updateUser(@RequestBody UserDetail userDetail) {
		return userService.updateUserDetail(userDetail);
	}
	
	@GetMapping("/cart/{id}")
	public ResponseEntity<Cart> getCartById(@PathVariable("id") String id){
		return cartService.getCartById(id);
	}
	
	@PostMapping("cart")
	public void saveCart(@RequestBody Cart cart) {
		cartService.saveCartDetail(cart);
	}
	
	@DeleteMapping("cart/delete/{id}")
	public void deleteCartById(@PathVariable("id") String id) {
		cartService.deleteCartById(id);
	}
	
	@PutMapping("cart/update")
	public String updateCart(@RequestBody Cart cart) {
		return cartService.updateCartDetail(cart);
	}
	
	@GetMapping("/notification/{id}")
	public ResponseEntity<Notification> getNotificationById(@PathVariable("id") String id){
		return notificationService.getNotificationById(id);
	}
	
	@PostMapping("notification")
	public void saveUser(@RequestBody Notification notification) {
		notificationService.saveNotificationDetail(notification);
	}
	
	@DeleteMapping("notification/delete/{id}")
	public void deleteNotificationById(@PathVariable("id") String id) {
		notificationService.deleteNotificationById(id);
	}
	
	@PutMapping("/notification/update")
	public String updateNotification(@RequestBody Notification notification) {
		return notificationService.updateNotificationDetail(notification);
	}
}
