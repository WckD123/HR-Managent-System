routerApp.controller('attendanceController', function($scope, $http,$rootScope,$localStorage) {

        console.log("Here");
        $http.post("http://localhost:8080/hrms/getAttendanceById", {emp_id : $rootScope.globals.empId, pageno : 0}).then(function(res){
            console.log(res.data);
            $scope.dateData = res.data;
        },function(err){
            console.log(err);
        });



});
