app.controller("forumcontroller", function ($scope,$http,$location,$rootScope) {
	console.log("in forum controller")
	$scope.Forum={formname:'',formcontent:''};
	
	
	
		
	
	
	
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
	
	
	 $scope.addForum=function()
	 {
		console.log("in add forum method")
		 $http.post("http://localhost:8080/SayhiMiddleware/forums/addForum",$scope.Forum).then(fetchAllForums(),function(response){
			 console.log("Forum added successfully")
			 
								
			},function(error){
				console.error("Error while adding adding forum")
			});
		$location.path('/forummanage')
		 
	 }
	 
$scope.fetchforumbyid=function(idd)
{
	console.log("in fetchby id method")
	 $http.get("http://localhost:8080/SayhiMiddleware/forums/getForumById/"+idd).then(function(response){
		 console.log("Forum retrieve successfully")

			$scope.ForumByid=response.data; 
		 console.log("Forum retrieve successfully")
		 console.log("Forum name"+$scope.ForumByid.formname)
		 console.log("Forum content"+$scope.ForumByid.formcontent)
			},function(error){
				console.log("Error on retrieving forum")
			});
	
	

$http.get("http://localhost:8080/SayhiMiddleware/forums/checkIfMyForum/"+idd+"/"+$rootScope.currentuser.userid).then(function(response){
	 $scope.forr=response.data;
	 console.log($scope.forr)

		

/*if($scope.forr==null)
	{
	$scope.fstatus="SEND REQUEST";
	console.log("send request")
	}
else if($scope.forr.status=='A')
				{
	$scope.fstatus="PENDING";	

	console.log("pending")

				}			
else if($scope.forr.status=='YES')
	{
	$scope.fstatus="ENJOY DISCUSSION";
	

	console.log("enjoy discussion")

	}*/
		},function(error){

		});
$location.path('/forumview');
}



	 $scope.editForum=function(idd)
	 {
		console.log("in edit blog method")
		 $http.post("http://localhost:8080/SayhiMiddleware/forums/updateForum/"+$scope.Forum).then(fetchForum(idd),function(response){
			 console.log("Forum updated successfully");
								
			},function(error){
				console.error("Error while updating Forum");
			});
		 
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
		 
	 }
	

	
	
	$scope.myforums=function()
	{
		
 $http.get("http://localhost:8080/SayhiMiddleware/forums/myforums/"+$rootScope.currentuser.userid).then(function(response){
			 
			$scope.myforums=response.data;
								
			},function(error){
				console.error("Error while accepting forumrequets Forum");
			});	
		
		
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
		 
	 }
	
	
});
