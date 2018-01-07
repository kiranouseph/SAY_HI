package com.niit.Sayhiprojectcontroller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SayhiBackend.dao.EventDAO;
import com.niit.SayhiBackend.dao.UsersDAO;
import com.niit.SayhiBackend.model.EventParticipants;
import com.niit.SayhiBackend.model.Events;
import com.niit.SayhiBackend.model.JobApplications;
import com.niit.SayhiBackend.model.Users;

@RestController
@RequestMapping("/events")
public class EventController {
	
	@Autowired 
	EventDAO eventDAO;
	

@Autowired
UsersDAO userDAO;
	@RequestMapping(value="/addEvent",method=RequestMethod.POST)
	public ResponseEntity<String> addEvent(@RequestBody Events events,HttpSession session){
		 Users user = (Users)session.getAttribute("currentuser");
		if(user.getRole()=="ROLE_ADMIN")
		{
			events.setStatus("A");
		}
		boolean isSaved=eventDAO.addEvent(events);
		if(isSaved)
		return new ResponseEntity<String>("event added ok",HttpStatus.OK);
		else
			return new ResponseEntity<String>("event add error",HttpStatus.BAD_REQUEST);
		
	}
	
	
	@RequestMapping(value="/getEvent/{eventid}",method=RequestMethod.GET,headers = "Accept=application/json")
	public ResponseEntity<Events> getEvent(@PathVariable("eventid") int eventid){

	System.out.println("In get Event controller"+eventid);
	if(eventDAO.getevent(eventid)==null){
		return new ResponseEntity<Events>(eventDAO.getevent(eventid),HttpStatus.BAD_REQUEST);	
		
	}
	else
	{
		return new ResponseEntity<Events>(eventDAO.getevent(eventid),HttpStatus.OK);	
	}


	}
	@RequestMapping(value="/getAllEvents",method=RequestMethod.GET,headers = "Accept=application/json")
	public ArrayList<Events> getAllEvents(){
		ArrayList<Events> events=(ArrayList<Events>)eventDAO.getAllevents();
		if(events.isEmpty()){
			return null;
		}
		else
		{
			return events;	
		}
		
				
	}
	
	
	@RequestMapping(value="/getAlleventreq",method=RequestMethod.GET)
	public ArrayList<Events> getAllEventreq(){
	 System.out.println("in rest controller getalleventsreq");
		ArrayList<Events> eventreq=(ArrayList<Events>)eventDAO.eventrequests();
		System.out.println("in rest controller getalleventsreq");

	return eventreq;		
	} 
 
 @RequestMapping(value="/approveevents/{eventid}",method=RequestMethod.GET)
 public void approveusers(@PathVariable("eventid") int eventid)
 {
	 Events event=eventDAO.getevent(eventid);
	 event.setStatus("A");
	
	 eventDAO.approveevent(event);
	 
 }
 
 
 @RequestMapping(value="/rejectevents/{eventid}",method=RequestMethod.GET)
 public void rejectusers(@PathVariable("eventid") int eventid)
 {
	 Events event=eventDAO.getevent(eventid);
	 event.setStatus("R");
	
	 eventDAO.rejectevent(event);
	 
 }
 
 	
	
	
	
	@RequestMapping(value="/deleteEvent/{eventid}",method=RequestMethod.GET)
	public ResponseEntity<String> deleteBlog(@PathVariable("eventid") int eventid){

	Events events=eventDAO.getevent(eventid);
	if(eventDAO.deleteEvent(events))
	{ArrayList<EventParticipants> evp=eventDAO.eventpars(eventid);
	for(EventParticipants evpp:evp)
	{
		eventDAO.deleteEventpars(evpp);
	}
		return new ResponseEntity<String>("Event deleted successfully",HttpStatus.OK);	
	}
	return new ResponseEntity<String>("Event deletion error",HttpStatus.BAD_REQUEST);	
			



	}
	@RequestMapping(value="/updateEvent/{eventid}/{eventdate}/{eventname}/{eventesc}/{eventvenue}",method=RequestMethod.GET)
	public ResponseEntity<String> updateEvents(@PathVariable("eventid") int eventid,@PathVariable("eventdate") Date eventdate,@PathVariable("eventname") String eventname,@PathVariable("eventesc") String eventesc,@PathVariable("eventvenue") String eventvenue){
	
		Events event=new Events();
		event.setEventid(eventid);
		
		event.setEventname(eventname);
		event.setEventdesc(eventesc);
		event.setEventvenue(eventvenue);
	
		boolean isSaved=eventDAO.updateEvent(event);
		if(isSaved)
		return new ResponseEntity<String>("event update succcess",HttpStatus.OK);
		else
			return new ResponseEntity<String>("event update failure",HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@RequestMapping(value="/applyEvent/{Eventid}/{myid}",method=RequestMethod.GET)
	public ResponseEntity<String> applyJob(@PathVariable("Eventid") int eventid,@PathVariable("myid") int myid)
	{
		EventParticipants eventparticipants=new EventParticipants();
		eventparticipants.setEventid(eventid);
		eventparticipants.setUserid(myid);
		boolean isSaved=eventDAO.applyevent(eventparticipants);
		if(isSaved)
		{
			return new ResponseEntity<String>("events applied successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("event apply failed",HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value="/myEvents/{myid}",method=RequestMethod.GET)
	public ArrayList<Events> myevents(@PathVariable("myid") int myid)
	{
		ArrayList<Events> myevents=new ArrayList<Events>();
		ArrayList<EventParticipants> evenpars =eventDAO.myevents(myid);
		for(EventParticipants eventpa:evenpars)
		{
			
			myevents.add(eventDAO.getevent(eventpa.getEventid()));
			
		}
		for(Events e:myevents)
		{
			System.out.println(e.getEventname());
		}
		return myevents;
	}
	
	
	@RequestMapping(value="/checkifappliedevent/{eventid}/{myid}",method=RequestMethod.GET)
	public ArrayList<EventParticipants> checkifapplied(@PathVariable("eventid") int eventid,@PathVariable("myid") int myid)
	{
		return eventDAO.checkIfeveAppliied(eventid, myid);
	}

	@RequestMapping(value="/eventparts/{eventid}",method=RequestMethod.GET)
	public ArrayList<Users> jobapps(@PathVariable("eventid") int eventid)
	{ArrayList<Users> u=new ArrayList<Users>();
		ArrayList<EventParticipants> evepars=eventDAO.eventpars(eventid);
		for(EventParticipants e:evepars)
		{
			Users us=userDAO.getUser(e.getUserid());
			u.add(us);
		}
		return u;
	}



}
