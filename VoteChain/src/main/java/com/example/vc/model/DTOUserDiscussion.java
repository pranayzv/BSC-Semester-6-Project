package com.example.vc.model;

public class DTOUserDiscussion {
	private String u;
	private String d;
	DTOUserDiscussion(){}
	public DTOUserDiscussion(String u, String d) {
		super();
		this.u = u;
		this.d = d;
	}
	public String getU() {
		return u;
	}
	public void setU(String u) {
		this.u = u;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	

}
