/**
 * Created by rdemarla on 10-Nov-15.
 **/

var AppServices = ['$http', 'context', function($http, context){
    return {
        login: function (loginReq) {
            return $http.post(context+'/login', loginReq).success(function (data) {
                return data;
            });
        },
        signUp: function (signUpReq) {
            return $http.post(context+'/signUp', signUpReq).success(function (data) {
                return data;
            });
        }
    };
}];
