app.controller("logincontroller", function ($scope) {
    $scope.msg = "Login page";
});
app.controller("registercontroller", function ($scope,userservice) {
	 $scope.msg = "Register  page";
	 $scope.User={firstname:'',lastname:'',email:'',password:'',role:'USER',status:'feels good',isonline:'Y',dob:new Date(),gender:''};
	 $scope.register=function()
	 {
	
		
		 userservice.createUser($scope.User).then(function(response){
			 console.log("Registerd Successfully");
								
			},function(error){
				console.error("Error while creating user");
			})
		 
	 }
	 
});