var app = angular.module('home_app', [ 'ngRoute' ])

app.config(function($routeProvider) {
	$routeProvider.when('/home', {
		templateUrl : 'home.html',
		controller : 'HomeController'
	}).when('/create', {
		templateUrl : 'filter.html',
		controller : 'FilterController'
	}).when('/view', {
		templateUrl : 'view.html',
		controller : 'ViewController'
	}).otherwise({
		redirectTo : '/home'
	})
})