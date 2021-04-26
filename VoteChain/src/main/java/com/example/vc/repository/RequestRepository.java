package com.example.vc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.vc.model.Request;

@Repository
public interface RequestRepository extends CrudRepository<Request, Integer> {
	
	@Query(value="select count(id) from requests where vote = true and discname = :dis",nativeQuery=true)
	public int yesForDiscussion(@Param("dis") String dis);
	
	@Query(value="select count(id) from requests where vote = false and discname = :dis",nativeQuery=true)
	public int noForDiscussion(@Param("dis") String dis);
	
	@Modifying
	@Transactional
	@Query(value="update requests set allowed=true where usrname = :uname and discname = :dis",nativeQuery=true)
	public void allowUser(@Param("dis") String dis,@Param("uname") String uname);
	
	
	
}
