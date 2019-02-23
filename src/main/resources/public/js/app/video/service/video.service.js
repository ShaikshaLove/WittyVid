angular.module("VideoModule").service("VideoServices",function($http){
              
	    this.getVideos=function (){
	    	console.log("fetching videos")
                    return $http.get("http://sa-wittyvidz-sandbox.mymicroapps.net/api/videos");
               };
          
              this.saveVideo=function(video,description){
            	   var fd=new FormData();
            	   fd.append("video",video);
            	   fd.append("description",description)
            	   console.log(fd);
            	  return $http.post("http://sa-wittyvidz-sandbox.mymicroapps.net/api/videos",fd,{
                       transformRequest: angular.identity,
                       headers: {'Content-Type': undefined}
                   });
                 }
   
              });    
