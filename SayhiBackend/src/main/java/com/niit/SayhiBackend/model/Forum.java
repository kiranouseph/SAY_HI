package com.niit.SayhiBackend.model;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@Column(name = "Staus", nullable = false)
    private String status;
	
	@OneToMany(targetEntity=ForumComments.class,mappedBy="forumm",cascade = CascadeType.DETACH,fetch=FetchType.EAGER)
    private Set<ForumComments> forumcomments ;

	
	 @ManyToOne
	    @JoinColumn(name="U_id",updatable=true,insertable=true,nullable=false)
	    private Users userss;
	 
	 
	public int getForumid() {
		return forumid;
	}

	public void setForumid(int forumid) {
		this.forumid = forumid;
	}

	public String getFormname() {
		return formname;
	}

	public Set<ForumComments> getForumcomments() {
		return forumcomments;
	}

	public void setForumcomments(Set<ForumComments> forumcomments) {
		this.forumcomments = forumcomments;
	}

	public Users getUserss() {
		return userss;
	}

	public void setUserss(Users userss) {
		this.userss = userss;
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


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	

}
