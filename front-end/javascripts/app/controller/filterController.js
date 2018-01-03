app.controller('FilterController', function($scope, $window, $http) {
	$scope.createFilter = function() {
		filter = jQuery.extend({}, $scope.filter)
		filter.startDate = filter.startDate.getTime()
		filter.endDate = filter.endDate.getTime()
		request = $http.post(host_app + "/api/v1/filter/", filter).then(successCallback, errorCallback)
		request.then(function(response) {
			$window.location.href = "/front-end/#!/home"
		})
	}
})