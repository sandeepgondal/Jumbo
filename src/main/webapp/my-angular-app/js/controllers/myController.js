// myApp.controller("myController", ['$scope', 'getUserList', function(myScope, userListService) {
//     myScope.userName = "Sandeep Gondal";
//     myScope.age = 34;
//
//     // alert(userList[0].name);
// }]);


myApp.controller("myController", function($scope, getUserList) {
    $scope.userName = "Sandeep Gondal";
    $scope.age = 34;
    $scope.agree = true;
    $scope.gender = "Male";
    $scope.car = "baleno";

    $scope.userList = getUserList;

    $scope.submitData = function() {
        console.log("User Name: " + $scope.userName);
        console.log("Age: " + $scope.age);
        console.log("Agree: " + $scope.agree);
        console.log("Gender: " + $scope.gender);
        console.log("Car: " + $scope.car);
    };
});