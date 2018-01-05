package com.niit.SayhiBackend.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Events")
public class Events implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	@Column(name="EventId",nullable=false)
	public int eventid;

	@Column(name="EventName",nullable=false)
	public String eventname;
	@Column(name="EventDesc",nullable =false)
	public String eventdesc;
	@Column(name="EventVenue",nullable =false)
	public String eventvenue;
	@Column(name="Username",nullable=false)
	public String username;
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEventdesc() {
		return eventdesc;
	}
	public void setEventdesc(String eventdesc) {
		this.eventdesc = eventdesc;
	}
	public String getEventvenue() {
		return eventvenue;
	}
	public void setEventvenue(String eventvenue) {
		this.eventvenue = eventvenue;
	}
	
	
	

}
