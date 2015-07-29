'use strict';

angular.module('gymApp', ['ngRoute'])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/user', {
                templateUrl: '/web/angular/views/user.html',
                controller: 'userController'
            })

    });