angular.module("VideoModule").controller("VideoController",function($scope,VideoServices){
        $scope.myValue=true;
        $scope.thumbnail=true;
        $scope.videosListNew=[];
        console.log("From VideoListCtrl");
        VideoServices.getVideos().then(function (serverdata){
            $scope.videosListNew=serverdata.data;
        
            
            console.log($scope.videosListNew);
            $scope.myValue=false;

        },function (error){
            alert("error while loading the data");
        });
        
        $scope.playVideo=function(){
            $scope.thumbnail=false;

        };
});
