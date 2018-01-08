var app = angular.module("SAYHI", ["ngRoute",'ngCookies']);
app.config(function($routeProvider) {
	
    $routeProvider
    .when("/", {
        templateUrl : "User/login.html",
       
    })
   
    .when("/login", {
        templateUrl : "User/login.html",
       
    })
    .when("/register", {
        templateUrl : "User/register.html",
        
    })
   
      .when("/mywall", {
        templateUrl : "pages/mywall.html",
   controller:"friendcontroller",
        
    })
    
          .when("/picuplaod", {
        templateUrl : "pages/mywall.html",
   controller:"picuploadcontroller",
        
    })


    .when("/blog", {
        templateUrl : "pages/home.html",
       
       
    })
  
    
    .when("/newblog", {
        templateUrl : "Blog/newblog.html",
       
       
    })
  
       .when("/newforum", {
        templateUrl : "forum/newforum.html",
       
       
    })
  
       .when("/newjob", {
        templateUrl : "Job/newjob.html",
       
       
    })
     .when("/newevent", {
        templateUrl : "Events/newevent.html",
       
       
    })
  
    
    
      
    
     .when("/forumrequests", {
        templateUrl : "forum/forumrequests.html",
       
        
    })
    
    
      .when("/blogrequests", {
        templateUrl : "Blog/blogrequests.html",
       
        
    })
       .when("/eventrequests", {
        templateUrl : "Events/eventrequests.html",
       
        
    })
        .when("/userrequests", {
        templateUrl : "User/userrequests.html",
       
        
    })
    
    
      .when("/forummanage", {
        templateUrl : "forum/forummanage.html",
        
    })
    .when("/blogmanage", {
        templateUrl : "Blog/blogmanage.html",
        
    })
    .when("/jobmanage", {
        templateUrl : "Job/jobmanage.html",
        
    })
      .when("/eventmanage", {
        templateUrl : "Events/eventmanage.html",
        
    })
    
      .when("/blogforedit", {
        templateUrl : "Blog/updateblog.html",
        
    })
    
     .when("/forumforedit", {
        templateUrl : "forum/updateforum.html",
        
    })
    
      .when("/jobforedit", {
        templateUrl : "Job/updatejob.html",
        
    })
        .when("/eventforedit", {
        templateUrl : "Events/updateevent.html",
        
    })
    
     .when("/chat", {
        templateUrl : "chat/chat.html",
        
    })
      .when("/friendwall", {
        templateUrl : "pages/friendpreview.html",
        
    })
    
     .when("/forumview", {
        templateUrl : "forum/forumview.html",
        controller:"forumcontroller",
        
    })
    
        
     .when("/jobview", {
        templateUrl : "Job/jobview.html",
        controller:"jobcontroller",
        
    })
    
     .when("/eventview", {
        templateUrl : "Events/eventview.html",
        controller:"eventcontroller",
        
    })
      .when("/blogview", {
        templateUrl : "Blog/blogview.html",
  
    })
    .when("/noti", {
        templateUrl : "Notifications/notifications.html",
  
    });
    
});

app.run( function ($rootScope, $location, $cookieStore, $http) 
		{
		 $rootScope.$on('$locationChangeStart', function (event, next, current) 
					 {
						 console.log("$locationChangeStart")
						    
						 var userPages = ['/noti','/login','/register','/mywall','/picupload','/newblog','/newevent','/blogforedit','/eventforedit','/friendpreview'];
				 var adminPages = ['/login','/register','/newforum','/newjob','newevent','forumrequests','userrequests','/blogrequests','/eventrequests','/forummanage','/blogmanage','/jobmanage','/eventmanage','/forumforedit','/jobforedit','/eventforedit'];
						 
						 var currentPage = $location.path();
						 
						 var isUserPage = $.inArray(currentPage, userPages);
						 var isAdminPage = $.inArray(currentPage, adminPages);
						 
						 var isLoggedIn = $rootScope.currentuser.email;
					        
					     console.log("isLoggedIn:" +isLoggedIn)
					     console.log("isUserPage:" +isUserPage)
					     console.log("isAdminPage:" +isAdminPage)
					        
					        if(!isLoggedIn)
					        	{
					        	
					        		if(isUserPage!=-1 || isAdminPage!=-1)  
					        	 	{
						        	  console.log("Navigating to login page:")
						        	  alert("You need to Login first!")
						        	  $location.path('/login');
						         	}
					        	}
					        
							 else //logged in
					        	{
					        	
								 var role = $rootScope.currentuser.role;
								 if(isAdminPage!=-1 && role!='ROLE_ADMIN' )
									 {
									  alert("You cannot view this page as a " + role )
									  $location.path('/blog');
									 }
								 if(isUserPage!=-1 && role!='ROLE_USER' )
								 {
								  alert("You cannot view this page as a " + role )
								  $location.path('/blog');
								 }
								 
					        	}
					 });
					 
					 // to keep the user logged in after page refresh
				    $rootScope.currentuser = $cookieStore.get('user') || {};
				    if ($rootScope.currentuser)
				    {
				        $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.currentuser; 
				    }
				});