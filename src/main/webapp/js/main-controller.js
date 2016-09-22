'use strict';

appControllers.controller('MainController', ['$rootScope', '$scope', '$http', 'authorization',
    function($rootScope, $scope, $http, authorization) {
        $scope.status = 'running...';
        $scope.profile = authorization.profile;
        $scope.isSuperManager = authorization.hasRealmRole('super manager')
        $scope.isManager = authorization.hasRealmRole('manager')
        
        $scope.getAccounts = function() {
        	$http.get("http://localhost:8000/api/accounts").success(function(data) {
            	$scope.accounts = data;
            });
        }
        
        $scope.logout = function() {
        	authorization.logout();
        }
    }
]);