package com.cekud.guud.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cekud.guud.entity.PostingEntity;
import com.cekud.guud.service.PostingService;

@Controller
@RequestMapping(value="post")
public class PostingController {

	@Autowired
	private PostingService servicePosting;
	
	@CrossOrigin
	@GetMapping(value="listdata")
	@ResponseBody
	public Page<PostingEntity> postingList(@PageableDefault(page=0, size=10, sort="idPosting", direction=Direction.DESC) Pageable pageable) {
		return servicePosting.getListData(pageable);
	}
	
	@CrossOrigin
	@GetMapping(value="viewdata")
	@ResponseBody
	public Map<String, Object> postingView(@RequestParam(value="idPosting") int idPosting){
		Map<String, Object> body = new HashMap<String, Object>();

		try {
			body = servicePosting.getViewData(idPosting);
			return body;
		}catch (IllegalArgumentException e) {
			body.put("message", e.getMessage());
			body.put("status", false);
			return body;
		}
		catch (Exception e) {
			e.printStackTrace();
			body.put("message", "terjadi kesalahan");
			body.put("status", false);
			return body;
		}
		
	}
	
	@CrossOrigin
	@GetMapping(value="listmanage")
	@ResponseBody
	public Page<PostingEntity> postingManageList(@RequestParam(value="idPerusahaan") int idPerusahaan, @PageableDefault(page=0, size=10, sort="idPosting", direction=Direction.DESC) Pageable pageable){
		return servicePosting.getListDataByPerusahaan(idPerusahaan, pageable);
	}
	
	@CrossOrigin
	@PostMapping(value="savedata")
	@ResponseBody
	public Map<String, Object> savePosting(@RequestParam String model, @RequestParam MultipartFile file) {
		Map<String, Object> body = new HashMap<String, Object>();
		
		try {
			body = servicePosting.addData(model, file);
			return body;
		}catch(IOException e) {
			body.put("message", "Simpan gambar gagal");
			body.put("status", false);
			return body;
		}catch (Exception e) {
			e.printStackTrace();
			body.put("message", "terjadi kesalahan");
			body.put("status", false);
			return body;
		}
	}
	
	@CrossOrigin
	@PostMapping(value="editdata")
	@ResponseBody
	public Map<String, Object> editPosting(@RequestParam(value="idPosting") int idPosting, @RequestParam String model, @RequestParam(required=false) MultipartFile file) {
		Map<String, Object> body = new HashMap<String, Object>();
		
		try {
			body = servicePosting.editDataByIdPosting(idPosting, model, file);
			return body;
		}catch(IOException e) {
			e.printStackTrace();
			body.put("message", "Simpan gambar gagal");
			body.put("status", false);
			return body;
		}catch (Exception e) {
			e.printStackTrace();
			body.put("message", "terjadi kesalahan");
			body.put("status", false);
			return body;
		}
	}
	
	@CrossOrigin
	@PostMapping(value="deletedata")
	@ResponseBody
	public Map<String, Object> deletePosting(@RequestParam(value="idPosting") int idPosting) {
		Map<String, Object> body = new HashMap<String, Object>();
		try {
			body = servicePosting.deleteData(idPosting);
			return body;
		}catch (Exception e) {
			e.printStackTrace();
			body.put("message", "terjadi kesalahan");
			body.put("status", false);
			return body;
		}
	}

}
