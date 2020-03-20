package com.cekud.guud.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class PenerimaPerusahaanUser {
	
	private String namaPerusahaan;
	
	private String alamatPerusahaan;
	
	private String bidangPerusahaan;
	
	private String nama;

	private String jabatan;
	
	private String alamat;
	
	private String jenisKelamin;
	
	private String username;

	private String password;
	
	private String tempatLahir;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date tanggalLahir;

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

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getJabatan() {
		return jabatan;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

	
	
	
}
