package com.niit.SayhiBackend.Test;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SayhiBackend.dao.BlogDAO;
import com.niit.SayhiBackend.model.Blog;
import com.niit.SayhiBackend.model.BlogComment;

import junit.framework.TestCase;

import static org.junit.Assert.*;
import java.sql.Date.*;
import java.util.*;
public class BlogDAOTest 
{
	@Autowired
private static BlogDAO blogDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.SayhiBackend");
		context.refresh();
		
		blogDAO=(BlogDAO)context.getBean("blogDAO");
	}

	@Ignore
	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		
		blog.setBlogid(105);
		blog.setBlogname("Core Java");
		blog.setBlogcontent("It is based on Simple Java Concept");
		blog.setUsername("sunil");
		blog.setStatus("A");
		blog.setLikes(3);
		blog.setDislikes(3);
		
		
		assertTrue("Problem in Inserting Blog",blogDAO.addBlog(blog));
	
	}
	
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
		
		Blog blog=(Blog)blogDAO.getBlog(41);
		blog.setBlogcontent("it is hibernate based");
		blog.setBlogname("hibernate core");
		assertTrue("Problem in Updating  Blog",blogDAO.updateBlog(blog));
		
		
	}
	@Ignore
	@Test
	public void deleteBlogTest()
	{
		Blog blog=(Blog)blogDAO.getBlog(41);
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
		Blog blog=(Blog)blogDAO.getBlog(41);
		blog.setStatus("Y");
		assertTrue("Problem in Approving  Blog",blogDAO.approveBlog(blog));
		
	}
	@Ignore
	@Test
	public void rejectBlogTest()
	{
		Blog blog=(Blog)blogDAO.getBlog(41);
		blog.setStatus("N");
		assertTrue("Problem in Rejecting  Blog",blogDAO.rejectBlog(blog));
		
	}
	@Ignore
	@Test
	public void likeBlogTest()
	{
	
		assertTrue("Problem in Rejecting  Blog",blogDAO.like(41));
		
	}
	
	@Ignore
	@Test
	public void dislikeBlogTest()
	{
	
		assertTrue("Problem in Rejecting  Blog",blogDAO.dislike(41));
		
	}
	@Ignore
	@Test
	public void addBlogComment()
	{
		BlogComment blogcomment = new BlogComment();
		blogcomment.setBlogid(41);
		blogcomment.setComment("very good");
		blogcomment.setCommentid(1000);
		blogcomment.setUserid(500);
		assertTrue("Problem in Inserting BlogComment",blogDAO.addBlogComment(blogcomment));
	
	}
	
/*	@Test
	public void getBlogCommentTest()
	{
		BlogComment blog=(BlogComment)blogDAO.getBlogComment(41);	
		System.out.println(BlogComment.ge)
		
	}
	@Ignore
	@Test
	public void deleteBlogCommentTest()
	{
		BlogComment blog=(BlogComment)blogDAO.getBlogComment(41);
		assertTrue("Problem in Updating  Blog",blogDAO.deleteBlog(blog));
		
		

	}*/
	
	
	
}


