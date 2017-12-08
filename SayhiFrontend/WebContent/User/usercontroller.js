app.controller("logincontroller", function ($scope) {
    $scope.msg = "Login page";
});


app.controller("registercontroller", function ($scope,$location,$http) {
	 $scope.msg = "Register  page";
	 $scope.Users={firstname:'',lastname:'',email:'',password:'',role:'User',status:'Fine',isonline:'Yes',dob:new Date(),gender:'MALE'};
	 $scope.register=function()
	 {
		 console.log("in register controller angualr"+$scope.Users.dob);
		
		 $http.post("http://localhost:8080/SayhiMiddleware/user/register",$scope.Users).then(function(response){
		 
			 console.log("Registerd Successfully")
			 $scope.Users=response.data;
			 $location.path("/blog")
								
			},function(error){
				console.error("Error while creating user"+error)
			});
		 
	 }
	 
});