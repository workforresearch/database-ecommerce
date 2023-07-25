package com.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	@Id
	private String product_ID;
	private String specification;
	private float price;
	private float discount;
	private String skus;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
}
