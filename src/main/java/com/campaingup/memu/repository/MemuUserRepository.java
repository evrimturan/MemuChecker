package com.campaingup.memu.repository;

import com.campaingup.memu.entity.MemuUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemuUserRepository extends CrudRepository<MemuUser, Integer> {
	
	MemuUser findByUsername(String username);
	
}