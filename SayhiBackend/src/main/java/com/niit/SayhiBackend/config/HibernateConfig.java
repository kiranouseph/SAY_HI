package com.niit.SayhiBackend.config;



import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.SayhiBackend.dao.BlogCommentDAO;
import com.niit.SayhiBackend.dao.BlogDAO;
import com.niit.SayhiBackend.dao.EventDAO;
import com.niit.SayhiBackend.dao.ForumCommentDAO;
import com.niit.SayhiBackend.dao.ForumDAO;
import com.niit.SayhiBackend.dao.FriendDAO;
import com.niit.SayhiBackend.dao.JobDAO;
import com.niit.SayhiBackend.dao.UsersDAO;
import com.niit.SayhiBackend.daoimpl.BlogCommentDAOImpl;
import com.niit.SayhiBackend.daoimpl.BlogDAOImpl;
import com.niit.SayhiBackend.daoimpl.EventDAOImpl;
import com.niit.SayhiBackend.daoimpl.ForumCommentDAOImpl;
import com.niit.SayhiBackend.daoimpl.ForumDAOImpl;
import com.niit.SayhiBackend.daoimpl.FriendDAOImpl;
import com.niit.SayhiBackend.daoimpl.JobDAOImpl;
import com.niit.SayhiBackend.daoimpl.UsersDAOImpl;
import com.niit.SayhiBackend.model.Blog;
import com.niit.SayhiBackend.model.BlogComments;
import com.niit.SayhiBackend.model.EventParticipants;
import com.niit.SayhiBackend.model.Events;
import com.niit.SayhiBackend.model.Forum;
import com.niit.SayhiBackend.model.ForumComments;
import com.niit.SayhiBackend.model.ForumRequests;
import com.niit.SayhiBackend.model.Friend;
import com.niit.SayhiBackend.model.Job;
import com.niit.SayhiBackend.model.JobApplications;
import com.niit.SayhiBackend.model.Users;


@Configuration
@ComponentScan("com.niit.SayhiBackend")
@EnableTransactionManagement
public class HibernateConfig 
{
	@Autowired
	    @Bean(name="sessionFactory")
	    public SessionFactory sessionFactory(DataSource dataSource)  {
	        LocalSessionFactoryBuilder sessionBuilder  = new LocalSessionFactoryBuilder(dataSource);

	        /*sessionBuilder.setProperty("hibernate.show_sql", "true");*/
	        
	        sessionBuilder.addProperties(getHibernateProperties());
	     
	       sessionBuilder.addAnnotatedClass(Users.class);
	        sessionBuilder.addAnnotatedClass(Blog.class);
	       sessionBuilder.addAnnotatedClass(BlogComments.class);
	        sessionBuilder.addAnnotatedClass(Forum.class);
	        sessionBuilder.addAnnotatedClass(ForumComments.class);
	        sessionBuilder.addAnnotatedClass(Friend.class);
	        sessionBuilder.addAnnotatedClass(Job.class);
	        sessionBuilder.addAnnotatedClass(ForumRequests.class);
	        sessionBuilder.addAnnotatedClass(JobApplications.class);
	        sessionBuilder.addAnnotatedClass(Events.class); 
	        sessionBuilder.addAnnotatedClass(EventParticipants.class);
	        
	       
	        
	       
	        
	        return sessionBuilder.buildSessionFactory();
	    }
	 @Autowired
	    @Bean(name = "datasource") 
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.h2.Driver");
	        dataSource.setUrl("jdbc:h2:tcp://localhost/~/ecomdb");

	        dataSource.setUsername("sa");
	        dataSource.setPassword("");
	        System.out.println("Data Source Created.....");
	        return dataSource;

	       
	        }

	    private Properties getHibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.show_sql", "true");
	        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	  
	        properties.put("hibernate.format_sql", "true");
	        properties.put("hibernate.hbm2ddl.auto", "update");
	        properties.put("hibernate.connection.autocommit", true);
	        return properties;
	    }

	    
	    
	    @Autowired
	    @Bean(name="transactionManager")
	     
	        public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
	                return new HibernateTransactionManager(sessionFactory);
	        }
	        
	   @Autowired    
	    @Bean(name="blogDAO")
		public BlogDAO getBlogDAO(SessionFactory sessionFactory)
		{
			System.out.println("Blog DAO object Created");
			return new BlogDAOImpl(sessionFactory);
		}
	    
	    @Autowired    
	    @Bean(name="userDAO")
		public UsersDAO getUserDAO(SessionFactory sessionFactory)
		{
			System.out.println("User DAO object Created");
			return new UsersDAOImpl(sessionFactory);
		}
	    @Autowired    
	    @Bean(name="jobDAO")
		public JobDAO getJobDAO(SessionFactory sessionFactory)
		{
			System.out.println("Job DAO object Created");
			return new JobDAOImpl(sessionFactory);
		}
	    @Autowired    
	    @Bean(name="forumDAO")
		public ForumDAO getForumDAO(SessionFactory sessionFactory)
		{
			System.out.println("Forum DAO object Created");
			return new ForumDAOImpl(sessionFactory);
		}
	    
	    @Autowired    
	    @Bean(name="forumCommentDAO")
		public ForumCommentDAO getForumCommentDAO(SessionFactory sessionFactory)
		{
			System.out.println("ForumComment DAO object Created");
			return new ForumCommentDAOImpl(sessionFactory);
		}
	    
	    @Autowired    
	    @Bean(name="blogCommentDAO")
	    public BlogCommentDAO getBlogCommentDAO(SessionFactory sessionFactory)
		{
			System.out.println("BlogComment DAO object Created");
			return new BlogCommentDAOImpl(sessionFactory);
		}
	    
	    
	    @Autowired    
	    @Bean(name="friendDAO")
	    public FriendDAO getFriendDAO(SessionFactory sessionFactory)
		{
			System.out.println("BlogComment DAO object Created");
			return new FriendDAOImpl(sessionFactory);
		}
	    
	    @Autowired    
	    @Bean(name="eventDAO")
	    public EventDAO getEventDAO(SessionFactory sessionFactory)
		{
			System.out.println("Events DAO object Created");
			return new EventDAOImpl(sessionFactory);
		}
	 	 
	 

}