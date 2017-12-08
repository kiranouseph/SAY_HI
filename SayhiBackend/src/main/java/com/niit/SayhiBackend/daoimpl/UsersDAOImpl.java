package com.niit.SayhiBackend.daoimpl;

import java.util.ArrayList;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SayhiBackend.dao.UsersDAO;
import com.niit.SayhiBackend.model.Users;


@Repository("userDAO")
public class UsersDAOImpl implements UsersDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public UsersDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}
	 @Transactional
		public ArrayList<Users> getAllUser() {
			
			String hql = "from Users";
			Query query =sessionFactory.getCurrentSession().createQuery(hql);		
			return (ArrayList<Users>) query.list();
			
		}
	  @Transactional
	  public boolean saveUser(Users user) {
	  	
	  	try {
	  		sessionFactory.getCurrentSession().save(user);
	  		return true;
	  	} catch (HibernateException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  		return false;
	  	}
	  }
	  
	  @Transactional	  
	public boolean updateOnlineStatus(Users user) {
		try{
			user.setIsonline("Y");
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
		
	}
	  
	@Transactional 
	public Users getUser(int userid) {
		
		System.err.println(userid);
		Users user=new Users();
		try{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from Users where userid="+userid);
			 user=(Users)query.list().get(0);
			session.close();
			
		}
		catch(Exception e)
		{
			
			
		}
		return user;
		
	}

	



	

}
