'use strict';

angular.module('gymApp')
    .controller('userController', function($scope, $http){
        $http.get('/web/user').success(function(userList){
            console.log(userList);
            $scope.userList = userList;
        });

        //$http.delete('/web/user').success(function(users){
        //    console.log(users);
        //    $scope.users = users;
        //});

    });