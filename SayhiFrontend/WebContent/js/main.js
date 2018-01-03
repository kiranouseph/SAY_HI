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
   .when("/jobmanage", {
        templateUrl : "Job/jobmanage.html",
        
    })
      .when("/mywall", {
        templateUrl : "pages/mywall.html",
   
        
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
  
    
     .when("/forumview", {
        templateUrl : "forum/forumview.html",
        controller:"forumcontroller",
        
    })
    
        
     .when("/jobview", {
        templateUrl : "Job/jobview.html",
        controller:"jobcontroller",
        
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
    
    
      .when("/blogforedit", {
        templateUrl : "Blog/updateblog.html",
        
    })
    
     .when("/forumforedit", {
        templateUrl : "forum/updateforum.html",
        
    })
    
      .when("/jobforedit", {
        templateUrl : "Job/updatejob.html",
        
    })
    
     .when("/chat", {
        templateUrl : "chat/chat.html",
        
    })
      .when("/friendwall", {
        templateUrl : "pages/friendpreview.html",
        
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
