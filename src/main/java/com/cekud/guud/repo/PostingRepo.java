package com.cekud.guud.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cekud.guud.entity.PostingEntity;

@Repository
public interface PostingRepo extends JpaRepository<PostingEntity, Integer> {

	public PostingEntity findOneByIdPosting(int idPosting);
	public Page<PostingEntity> findByIdPerusahaan(int idPerusahaan, Pageable pageable);
}
