app.factory("userservice",function($http){
    var BASE_URL="http://localhost:8080/SayhiMiddleware";
	var userservice ={};
	userservice.createUser=function(user){
	
		return $http.post(BASE_URL+"/user/register",user);		
	}
	return userservice;
});