package com.cekud.guud.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cekud.guud.entity.PerusahaanEntity;
import com.cekud.guud.repo.PerusahaanRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PerusahaanService {

	@Autowired
	private PerusahaanRepo repoPerusahaan;
	
	public Map<String, Object> viewData(int idPerusahaan) {
		Map<String, Object> body = new HashMap<String, Object>();
		PerusahaanEntity perusahaanData = repoPerusahaan.findOneByIdPerusahaan(idPerusahaan);
		
		body.put("status", true);
		body.put("data", perusahaanData);
		
		return body;
	}
	
	public Map<String, Object> editData(int idPerusahaan, String model) throws JsonProcessingException, JsonMappingException {
		Map<String, Object> body = new HashMap<String, Object>();
		PerusahaanEntity perusahaanData = repoPerusahaan.findOneByIdPerusahaan(idPerusahaan);
		ObjectMapper mapper = new ObjectMapper();
		PerusahaanEntity perusahaanModel = mapper.readValue(model, PerusahaanEntity.class);
		
		perusahaanData.setNamaPerusahaan(perusahaanModel.getNamaPerusahaan());
		perusahaanData.setAlamatPerusahaan(perusahaanModel.getAlamatPerusahaan());
		perusahaanData.setBidangPerusahaan(perusahaanModel.getBidangPerusahaan());
		perusahaanData = repoPerusahaan.save(perusahaanData);
		
		body.put("message", "Berhasil Ubah Data");
		body.put("status", true);
		return body;
	}
	
}
