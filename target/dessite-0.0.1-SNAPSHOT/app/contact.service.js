angular.module('des_site').factory('Contact', ContactService);

ContactService.$inject = ['%resource'];

function ContactService($resource) {
    var resourceUrl = "api/contactUs/:id";

    return $resource(resourceUrl, {}, {
       'insert':{
           method:'PUT'
       }
    });
}
