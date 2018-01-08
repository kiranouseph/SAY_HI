package com.niit.SayhiBackend.dao;

import java.util.ArrayList;

import com.niit.SayhiBackend.model.EventParticipants;
import com.niit.SayhiBackend.model.Events;


public interface EventDAO {
	
	public Events addEvent(Events event);
	public boolean updateEvent(Events event);
	public boolean deleteEvent(Events event);
	public Events getevent(int eventid);
	public ArrayList<Events> getAllevents();
	public boolean applyevent(EventParticipants eventparticipants);
	public ArrayList<EventParticipants> myevents(int myid);
	public ArrayList<EventParticipants> checkIfeveAppliied(int eventid,int myid);
	public ArrayList<EventParticipants> eventpars(int eventid);
	public boolean deleteEventpars(EventParticipants eventparticipants);
	public ArrayList<Events> eventrequests();
	public boolean approveevent(Events events);
	public boolean rejectevent(Events events);
}
