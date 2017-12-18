var app = angular.module("SAYHI", ["ngRoute"]);
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
      .when("/forummanage", {
        templateUrl : "forum/forummanage.html",
        
    })
    
      .when("/blogview", {
        templateUrl : "Blog/blogview.html",
        controller : "blogcontroller",
    });
    
});

