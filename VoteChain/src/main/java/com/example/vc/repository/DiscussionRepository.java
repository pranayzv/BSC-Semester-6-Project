package com.example.vc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.vc.model.Discussion;

@Repository
public interface DiscussionRepository extends CrudRepository<Discussion,Integer>{
	
	
}
