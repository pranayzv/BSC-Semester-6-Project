package com.example.vc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="requests")
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String usrname;
	private String discname;
	private boolean allowed;
	private boolean vote;
	private boolean voted;
	private String comment;
	
	
	Request(){}

	
	public Request(long id, String usrname, String discname, boolean allowed, boolean vote, boolean voted,
			String comment) {
		super();
		this.id = id;
		this.usrname = usrname;
		this.discname = discname;
		this.allowed = allowed;
		this.vote = vote;
		this.voted = voted;
		this.comment = comment;
	}
	
	

	public String getUsrname() {
		return usrname;
	}



	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getDiscname() {
		return discname;
	}
	public void setDiscname(String discname) {
		this.discname = discname;
	}
	public boolean isAllowed() {
		return allowed;
	}
	public void setAllowed(boolean allowed) {
		this.allowed = allowed;
	}
	
	public boolean isVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}
	public boolean isVoted() {
		return voted;
	}
	public void setVoted(boolean voted) {
		this.voted = voted;
	}

}
