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
@Table(name="ForumComments")
public class ForumComments implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue 
    @Column(name = "ForumcomId", nullable = false)
	private int forumcomid;
	 @Column(name = "ForumComm", nullable = false)
		private String forumcomm;
	 @Column(name = "Forumid", nullable = false)
		private int forumid;	
	 @Column(name = "Createdate", nullable = false)
		private int createdate;
	 @Column(name = "Userid", nullable = false)
		private int Userid;

	public int getForumcomid() {
		return forumcomid;
	}
	public void setForumcomid(int forumcomid) {
		this.forumcomid = forumcomid;
	}
	public String getForumcomm() {
		return forumcomm;
	}
	public void setForumcomm(String forumcomm) {
		this.forumcomm = forumcomm;
	}
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	public int getCreatedate() {
		return createdate;
	}
	public void setCreatedate(int createdate) {
		this.createdate = createdate;
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	
	

}
