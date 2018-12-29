routerApp.controller('adminController', function($scope,  $http, $localStorage, $rootScope, $state) {

    $scope.checkAdmin = function(){
        if($rootScope.globals.currentUser.role == "ADMIN"){
            return true;
        }
        else{
            $state.go(signedIn);
        }
    }

    $scope.message = 'test';
    $scope.loggedIn = "Yes";

    $scope.currentNavItem = 'page1';

    $scope.goto = function(page) {
      console.log("Goto " + page);
    };

    $scope.goToStateLeaves = function(){
        $state.go(adminSignedIn.leaves);
    };









    // ************************* APPROVE LEAVES *****************//////////////////

    $http.get("http://localhost:8080/hrms/admin/apple").then(function(res){
        $scope.allLeaveData = res.data;
    },function(err){
        console.log(err);
    });




    // ************************* Employee *****************//////////////////

    $http.post("http://localhost:8080/hrms/admin/allEmp", {pageno : $scope.selectedPage}).then(function(res){
        $scope.allEmployeeData = res.data;
    },function(err){
        console.log(err);
    });

    $scope.selectedPage = 0;

    $scope.selectNewPage = function(val){
        console.log(val);
        $http.post("http://localhost:8080/hrms/admin/allEmp", {pageno : val}).then(function(res){
            $scope.allEmployeeData = res.data;
        },function(err){
            console.log(err);
        });
    };

    $scope.employeePaginationData =[
        { value : 0},
        { value : 1},
        { value : 2}
    ];


    // ************************* Salary Paid *****************//////////////////

    /*$http.get("http://localhost:8080/hrms/admin/allEmp").then(function(res){
        $scope.allEmployeeData = res.data;
    },function(err){
        console.log(err);
    });*/



    // ************************* Position Department Data *****************//////////////////

    $http.post("http://localhost:8080/hrms/admin/allepdh" , {pageno : 0}).then(function(res){
        $scope.allPosdepData = res.data;
    },function(err){
        console.log(err);
    });




});
