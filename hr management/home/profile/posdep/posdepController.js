routerApp.controller('posdepController',function($scope,  $http, $localStorage, $rootScope, $state,$mdToast ){
    console.log("inside erro fn");


        $http.post("http://localhost:8080/hrms/user/epdh", {emp_id : $rootScope.globals.currentUser.empId}).then(function(res){
            console.log(res.data);
            $scope.empPosDeptHistoryArray = res.data;
        },function(err){
            //console.log(err);
            console.log("inside erro fn");
        });

        $scope.empPosDeptHistoryArray = [];


});
