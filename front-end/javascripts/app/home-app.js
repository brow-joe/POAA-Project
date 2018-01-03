var app = angular.module('home_app', [ 'ngRoute' ])

var host_app = 'http://localhost:5000'

app.config(function($routeProvider) {
	$routeProvider.when('/home', {
		templateUrl : 'home.html',
		controller : 'HomeController'
	}).when('/create', {
		templateUrl : 'filter.html',
		controller : 'FilterController'
	}).when('/view/:filterId', {
		templateUrl : 'view.html',
		controller : 'ViewController'
	}).otherwise({
		redirectTo : '/home'
	})
})

function successCallback(response) {
	var data = {}
	if (response.status == 200) {
		data = response.data.content
	}
	return data
}

function errorCallback(response) {
	alert(response.statusText)
}