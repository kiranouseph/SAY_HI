app.controller("blogcontroller", function ($scope,$http,$location,$rootScope) {
	 
	 $scope.Blog={blogname:'',blogcontent:'',status:'A',likes:'0',dislikes:'0',views:'0',username:$rootScope.currentuser.email};
	$scope.BlogComments={blogcomm:'',blogg:''};
	function fetchBlog(idd)
	{
		 $http.get("http://localhost:8080/SayhiMiddleware/blogs/getBlogById/"+idd).then(function(response){
				$scope.blogByid=response.data; 
									
				},function(error){
				
				});
	};
	function fetchAllBlogs()
	{
	$http.get("http://localhost:8080/SayhiMiddleware/blogs/getAllBlogs")
		.then(function(response)
		{
			console.log("Blogs retrieve successfully")
			$scope.blogs=response.data;
			console.log($scope.blogs)
						
		},function(error)
		{
			console.log("Error on retrieving blogs")
		});
	};
	fetchAllBlogs();
	
	 $scope.maximum=function(idd)
	 {
		 console.log("in add max method"+idd)
		 
		 
		  $http.get("http://localhost:8080/SayhiMiddleware/blogs/incview/"+idd).then(function(response){
			
			},function(error){
			
			});
		 
		 
		 
		 
		 
		 
		 $http.get("http://localhost:8080/SayhiMiddleware/blogs/getBlogById/"+idd).then(function(response){
			$scope.blogByid=response.data; 
			console.log("blogname"+$scope.blogByid.blogname)
			console.log("username"+$scope.blogByid.username)
			},function(error){
			
			});
		 
		 
		 $location.path('/blogview')
		 
	 }
	 
	 

	 $scope.addBlog=function()
	 {
		console.log("in add blog method"+$scope.Blog.blogname)
		 $http.post("http://localhost:8080/SayhiMiddleware/blogs/addBlog",$scope.Blog).then(fetchAllBlogs(),function(response){
			 console.log("Blog added successfully")
								
			},function(error){
				console.error("Error while creating blog")
			});
		$location.path('/blog')
		 
	 }
	 
	 
	 
	 
	 
	 

	 $scope.editBlog=function(idd)
	 {
		console.log("in edit blog method")
		 $http.post("http://localhost:8080/SayhiMiddleware/blogs/updateBlog/"+idd,$scope.Blog).then(fetchBlog(idd),function(response){
			 console.log("Blog updated successfully");
								
			},function(error){
				console.error("Error while updating blog");
			});
		 
	 }
	 
	 $scope.deleteBlog=function(idd)
	 {
		console.log("in delete blog method")
		 $http.get("http://localhost:8080/SayhiMiddleware/blogs/deleteBlog/"+idd).then(fetchBlog(idd),function(response){
			 console.log("Blog deleted successfully");
								
			},function(error){
				console.error("Error while deleting blog");
			});
		 
	 }
	 
	 
	 $scope.approveBlog=function(idd)
	 {
		console.log("in approve blog method")
		 $http.get("http://localhost:8080/SayhiMiddleware/blogs/approveBlog/"+idd).then(fetchBlog(idd),fetchAllBlogs(),function(response){
			 console.log("Blog approved successfully");
								
			},function(error){
				console.error("Error while approving blog");
			});
		 
	 }
	 
	 $scope.rejetcBlog=function(idd)
	 {
		console.log("in reject blog method")
		 $http.get("http://localhost:8080/SayhiMiddleware/blogs/rejectBlog/"+idd).then(fetchBlog(idd),fetchAllBlogs(),function(response){
			 console.log("Blog rejected successfully");
								
			},function(error){
				console.error("Error while rejecting blog");
			});
		 
	 }
	 
	 $scope.likeBlog=function(idd)
	 {
		console.log("in like blog method")
		 $http.get("http://localhost:8080/SayhiMiddleware/blogs/likeBlog/"+idd).then(fetchBlog(idd),function(response){
			 console.log("Blog liked successfully");
								
			},function(error){
				console.error("Error while liking blog");
			});
		 
	 }
	 
	 
	 $scope.dislikeBlog=function(idd)
	 {
		console.log("in like blog method")
		 $http.get("http://localhost:8080/SayhiMiddleware/blogs/dislikeBlog/"+idd).then(fetchBlog(idd),function(response){
			 console.log("Blog disliked successfully");
								
			},function(error){
				console.error("Error while disliking blog");
			});
		 
	 }

	 
	 
	 $scope.addBlogComment=function(idd)
	 {
		console.log("in add blogComment method")
		 $http.post("http://localhost:8080/SayhiMiddleware/blogs/addBlogComments/"+idd,$scope.BlogComments).then(function(response){
			 console.log("BlogComments added successfully")
								
			},function(error){
				console.error("Error while creating blogComments")
			});
		 
	 }
	 
	 
	 $scope.updateBlogComment=function(idd)
	 {
		console.log("in update blogComment method")
		 $http.post("http://localhost:8080/SayhiMiddleware/blogs/updateBlogComments/"+idd,$scope.BlogComments).then(function(response){
			 console.log("BlogComments updated successfully")
								
			},function(error){
				console.error("Error while updating blogComments")
			});
		 
	 }
	 
	 
	 $scope.deleteBlogComment=function(idd)
	 {
		console.log("in delete blogcomment method")
		 $http.get("http://localhost:8080/SayhiMiddleware/blogs/deleteBlogComment/"+idd).then(function(response){
			 console.log("Blogcomments deleted successfully");
								
			},function(error){
				console.error("Error while deleting blogcomments");
			});
		 
	 }
	 
	 
	 
});