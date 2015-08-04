'use strict';

angular.module('gymApp').service('customerService',function($http){
    this.getCustomers = function(callback){
        $http.get('api/customer').success(function(data){
            callback(data);
        });
    }
});