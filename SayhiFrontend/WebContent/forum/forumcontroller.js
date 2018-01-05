app.controller("forumcontroller", function ($scope,$http,$location,$rootScope) {
	console.log("in forum controller")
	$scope.Forum={formname:'',formcontent:''};
	$scope.ForumComments={forumcomm:'',forumid:'',userid:'',username:''};
	function fetchAllForums()
	{
		console.log("in fetch all forums method")
	$http.get("http://localhost:8080/SayhiMiddleware/forums/getAllForums")
		.then(function(response)
		{
			console.log("Forums retrieve successfully")
			$scope.forums=response.data;
	console.log($scope.forums)
						
		},function(error)
		{
			console.log("Error on retrieving forums")
		});
	};
	
	
	fetchAllForums();
	
	
	
	function myallforums()
	{
		
	
		$http.get("http://localhost:8080/SayhiMiddleware/forums/myforums/"+$rootScope.currentuser.userid)
		.then(function(response)
		{
			
			$rootScope.myforum=response.data;
			
						
		},function(error)
		{
			console.log("Error on retrieving blogs")
		});	
		
		
	}
	myallforums();
	
	
	
	
	
	
	function fetchForumByIdd(idd)
	{
		
		 $http.get("http://localhost:8080/SayhiMiddleware/forums/getForumById/"+idd).then(function(response){
				

				$rootScope.ForumByid=response.data; 
			
				},function(error){
					console.log("Error on retrieving forum")
				});
		
		

	$http.get("http://localhost:8080/SayhiMiddleware/forums/checkIfMyForum/"+idd+"/"+$rootScope.currentuser.userid).then(function(response){
		$rootScope.fcheck=response.data;
		
		
			


		

			});
	$location.path('/forumview');
		
		
		
	}
	
	
	 $scope.addForum=function()
	 {
		console.log("in add forum method")
		 $http.post("http://localhost:8080/SayhiMiddleware/forums/addForum",$scope.Forum).then(fetchAllForums(),function(response){
			 console.log("Forum added successfully")
			 
								
			},function(error){
				console.error("Error while adding adding forum")
			});
		$location.path('/blog')
		 
	 }
	 
$scope.fetchforumbyid=function(idd)
{
console.log('in fetch forum by id method'+idd)
	 $http.get("http://localhost:8080/SayhiMiddleware/forums/getForumById/"+idd).then(function(response){
		

			$rootScope.ForumByid=response.data; 
		
			},function(error){
				console.log("Error on retrieving forum")
			});
	
	

$http.get("http://localhost:8080/SayhiMiddleware/forums/checkIfMyForum/"+idd+"/"+$rootScope.currentuser.userid).then(function(response){
	$rootScope.fcheck=response.data;
	
	
		


	

		});


$http.get("http://localhost:8080/SayhiMiddleware/forums/getAllForumComments/"+idd)
.then(function(response)
{
	
	$rootScope.gforumcomm=response.data;
	
	
},function(error)
{
	
});		


$http.get("http://localhost:8080/SayhiMiddleware/forums/forumreqbyforumid/"+idd)
.then(function(response)
{
	
	$rootScope.forusers=response.data;
	
	
},function(error)
{
	
});





$location.path('/forumview');
}

$scope.fetchforumforedit=function(idd)
{
	console.log("in forum fetch for edit  method")
	 $http.get("http://localhost:8080/SayhiMiddleware/forums/getForumById/"+idd).then(function(response){
		 

			$rootScope.eforum=response.data; 
		
			},function(error){
				console.log("Error on retrieving forum")
			});
	
	$location.path('/forumforedit')

}

	 $scope.editForum=function(idd)
	 {
		console.log("in edit blog method")
		if($scope.Forum.formname==null)
			{
			$scope.Forum.formname=$rootScope.ForumByid.formname;
			}
		if($scope.Forum.formcontent==null)
			{
			$scope.Forum.formcontent=$rootScope.ForumByid.formcontent;
			}
		 $http.post("http://localhost:8080/SayhiMiddleware/forums/updateForum/"+idd+"/"+$scope.Forum.formname+"/"+$scope.Forum.formcontent).then(fetchAllForums(),function(response){
			 console.log("Forum updated successfully");
								
			},function(error){
				console.error("Error while updating Forum");
			});
		
		
		
		 $http.get("http://localhost:8080/SayhiMiddleware/forums/getForumById/"+$rootScope.eforum.forumid).then(function(response){
				$rootScope.eforum=response.data; 
					
				},function(error){
				
				});
		 
		 $location.path('/blog')
		 
		 
		 
	 }
	
	
	 $scope.deleteForum=function(idd)
	 {
		console.log("in delete forum method")
		 $http.get("http://localhost:8080/SayhiMiddleware/forums/deleteForum/"+idd).then(fetchAllForums(),function(response){
			 console.log("Forum deleted successfully");
			 location.path('/forummanage')
								
			},function(error){
				console.error("Error while deleting Forum");
			});
		
		 $location.path('/blog')
	 }
	

	
	
	$scope.myforums=function()
	{
		
 $http.get("http://localhost:8080/SayhiMiddleware/forums/myforums/"+$rootScope.currentuser.userid).then(function(response){
			 
			$scope.myforums=response.data;
								
			},function(error){
				console.error("Error while accepting forumrequets Forum");
			});	
		
		
	}
	
	
	
	 $scope.sendforumrequests=function()
	 {
		console.log('in send froum request')
		console.log($rootScope.ForumByid.forumid+$rootScope.currentuser.userid)
		 $http.get("http://localhost:8080/SayhiMiddleware/forums/addForumReq/"+$rootScope.ForumByid.forumid+"/"+$rootScope.currentuser.userid).then(fetchForumByIdd($rootScope.ForumByid.forumid),function(response){
			 console.log("Forumrequested successfully");
		 });
		
		 $location.path('/forumview')
	 }
	 
	 
	 
	 
	 
	 $scope.addForumComment=function()
	 {
		console.log("in add forumComment method")
		console.log($rootScope.ForumByid.forumid+$rootScope.currentuser.email+$scope.ForumComments.forumcomm)

		$http.get("http://localhost:8080/SayhiMiddleware/forums/addForumComments/"+$rootScope.ForumByid.forumid+"/"+$rootScope.currentuser.email+"/"+$scope.ForumComments.forumcomm).then(function(response){
			 console.log("BlogComments added successfully")
								
			},function(error){
				
			});
		
		$http.get("http://localhost:8080/SayhiMiddleware/forums/getAllForumComments/"+$rootScope.ForumByid.forumid)
		.then(function(response)
		{
			
			$rootScope.gforumcomm=response.data;
			
			
		},function(error)
		{
			
		});		
		
		$location.path('/forumview')	 
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	
	
	
	
	
});


app.controller("forumrequestcontroller", function ($scope,$http,$location,$rootScope) {
	function fetchAllForumreq()
	{
	
	 $http.get("http://localhost:8080/SayhiMiddleware/forums/getForumRequests")
	    .then(function(response)
	    		{
	    	
	    
		 $scope.forumrequests=response.data;
	
		 $location.path('/forumrequests')
							
		},function(error){
			console.error("Error while deleting Forum");
		});
	}
	
	
	fetchAllForumreq();
	
	
	
	
	
	
	 $scope.acceptforumrequests=function(id)
	 {
		 
		 
		console.log("in forum request  accept method")
		 $http.get("http://localhost:8080/SayhiMiddleware/forums/approveForumRequests/"+id).then(fetchAllForumreq(),function(response){
			 
			 console.log("Forumrequests accepted  successfully");
			 $location.path('/forumrequests')
								
			},function(error){
				console.error("Error while accepting forumrequets Forum");
			});
		$location.path('/forummanage')
		 
	 }
	 

	 
	
	
});
