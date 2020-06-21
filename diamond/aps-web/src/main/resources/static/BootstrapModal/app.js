
var modalInstance = '';

var app = angular.module('TestApp', ['ui.bootstrap']);
app.controller('TestCtrl', function($scope, $http) {

	function modalOpenCtrl($scope, payload){
		console.log('fgfdfd');
		$scope.datas = payload;
		console.log($scope.datas);
		$scope.closeModal = function(){
			$scope.cancelModal();
		}
	}

	$scope.openModal = function(task){
		modalInstance = $uibModal.open({
			animation: false,
			templateUrl: './modal_window.html',
			controller: 'modalOpenCtrl',
			scope: $scope,
			size: 'md',
			backdrop: 'static',
			resolve: {
				payload: function () {
					return {
						msg_body : 'Hello! I am payload msg',
						title : 'Hello! Title',
						body_title : 'UiBootstrap.net'
					};
				}
			}
		});
	}

	function modalOpenCtrl($scope, payload){
		console.log('fgfdfd');
		$scope.datas = payload;
		console.log($scope.datas);
		$scope.closeModal = function(){
			$scope.cancelModal();
		}
	}
})