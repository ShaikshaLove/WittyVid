angular.module("ProductApp").controller("ProductRegisterCtrl",function  productRegisterFn($scope,ProductService){
   
	$scope.product={};
	$scope.myFile;
	$scope.message;
	$scope.showMessage=false;
	$scope.saveProduct=function (){
		$scope.myValue=true;
		ProductService.saveProduct($scope.product,$scope.myFile).then(
				                             function (serverdata){
				                            	
		                                    	$scope.message=serverdata.data;
		                                        $scope.myValue=false;
		                                        $scope.showMessage=true;
		                                        $scope.product={};
		                                        },function (error){
				                            	 console.log(error);

		                                    	alert("error while loading the data");
		                                        $scope.myValue=false;

		                                   });

	  };

});
