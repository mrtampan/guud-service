package com.cekud.guud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name="posting")
public class PostingEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_posting")
	private int idPosting;
	
	@Column(name="judul")
	private String judul;

	@Lob
	@Column(name="gambar", length=512)
	private String gambar;
	
	@Lob
	@Column(name="isi", length=512)
	private String isi;
	
	@Column(name="gaji")
	private String gaji;
	
	@Column(name="posisi")
	private String posisi;
	
	@JsonFormat(shape=Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_by")
	private String createBy;
	
	@Column(name="id_perusahaan")
	private int idPerusahaan;

	public int getIdPosting() {
		return idPosting;
	}

	public void setIdPosting(int idPosting) {
		this.idPosting = idPosting;
	}

	public String getJudul() {
		return judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public String getGambar() {
		return gambar;
	}

	public void setGambar(String gambar) {
		this.gambar = gambar;
	}

	public String getIsi() {
		return isi;
	}

	public void setIsi(String isi) {
		this.isi = isi;
	}

	public String getGaji() {
		return gaji;
	}

	public void setGaji(String gaji) {
		this.gaji = gaji;
	}

	public String getPosisi() {
		return posisi;
	}

	public void setPosisi(String posisi) {
		this.posisi = posisi;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public int getIdPerusahaan() {
		return idPerusahaan;
	}

	public void setIdPerusahaan(int idPerusahaan) {
		this.idPerusahaan = idPerusahaan;
	}
	
	
}
