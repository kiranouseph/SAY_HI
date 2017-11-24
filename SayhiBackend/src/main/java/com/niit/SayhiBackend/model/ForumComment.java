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
public class ForumComment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue 
    @Column(name = "ID", nullable = false)
	private int commentid;
	 @Column(name = "Comment", nullable = false)
		private String comment;
	 @Column(name = "Forumid", nullable = false)
		private int forumid;	
	 @Column(name = "Createdate", nullable = false)
		private int createdate;
	 @Column(name = "Userid", nullable = false)
		private int Userid;
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
