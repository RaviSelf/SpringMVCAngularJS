/**
 * Created by Ravi on 08/11/15.
 **/
//'$uibModalInstance', 'items',
//var app = angular.module('users', []);
var LoginController = ['$scope', 'AppServices', '$location', '$rootScope', '$uibModalInstance', 'items',
    function($scope, AppServices, $location, $rootScope, $uibModalInstance, items){
    $scope.items = items;
    $scope.selected = {
        item: $scope.items[0]
    };

    $scope.userRoles = {};
    $scope.userRoles.users = {};
    $scope.confirmPassword = {};
    $scope.hasAgreedChecked = {};

    $scope.doLogin = function () {
        console.log("Do login Clicked", $scope.users);
        //$scope.log
        if($scope.loginForm.$valid){
            AppServices.login($scope.users).then(function (result) {
                $scope.data = result;
                if (!result.error) {
                    window.sessionStorage["userInfo"] = JSON.stringify(result.data);
                    $rootScope.userInfo = JSON.parse(window.sessionStorage["userInfo"]);
                }
            });
        }
    };

    $scope.doSignUp = function () {
        console.log("Sign up button clicked", $scope.userRoles);
        AppServices.signUp($scope.userRoles).then(function (result){
            $scope.data = result;
            if (!result.error) {
                $scope.selected.item = 'LOG IN';
            }
            else
                $scope.selected.item = 'SIGN UP';
        })
    };

    $scope.canMoveForward = function()
    {
        $scope.enableDisableButton = $scope.userRoles.firstName !== undefined && $scope.userRoles.firstName.length > 0 &&
                $scope.userRoles.lastName !== undefined && $scope.userRoles.lastName.length > 0 &&
                $scope.confirmPassword.password !== undefined && $scope.confirmPassword.password.length > 0 &&
                $scope.userRoles.users.username !== undefined && $scope.userRoles.users.username.length > 0 &&
                $scope.userRoles.users.password !== undefined && $scope.userRoles.users.password.length > 0 &&
                $scope.hasAgreedChecked.checked;
    }

}];

