package com.niit.Sayhiprojectcontroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SayhiBackend.dao.ForumDAO;
import com.niit.SayhiBackend.dao.UsersDAO;
import com.niit.SayhiBackend.model.Forum;
import com.niit.SayhiBackend.model.ForumComments;
import com.niit.SayhiBackend.model.Users;

@RestController
@RequestMapping("/forums")
public class ForumController {
	@Autowired 
	ForumDAO forumDAO;
	@Autowired 
	UsersDAO usersDAO;
	
	
	@RequestMapping(value="/getAllForums",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity<ArrayList<Forum>> getAllForums(){
		
		if(forumDAO.getAllForum().isEmpty()){
			
		}
		return new ResponseEntity<ArrayList<Forum>>(forumDAO.getAllForum(),HttpStatus.OK);
				
	}
	
	
	@RequestMapping(value="/addForum/{uid}",method=RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<Forum> addForum(@RequestBody Forum forum,@PathVariable("uid") int uid){
		System.out.println(uid);
		Users users=usersDAO.getUser(uid);
		
		boolean isSaved=forumDAO.addForum(forum);
		if(isSaved)
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		else
			return new ResponseEntity<Forum>(forum,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@RequestMapping(value="/getForum/{forumid}",method=RequestMethod.GET)
	public ResponseEntity<Forum> getForum(@PathVariable("forumid") int forumId){
	
	
	if(forumDAO.getForum(forumId)==null){
		
	}
	return new ResponseEntity<Forum>(forumDAO.getForum(forumId),HttpStatus.OK);	
			
	
	
	
	}
	
	
	
	
	@RequestMapping(value="/deleteForum/{forumid}",method=RequestMethod.DELETE)
	public ResponseEntity<Forum> deleteForum(@PathVariable("forumid") int forumId){
	
	Forum forum=forumDAO.getForum(forumId);
	forumDAO.deleteForum(forum);
	if(forumDAO.getForum(forumId)==null){
		
	}
	return new ResponseEntity<Forum>(forum,HttpStatus.OK);	
			
	
	
	
	}

	@RequestMapping(value="/updateForum",method=RequestMethod.PUT)
	public ResponseEntity<Forum> updateForum(@RequestBody Forum forum){
		
		boolean isSaved=forumDAO.updateForum(forum);
		if(isSaved)
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		else
			return new ResponseEntity<Forum>(forum,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@RequestMapping(value="/approveForum/{forumId}",method=RequestMethod.GET)
	public ResponseEntity<Forum> approveBlog(@PathVariable("forumId") int forumId){
		Forum forum=forumDAO.getForum(forumId);
		forum.setStatus("Y");
		
		boolean isSaved=forumDAO.updateForum(forum);
		if(isSaved)
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		else
			return new ResponseEntity<Forum>(forum,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@RequestMapping(value="/rejectForum/{forumId}",method=RequestMethod.GET)
	public ResponseEntity<Forum> rejectBlog(@PathVariable("forumId") int forumId){
		Forum forum=forumDAO.getForum(forumId);
		forum.setStatus("N");
		
		boolean isSaved=forumDAO.updateForum(forum);
		if(isSaved)
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		else
			return new ResponseEntity<Forum>(forum,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@RequestMapping(value="/addForumComments/{forumId}",method=RequestMethod.POST)
	public ResponseEntity<ForumComments> addForumcomments(@RequestBody ForumComments forumcomments,@PathVariable("forumId") int forumId){
Forum forum=forumDAO.getForum(forumId);
forumcomments.setForumm(forum);
		boolean isSaved=forumDAO.addForumComment(forumcomments);
		if(isSaved)
		return new ResponseEntity<ForumComments>(forumcomments,HttpStatus.OK);
		else
			return new ResponseEntity<ForumComments>(forumcomments,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@RequestMapping(value="/updateForumComments",method=RequestMethod.PUT)
	public ResponseEntity<ForumComments> updateBlogComments(@RequestBody ForumComments forumcomments){
		
		boolean isSaved=forumDAO.updateForumComment(forumcomments);
		if(isSaved)
		return new ResponseEntity<ForumComments>(forumcomments,HttpStatus.OK);
		else
			return new ResponseEntity<ForumComments>(forumcomments,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@RequestMapping(value="/deleteForumComment/{forumcommentid}",method=RequestMethod.DELETE)
	public ResponseEntity<ForumComments> deleteForumComment(@PathVariable("forumcommentid") int forumcommentId){
	
	ForumComments forumComments=forumDAO.getForumComment(forumcommentId);
forumDAO.deleteForumComment(forumComments);
	if(forumDAO.getForumComment(forumcommentId)==null)
	{
		
	}
	return new ResponseEntity<ForumComments>(forumDAO.getForumComment(forumcommentId),HttpStatus.OK);	
			
	}
	
	
	@RequestMapping(value="/getForumComment/{forumcommentId}",method=RequestMethod.GET)
	public ResponseEntity<ForumComments> getforumComment(@PathVariable("forumcomentid") int forumcommentId){
	
	
	if(forumDAO.getForumComment(forumcommentId)==null){
		
	}
	return new ResponseEntity<ForumComments>(forumDAO.getForumComment(forumcommentId),HttpStatus.OK);	
			
	
	
	
	}
	
	@RequestMapping(value="/getAllForumComments/{forumId}",method=RequestMethod.GET)
	public ResponseEntity<ArrayList<ForumComments>> getAllForumComment(@PathVariable("forumId") int forumId){
	
	
	if(forumDAO.getAllForumComments(forumId).isEmpty()){
		
	}
	return new ResponseEntity<ArrayList<ForumComments>>(forumDAO.getAllForumComments(forumId),HttpStatus.OK);	
			
	
	
	
	}

}
