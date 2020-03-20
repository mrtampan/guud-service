package com.cekud.guud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cekud.guud.entity.PenerimaKerjaEntity;

@Repository
public interface PenerimaKerjaRepo extends JpaRepository<PenerimaKerjaEntity, Integer> {

	public PenerimaKerjaEntity findOneByIdUser(int idUser);
}
