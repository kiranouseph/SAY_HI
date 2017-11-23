package com.niit.SayhiBackend.daoimpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SayhiBackend.dao.ForumDAO;
import com.niit.SayhiBackend.model.Forum;
import com.niit.SayhiBackend.model.ForumComment;

public class ForumDAOImpl implements ForumDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ForumDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public boolean addForum(Forum forum) {
		try
		{
		sessionFactory.getCurrentSession().save(forum);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

	public boolean updateForum(Forum forum) {
		try
		{
		sessionFactory.getCurrentSession().update(forum);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

	public boolean deleteForum(Forum forum) {
		try
		{
		sessionFactory.getCurrentSession().update(forum);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

	public Forum getForum(int forumId) {
		Session session=sessionFactory.openSession();
		Forum forum = (Forum) session.get(Forum.class, forumId);
		session.close();
		return forum;
	}
	public ArrayList<Forum> getAllForum() {
		Session session = sessionFactory.openSession();
		ArrayList<Forum> forumList=(ArrayList<Forum>)session.createQuery("from Forum");
		session.close();
		return forumList;
	}

	public boolean approveForum(Forum forum) {
		try{
			forum.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
			
		}
		catch(Exception e)
		{
		
		return false;
		}
	}

	public boolean rejectforum(Forum forum) {
		try{
			forum.setStatus("N");
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
			
		}
		catch(Exception e)
		{
		
		return false;
		}
	}

	public boolean addForumComment(ForumComment forumcomment) {
		
		try
		{
		sessionFactory.getCurrentSession().save(forumcomment);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

	public boolean updateForumComment(ForumComment forumcomment) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(forumcomment);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

	public boolean deleteForumComment(ForumComment forumcomment)
	{
		try
	{
	sessionFactory.getCurrentSession().delete(forumcomment);
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;
	}
	}

}
