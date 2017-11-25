package com.niit.SayhiBackend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component	
@Table(name="BlogComments")
public class BlogComments implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue 
    @Column(name = "BlogcomId", nullable = false)
	private int blogcomid;
	@Column(name = "BlogComm", nullable = false)
    private String blogcomm;
	@Column(name = "BlogID", nullable = false)
    private int blogid;
	@Column(name = "UserID", nullable = false)
    private int userid;
	public int getBlogcomid() {
		return blogcomid;
	}
	public String getBlogcomm() {
		return blogcomm;
	}
	public void setBlogcomm(String blogcomm) {
		this.blogcomm = blogcomm;
	}
	public void setBlogcomid(int blogcomid) {
		this.blogcomid = blogcomid;
	}

	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	 	

}