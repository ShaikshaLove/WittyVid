angular.module("VideoModule").controller("VideoUploaderCtrl",function($scope,VideoServices){

	$scope.myFile;
	$scope.uploading=false;
	$scope.message;
	$scope.showMessage=false;
	console.log("hello from VideoUploaderCtrl")
	$scope.upload=function(){
		$scope.uploading=true;

		VideoServices.saveVideo($scope.myFile,$scope.description).then(
				
				function (serverdata){
					$scope.message=serverdata.data;
					$scope.showMessage=true;
					$scope.uploading=false;
					$scope.myFile="";
					$scope.description="";
				},function (error){
					console.log(error);
					$scope.message="We encountered a problem during uploading the video please try again";
					$scope.myValue=false;

				});



	};


});
