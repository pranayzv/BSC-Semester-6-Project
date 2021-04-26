package com.example.vc.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.vc.model.DTOUserDiscussion;
import com.example.vc.model.Discussion;
import com.example.vc.model.Request;
import com.example.vc.model.User;
import com.example.vc.services.DiscussionService;
import com.example.vc.services.RequestService;
import com.example.vc.services.UserService;


@RestController
public class MainController {
	
	@Autowired
	private UserService usrService;
	@Autowired
	private DiscussionService disService;
	@Autowired
	private RequestService reqService;
	
	@RequestMapping("/test")
	public String test() {
		return "Test";
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/discussions")
	public List<Discussion> getDiscussions() {
		System.out.println(reqService.getYesCount("abc"));
		System.out.println(reqService.getNoCount("abc"));
		return disService.getAllDiscussions();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/newdiscussion",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createNewDiscussion(@RequestBody DTOUserDiscussion dis){
		Discussion d = new Discussion();
		d.setAdmin(dis.getU());
		d.setName(dis.getD());
		disService.addDiscussion(d);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/newrequest",consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean addRequest(@RequestBody Request req){
		if(!reqService.userRequestExists(req.getDiscname(), req.getUsrname())) {
			reqService.addRequest(req);
			return true;
		}
		return false;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/allusers")
	public List<User> getAllUsers(){
		return usrService.getAllUsers();
	} 
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/getnotallowedreqs",method=RequestMethod.POST)
	public List<User> getNotAllowedReqs(@RequestBody String d){
		return reqService.getNotAllowedReqs(d);
	} 
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/usercheck",consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean userExists(@RequestBody User user) {
		return usrService.userExists(user); 
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/discussioncheck")
	public boolean discussionExists(@RequestBody String discussion) {
		System.out.println(discussion);
		return disService.discussionCheck(discussion); 
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/admincheck",consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean adminExists(@RequestBody DTOUserDiscussion ud) {
		System.out.println("admincheck: "+ud.getU()+" "+ud.getD());
		
		return disService.adminCheck(ud.getD(),ud.getU()); 
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/userrequestexists",consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean userReqCheck(@RequestBody DTOUserDiscussion ud) {
		System.out.println((ud.getD()+" "+ud.getU()));
		return reqService.userRequestExists(ud.getD(),ud.getU()); 
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/register",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String registerUser(@RequestBody User user) {
		usrService.addUser(user);
		return "hello "+user.getUsrname()+" you are registered successfully."; 
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/getrequest",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Request addRequest(@RequestBody DTOUserDiscussion ud){
		System.out.println((ud.getD()+" "+ud.getU()));
		return reqService.geRequest(ud.getD(),ud.getU());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/registervote",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void registerVote(@RequestBody Request req){
		 reqService.addVote(req);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/allowuser",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void allowUser(@RequestBody Request req){
		 reqService.allowUser(req);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/getuserdetails")
	public User getUserDetails(@RequestBody String u){
		 return usrService.getUserDetails(u);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/getyescomments")
	public List<String> getYesComments(@RequestBody String d){
		 return reqService.getYesComments(d);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/getnocomments")
	public List<String> getNoComments(@RequestBody String d){
		 return reqService.getNoComments(d);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/getyescount")
	public int getYesCount(@RequestBody String d){
		 return reqService.getYesCount(d);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/getnocount")
	public int getNoCount(@RequestBody String d){
		 return reqService.getNoCount(d);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/totalvotes")
	public int getTotalVotes(@RequestBody String d){
		 return reqService.getTotalVotesCasted(d);
	}
	
}
		