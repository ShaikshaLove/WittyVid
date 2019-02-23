angular.module("WittyVid",["VideoModule","ngRoute"]);


angular.module("WittyVid").config(function($routeProvider){
      console.log("RouteProvider")
	$routeProvider.when("/upload",{
		templateUrl:"js/app/video/html/upload-video.html",
		controller:"VideoUploaderCtrl"

	});

	$routeProvider.otherwise(
			{
				templateUrl:"js/app/video/html/videos.html",
				controller:"VideoController"
			});

});