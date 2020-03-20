package com.cekud.guud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="perusahaan")
public class PerusahaanEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_perusahaan")
	private int idPerusahaan;
	
	@Column(name="nama_perusahaan")
	private String namaPerusahaan;
	
	@Column(name="alamat_perusahaan")
	private String alamatPerusahaan;
	
	@Column(name="bidang_perusahaan")
	private String bidangPerusahaan;

	public int getIdPerusahaan() {
		return idPerusahaan;
	}

	public void setIdPerusahaan(int idPerusahaan) {
		this.idPerusahaan = idPerusahaan;
	}

	public String getNamaPerusahaan() {
		return namaPerusahaan;
	}

	public void setNamaPerusahaan(String namaPerusahaan) {
		this.namaPerusahaan = namaPerusahaan;
	}

	public String getAlamatPerusahaan() {
		return alamatPerusahaan;
	}

	public void setAlamatPerusahaan(String alamatPerusahaan) {
		this.alamatPerusahaan = alamatPerusahaan;
	}

	public String getBidangPerusahaan() {
		return bidangPerusahaan;
	}

	public void setBidangPerusahaan(String bidangPerusahaan) {
		this.bidangPerusahaan = bidangPerusahaan;
	}
	
	
	
}
