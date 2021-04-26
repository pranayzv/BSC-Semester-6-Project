package com.example.vc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vc.model.User;
import com.example.vc.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository repo;
		
		
		public List<User> getAllUsers() {
			List<User> users= new ArrayList<>();
			repo.findAll().forEach(users::add);
			return users;
		}
		
		public boolean userExists(User user) {
			System.out.println(user.getUsrname());
			System.out.println(user.getPass());
			List<User> users= new ArrayList<>();
			repo.findAll().forEach(users::add);
			for(User u : users) {
				if(u.getUsrname().equals(user.getUsrname()) && u.getPass().equals(user.getPass())) {
					System.out.println(u.getUsrname());
					System.out.println(u.getPass());
					return true;
				}
			}
			return false;
		}
		
		public void addUser(User user) {
			repo.save(user);
		}

		public User getUserDetails(String u) {
			List<User> users= new ArrayList<>();
			repo.findAll().forEach(users::add);
			for(User usr : users) {
				if(usr.getUsrname().equals(u)) {
					usr.setPass("");
					return usr;
				}
			}
			return null;
		}


}
