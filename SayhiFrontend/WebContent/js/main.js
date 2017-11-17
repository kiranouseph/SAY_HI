var app = angular.module("SAYHI", ["ngRoute"]);
app.config(function($routeProvider) {
	
    $routeProvider
    .when("/", {
        templateUrl : "User/login.html",
        controller : "homecontroller"
    })
   
    .when("/login", {
        templateUrl : "User/login.html",
        controller : "logincontroller"
    })
    .when("/register", {
        templateUrl : "User/register.html",
        controller : "registercontroller"
    });
});

