app.factory("blogservice",function($http){
    var BASE_URL="http://localhost:8080/SayhiMiddleware";
	var blogservice ={};
	blogservice.addblog=function(blog){

		return $http.post(BASE_URL+"/blogs/addBlog",blog);		
	}
	
	
	
	blogservice.getAllBlogs=function()
	{
		return $http.get(BASE_URL+"/blogs/getAllBlogs");		

	}
	
	
	return blogservice;
});