app.controller("jobcontroller", function ($scope,$http,$location) {
$scope.Job={jobprofile:'',jobdesc:'',qualification:'',salary:''};	
	function fetchAllJobs()
	{
		console.log("fetched all jobs")
		$http.get("http://localhost:8080/SayhiMiddleware/jobs/getAllJobs")

		.then(function(response) {
			$scope.jobsdata = response.data;
			console.log("all jobs fetched")
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
			$location.path("/job")
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
});