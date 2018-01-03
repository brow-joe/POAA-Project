app.controller('HomeController', function($scope, $window, $http, $route) {
	request = $http.get(host_app + "/api/v1/filter/").then(successCallback, errorCallback)
	request.then(function(filters) {
		$scope.filters = filters
	})
	$scope.view = function(id) {
		$window.location.href = "/front-end/#!/view/" + id
	}
	$scope.remove = function(id) {
		request = $http.delete(host_app + "/api/v1/filter/" + id)
		request.then(function(response) {
		    $route.reload()
		}, errorCallback);
	}
})