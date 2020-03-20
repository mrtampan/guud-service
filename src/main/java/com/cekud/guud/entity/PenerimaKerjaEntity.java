package com.cekud.guud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name="penerima_kerja")
public class PenerimaKerjaEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_penerima_kerja")
	private int idPenerimaKerja;
	
	@Column(name="nama")
	private String nama;
	
	@Column(name="jabatan")
	private String jabatan;
	
	@Column(name="alamat")
	private String alamat;
	
	@Column(name="jenis_kelamin")
	private String jenisKelamin;
	
	@Column(name="tempat_lahir")
	private String tempatLahir;
	
	@JsonFormat(shape=Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tanggal_lahir")
	private Date tanggalLahir;
	
	@Column(name="id_user")
	private int idUser;
	
	@Column(name="id_perusahaan")
	private int idPerusahaan;

	public int getIdPenerimaKerja() {
		return idPenerimaKerja;
	}

	public void setIdPenerimaKerja(int idPenerimaKerja) {
		this.idPenerimaKerja = idPenerimaKerja;
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

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdPerusahaan() {
		return idPerusahaan;
	}

	public void setIdPerusahaan(int idPerusahaan) {
		this.idPerusahaan = idPerusahaan;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}
	
	
	
	
}
