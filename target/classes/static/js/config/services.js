app.service('notificationService', ['toaster', function( toaster) {
    // this.config = Object.assign({},toastrConfig); //  we need a clone, not reference.
    this.getErrorNotificationmsg        =  function (msg, isStatic, onTapCallback) {
        if(isStatic) {
            toaster.error(msg, 'Error');
        }else{
            toaster.error(msg, 'Error');
        }
    };
    this.getInfoNotificationmsg        = function (msg, isStatic, onTapCallback) {
        if(isStatic) {
            toaster.info(msg, 'Info');
        }else{
            toaster.warning(msg, 'Info');
        }
    };
    this.getSuccessNotificationmsg      = function (msg, isStatic, onTapCallback) {
        if(isStatic) {
            toaster.success(msg, 'Success');
        }else{
            toaster.success(msg, 'Success');
        }
    };
}]);
