package com.niit.SayhiBackend.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Component
@Table(name="FORUM")
public class Forum implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue 
    @Column(name = "ForumID", nullable = false)
	private int forumid;
	@Column(name = "Formname", nullable = false)
    private String formname;
	@Column(name = "FormContent", nullable = false)
    private String formcontent;
	@Column(name = "Username", nullable = false)
    private String username;
	@Column(name = "Staus", nullable = false)
    private String status;
	
	@Column(name = "CreateDate", nullable = false)
    private Date createdate;

	public int getForumid() {
		return forumid;
	}

	public void setForumid(int forumid) {
		this.forumid = forumid;
	}

	public String getFormname() {
		return formname;
	}

	public void setFormname(String formname) {
		this.formname = formname;
	}

	public String getFormcontent() {
		return formcontent;
	}

	public void setFormcontent(String formcontent) {
		this.formcontent = formcontent;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	

}
