app.controller("jobcontroller", function ($scope,$http,$location,$rootScope) {
$scope.Job={jobprofile:'',jobdesc:'',qualification:'',salary:'',company:'',companydesc:''};	
	function fetchAllJobs()
	{
		console.log("fetched all jobs")
		$http.get("http://localhost:8080/SayhiMiddleware/jobs/getAllJobs")

		.then(function(response) {
			$scope.jobsdata = response.data;
			console.log("all jobs fetched")
		});
		
		
		console.log("fetched all jobs")
		$http.get("http://localhost:8080/SayhiMiddleware/jobs/myjobs/"+$rootScope.currentuser.userid)

		.then(function(response) {
			$scope.myjobs = response.data;
			console.log("all my jobs fetched")
		});
		
		
		
	}
	;
	fetchAllJobs();
	
	$scope.insertJobs = function()
	{
		console.log('entered insertJobs');
		$http.post('http://localhost:8080/SayhiMiddleware/jobs/addJob',
				$scope.Job).then(fetchAllJobs(), function(response) {
			console.log("successful jobs entered");
			$location.path("/blog")
		});
	}
	
	
	$scope.applyJob = function(idd)
	{
		console.log('apply job');
		$http.get('http://localhost:8080/SayhiMiddleware/jobs/applyJob/'+idd+"/"+$rootScope.currentuser.userid).then(fetchAllJobs(), function(response) {
			console.log("successful jobs applied");
			$location.path("/blog")
		});
	}
	
	$scope.getjob = function(idd)
	{
		console.log('in getjob method'+idd)
		$http.get('http://localhost:8080/SayhiMiddleware/jobs/getJob/'+idd).then(function(response) {
			console.log('getjob method ok')
			$scope.jobbyid=response.data;
			console.log('jobname'+$scope.jobbyid.company)
				console.log('jobname'+$scope.jobbyid.salary)
				
				
					});
		
		$http.get('http://localhost:8080/SayhiMiddleware/jobs/checkifapplied/'+idd+"/"+$rootScope.currentuser.userid).then(function(response) {
			$scope.checkifapplied=response.data;
			
			
			});
		$location.path("/jobview")

	}
	
	$scope.fetchjobforedit=function()
	{
		
		$http.get('http://localhost:8080/SayhiMiddleware/jobs/getJob/'+idd).then(function(response) {
			console.log('getjob method ok')
			$scope.jobforedit=response.data;
			console.log('jobname'+$scope.jobbyid.company)
				console.log('jobname'+$scope.jobbyid.salary)
				
				
					});
		
		
	}
	
	
	$scope.editjob=function(idd)
	{
		
		$http.get('http://localhost:8080/SayhiMiddleware/jobs/updateJob/'+idd).then(function(response) {
		
			 console.log("job updated successfully");
				
		},function(error){
			console.error("Error while updating job");
		
		});
		
		
	}
	
	
	
	
	
});