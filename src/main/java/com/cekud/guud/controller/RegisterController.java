package com.cekud.guud.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cekud.guud.service.RegisterService;

@Controller
@RequestMapping(value="register")
public class RegisterController {
	
	@Autowired
	private RegisterService serviceRegister;

	@PostMapping(value="publisher")
	@CrossOrigin
	@ResponseBody
	public Map<String, Object> savePublisher(@RequestParam String model) {
		Map<String, Object> body = new HashMap<String, Object>();
		try {
			return serviceRegister.savePencariKerja(model);	
		}catch (IllegalArgumentException e) {
			body.put("status", false);
			body.put("message", e.getMessage());
			return body;
		}catch(Exception e) {
			e.printStackTrace();
			body.put("status", false);
			body.put("message", "terjadi kesalahan");
			return body;
		}
		
	}
	
	@PostMapping(value="advertiser")
	@CrossOrigin
	@ResponseBody
	public Map<String, Object> saveAdvertiser(@RequestParam String model) {
		Map<String, Object> body = new HashMap<String, Object>();
		try {
			return serviceRegister.savePenerimaKerja(model);
		}catch (IllegalArgumentException e) {
			body.put("status", false);
			body.put("message", e.getMessage());
			return body;
		}catch (Exception e) {
			e.printStackTrace();
			body.put("status", false);
			body.put("message", "terjadi kesalahan");
			return body;
		}
	}
}
