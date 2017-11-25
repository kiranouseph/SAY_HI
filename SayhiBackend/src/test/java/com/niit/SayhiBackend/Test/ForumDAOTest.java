package com.niit.SayhiBackend.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SayhiBackend.dao.BlogDAO;
import com.niit.SayhiBackend.dao.ForumDAO;
import com.niit.SayhiBackend.model.Blog;
import com.niit.SayhiBackend.model.BlogComments;
import com.niit.SayhiBackend.model.Forum;
import com.niit.SayhiBackend.model.ForumComments;

public class ForumDAOTest {

	
	@Autowired
	private static ForumDAO forumDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.SayhiBackend");
		context.refresh();
		
		forumDAO=(ForumDAO)context.getBean("forumDAO");
	}
@Ignore
	@Test
	public void addForumTest()
	{
		Forum forum=new Forum();
		forum.setFormcontent("Java or .Net");
		forum.setFormname("JAVA");
		forum.setForumid(1500);
		forum.setStatus("N");
		forum.setUsername("kiran");
		assertTrue("Problem in adding Forum  ",forumDAO.addForum(forum));
	
	
	}
@Ignore
	@Test
	public void getForumTest()
	{
		
		Forum forum=forumDAO.getForum(63);
		System.out.println(forum.getFormcontent());	
		System.out.println(forum.getFormname());
	}
	@Ignore
	@Test
	public void updateForumTest()
	{
		
	Forum forum=forumDAO.getForum(63);
	forum.setFormcontent("Kotlin or java");
	forum.setFormname("Android tech");
		assertTrue("Problem in Updading forum",forumDAO.updateForum(forum));
		
		
	}
	@Ignore
	@Test
	public void deleteForumTest()
	{
		Forum forum=forumDAO.getForum(63);
		assertTrue("Problem in deleting forum",forumDAO.deleteForum(forum));
	}
	@Ignore
	@Test
	public void getAllForumTest()
	{
		
	
		ArrayList<Forum> forum=(ArrayList<Forum>)forumDAO.getAllForum();
	for(Forum f:forum)
	{
		System.out.println(f.getFormname());
	}
	
	}
@Ignore
	@Test
	public void approveForumTest()
	{
		Forum forum =forumDAO.getForum(63);
		
		forum.setStatus("Y");
		assertTrue("Problem in Approving  Forum",forumDAO.approveForum(forum));
		
	}
	
	
@Ignore
	@Test
	public void rejectForumTest()
	{
		Forum forum=forumDAO.getForum(63);
		forum.setStatus("N");
	
		assertTrue("Problem in Rejecting  Forum",forumDAO.rejectforum(forum));
		
	}
	
	
@Ignore
	@Test
	public void addForumComment()
	{
		ForumComments forumcomment =new ForumComments();
		forumcomment.setForumcomm("v good");
		
		forumcomment.setForumid(41);
		forumcomment.setUserid(50);
		assertTrue("Problem in adding Forumcomment ",forumDAO.addForumComment(forumcomment));
		
	}
	
	
	
@Ignore
	@Test
	public void getForumCommentTest()
	{
		
		ForumComments forumcomment=forumDAO.getForumComment(65);
		System.out.println(forumcomment.getForumcomm());
		
	}
	

@Test
public void getForumCommentByForumidTest()
{
	
	ArrayList<ForumComments> forumcomment=(ArrayList<ForumComments>)forumDAO.getAllForumComments(41);
	for(ForumComments f:forumcomment)
		
	{
		System.out.println(f.getForumcomm());
	}
	
}

	
	@Ignore
	@Test
	public void updateForumCommentTest()
	{
		ForumComments forumcomment =new ForumComments();
		forumcomment.setForumcomm("Too good");
		assertTrue("Problem in updating Forumcomment ",forumDAO.updateForumComment(forumcomment));
		
		
	}
	
	
	
@Ignore	
	@Test
	public void deleteForumCommentTest()
	{
		ForumComments forumcomment=forumDAO.getForumComment(41);
		assertTrue("Problem in deleting Forumcomment ",forumDAO.deleteForumComment(forumcomment));
		
	}
	
}
