'use strict';


angular.module('gymApp').service('scheduleService',function($http,$filter){

    this.getSchedules = function(callback){
        $http.get('api/schedules').success(function(data){
            callback(data);
        });
    };

    this.getCoaches = function(callback){
        $http.get('api/schedules/coaches').success(function(data){
            callback(data);
        });
    };

    this.deleteSchedule = function(id,callback){
        $http({
            method: 'DELETE',
            url: 'api/schedules',
            params: {
                'id': id
            }
        }).success(function(){
            callback();
        });
    };

    this.addSchedule = function(courseId,coachId,time,customer,callback){
        $http({
            method: 'POST',
            url: 'api/schedules',
            params:{
                'courseId': courseId,
                'coachId': coachId,
                'time': $filter('date')(time, 'yyyy-MM-dd'),
                'customer': customer
            }
        }).success(function(data){
            callback(data);
        }).error(function(){
            alert("Time is conflict.");
        });
    };

    this.updateSchedule = function(id,courseId,coachId,time,customer,callback){
        $http({
            method: 'PUT',
            url: 'api/schedules',
            params: {
                'id': id,
                'courseId': courseId,
                'coachId': coachId,
                'time': $filter('date')(time, 'yyyy-MM-dd'),
                'customer': customer
            }
        }).success(function(data){
           callback(data);
        }).error(function(){
            alert("Update failed!");
        });
    };
});


