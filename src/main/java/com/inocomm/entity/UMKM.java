package com.inocomm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="t_umkm")
@AllArgsConstructor
@NoArgsConstructor
public class UMKM {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "merk")
	private String merk;
	
	@Column(name = "nama_pemilik")
	private String pemilik;
	
	@Column(name = "nik")
	private String nik;
	
	@Column(name = "alamat_pemilik")
	private String alamat;
}
