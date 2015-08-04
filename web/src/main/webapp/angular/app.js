'use strict';

angular.module('gymApp', ['ngRoute'])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/users', {
                templateUrl: 'angular/views/user.html',
                controller: 'userController'
            })
            .when('/schedules',{
                templateUrl: 'angular/views/schedule.html',
                controller: 'scheduleController'
            })
            .when('/customer',{
                templateUrl: 'angular/views/customer.html',
                controller: 'customerController'
            })
            .when('/course',{
                templateUrl: 'angular/views/course.html',
                controller: 'courseController'
            })


    });