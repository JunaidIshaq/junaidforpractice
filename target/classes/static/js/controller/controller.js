var app = angular.module('webApp', ['toaster', 'ngAnimate']);

app.controller('postController', function ($scope, $http, toaster) {

    $scope.contact = {};
    $scope.bookservice = {};

    $scope.saveContact = function () {
        // var url = $location.path() + "/contactUs";
        var url = "http://localhost:8080/api/contactUs";
        var config = {
            headers : {
                'Content-Type' : 'application/json;charset=utf-8;'
            }
        }
        var data = {
            fullName : $scope.contact.fullName,
            email : $scope.contact.email,
            subject : $scope.contact.subject,
            message : $scope.contact.message
        }
        $http.post(url,data,config).then(function mySuccess(response) {
            if(response.data.id){
               toaster.success("Your Message has been saved. we will contact you soon !");
            }
        }, function myError(response) {
               toaster.error("Unfortunaley message not saved. We are working on this !");
        });
        // $scope.contact = {};
    }

    $scope.saveBookAService = function () {
        // var url = $location.path() + "/contactUs";
        var url = "http://localhost:8080/api/bookAService";
        var config = {
            headers : {
                'Content-Type' : 'application/json;charset=utf-8;'
            }
        }
        var data = {
            fullName : $scope.bookservice.fullName,
            serviceName : $scope.bookservice.serviceName,
            address : $scope.bookservice.address,
            email : $scope.bookservice.email,
            mobileNum : $scope.bookservice.mobileNum,
            description : $scope.bookservice.description,
        }
        $http.post(url,data,config).then(function mySuccess(response) {
            if(response.data.id){
                toaster.success("Your Request for a service has been saved. we will contact you soon !");
            }
        }, function myError(response) {
                toaster.error("Unfortunaley message not saved. We are working on this !", 'Error');
        });

        $scope.bookservice = {};
    }

});
