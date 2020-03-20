package com.cekud.guud.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cekud.guud.service.PerusahaanService;

@Controller
@RequestMapping(value="pt")
public class PerusahaanController {

	@Autowired
	private PerusahaanService servicePerusahaan;
	
	@CrossOrigin
	@GetMapping(value="viewdata")
	@ResponseBody
	public Map<String, Object> perusahaanView(@RequestParam(value="idPerusahaan") int idPerusahaan){
		return servicePerusahaan.viewData(idPerusahaan);
	}
	
	@CrossOrigin
	@PostMapping(value="editdata")
	@ResponseBody
	public Map<String, Object> perusahaanEdit(@RequestParam(value="idPerusahaan") int idPerusahaan, @RequestParam String model) {
		Map<String, Object> body = new HashMap<String, Object>();
		
		try {
			body = servicePerusahaan.editData(idPerusahaan, model);
			return body;
		}catch (Exception e) {
			e.printStackTrace();
			body.put("message", "Terjadi kesalahan");
			body.put("status", false);
			return body;
		}
	}
}
