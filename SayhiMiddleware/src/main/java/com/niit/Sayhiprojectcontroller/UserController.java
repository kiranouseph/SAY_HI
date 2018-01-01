package com.niit.Sayhiprojectcontroller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.niit.SayhiBackend.dao.JobDAO;
import com.niit.SayhiBackend.dao.UsersDAO;
import com.niit.SayhiBackend.model.Job;
import com.niit.SayhiBackend.model.Users;

@RestController

@RequestMapping("/user")
public class UserController {
@Autowired
UsersDAO userDAO;
@Autowired
JobDAO jobDAO;	
	

	 @RequestMapping(value="/getAllUsers",method=RequestMethod.GET)
		public ArrayList<Users> getAllUser(){
		 System.out.println("in rest controller getallusers");
			ArrayList<Users> user=(ArrayList<Users>)userDAO.getAllUser();
			System.out.println("in rest controller getallusers");

		return user;		
		}
	 
	 

	 
	 
	 @RequestMapping(value="/getUser/{userid}",method=RequestMethod.GET)
		public ResponseEntity<Users> getUser(@PathVariable("userid") int userId){
			
		 if(userDAO.getUser(userId)==null){
				
			}
			return new ResponseEntity<Users>(userDAO.getUser(userId),HttpStatus.OK);
					
		}
	 
	 @RequestMapping(value="/register",method=RequestMethod.POST)
		public ResponseEntity<Users> createUser(@RequestBody Users user){
			System.out.println("In register controller");
			boolean isSaved=userDAO.saveUser(user);
			if(isSaved) {
			return new ResponseEntity<Users>(user,HttpStatus.OK);
			}
			else
				return new ResponseEntity<Users>(user,HttpStatus.BAD_REQUEST);
			
		}
	
	 @RequestMapping(value="/login",method=RequestMethod.POST)
		public ResponseEntity<Users> login(@RequestBody Users user,HttpSession http){
		


		 
			if(userDAO.checkLogin(user))
			{
				 Users tempuser=userDAO.getUserbyemail(user.getEmail());
				System.out.println("3..."+tempuser.getEmail());
				System.out.println("3..."+tempuser.getPassword());
			tempuser.setIsonline("YES");
				userDAO.updateOnlineStatus(tempuser);
			http.setAttribute("currentuser",tempuser);	
			return new ResponseEntity<Users>(tempuser,HttpStatus.OK);
				
				
			}
			else
			{
				return new ResponseEntity<Users>(user,HttpStatus.BAD_REQUEST);
			}
			
		}
	
	 @RequestMapping(value="/job",method=RequestMethod.POST)
		public ResponseEntity<Job> getJob(){
		
			
				return new ResponseEntity<Job>(jobDAO.getjob(33),HttpStatus.BAD_REQUEST);
			
		}
	 
	 @RequestMapping(value="/logout/{email}",method=RequestMethod.GET)
		public ResponseEntity<String> logout(@PathVariable("email") String email){
		 System.out.println(email);
		 
	 String emaill=email+".com";

	 System.out.println(emaill);
Users tempuser=userDAO.getUserbyemail(emaill);
		 tempuser.setIsonline("NO");
		userDAO.updateOnlineStatus(tempuser);
		return new ResponseEntity<String>("Lgout success",HttpStatus.OK);		 
}
	 
	 @RequestMapping(value="/up",method = RequestMethod.POST)
	 public void upload(HttpServletRequest request,@RequestParam("uploadedFile") MultipartFile file,HttpSession session )
	 {
	 	  /* String filepath = request.getSession().getServletContext().getRealPath("/") + "resources/product/" + file.getOriginalFilename();
	 		*/
	 	    String filepath ="C:/Users/user/eclipse-workspace/SayhiFrontend/WebContent/resources/images/" + file.getOriginalFilename();
	 		String img=file.getOriginalFilename();
	 		System.out.println(img);
	 		System.out.println(filepath);
	 		try {
	 			byte imagebyte[] = file.getBytes();
	 			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));
	 			fos.write(imagebyte);
	 			fos.close();
	 			} catch (IOException e) {
	 			e.printStackTrace();
	 			} catch (Exception e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 			}
	 		Users user = (Users)session.getAttribute("currentuser");
	 	System.out.println(user.getEmail());
	 		user.setImage(img);
	 	userDAO.updateOnlineStatus(user);
	 }
	 
	 
	 @RequestMapping(value="/upcover",method = RequestMethod.POST)
	 public void uploadcover(HttpServletRequest request,@RequestParam("uploadedFile") MultipartFile file,HttpSession session )
	 {
	 	  /* String filepath = request.getSession().getServletContext().getRealPath("/") + "resources/product/" + file.getOriginalFilename();
	 		*/
	 	    String filepath ="C:/Users/user/eclipse-workspace/SayhiFrontend/WebContent/resources/images/" + file.getOriginalFilename();
	 		String img=file.getOriginalFilename();
	 		System.out.println(img);
	 		System.out.println(filepath);
	 		try {
	 			byte imagebyte[] = file.getBytes();
	 			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));
	 			fos.write(imagebyte);
	 			fos.close();
	 			} catch (IOException e) {
	 			e.printStackTrace();
	 			} catch (Exception e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 			}
	 		Users user = (Users)session.getAttribute("currentuser");
	 	System.out.println(user.getEmail());
	 		user.setCover(img);
	 	userDAO.updateOnlineStatus(user);
	 }
	
}