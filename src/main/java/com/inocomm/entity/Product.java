package com.inocomm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "product_name", nullable = false)
	private String productName;
	
	@Column(name = "price", nullable = false)
	private Long price;
	
	@Column(name = "pict")
	private String pict;
	
	@Column(name = "quantity", nullable = false)
	private Long quantity;
	
	@Column(name = "description", nullable = true, columnDefinition = "TEXT")
	private String description;

	@Transient
    public String getPhotosImagePath() {
        if (pict == null || id == null) return null;
         
        return "/assets/images/product/" + pict;
//        return "/user-photos/" + id + "/" + pict;
    }
}
