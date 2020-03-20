package com.cekud.guud.service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import com.cekud.guud.entity.PostingEntity;
import com.cekud.guud.repo.PostingRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PostingService {

	@Autowired
	private PostingRepo repoPosting;
	
	public Page<PostingEntity> getListData(Pageable pageable){
		return repoPosting.findAll(pageable);
	}
	
	public Map<String, Object> getViewData(int idPosting) throws IllegalArgumentException{
		Map<String, Object> body = new HashMap<String, Object>();
		PostingEntity postingData = repoPosting.findOneByIdPosting(idPosting);
		
		Assert.notNull(postingData, "Data tidak ada");
		
		body.put("status", true);
		body.put("data", postingData);
		return body;
	}
	
	public Page<PostingEntity> getListDataByPerusahaan(int idPerusahaan, Pageable pageable) {
		return repoPosting.findByIdPerusahaan(idPerusahaan, pageable);
	}
	
	public Map<String, Object> editDataByIdPosting(int idPosting, String model, MultipartFile file) throws JsonMappingException, JsonProcessingException, IOException, IllegalArgumentException{
		Map<String, Object> body = new HashMap<String, Object>();
		PostingEntity postingData = repoPosting.findOneByIdPosting(idPosting);
		
		Assert.notNull(postingData, "Data tidak ada");
		
		ObjectMapper mapper = new ObjectMapper();
		PostingEntity postingModel = mapper.readValue(model, PostingEntity.class);
		Date currentDate = new Date();
		
		if(file == null || file.isEmpty()) {
			postingData.setCreateBy(postingModel.getCreateBy());
			postingData.setCreateDate(currentDate);
			postingData.setGaji(postingModel.getGaji());
			postingData.setIsi(postingModel.getIsi());
			postingData.setJudul(postingModel.getJudul());
			postingData.setPosisi(postingModel.getPosisi());
			
			postingData = repoPosting.save(postingData);
			
			body.put("message", "Sukses");
			body.put("status", true);
			return body;
			
		}
		
		postingData.setCreateBy(postingModel.getCreateBy());
		postingData.setCreateDate(currentDate);
		postingData.setGaji(postingModel.getGaji());
		postingData.setGambar(Base64.encodeBase64String(file.getBytes()));
		postingData.setIsi(postingModel.getIsi());
		postingData.setJudul(postingModel.getJudul());
		postingData.setPosisi(postingModel.getPosisi());
		
		postingData = repoPosting.save(postingData);
		
		
		body.put("message", "Sukses");
		body.put("status", true);
		return body;
	}
	
	public Map<String, Object> addData(String model, MultipartFile file) throws JsonMappingException, JsonProcessingException, IOException{
		Map<String, Object> body = new HashMap<String, Object>();
		PostingEntity postingData = new PostingEntity();
		
		ObjectMapper mapper = new ObjectMapper();
		PostingEntity postingModel = mapper.readValue(model, PostingEntity.class);
		Date currentDate = new Date();
		
		
		postingData.setCreateBy(postingModel.getCreateBy());
		postingData.setCreateDate(currentDate);
		postingData.setGaji(postingModel.getGaji());
		postingData.setGambar(Base64.encodeBase64String(file.getBytes()));
		postingData.setIdPerusahaan(postingModel.getIdPerusahaan());
		postingData.setIsi(postingModel.getIsi());
		postingData.setJudul(postingModel.getJudul());
		postingData.setPosisi(postingModel.getPosisi());
		
		postingData = repoPosting.save(postingData);
		
		
		body.put("message", "Sukses");
		body.put("status", true);
		return body;
	}
	
	public Map<String, Object> deleteData(int idPosting) {
		Map<String, Object> body = new HashMap<String, Object>();
		
		PostingEntity postingData = repoPosting.findOneByIdPosting(idPosting);
		
		repoPosting.delete(postingData);
		
		body.put("message", "berhasil hapus");
		body.put("status", true);
		return body;
	}
	
}
