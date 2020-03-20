package com.cekud.guud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cekud.guud.entity.PencariKerjaEntity;

@Repository
public interface PencariKerjaRepo extends JpaRepository<PencariKerjaEntity, Integer> {

}
