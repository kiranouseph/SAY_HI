
app.controller("friendrequsetcontroller", function ($scope,$http,$location,$rootScope) {

	$http.get("http://localhost:8080/SayhiMiddleware/friend/getAllMyFriendRequests/"+ $rootScope.currentuser.userid)

	.then(function(response) {
		$scope.myfriendreqs = response.data;
		console.log("all my friendsreqs  fetched")
	},function(error)
	{
		console.log("Error on retrieving forums")
	});

});




app.controller("friendcontroller", function ($scope,$http,$location,$rootScope) {
	
	function fetchAllUsers()
	{
		
		
		$http.get("http://localhost:8080/SayhiMiddleware/friend/getMyFriends/"+ $rootScope.currentuser.userid)

		.then(function(response) {
			$scope.myfriends = response.data;
			console.log("all my friends fetched")
		},function(error)
		{
			console.log("Error on retrieving forums")
		});
		
		
		$http.get("http://localhost:8080/SayhiMiddleware/friend/getAllOtherUsers/"+ $rootScope.currentuser.userid)

		.then(function(response) {
			$scope.otherusers = response.data;
			console.log("all other users fetched")
		},function(error)
		{
			console.log("Error on retrieving forums")
		});
		

		$http.get("http://localhost:8080/SayhiMiddleware/friend/getOnlineFriends/"+ $rootScope.currentuser.userid)

		.then(function(response) {
			$scope.onlineusers = response.data;
			console.log("all online users fetched")
		},function(error)
		{
			console.log("Error on retrieving forums")
		});
		
		
		$http.get("http://localhost:8080/SayhiMiddleware/friend/getAllMyFriendRequests/"+ $rootScope.currentuser.userid)

		.then(function(response) {
			$scope.myfriendreqs = response.data;
			console.log("all my friendsreqs  fetched")
		},function(error)
		{
			console.log("Error on retrieving forums")
		});
		
		
		
		
	}
	;
	fetchAllUsers();
	
	$scope.insertFriend = function(friendid)
	{
		console.log('entered add friend method'+friendid);
		$http.get('http://localhost:8080/SayhiMiddleware/friend/addFriend/'+$rootScope.currentuser.userid+'/'+friendid)
		.then(fetchAllUsers(), function(response) {
			console.log("successful friend add ");
			$location.path("/mywall")
		});
	}
	
	
	

	$scope.unfriend = function(friendid)
	{
	console.log("in unfriend method")
		$http.get('http://localhost:8080/SayhiMiddleware/friend/unfriend/'+$rootScope.currentuser.userid+'/'+friendid)
		.then(fetchAllUsers(), function(response) {
			console.log("successful friend add ");
			$location.path("/mywall")
		});
	}
	
	$scope.acceptfriend = function(friendid)
	{
	console.log("in unfriend method")
		$http.get('http://localhost:8080/SayhiMiddleware/friend/acceptfriend/'+$rootScope.currentuser.userid+'/'+friendid)
		.then(fetchAllUsers(), function(response) {
			console.log("successful friend add ");
			$location.path("/mywall")
		});
	}
	
	
	
	
});