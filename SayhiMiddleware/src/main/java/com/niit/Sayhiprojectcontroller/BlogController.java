package com.niit.Sayhiprojectcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SayhiBackend.dao.BlogDAO;
import com.niit.SayhiBackend.model.Blog;
import com.niit.SayhiBackend.model.BlogComments;
import com.niit.SayhiBackend.model.Users;

@RestController
@RequestMapping("/blogs")
public class BlogController {
	@Autowired 
	BlogDAO blogDAO;
	
	

	@RequestMapping(value="/getAllBlogs",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity getAllUser(){
		
		if(blogDAO.getAllBlogs().isEmpty()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No User registerd..");
		}
		return new ResponseEntity(blogDAO.getAllBlogs(),HttpStatus.OK);
				
	}
	
	
	@RequestMapping(value="/addBlog",method=RequestMethod.POST)
	public ResponseEntity<Blog> addBlog(@RequestBody Blog blog){
		
		boolean isSaved=blogDAO.addBlog(blog);
		if(isSaved)
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		else
			return new ResponseEntity<Blog>(blog,HttpStatus.BAD_REQUEST);
		
	}
	
	@RequestMapping(value="/getBlog/{blogid}",method=RequestMethod.GET)
	public ResponseEntity getBlog(@PathVariable("blogid") int blogId){
	
	
	if(blogDAO.getBlog(blogId)==null){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such blog exists");
	}
	return new ResponseEntity(blogDAO.getBlog(blogId),HttpStatus.OK);	
			
	
	
	
	}
	
	
	@RequestMapping(value="/deleteBlog/{blogid}",method=RequestMethod.DELETE)
	public ResponseEntity deleteBlog(@PathVariable("blogid") int blogId){
	
	Blog blog=blogDAO.getBlog(blogId);
	blogDAO.deleteBlog(blog);
	if(blogDAO.getBlog(blogId)==null){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such blog exists");
	}
	return new ResponseEntity(blogDAO.getAllBlogs(),HttpStatus.OK);	
			
	
	
	
	}
	
	@RequestMapping(value="/updateBlog",method=RequestMethod.PUT)
	public ResponseEntity updateBlog(@RequestBody Blog blog){
		
		boolean isSaved=blogDAO.updateBlog(blog);
		if(isSaved)
		return new ResponseEntity(blog,HttpStatus.OK);
		else
			return new ResponseEntity(blog,HttpStatus.BAD_REQUEST);
		
	}
	
	@RequestMapping(value="/approveBlog/{blogId}",method=RequestMethod.GET)
	public ResponseEntity approveBlog(@PathVariable("blogId") int blogId){
		Blog blog=blogDAO.getBlog(blogId);
		blog.setStatus("Y");
		
		boolean isSaved=blogDAO.updateBlog(blog);
		if(isSaved)
		return new ResponseEntity(blog,HttpStatus.OK);
		else
			return new ResponseEntity(blog,HttpStatus.BAD_REQUEST);
		
	}
	@RequestMapping(value="/rejectBlog/{blogId}",method=RequestMethod.GET)
	public ResponseEntity rejectBlog(@PathVariable("blogId") int blogId){
		Blog blog=blogDAO.getBlog(blogId);
		blog.setStatus("N");
		
		boolean isSaved=blogDAO.updateBlog(blog);
		if(isSaved)
		return new ResponseEntity(blog,HttpStatus.OK);
		else
			return new ResponseEntity(blog,HttpStatus.BAD_REQUEST);
		
	}	
	
	
	
	@RequestMapping(value="/likeBlog/{blogId}",method=RequestMethod.GET)
	public ResponseEntity likeBlog(@PathVariable("blogId") int blogId){
		Blog blog=blogDAO.getBlog(blogId);
		blog.setLikes(blog.getLikes()+1);
		
		boolean isSaved=blogDAO.updateBlog(blog);
		if(isSaved)
		return new ResponseEntity(blog,HttpStatus.OK);
		else
			return new ResponseEntity(blog,HttpStatus.BAD_REQUEST);
		
	}	
	
	
	@RequestMapping(value="/dislikeBlog/{blogId}",method=RequestMethod.GET)
	public ResponseEntity dislikeBlog(@PathVariable("blogId") int blogId){
		Blog blog=blogDAO.getBlog(blogId);
		blog.setLikes(blog.getDislikes()+1);
		
		boolean isSaved=blogDAO.updateBlog(blog);
		if(isSaved)
		return new ResponseEntity(blog,HttpStatus.OK);
		else
			return new ResponseEntity(blog,HttpStatus.BAD_REQUEST);
		
	}	

	
	
	
	@RequestMapping(value="/addBlogComments/{blogId}",method=RequestMethod.POST)
	public ResponseEntity addBlogComments(@RequestBody BlogComments blogcomment,@PathVariable("blogId") int blogId){
		blogcomment.setBlogid(82);
		boolean isSaved=blogDAO.addBlogComment(blogcomment);
		if(isSaved)
		return new ResponseEntity(blogcomment,HttpStatus.OK);
		else
			return new ResponseEntity(blogcomment,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
}
