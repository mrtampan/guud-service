package com.cekud.guud.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cekud.guud.service.LoginService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private LoginService serviceLogin;

	@ResponseBody
	@CrossOrigin
	@PostMapping("publisher")
	public Map<String, Object> loginPublish(@RequestParam(value="username") String username, @RequestParam(value="password") String password) {
		Map<String, Object> body = new HashMap<String, Object>();
		
		try {
			body = serviceLogin.processLoginPublish(username, password);
			return body;
		}catch(IllegalArgumentException e) {
			body.put("message", e.getMessage());
			body.put("status", false);
			return body;
		}catch (Exception e) {
			e.printStackTrace();
			body.put("message", "Terjadi Kesalahan");
			body.put("status", false);
			return body;
		}
	}
	
	@ResponseBody
	@CrossOrigin
	@PostMapping("advertiser")
	public Map<String, Object> loginAdvert(@RequestParam(value="username") String username, @RequestParam(value="password") String password){
		Map<String, Object> body = new HashMap<String, Object>();
		
		try {
			body = serviceLogin.processLoginAdvert(username, password);
			return body;
		}catch(IllegalArgumentException e) {
			body.put("message", e.getMessage());
			body.put("status", false);
			return body;
		}catch (Exception e) {
			e.printStackTrace();
			body.put("message", "Terjadi Kesalahan");
			body.put("status", false);
			return body;
		}
	}
	
}
