'use strict';

angular.module('gymApp', ['ngRoute'])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/users', {
                templateUrl: 'angular/views/user.html',
                controller: 'userController'
            })
            //.when('/users/add',{
            //    templateUrl: 'angular/views/userInsert.html'
            //})


    });