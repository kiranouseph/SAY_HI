app.controller("jobcontroller", function ($scope,$http,$location,$rootScope) {
$scope.Job={jobprofile:'',jobdesc:'',qualification:'',salary:'',company:'',companydesc:''};	

	function fetchAllJobs()
	{
		console.log("fetched all jobs")
		$http.get("http://localhost:8080/SayhiMiddleware/jobs/getAllJobs")

		.then(function(response) {
			$rootScope.jobsdata = response.data;
			console.log("all jobs fetched")
		});
		
		
		console.log("fetched all jobs")
		$http.get("http://localhost:8080/SayhiMiddleware/jobs/myjobs/"+$rootScope.currentuser.userid)

		.then(function(response) {
			$rootScope.myjobs = response.data;
			console.log("all my jobs fetched")
		});
		
		
		
	};
	
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
		console.log('apply job'+idd);
		$http.get('http://localhost:8080/SayhiMiddleware/jobs/applyJob/'+idd+"/"+$rootScope.currentuser.userid).then(fetchAllJobs(), function(response) {
			console.log("successful jobs applied");
			$location.path("/blog")
		});
	}
	
	$scope.getjob = function(idd)
	{
		
		$http.get('http://localhost:8080/SayhiMiddleware/jobs/getJob/'+idd).then(function(response) {
			$rootScope.gjob=response.data;
			console.log($rootScope.gjob.jobprofile+$rootScope.gjob.company)
		
		
	},function(error){
		console.log("Error on retrieving job")
	});
	
				
				
					
		
		$http.get('http://localhost:8080/SayhiMiddleware/jobs/checkifapplied/'+idd+"/"+$rootScope.currentuser.userid).then(function(response) {
			$rootScope.gcheck=response.data;
			console.log(gcheck)
			
			
			});
		
		
		
		$http.get("http://localhost:8080/SayhiMiddleware/jobs/jobapplicants/"+idd)
		.then(function(response)
		{
			
			$rootScope.jobapps=response.data;
			
			
		},function(error)
		{
			
		});

		
		
		
		$location.path("/jobview")

	}
	
	$scope.fetchjobforedit=function(idd)
	{
		
		$http.get("http://localhost:8080/SayhiMiddleware/jobs/getJob/"+idd).then(function(response) {
			console.log('get job for edit method ok'+idd)
			$rootScope.ejob=response.data;
							
				
					});
		$location.path('/jobforedit')
		
		
	}
	
	
	$scope.editjob=function(idd)
	{
		console.log(idd)
	if($scope.Job.jobprofile==null)
		{
		
		$scope.Job.jobprofile=$rootScope.ejob.jobprofile;
			}
		
		if($scope.Job.jobdesc==null)
		{
		
		$scope.Job.jobprofile=$rootScope.ejob.jobdesc;
			}
		
		
		if($scope.Job.qualification==null)
		{
		
		$scope.Job.jobprofile=$rootScope.ejob.qualification;
			}
		
		
		if($scope.Job.salary==null)
		{
		
		$scope.Job.jobprofile=$rootScope.ejob.salary;
			}
		
		
		if($scope.Job.company==null)
		{
		
		$scope.Job.jobprofile=$rootScope.ejob.company;
			}
		
		if($scope.Job.companydesc==null)
		{
		
		$scope.Job.jobprofile=$rootScope.ejob.companydesc;
			}
		$http.get("http://localhost:8080/SayhiMiddleware/jobs/updateJob/"+idd+"/"+$scope.Job.jobprofile+"/"+$scope.Job.jobdesc+"/"+$scope.Job.qualification+"/"+$scope.Job.salary+"/"+$scope.Job.company+"/"+$scope.Job.companydesc).then(function(response) {
		
			 console.log("job updated successfully");
				
		},function(error){
			console.error("Error while updating job");
		
		});
		
		$location.path("/blog")
		
		
	}
	
	
	
	
	
});