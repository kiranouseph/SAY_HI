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
  
    });
    
});

app.run(function($rootScope,$cookieStore){
	console.log('i am in run function');

	if($rootScope.currentuser==undefined)
		{
		$rootScope.currentuser=$cookieStore.get('user');
		}
	else{
	
	}
});
