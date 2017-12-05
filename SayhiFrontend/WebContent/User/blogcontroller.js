app.controller("blogcontroller", function ($scope,blogservice) {
	 
	 $scope.Blog={blogname:'',blogcontent:'',username:'kiran',status:'N',likes:'0',dislikes:'0'};
	 getblogs()
	 {
		$scope.blogs=blogservice.getAllBlogs().then(function(response)
		{
			console.log("Blogs retrieved successfully");
		},function(error)
		{
			console.log("Error");
		})
		 
	 }
	 
	 $scope.addBlog=function()
	 {
		
		blogservice.addblog($scope.Blog).then(function(response){
			 console.log("Blog added successfully");
								
			},function(error){
				console.error("Error while creating ");
			})
		 
	 }
	 
});