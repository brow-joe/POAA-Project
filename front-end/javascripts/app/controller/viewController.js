app.controller('ViewController', function($scope, $window, $routeParams, $http) {
	$scope.urlScores = host_app + "/api/v1/filter/" + $routeParams.filterId + "/scores"

	function loadDataScores(grouped, loadSelector){
		host = $scope.urlScores
		if(grouped != undefined){
			host += "?grouped=" + encodeURIComponent(grouped)
		}
		request = $http.get(host).then(successCallback, errorCallback)
		request.then(function(scores) {
			$scope.scores = scores
			if(loadSelector){
				$scope.groupeds = [...new Set(scores.map(score => score.grouped))]
			}
		})	
	}

	loadDataScores(undefined, true)

	$scope.reloadScores = function(grouped) {
		if(grouped == "#"){
			loadDataScores()
		}else{
			loadDataScores(grouped)
		}
	}
})