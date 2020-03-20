package com.cekud.guud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test")
public class TestEntity {
	
	@Id
	@Column(name="no_order")
	private String noOrder;
	
	@Column(name="cuk")
	private String cuk;
	
	@Column(name="dokumen", columnDefinition = "TEXT")
	private String dokumen;
	
	@Column(name="approval_status", nullable = false, columnDefinition = "TINYINT")
	private Integer approvalStatus;
	
}
