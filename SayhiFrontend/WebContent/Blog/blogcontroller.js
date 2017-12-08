app.controller("blogcontroller", function ($scope,$http,$location) {
	 
	 $scope.Blog={blogname:'',blogcontent:'',status:'N',likes:'0',dislikes:'0',userss:{firstname:'',lastname:'',email:'',password:'',role:'',status:'',isonline:'',dob:'',gender:''}};
	$scope.BlogComments={blogcomm:'',blogg:''};
	
	$http.get("http://localhost:8080/SayhiMiddleware/blogs/getAllBlogs")
		.then(function(response)
		{
			console.log("Blogs retrieve successfully")
			$scope.blogs=response.data;
						
		},function(error)
		{
			console.log("Error on retrieving blogs")
		});
		
	
	 
	 

	 $scope.addBlog=function(idd)
	 {
		console.log("in add blog method"+$scope.Blog.blogname)
		 $http.post("http://localhost:8080/SayhiMiddleware/blogs/addBlog/"+idd,$scope.Blog).then(function(response){
			 console.log("Blog added successfully")
								
			},function(error){
				console.error("Error while creating blog")
			});
		 
	 }
	 
	 
	 
	 
	 
	 

	 $scope.editBlog=function(idd)
	 {
		console.log("in edit blog method")
		 $http.post("http://localhost:8080/SayhiMiddleware/blogs/updateBlog/"+idd,$scope.Blog).then(function(response){
			 console.log("Blog updated successfully");
								
			},function(error){
				console.error("Error while updating blog");
			});
		 
	 }
	 
	 $scope.deleteBlog=function(idd)
	 {
		console.log("in delete blog method")
		 $http.get("http://localhost:8080/SayhiMiddleware/blogs/deleteBlog/"+idd).then(function(response){
			 console.log("Blog deleted successfully");
								
			},function(error){
				console.error("Error while deleting blog");
			});
		 
	 }
	 
	 
	 $scope.approveBlog=function(idd)
	 {
		console.log("in approve blog method")
		 $http.get("http://localhost:8080/SayhiMiddleware/blogs/approveBlog/"+idd).then(function(response){
			 console.log("Blog approved successfully");
								
			},function(error){
				console.error("Error while approving blog");
			});
		 
	 }
	 
	 $scope.rejetcBlog=function(idd)
	 {
		console.log("in reject blog method")
		 $http.get("http://localhost:8080/SayhiMiddleware/blogs/rejectBlog/"+idd).then(function(response){
			 console.log("Blog rejected successfully");
								
			},function(error){
				console.error("Error while rejecting blog");
			});
		 
	 }
	 
	 $scope.likeBlog=function(idd)
	 {
		console.log("in like blog method")
		 $http.get("http://localhost:8080/SayhiMiddleware/blogs/likeBlog/"+idd).then(function(response){
			 console.log("Blog liked successfully");
								
			},function(error){
				console.error("Error while liking blog");
			});
		 
	 }
	 
	 
	 $scope.dislikeBlog=function(idd)
	 {
		console.log("in like blog method")
		 $http.get("http://localhost:8080/SayhiMiddleware/blogs/dislikeBlog/"+idd).then(function(response){
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