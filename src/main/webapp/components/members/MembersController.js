/**
 * Created by rdemarla on 29-Oct-15.
 **/

var MembersController = ["$scope", "$http", "context", '$location', function($scope, $http, context, $location){
    $scope.member = {};
    $scope.role = {};
    $scope.gender = {};

    //$scope.member.address = {};{"President", "Vice-President", "Treasurer", "Member"}
    $scope.roles = [{Id: 0, Description: "-- Choose Role --"},
        {Id: 1, Description: "President"},
        {Id: 2, Description: "Vice-President"},
        {Id: 3, Description: "Treasurer"},
        {Id: 4, description: "Member"}];

    $scope.genderArray = [{Id:1, Value:"Male"},{Id:2, Value:"Female"},{Id:3, Value:"Other"}];

    $scope.addNewMember = function(newMember)
    {
        $scope.member.gender = $scope.gender.Value;
        $scope.member.role = $scope.role.Description;
        var request = $http.post(context+'/addMember', $scope.member);

        console.log(newMember);
        request.success(function (data, status, headers)
        {
            alert("Member Added Successfully");
            $location.path("/members");
        });

        request.error(function (data, status, headers, config) {
            $location.path("/members");
        });
        //MemberController.addNewMember($scope, $http, newMember);
    };

    $scope.resetForm = function()
    {
        $location.path("/members");
    }
}];