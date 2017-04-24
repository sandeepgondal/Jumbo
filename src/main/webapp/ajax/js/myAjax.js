var myApp = angular.module("myAjax", []);

myApp.controller("myController", function($scope, $http) {
    $scope.getData = function() {
        console.log("Button Clicked");
        // $scope.data = "Got this data";

        var promise = $http.get("response.json");
        promise.success(function(data, status, headers, config) {
            $scope.data = data;
        });
        promise.error(function(data, status, headers, config) {
            $scope.data = "Got error";
        });
    };
});