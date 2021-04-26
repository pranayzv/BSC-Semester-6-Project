package com.example.vc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vc.model.Discussion;
import com.example.vc.repository.DiscussionRepository;

@Service
public class DiscussionService {
	
	@Autowired
	DiscussionRepository repo;
	
	public void addDiscussion(Discussion dis) {
		System.out.println("Dis name: "+dis.getName());
		repo.save(dis);
	}

	public List<Discussion> getAllDiscussions() {
		List<Discussion> arr = new ArrayList<>();
		repo.findAll().forEach(arr::add);
		List<Discussion> a= new ArrayList<>();
		for(Discussion s : arr) {
			//a.add(s.getName());
		}
		return arr;
	}

	public boolean adminCheck(String d, String u) {
		List<Discussion> arr = new ArrayList<>();
		repo.findAll().forEach(arr::add);
		for(Discussion s : arr) {
			if(s.getName()==null) {continue;}
			if(s.getName().equals(d) && s.getAdmin().equals(u)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean discussionCheck(String discussion) {
		List<Discussion> arr = new ArrayList<>();
		repo.findAll().forEach(arr::add);
		for(Discussion s : arr) {
			if(s.getName()==null) {continue;}
			if(s.getName().equals(discussion)) {
				return true;
			}
		}
		return false;
	}

}
