package com.niit.Sayhiprojectcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SayhiBackend.dao.UsersDAO;
import com.niit.SayhiBackend.model.Users;

@RestController

@RequestMapping("/user")
public class UserController {
@Autowired
UsersDAO udao;
	
	
@CrossOrigin(origins="http://localhost:8080")
	 @RequestMapping(value="/getAllUsers",method=RequestMethod.GET,headers="Accept=application/json")
		public ResponseEntity getAllUser(){
			
			if(udao.getAllUser().isEmpty()){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No User registerd..");
			}
			return new ResponseEntity(udao.getAllUser(),HttpStatus.OK);
					
		}
	 
	 @RequestMapping(value="/register",method=RequestMethod.POST)
		public ResponseEntity<Users> createUser(@RequestBody Users user){
			System.out.println("In register cvontrolelr");
			boolean isSaved=udao.saveUser(user);
			if(isSaved)
			return new ResponseEntity<Users>(user,HttpStatus.OK);
			else
				return new ResponseEntity<Users>(user,HttpStatus.METHOD_FAILURE);
			
		}
		
	

}
