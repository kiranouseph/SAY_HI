package com.niit.SayhiBackend.daoimpl;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SayhiBackend.dao.UserDAO;
import com.niit.SayhiBackend.model.User;

import antlr.collections.List;
@Repository("UserDAOImpl")
public class UserDAOImpl implements UserDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public UserDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}
	 @Transactional
		public ArrayList<User> getAllUser() {
			
			String hql = "from User";
			Query query =sessionFactory.getCurrentSession().createQuery(hql);		
			return (ArrayList<User>) query.list();
			
		}
	  @Transactional
	  public boolean saveUser(User user) {
	  	
	  	try {
	  		sessionFactory.getCurrentSession().save(user);
	  		return true;
	  	} catch (HibernateException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  		return false;
	  	}
	  }

	



	

}
