package com.example.vc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.vc.model.Request;
import com.example.vc.model.User;
import com.example.vc.repository.RequestRepository;

@Service
public class RequestService {
	
	@Autowired
	private RequestRepository repo;
	@Autowired
	private UserService usrService;
	
	public void addRequest(Request req){
		repo.save(req);
	}
	
	
	public boolean userAllowedToVote(String d,String u) {
		List<Request> arr  = new ArrayList<>();
		repo.findAll().forEach(arr :: add);
		for(Request req : arr ) {
			if(req.getUsrname().equals(u) && req.getDiscname().equals(d)) {
				return req.isAllowed();
			}
		}
		return false;
	}
	public String getUserComment(String d,String u) {
		List<Request> arr  = new ArrayList<>();
		repo.findAll().forEach(arr :: add);
		for(Request req : arr ) {
			if(req.getUsrname().equals(u) && req.getDiscname().equals(d)) {
				return req.getComment();
			}
		}
		return "User Doesn't exists.";
	}
	public boolean userRequestExists(String d,String u) {
		List<Request> arr  = new ArrayList<>();
		repo.findAll().forEach(arr :: add);
		System.out.println("u="+u);
		System.out.println("d="+d);
		for(Request req : arr ) {
			if(req.getUsrname().equals(u) && req.getDiscname().equals(d)) {
				System.out.println("req exists");
				return true;
			}
		}
		System.out.println("req does not exists");
		return false;
	}
	
	public boolean isUserVoted(String d,String u) {
		List<Request> arr  = new ArrayList<>();
		repo.findAll().forEach(arr :: add);
		for(Request req : arr ) {
			if(req.getUsrname().equals(u) && req.getDiscname().equals(d)) {
				return req.isVoted();
			}
		}
		return false;
	}
	public void allowUserToVote(String uname,String dis) {
		repo.allowUser(uname, dis);
	}
	
	public Request geRequest(String d,String u) {
		List<Request> arr  = new ArrayList<>();
		repo.findAll().forEach(arr :: add);
		for(Request req : arr ) {
			if(req.getUsrname().equals(u) && req.getDiscname().equals(d)) {
				return req;
			}
		}
		return null;
	}
	
	public void addVote(Request req){
		repo.save(req);
	}

	public List<String> getNoComments(String d) {
		List<String> com  = new ArrayList<>();
		List<Request> arr  = new ArrayList<>();
		repo.findAll().forEach(arr :: add);
		for(Request req : arr ) {
			if(req.getDiscname().equals(d)) {
				if(req.isAllowed() && req.isVoted()) {
					if(!req.isVote()) {
						System.out.println(req.getComment());
						com.add(req.getComment());
					}
				}
			}
		}
		
		return com;
	}

	public List<String> getYesComments(String d) {
		List<String> com  = new ArrayList<>();
		List<Request> arr  = new ArrayList<>();
		repo.findAll().forEach(arr :: add);
		for(Request req : arr ) {
			if(req.getDiscname().equals(d)) {
				if(req.isAllowed() && req.isVoted()) {
					if(req.isVote()) {
						System.out.println(req.getComment());
						com.add(req.getComment());
					}
				}
			}
		}
		
		return com;
	}
	
	public int getYesCount(String d) {
		int val =0;
		List<Request> arr  = new ArrayList<>();
		repo.findAll().forEach(arr :: add);
		for(Request req : arr ) {
			if(req.getDiscname().equals(d)) {
				if(req.isAllowed() && req.isVoted()) {
					if(req.isVote()) {
						val++;
					}
				}
			}
		}
		
		return val;
		
	}
	
	public int getNoCount(String d) {
		int val =0;
		List<Request> arr  = new ArrayList<>();
		repo.findAll().forEach(arr :: add);
		for(Request req : arr ) {
			if(req.getDiscname().equals(d)) {
				if(req.isAllowed() && req.isVoted()) {
					if(!req.isVote()) {
						val++;
					}
				}
			}
		}
		
		return val;
			
	}
	
	public int getTotalVotesCasted(String d) {
		int val =0;
		List<Request> arr  = new ArrayList<>();
		repo.findAll().forEach(arr :: add);
		for(Request req : arr ) {
			if(req.getDiscname().equals(d)) {
				if(req.isAllowed() && req.isVoted()) {
						val++;
						}
			}
		}
		
		return val;
			
	}


	public List<User> getNotAllowedReqs(String d) {
		List<Request> arr  = new ArrayList<>();
		List<User> usr  = new ArrayList<>();
		repo.findAll().forEach(arr :: add);
		for(Request req : arr ) {
			if(req.getDiscname().equals(d) && !req.isAllowed()) {
				usr.add(usrService.getUserDetails(req.getUsrname()));
			}
		}
		return usr;
	}


	public void allowUser(Request req) {
		repo.allowUser(req.getDiscname(), req.getUsrname());
		
	}
	
}
