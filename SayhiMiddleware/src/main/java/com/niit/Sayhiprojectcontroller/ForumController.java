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
import com.niit.SayhiBackend.model.ForumRequests;
import com.niit.SayhiBackend.model.Users;

@RestController
@RequestMapping("/forums")
public class ForumController {
	@Autowired 
	ForumDAO forumDAO;
	@Autowired 
	UsersDAO usersDAO;
	
	
	@RequestMapping(value="/getAllForums",method=RequestMethod.GET)
	public  ArrayList<Forum> getAllForums(){
		
		ArrayList<Forum> forum=forumDAO.getAllForum();
		
		return  forum;
				
	}
	
	
	@RequestMapping(value="/addForum",method=RequestMethod.POST)
	public ResponseEntity<Forum> addForum(@RequestBody Forum forum){
		
		
		boolean isSaved=forumDAO.addForum(forum);
		if(isSaved)
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		else
			return new ResponseEntity<Forum>(forum,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@RequestMapping(value="/getForumById/{forumid}",method=RequestMethod.GET)
	public ResponseEntity<Forum> getForum(@PathVariable("forumid") int forumId){
	
	
	if(forumDAO.getForum(forumId)==null){
		
	}
	return new ResponseEntity<Forum>(forumDAO.getForum(forumId),HttpStatus.OK);	
			
	
	
	
	}
	
	
	

	
	
	
	
	@RequestMapping(value="/deleteForum/{forumid}",method=RequestMethod.GET)
	public ResponseEntity<Forum> deleteForum(@PathVariable("forumid") int forumId){
	
	Forum forum=forumDAO.getForum(forumId);
	forumDAO.deleteForum(forum);
	if(forumDAO.getForum(forumId)==null){
		
	}
	return new ResponseEntity<Forum>(forum,HttpStatus.OK);	
			
	
	
	
	}

	@RequestMapping(value="/updateForum",method=RequestMethod.POST)
	public ResponseEntity<Forum> updateForum(@RequestBody Forum forum){
		
		boolean isSaved=forumDAO.updateForum(forum);
		if(isSaved)
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		else
			return new ResponseEntity<Forum>(forum,HttpStatus.BAD_REQUEST);
		
	}
	
	

	

	
	@RequestMapping(value="/addForumComments/{forumId}",method=RequestMethod.POST)
	public ResponseEntity<ForumComments> addForumcomments(@RequestBody ForumComments forumcomments,@PathVariable("forumId") int forumId){

forumcomments.setForumid(forumId);
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
	
	
	if(forumDAO.getAllForumCommentsById(forumId).isEmpty()){
		
	}
	return new ResponseEntity<ArrayList<ForumComments>>(forumDAO.getAllForumCommentsById(forumId),HttpStatus.OK);	
			
	
	
	
	}
	
	@RequestMapping(value="/myforums/{myid}")
	public ResponseEntity<ArrayList<ForumRequests>> getmyforums(@PathVariable("myid") int myid)
	{
		return new ResponseEntity<ArrayList<ForumRequests>>(forumDAO.getAllMyForum(myid),HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/checkIfMyForum/{forumid}/{myid}",method=RequestMethod.GET)
	public ResponseEntity<ArrayList<ForumRequests>> getcheckifmyforum(@PathVariable("forumid") int forumId,@PathVariable("myid") int myid){
		ForumRequests f=new ForumRequests();
	ArrayList<ForumRequests> foru=forumDAO.checkIfMyForum(forumId, myid);
	return new ResponseEntity<ArrayList<ForumRequests>>(foru,HttpStatus.OK);	
			
	
	
	
	}
	
	
	@RequestMapping(value="/addForum/{forumid}/{myid}",method=RequestMethod.GET)
	public ResponseEntity<ForumRequests> addForumReq(@PathVariable("forumid") int forumId,@PathVariable("myid") int myid){
	
	
	
	ForumRequests fr=new ForumRequests();
	fr.setForumid(forumId);
	fr.setUserid(myid);
	fr.setStatus("NO");
	
	
		boolean isSaved=forumDAO.addForumRequest(fr);
		if(isSaved)
		{
			return new ResponseEntity<ForumRequests>(fr,HttpStatus.OK);	
		}
		else
		{
			return new ResponseEntity<ForumRequests>(fr,HttpStatus.BAD_REQUEST);
		}
				
	
	
	
	}
	
	
	@RequestMapping(value="/getForumRequests",method=RequestMethod.GET)
	public ResponseEntity<ArrayList<ForumRequests>> getForumrequests()
    {
		ArrayList<ForumRequests> ff=forumDAO.getAllForumRequest();
		for(ForumRequests fff:ff)
		{
			System.err.println(fff.getForumname());
			System.err.println(fff.getUsername());
			
		}
	return new ResponseEntity<ArrayList<ForumRequests>>(forumDAO.getAllForumRequest(),HttpStatus.OK);		
	}
	
	
	@RequestMapping(value="/approveForumRequests/{forumReqId}",method=RequestMethod.GET)
	public void approveForumRequets(@PathVariable("forumReqId") int forumreqid)
	{
		ForumRequests fr=forumDAO.getForumRequest(forumreqid);
		fr.setStatus("YES");
boolean IsSaved=forumDAO.acceptForumRequest(fr);
	}
	
	

}
