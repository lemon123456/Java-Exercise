'use strict';

angular.module('gymApp')
    .controller('userController', function ($scope, $http, $route) {

        $http.get('api/users').success(function (userList) {
            $scope.userList = userList;
        });

        $scope.add = function () {
            $http({
                method: 'POST',
                url: 'api/users',
                params: {
                    'name': $scope.name,
                    'password': $scope.password,
                    'employeeId': $scope.employeeId
                }
            }).success(function (data) {
                $scope.userList.push(data);
                $scope.name = "";
                $scope.password = "";
                $scope.employeeId = "";
            });
        };

        $scope.delete = function(idx,id){
            $http({
                method: 'DELETE',
                url: 'api/users',
                params: {
                    'id': id
                }
            }).success(function(){
                $scope.userList.splice(idx,1)
            });
        };

        $scope.hide = [];
        $scope.modify = function($index){
            $scope.hide[$index] = true;
        };

        $scope.update = function($index,$this){
            $http({
                method: 'PUT',
                url: 'api/users',
                params: {
                    'id': this.user.id,
                    'name': this.user.name,
                    'password': this.user.password,
                    'employeeId': this.user.employee.id
                }
            }).success(function(){
                $scope.hide[$index] = false;
            });
        };

    });