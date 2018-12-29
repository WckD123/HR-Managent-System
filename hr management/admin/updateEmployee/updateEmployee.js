routerApp.controller('updateEmployeeController', function($scope,$http,$mdToast) {


    $scope.getThisId = "";
    $scope.show = false;
    $scope.findEmployee = function(){
                $http.post("http://localhost:8080/hrms/findById",{emp_id : $scope.getThisId}).then(function(res){
                    $scope.user = res.data;
                    $scope.show = true;
                },function(err){
                    console.log(err);
                });
    }






    $scope.states = ('AL AK AZ AR CA CO CT DE FL GA HI ID IL IN IA KS KY LA ME MD MA MI MN MS ' +
    'MO MT NE NV NH NJ NM NY NC ND OH OK OR PA RI SC SD TN TX UT VT VA WA WV WI ' +
    'WY').split(' ').map(function(state) {
       return {abbrev: state};
     });

     $scope.maritalstatus = ('MARRIED UNMARRIED').split(' ').map(function(status){
         return {abbrev: status};
     });
     $scope.positions = [];
     $scope.departments = [];

     $http.get("http://localhost:8080/hrms/admin/allpm").then(function(res){
         for(var i=0 ;i<res.data.length ; i++){
             $scope.positions.push(res.data[i]);
         }
     },function(err){
         console.log(err);
     });

     $http.get("http://localhost:8080/hrms/admin/alldm").then(function(res){
         for(var i=0 ;i<res.data.length ; i++){
             $scope.departments.push(res.data[i]);
         }
     },function(err){
         console.log(err);
     });

     $scope.roles = ('ADMIN USER').split(' ').map(function(roles){
         return {abbrev: roles};
     });



     // ************** CREATE USER FUNCTION (THIS WILL BE MY EVEREST) ***********//

     $scope.createUser = function(){
         $http.put("http://localhost:8080/hrms/admin/updateEmp", $scope.user).then(function(res){
             console.log(res.data);
             },function(err){
                 console.log(err);
             })
         }



 });
