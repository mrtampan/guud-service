package com.cekud.guud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cekud.guud.entity.PerusahaanEntity;

@Repository
public interface PerusahaanRepo extends JpaRepository<PerusahaanEntity, Integer> {

	public PerusahaanEntity findOneByIdPerusahaan(int idPerusahaan);
}
