package com.niit.Sayhiprojectcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SayhiBackend.dao.ForumDAO;
import com.niit.SayhiBackend.model.Blog;
import com.niit.SayhiBackend.model.BlogComments;
import com.niit.SayhiBackend.model.Forum;
import com.niit.SayhiBackend.model.ForumComments;

@RestController
@RequestMapping("/forums")
public class ForumController {
	@Autowired 
	ForumDAO forumDAO;
	
	@RequestMapping(value="/getAllForums",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity getAllForums(){
		
		if(forumDAO.getAllForum().isEmpty()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No forums registerd..");
		}
		return new ResponseEntity(forumDAO.getAllForum(),HttpStatus.OK);
				
	}
	
	
	@RequestMapping(value="/addForum",method=RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<Forum> addForum(@RequestBody Forum forum){
		
		boolean isSaved=forumDAO.addForum(forum);
		if(isSaved)
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		else
			return new ResponseEntity<Forum>(forum,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@RequestMapping(value="/getForum/{forumid}",method=RequestMethod.GET)
	public ResponseEntity getForum(@PathVariable("forumid") int forumId){
	
	
	if(forumDAO.getForum(forumId)==null){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such forum exists");
	}
	return new ResponseEntity(forumDAO.getForum(forumId),HttpStatus.OK);	
			
	
	
	
	}
	
	
	
	
	@RequestMapping(value="/deleteForum/{forumid}",method=RequestMethod.DELETE)
	public ResponseEntity deleteForum(@PathVariable("forumid") int forumId){
	
	Forum forum=forumDAO.getForum(forumId);
	forumDAO.deleteForum(forum);
	if(forumDAO.getForum(forumId)==null){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such forum exists");
	}
	return new ResponseEntity(forumDAO.getAllForum(),HttpStatus.OK);	
			
	
	
	
	}

	@RequestMapping(value="/updateForum",method=RequestMethod.PUT)
	public ResponseEntity updateForum(@RequestBody Forum forum){
		
		boolean isSaved=forumDAO.updateForum(forum);
		if(isSaved)
		return new ResponseEntity(forum,HttpStatus.OK);
		else
			return new ResponseEntity(forum,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@RequestMapping(value="/approveForum/{forumId}",method=RequestMethod.GET)
	public ResponseEntity approveBlog(@PathVariable("forumId") int forumId){
		Forum forum=forumDAO.getForum(forumId);
		forum.setStatus("Y");
		
		boolean isSaved=forumDAO.updateForum(forum);
		if(isSaved)
		return new ResponseEntity(forum,HttpStatus.OK);
		else
			return new ResponseEntity(forum,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@RequestMapping(value="/rejectForum/{forumId}",method=RequestMethod.GET)
	public ResponseEntity rejectBlog(@PathVariable("forumId") int forumId){
		Forum forum=forumDAO.getForum(forumId);
		forum.setStatus("N");
		
		boolean isSaved=forumDAO.updateForum(forum);
		if(isSaved)
		return new ResponseEntity(forum,HttpStatus.OK);
		else
			return new ResponseEntity(forum,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@RequestMapping(value="/addForumComments/{forumId}",method=RequestMethod.POST)
	public ResponseEntity addForumcomments(@RequestBody ForumComments forumcomments,@PathVariable("forumId") int forumId){

		boolean isSaved=forumDAO.addForumComment(forumcomments);
		if(isSaved)
		return new ResponseEntity(forumcomments,HttpStatus.OK);
		else
			return new ResponseEntity(forumcomments,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@RequestMapping(value="/updateForumComments",method=RequestMethod.PUT)
	public ResponseEntity updateBlogComments(@RequestBody ForumComments forumcomments){
		
		boolean isSaved=forumDAO.updateForumComment(forumcomments);
		if(isSaved)
		return new ResponseEntity(forumcomments,HttpStatus.OK);
		else
			return new ResponseEntity(forumcomments,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@RequestMapping(value="/deleteForumComment/{forumcommentid}",method=RequestMethod.DELETE)
	public ResponseEntity deleteForumComment(@PathVariable("forumcommentid") int forumcommentId){
	
	ForumComments forumComments=forumDAO.getForumComment(forumcommentId);
forumDAO.deleteForumComment(forumComments);
	if(forumDAO.getForumComment(forumcommentId)==null)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such forrum comment exists");
	}
	return new ResponseEntity(forumDAO.getForumComment(forumcommentId),HttpStatus.OK);	
			
	}
	
	
	@RequestMapping(value="/getForumComment/{forumcommentId}",method=RequestMethod.GET)
	public ResponseEntity getforumComment(@PathVariable("forumcomentid") int forumcommentId){
	
	
	if(forumDAO.getForumComment(forumcommentId)==null){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such blogcommnet exists");
	}
	return new ResponseEntity(forumDAO.getForumComment(forumcommentId),HttpStatus.OK);	
			
	
	
	
	}
	
	@RequestMapping(value="/getAllForumComments/{forumId}",method=RequestMethod.GET)
	public ResponseEntity getAllForumComment(@PathVariable("forumId") int forumId){
	
	
	if(forumDAO.getAllForumComments(forumId).isEmpty()){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No comment for this forum exists");
	}
	return new ResponseEntity(forumDAO.getAllForumComments(forumId),HttpStatus.OK);	
			
	
	
	
	}

}
