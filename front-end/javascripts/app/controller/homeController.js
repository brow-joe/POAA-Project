app.controller('HomeController', function($scope, $window) {
	$scope.view = function() {
		console.log("view");
		$window.location.href = "/front-end/#!/view"
	}
	$scope.remove = function() {
		console.log("remove");
		$window.location.href = "/front-end/#!/home"
	}
})