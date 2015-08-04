'use strict';

angular.module('gymApp').controller('courseController',function($scope,courseService){

    getCourses();
    function getCourses(){
        courseService.getCourses(function(data){
            $scope.courseList = data;
        });
    }

});