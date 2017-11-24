package com.niit.SayhiBackend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SayhiBackend.dao.ForumCommentDAO;
import com.niit.SayhiBackend.dao.ForumDAO;

@Repository("forumCommentDAOImpl")
public class ForumCommentDAOImpl implements ForumCommentDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public ForumCommentDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

}
