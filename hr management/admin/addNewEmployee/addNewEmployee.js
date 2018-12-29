routerApp.controller('addNewEmployeeController', function($scope,$http,$mdToast) {

    $scope.minDate = new Date();

    $scope.user = {
     email_id : '',
     full_name: '',
     qualification : '',
     company: 'Reflexis Systems',
     address: '',
     mobile: '',
     pan_no:'',
     aadhar_no:'',
     marital_status:'',
     joining_date: '',
     role : ''
    };

    $scope.posDep = {
     pos : "",
     dep : ""
    };

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
         $http.post("http://localhost:8080/hrms/admin/addEmp", $scope.user).then(function(res){
             console.log(res.data);

             var formatDate = function (date) {
                 var d = new Date(date),
                     month = '' + (d.getMonth() + 1),
                     day = '' + d.getDate(),
                     year = d.getFullYear();

                 if (month.length < 2) month = '0' + month;
                 if (day.length < 2) day = '0' + day;

                 return [year, month, day].join('-');
             }

             var posDepSendData = {
                 emp_id : res.data,
                 dept_id : $scope.posDep.pos,
                 pos_id : $scope.posDep.dep,
                 //start_date : formatDate($scope.user.joining_date),
                 status : "Active"
             };


                     $http.post("http://localhost:8080/hrms/admin/addepdh", posDepSendData).then(function(response){
                         console.log(response);


                         $scope.user = {
                          email_id : '',
                          full_name: '',
                          qualification : '',
                          company: 'Reflexis Systems',
                          address: '',
                          mobile: '',
                          pan_no:'',
                          aadhar_no:'',
                          marital_status:'',
                          joining_date: '',
                          role : ''
                         };
                         $scope.posDep = {
                          pos : "",
                          dep : ""
                         };

                         $mdToast.show($mdToast.simple().position('bottom right')
                         .textContent('New Employee Has Been Created!').hideDelay(10000).parent(document.getElementById('modalToast')));

                     },function(err){
                         console.log(err);
                     });

             },function(err){
                 console.log(err);
             })
         }



 });
