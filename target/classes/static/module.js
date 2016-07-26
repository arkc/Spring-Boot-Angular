var myApp = angular
			.module("myModule",[])
			.controller("myCtrl",function($scope, $http, $sce)
			{
				$scope.message = "Angular";
				
				$scope.getDoc = function(){
                    
                    //$scope.doc = "Your doc is here.."
                    
					$http({
						  method: 'GET',
						  url: '/getPdf',
						  responseType:'arraybuffer'
						}).then(function success(response) {
							
							var fileName = "myFile.pdf";
				            var a = document.createElement("a");
				            document.body.appendChild(a);
				            a.style = "display: none";
							
							var file = new Blob([response.data], {type: 'application/pdf'});
						    var fileURL = window.URL.createObjectURL(file);
							$scope.data1 = $sce.trustAsResourceUrl(fileURL);
							
							
				            
				            a.href = fileURL;
			                a.download = fileName;
			                a.click();
						    
						  }, function error(response) {
							  
							  $scope.error = "Error";
						    
						  });
					
					
				}
				
				
			});