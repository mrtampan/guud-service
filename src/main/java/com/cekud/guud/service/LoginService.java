package com.cekud.guud.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestParam;

import com.cekud.guud.entity.PenerimaKerjaEntity;
import com.cekud.guud.entity.UserEntity;
import com.cekud.guud.repo.PencariKerjaRepo;
import com.cekud.guud.repo.PenerimaKerjaRepo;
import com.cekud.guud.repo.UserRepo;

@Service
public class LoginService {

	@Autowired
	private UserRepo repoUser;
	
	@Autowired
	private PenerimaKerjaRepo repoPenerimaKerja;
	
	public Map<String, Object> processLoginPublish(String username, String password) throws IllegalArgumentException{
		Map<String, Object> body = new HashMap<String, Object>();
		
		UserEntity userData = repoUser.findOneByUsernameAndPassword(username, password);
		
		if(userData.getRole() == "advertiser" ) {
			 throw new IllegalArgumentException("Akses ditolak");
		}
		
		Assert.notNull(userData, "Username dan Password salah");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", userData.getUsername());
		map.put("role", userData.getRole());
		
		body.put("status", true);
		body.put("data", map);
		return body;
	}
	
	public Map<String, Object> processLoginAdvert(String username, String password) throws IllegalArgumentException {
		Map<String, Object> body = new HashMap<String, Object>();
		
		UserEntity userData = repoUser.findOneByUsernameAndPassword(username, password);
		
		if(userData.getRole() == "publisher" ) {
			 throw new IllegalArgumentException("Akses ditolak");
		}
		
		Assert.notNull(userData, "Username dan Password salah");
		
		PenerimaKerjaEntity penerimaKerjaData = repoPenerimaKerja.findOneByIdUser(userData.getIdUser());
		
		Assert.notNull(penerimaKerjaData, "Terjadi Kesalahan");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", userData.getUsername());
		map.put("idPerusahaan", penerimaKerjaData.getIdPerusahaan());
		map.put("role", userData.getRole());
		
		body.put("data", map);
		body.put("status", true);

		return body;
	}
	
}
