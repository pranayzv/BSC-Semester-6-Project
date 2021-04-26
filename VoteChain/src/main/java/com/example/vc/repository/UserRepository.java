package com.example.vc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.vc.model.User;


@Repository
public interface UserRepository extends CrudRepository<User,Integer>{

		
}
