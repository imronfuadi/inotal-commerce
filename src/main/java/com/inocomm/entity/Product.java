package com.inocomm.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_name", nullable = false)
//	@NotBlank(message = "Nama Produk Harus Diisi")
	private String productName;

	@Column(name = "price", nullable = false)
//	@NotNull(message = "Harga Produk Harus Diisi")
	private Long price;

	@Column(name = "pict")
	private String pict;

	@Column(name = "quantity", nullable = false)
//	@NotBlank(message = "Jumlah Produk Harus Diisi")
	private int quantity;

	@Column(name = "description", nullable = true, columnDefinition = "TEXT")
//	@NotBlank(message = "Deskripsi Produk Harus Diisi")
	private String description;

	@Transient
	public String getPhotosImagePath() {
		if (pict == null || id == null)
			return null;

		return "/assets/images/product/" + pict;
	}
	
	@ManyToOne
    @JoinColumn(name = "categories_id")
    private Categories categories;

	@ManyToMany
	@JoinTable(name = "product_categories", joinColumns = {
			@JoinColumn(name = "product_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "categories_id", referencedColumnName = "id") })
	private List<Categories> category;
}
