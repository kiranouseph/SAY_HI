package com.niit.SayhiBackend.Test;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SayhiBackend.dao.BlogDAO;
import com.niit.SayhiBackend.dao.UsersDAO;
import com.niit.SayhiBackend.model.Blog;
import com.niit.SayhiBackend.model.BlogComments;
import com.niit.SayhiBackend.model.Users;

import junit.framework.TestCase;

import static org.junit.Assert.*;
import java.sql.Date.*;
import java.util.*;
public class BlogDAOTest 
{
	@Autowired
private static BlogDAO blogDAO;
	@Autowired
private static UsersDAO userDAO;	
	
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.SayhiBackend");
		context.refresh();
		
		blogDAO=(BlogDAO)context.getBean("blogDAO");
		userDAO=(UsersDAO)context.getBean("userDAO");
	
	}

	
	
	
	
	
@Ignore
	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		
		blog.setBlogid(1006);
		blog.setBlogname("yahoo");
		blog.setBlogcontent("fdesggfdg");
	
		blog.setStatus("A");
		blog.setLikes(3);
		blog.setDislikes(3);
		Users users=(Users)userDAO.getUser(1);
		blog.setUserss(users);
		System.out.println(users.getEmail());
		assertTrue("Problem in inserting   Blog",blogDAO.addBlog(blog));
		
		
		
	
	}
	
	
	
	
	@Ignore
	@Test
	public void getblogTest()
	{
		
		Blog blog=blogDAO.getBlog(41);
		System.out.println(blog.getBlogcontent());
		System.out.println(blog.getBlogname());
	}
	
	
	
	
@Ignore
	@Test
	public void updateBlogTest()
	{
		
		Blog blog=(Blog)blogDAO.getBlog(43);
		blog.setBlogcontent("it is hibernate based");
		blog.setBlogname("hibernate core");
		assertTrue("Problem in Updating  Blog",blogDAO.updateBlog(blog));
		
		
	}
	
	
	
	
	@Ignore
	@Test
	public void deleteBlogTest()
	{
		Blog blog=(Blog)blogDAO.getBlog(45);
		assertTrue("Problem in Updating  Blog",blogDAO.deleteBlog(blog));
		
		
		
	}
	
	
	
	
	@Ignore
	@Test
	public void getAllBlogTest()
	{
		
	
		ArrayList<Blog> blog=(ArrayList<Blog>)blogDAO.getAllBlogs();
	for(Blog b:blog)
	{
		System.out.println(b.getBlogname());
	}
	
	}
	
	
	
	
    @Ignore
	@Test
	public void approveBlogTest()
	{
		Blog blog=(Blog)blogDAO.getBlog(43);
		blog.setStatus("Y");
		assertTrue("Problem in Approving  Blog",blogDAO.approveBlog(blog));
		
	}
	
	
	
	
	@Ignore
	@Test
	public void rejectBlogTest()
	{
		Blog blog=(Blog)blogDAO.getBlog(43);
		blog.setStatus("N");
		assertTrue("Problem in Rejecting  Blog",blogDAO.rejectBlog(blog));
		
	}
	
	
	
	
	@Ignore
	@Test
	public void likeBlogTest()
	{
	
		Blog blog =blogDAO.getBlog(43);
		blog.setLikes(blog.getLikes()+1);
				assertTrue("problemin liking blog",blogDAO.updateBlog(blog));
		
	}
	
	
	
	
	@Ignore
	@Test
	public void dislikeBlogTest()
	{
	
		Blog blog =blogDAO.getBlog(43);
		blog.setDislikes(blog.getDislikes()+1);
		assertTrue("problemin disliking blog",blogDAO.updateBlog(blog));
		
		
	}
	
	
	
	
	
@Ignore
	@Test
	public void addBlogComment()
	{
		BlogComments blogcomment = new BlogComments();
		Blog blog=blogDAO.getBlog(4);
		blogcomment.setBlogg(blog);
		blogcomment.setBlogcomm("v good");
		blogcomment.setBlogcomid(1000);
	
		assertTrue("Problem in Inserting BlogComment",blogDAO.addBlogComment(blogcomment));
	
	}
	
	
	
	
@Ignore
	@Test
	public void getBlogCommentTest()
	{
		BlogComments blogcomment=(BlogComments)blogDAO.getBlogComment(61);
		System.out.println(blogcomment.getBlogcomm());
		
	}
	
	
	

@Ignore
	@Test
	public void updateBlogCommentTest()
	{
		BlogComments blogcomment =blogDAO.getBlogComment(62);
		blogcomment.setBlogcomm("amazing");
		assertTrue("Problem in Updating  Blog",blogDAO.updateBlogComment(blogcomment));		
		
	}
	
	@Ignore
	@Test
	public void deleteBlogCommentTest()
	{
		BlogComments blogcomment=(BlogComments)blogDAO.getBlogComment(62);
		assertTrue("Problem in deleting  Blog",blogDAO.deleteBlogComment(blogcomment));
		
		

	}
	
	
	
}


