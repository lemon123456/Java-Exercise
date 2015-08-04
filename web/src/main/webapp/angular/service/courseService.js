'use strict';
angular.module('gymApp').service('courseService',function($http){

    this.getCourses = function(callback){
        $http.get('api/course').success(function(data){
            callback(data);
        });
    }
});

