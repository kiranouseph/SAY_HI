package com.niit.SayhiBackend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SayhiBackend.dao.EventDAO;
@Repository("eventDAO")
public class EventDAOImpl implements EventDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Autowired
	public EventDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	
}
