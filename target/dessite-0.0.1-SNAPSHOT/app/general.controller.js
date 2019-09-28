angular.module("des_site").controller("GeneralController", GeneralController);

GeneralController.inject = ['$scope', 'ContactService'];

function GeneralController($scope, Contact) {

    $scope.contact = Contact.query();
    $scope.contact = {};
    $scope.buttonText = "Submit";

    $scope.saveContact = function () {
       Contact.save($scope.contact, function () {
           $scope.contact = Contact.query();
           $scope.contact = {};
       })
    }
}
