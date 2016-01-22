/**
 * Created by rdemarla on 29-Oct-15.
 **/

var angModule = angular.module("shalivahanaApp", ['ui.router', 'ngAnimate', 'ui.bootstrap']);

/** Start of Configurable constants **/
angModule.constant('useMockData', false);
angModule.constant('context', 'http://localhost:8080');
/** End of Configurable constants **/

angModule.config(['$urlRouterProvider', '$stateProvider',
    function ($urlRouterProvider, $stateProvider) {
        $stateProvider.state('home', {
            name:"home",
            url: '/',
            templateUrl: 'components/home/home-view.html',
            controller: HomeController
        });

        $stateProvider.state('history', {
            name:"history",
            url: '/history',
            templateUrl: 'components/history/history-view.html',
            controller: HistoryController
        });
        $stateProvider.state('members', {
            name:"members",
            url: '/members',
            templateUrl: 'components/members/members-view.html',
            controller: MembersController
        });
        $stateProvider.state('meetings', {
            name:"meetings",
            url: '/meetings',
            templateUrl: 'components/meetings/meetings-view.html',
            controller: MeetingsController
        });
        $stateProvider.state('contact', {
            name:"contact",
            url: '/contact',
            templateUrl: 'components/contact/contact-view.html',
            controller: ContactViewController
        });

        $urlRouterProvider.otherwise('/');
    }
]);

angModule.controller('MainController', ['$scope', '$uibModal', function($scope, $uibModal){
    $scope.items = ['LOG IN', 'SIGN UP'];
    $scope.openLoginWindow = function() {
        var modalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'components/login/login.html',
            controller:LoginController,
            resolve: {
                items: function () {
                    return $scope.items;
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            $scope.selected = selectedItem;
            console.log("Sign up button clicked");
        }, function () {
            //$log.info('Modal dismissed at: ' + new Date());
        });
    };
}]);

angModule.factory('AppServices', AppServices);
/*angModule.controller('MainController', MainController);
angModule.controller('SignInController', SignInController);*/

angModule.run(['$rootScope', '$state', function($rootScope, $state){
    $rootScope.state = $state;
    if(window.sessionStorage["userInfo"]){
        $rootScope.userInfo = JSON.parse(window.sessionStorage["userInfo"]);
    }
}]);

/*
angModule.directive("passwordVerify", [function() {
    return {
        require: "ngModel",
        scope: {
            passwordVerify: '='
        },
        link: function(scope, element, attrs, ctrl) {
            scope.$watch(function() {
                var combined;

                if (scope.passwordVerify || ctrl.$viewValue) {
                    combined = scope.passwordVerify + '_' + ctrl.$viewValue;
                }
                return combined;
            }, function(value) {
                if (value) {
                    ctrl.$parsers.unshift(function(viewValue) {
                        var origin = scope.passwordVerify;
                        if (origin !== viewValue) {
                            ctrl.$setValidity("passwordVerify", false);
                            return undefined;
                        } else {
                            ctrl.$setValidity("passwordVerify", true);
                            return viewValue;
                        }
                    });
                }
            });
        }
    };
}]);*/
