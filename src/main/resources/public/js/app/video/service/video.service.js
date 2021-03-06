angular.module("VideoModule").service("VideoServices",function($http){
              
	    this.getVideos=function (){
	    	console.log("fetching videos")
                    return $http.get("https://wittyvid.herokuapp.com/api/videos");
               };
          
              this.saveVideo=function(video,description){
            	   var fd=new FormData();
            	   fd.append("video",video);
            	   fd.append("description",description)
            	   console.log(fd);
            	  return $http.post("https://wittyvid.herokuapp.com/api/videos",fd,{
                       transformRequest: angular.identity,
                       headers: {'Content-Type': undefined}
                   });
                 }
   
              });    
