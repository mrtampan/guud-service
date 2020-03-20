package com.cekud.guud.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.cekud.guud.dto.PencariUser;
import com.cekud.guud.dto.PenerimaPerusahaanUser;
import com.cekud.guud.entity.PencariKerjaEntity;
import com.cekud.guud.entity.PenerimaKerjaEntity;
import com.cekud.guud.entity.PerusahaanEntity;
import com.cekud.guud.entity.UserEntity;
import com.cekud.guud.repo.PencariKerjaRepo;
import com.cekud.guud.repo.PenerimaKerjaRepo;
import com.cekud.guud.repo.PerusahaanRepo;
import com.cekud.guud.repo.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RegisterService {

	@Autowired
	private PencariKerjaRepo repoPencariKerja;
	
	@Autowired
	private PenerimaKerjaRepo repoPenerimaKerja;
	
	@Autowired
	private PerusahaanRepo repoPerusahaan;
	
	@Autowired
	private UserRepo repoUser;
	
	@Transactional
	public Map<String, Object> savePencariKerja(String model) throws JsonMappingException, JsonProcessingException, IllegalArgumentException {
		Map<String, Object> body = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		PencariUser pencariUserData = mapper.readValue(model, PencariUser.class);
		
		PencariKerjaEntity pencariKerjaData = new PencariKerjaEntity();
		UserEntity userData = new UserEntity();
		
		pencariKerjaData.setAgama(pencariUserData.getAgama());
		pencariKerjaData.setAlamat(pencariUserData.getAlamat());
		pencariKerjaData.setJenisKelamin(pencariUserData.getJenisKelamin());
		pencariKerjaData.setNama(pencariUserData.getNama());
		pencariKerjaData.setPendidikanAkhir(pencariUserData.getPendidikanAkhir());
		pencariKerjaData.setTanggalLahir(pencariUserData.getTanggalLahir());
		pencariKerjaData.setTempatLahir(pencariUserData.getTempatLahir());
		
		
		userData.setUsername(pencariUserData.getUsername());
		userData.setPassword(pencariUserData.getPassword());
		userData.setRole("publisher");
		
		Assert.notNull(pencariKerjaData, "Gagal Input Data Publisher");
		Assert.notNull(userData, "Gagal Input Data Login");
		
		pencariKerjaData = repoPencariKerja.save(pencariKerjaData);
		userData = repoUser.save(userData);
		
		
		body.put("status", true);
		body.put("message", "sukses");
		return body;
	}
	
	@Transactional
	public Map<String, Object> savePenerimaKerja(String model) throws JsonMappingException, JsonProcessingException, IllegalArgumentException {
		Map<String, Object> body = new HashMap<String, Object>();
		PenerimaPerusahaanUser penerimaPerusahaanData = new PenerimaPerusahaanUser();
		ObjectMapper mapper = new ObjectMapper();
		penerimaPerusahaanData = mapper.readValue(model, PenerimaPerusahaanUser.class);
		
		PerusahaanEntity perusahaanData = new PerusahaanEntity();
		perusahaanData.setNamaPerusahaan(penerimaPerusahaanData.getNamaPerusahaan());
		perusahaanData.setAlamatPerusahaan(penerimaPerusahaanData.getAlamatPerusahaan());
		perusahaanData.setBidangPerusahaan(penerimaPerusahaanData.getBidangPerusahaan());
		perusahaanData = repoPerusahaan.save(perusahaanData);
		
		Assert.notNull(perusahaanData, "Gagal Input Data Perusahaan");
		
		if(perusahaanData.getIdPerusahaan() < 0) {
			body.put("status", false);
			return body;
		}
		
		UserEntity userData = new UserEntity();
		userData.setUsername(penerimaPerusahaanData.getUsername());
		userData.setPassword(penerimaPerusahaanData.getPassword());
		userData.setRole("advertiser");
		
		Assert.notNull(userData, "Gagal Input Data Advertiser");
		
		userData = repoUser.save(userData);
		
		PenerimaKerjaEntity penerimaKerjaData = new PenerimaKerjaEntity();
		penerimaKerjaData.setIdPerusahaan(perusahaanData.getIdPerusahaan());
		penerimaKerjaData.setAlamat(penerimaPerusahaanData.getAlamat());
		penerimaKerjaData.setJabatan(penerimaPerusahaanData.getJabatan());
		penerimaKerjaData.setJenisKelamin(penerimaPerusahaanData.getJenisKelamin());
		penerimaKerjaData.setNama(penerimaPerusahaanData.getNama());
		penerimaKerjaData.setTanggalLahir(penerimaPerusahaanData.getTanggalLahir());
		penerimaKerjaData.setTempatLahir(penerimaPerusahaanData.getTempatLahir());
		penerimaKerjaData.setIdUser(userData.getIdUser());
		
		penerimaKerjaData = repoPenerimaKerja.save(penerimaKerjaData);
		
		Assert.notNull(penerimaKerjaData, "Gagal Input Data Advertiser");
		
//		pencariKerjaData = repoPencariKerja.save(pencariKerjaData);
//		
//		if(pencariKerjaData.getIdPencariKerja() < 0) {
//			body.put("status", false);
//			return body;
//		}
		
		body.put("status", true);
		body.put("message", "sukses");
		return body;
	}
}
