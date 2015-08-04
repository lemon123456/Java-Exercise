'use strict';

angular.module('gymApp').controller('customerController', function ($scope, $http,customerService) {

    getCustomers();
    function getCustomers(){
        customerService.getCustomers(function(data){
            $scope.customerList = data;
        });
    }
});