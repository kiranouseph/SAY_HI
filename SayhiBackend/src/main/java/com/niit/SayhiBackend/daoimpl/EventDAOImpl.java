package com.niit.SayhiBackend.daoimpl;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SayhiBackend.dao.EventDAO;
import com.niit.SayhiBackend.model.EventParticipants;
import com.niit.SayhiBackend.model.Events;
import com.niit.SayhiBackend.model.Job;
import com.niit.SayhiBackend.model.JobApplications;
import com.niit.SayhiBackend.model.Users;
@Repository("eventDAO")
public class EventDAOImpl implements EventDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Autowired
	public EventDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

@Transactional
	public boolean addEvent(Events event) {
		try
		{
		sessionFactory.getCurrentSession().save(event);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

@Transactional
	public boolean updateEvent(Events event) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(event);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

@Transactional
	public boolean deleteEvent(Events event) {
		try
		{
		sessionFactory.getCurrentSession().delete(event);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}
@Transactional
public boolean deleteEventpars(EventParticipants eventparticipants) {
	try
	{
	sessionFactory.getCurrentSession().delete(eventparticipants);
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;
	}
}
@Transactional
	public Events getevent(int eventid) {
		Session session=sessionFactory.openSession();
		Events events = (Events) session.get(Events.class,eventid);
		session.close();
		return events;
	}

@Transactional
	public ArrayList<Events> getAllevents() {
		Session session = sessionFactory.openSession();
		ArrayList<Events> eventlist=(ArrayList<Events>)session.createQuery("from Events where status='A'").list();
		session.close();
		return eventlist;
	}

@Transactional
	public boolean applyevent(EventParticipants eventparticipants) {
		try
		{
		sessionFactory.getCurrentSession().save(eventparticipants);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

@Transactional
	public ArrayList<EventParticipants> myevents(int myid) {
		System.err.println(myid);
		Session session = sessionFactory.openSession();
		ArrayList<EventParticipants> eventpars=(ArrayList<EventParticipants>)session.createQuery("from EventParticipants where userid="+myid).list();
		session.close();
		return eventpars;
	}

@Transactional
	public ArrayList<EventParticipants> checkIfeveAppliied(int eventid, int myid) {
		Session session = sessionFactory.openSession();
		ArrayList<EventParticipants> checkifappliedevent=(ArrayList<EventParticipants>)session.createQuery("from EventParticipants where userid="+myid+" and eventid="+eventid).list();
	session.close();
	return checkifappliedevent;
	}

@Transactional
	public ArrayList<EventParticipants> eventpars(int eventid) {
		Session session = sessionFactory.openSession();
		ArrayList<EventParticipants> eventpars=(ArrayList<EventParticipants>)session.createQuery("from EventParticipants where  eventid="+eventid).list();
		session.close();
		return eventpars;
	}
	
	@Transactional
	public ArrayList<Events> eventrequests()
	{
		Session session = sessionFactory.openSession();
		ArrayList<Events> eventreq=(ArrayList<Events>) session.createQuery("from Events where status='P'").list();
		session.close();
		return eventreq;
	}
	
	@Transactional
	public boolean approveevent(Events events)
	{
		
		
		try {
	  		sessionFactory.getCurrentSession().saveOrUpdate(events);
	  		return true;
	  	} catch (HibernateException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  		return false;
	  	}
		
	}
	}
	

