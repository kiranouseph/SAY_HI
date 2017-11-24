package com.niit.SayhiBackend.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SayhiBackend.dao.BlogDAO;
import com.niit.SayhiBackend.dao.UsersDAO;
import com.niit.SayhiBackend.model.Users;

public class UsersDAOTest {

	@Autowired
public static UsersDAO usersDAO;
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.SayhiBackend");
		context.refresh();
		
		usersDAO=(UsersDAO)context.getBean("userDAO");
	}
	
	@Ignore
	@Test
	public void getAllUsersTest()
	{
		ArrayList<Users> users= usersDAO.getAllUser();
		for(Users u:users)
		{
			System.out.println(u.getFirstname());
			System.out.println(u.getLastname());
			System.out.println(u.getPassword());
		
		
	}
	}
		
		@Ignore
		@Test
		public void addUserTest()
		{
			Users users =new Users();
			users.setFirstname("kiran");
			users.setLastname("ouseph");
			users.setEmail("kiranouseph@gmail.com");
			users.setIsonline("N");
			users.setPassword("kiranouseph12");
			users.setRole("ROLE_USER");
			users.setStatus("hello");
			users.setUserid(1236);
			
			assertTrue("Problem in Inserting USer",usersDAO.saveUser(users));
			
			
			
			
		}
		
		@Ignore
		@Test
		public void getUserTest()
		{
			
			Users users=(Users)usersDAO.getUser(42);
			
		}
		
		
		@Test
		public void updateOnlineStatusTest()

		{
			Users users=usersDAO.getUser(42);
			
			assertTrue("Problem in updating Online Status",usersDAO.updateOnlineStatus("Y", users));
			
			
		}

}

	