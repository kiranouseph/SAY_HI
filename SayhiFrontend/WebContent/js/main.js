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

    .when("/blog", {
        templateUrl : "Blog/blog.html",
        controller : "blogcontroller"
    });
    
});

