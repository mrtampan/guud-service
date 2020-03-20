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
@Table(name="pencari_kerja")
public class PencariKerjaEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pencari_kerja")
	private int idPencariKerja;
	
	@Column(name="nama")
	private String nama;
	
	@Column(name="alamat")
	private String alamat;
	
	@Column(name="jenis_kelamin")
	private String jenisKelamin;
	
	@JsonFormat(shape=Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tanggal_lahir")
	private Date tanggalLahir;
	
	@Column(name="tempat_lahir")
	private String tempatLahir;
	
	@Column(name="pendidikan_akhir")
	private String pendidikanAkhir;
	
	@Column(name="agama")
	private String agama;

	@Column(name="id_user")
	private int idUser;
	
	@Column(name="id_perusahaan")
	private int idPerusahaan;

	public int getIdPencariKerja() {
		return idPencariKerja;
	}

	public void setIdPencariKerja(int idPencariKerja) {
		this.idPencariKerja = idPencariKerja;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
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

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

	public String getPendidikanAkhir() {
		return pendidikanAkhir;
	}

	public void setPendidikanAkhir(String pendidikanAkhir) {
		this.pendidikanAkhir = pendidikanAkhir;
	}

	public String getAgama() {
		return agama;
	}

	public void setAgama(String agama) {
		this.agama = agama;
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
	
	
}
