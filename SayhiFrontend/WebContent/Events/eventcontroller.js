app.controller("eventcontroller", function ($scope,$http,$location,$rootScope) {
$scope.Events={eventname:'',eventdesc:'',eventvenue:'',username:$rootScope.currentuser.email,status:'P'};	

	function fetchAllEvents()
	{
		console.log("in fetch all events")
		$http.get("http://localhost:8080/SayhiMiddleware/events/getAllEvents")

		.then(function(response) {
			$rootScope.eventdata = response.data;
			console.log("all events fetched")
		});
		
		
		
		$http.get("http://localhost:8080/SayhiMiddleware/events/myEvents/"+$rootScope.currentuser.userid)

		.then(function(response) {
			$rootScope.myevents = response.data;
			console.log("all my events fetched")
		});
		
		
		
	};
	
	fetchAllEvents();
	
	$scope.insertEvent = function()
	{
		console.log('entered insertEvent');
		$http.post('http://localhost:8080/SayhiMiddleware/events/addEvent',
				$scope.Events).then(fetchAllEvents(), function(response) {
			console.log("successful event entered");
			$location.path("/blog")
		});
	}
	
	
	$scope.deleteevent = function(idd)
	{
		
		$http.get('http://localhost:8080/SayhiMiddleware/events/deleteEvent/'+idd
				).then(fetchAllEvents(), function(response) {
			console.log("successful event entered");
			$location.path("/blog")
		});
	}
	
	$scope.applyevent = function(idd)
	{
		console.log('apply job'+idd);
		$http.get('http://localhost:8080/SayhiMiddleware/events/applyEvent/'+idd+"/"+$rootScope.currentuser.userid).then(fetchAllEvents(), function(response) {
			console.log("successful event applied");
			$location.path("/blog")
		});
	}
	
	$scope.getEvent = function(idd)
	{
		
		$http.get('http://localhost:8080/SayhiMiddleware/events/getEvent/'+idd).then(function(response) {
			$rootScope.gevent=response.data;
		
		
		
	},function(error){
		console.log("Error on retrieving event")
	});
	
				
				
					
		
		$http.get('http://localhost:8080/SayhiMiddleware/events/checkifappliedevent/'+idd+"/"+$rootScope.currentuser.userid).then(function(response) {
			$rootScope.evecheck=response.data;
		
			
			
			});
		
		
		
		$http.get("http://localhost:8080/SayhiMiddleware/events/eventparts/"+idd)
		.then(function(response)
		{
			
			$rootScope.eventpars=response.data;
			
			
		},function(error)
		{
			
		});

		
		
		
		$location.path("/eventview")

	}
	
	$scope.fetcheventforedit=function(idd)
	{
		console.log(idd)
		$http.get("http://localhost:8080/SayhiMiddleware/events/getEvent/"+idd).then(function(response) {
			console.log('get job for edit method ok'+idd)
			$rootScope.editevent=response.data;
			console.log($rootScope.editevent.eventname)				
				
					});
		$location.path('/eventforedit')
		
		
	}
	
	
	$scope.editeventtt=function(idd)
	{
		
		if($scope.Events.eventname==null)
			{
			$scope.Events.eventname=$rootScope.editevent.eventname;
			}
		
		if($scope.Events.eventdesc==null)
		{
		$scope.Events.eventname=$rootScope.editevent.eventdesc;
		}
		
		if($scope.Events.eventvenue==null)
		{
		$scope.Events.eventname=$rootScope.editevent.eventvenue;
		}
		$http.get("http://localhost:8080/SayhiMiddleware/events/updateJob/"+idd+"/"+$scope.Events.eventname+"/"+$scope.Events.eventdesc+"/"+$scope.Events.eventvenue).then(function(response) {
		
			 console.log("event updated successfully");
				
		},function(error){
			console.error("Error while updating event");
		
		});
		
		$location.path("/blog")
		
		
	}
	
	
	
	
	
});


app.controller("eventrequestcontroller", function ($scope,$http,$location,$rootScope) {
	function fetchAlleventreq()
	{
	
	 $http.get("http://localhost:8080/SayhiMiddleware/events/getAlleventreq")
	    .then(function(response)
	    		{
	    	
	    
		 $scope.eventrequests=response.data;
	
		 $location.path('/eventrequests')
							
		},function(error){
			console.error("Error while fetching requets");
		});
	}
	
	
	fetchAlleventreq();
	
	
	
	
	
	
	 $scope.accepteventrequests=function(id)
	 {
		 
		 
		console.log("in event request  accept method")
		 $http.get("http://localhost:8080/SayhiMiddleware/events/approveevents/"+id).then(fetchAlleventreq(),function(response){
			 
			 console.log("eventrequets accepted  successfully");
			 $location.path('/eventrequests')
								
			},function(error){
				console.error("Error while accepting eventrequets");
			});
		$location.path('/eventmanage')
		 
	 }
	 

	 
	
	
});


