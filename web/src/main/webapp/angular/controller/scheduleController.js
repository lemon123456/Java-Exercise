'use strict';

angular.module('gymApp').controller('scheduleController', function ($scope, scheduleService, courseService, customerService) {

    getSchedules();
    getCourses();
    getCustomers();
    getCoaches();

    function getSchedules() {
        scheduleService.getSchedules(function (data) {
            $scope.scheduleList = data;
        });
    }

    function getCourses() {
        courseService.getCourses(function (data) {
            $scope.courseList = data;
        });
    }

    function getCustomers() {
        customerService.getCustomers(function (data) {
            $scope.customerList = data;
        });
    }

    function getCoaches() {
        scheduleService.getCoaches(function (data) {
            $scope.coachList = data;
        });
    }

    $scope.delete = function ($index, id) {
        scheduleService.deleteSchedule(id, function () {
            $scope.scheduleList.splice($index, 1);
        });
    };

    $scope.selectedCustomer = "all";
    $scope.add = function () {
        scheduleService.addSchedule($scope.selectedCourse, $scope.selectedCoach, $scope.selectedTime, $scope.selectedCustomer, function (data) {
            $scope.scheduleList.push(data);
            $scope.selectedCourse = "";
            $scope.selectedCoach = "";
            $scope.selectedTime = "";

        });
    };

});