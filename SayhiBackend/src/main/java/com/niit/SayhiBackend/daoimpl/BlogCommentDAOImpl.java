package com.niit.SayhiBackend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SayhiBackend.dao.BlogCommentDAO;
import com.niit.SayhiBackend.dao.ForumCommentDAO;

@Repository("blogCommentDAOImpl")
public class BlogCommentDAOImpl implements BlogCommentDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public BlogCommentDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

}
