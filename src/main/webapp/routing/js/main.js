var myApp = angular.module("myRouting", ['ngRoute']);

myApp.controller("myController", ['$scope', function(scope) {
    scope.user = {firstName:"Sandeep11", lastName:"Gondal11"};
}]);

myApp.config(function($routeProvider) {
    $routeProvider.when('/route1', {
        template:'This is route 1'
    }).
    when('/route2', {
        template:'This is route 2'
    });
});