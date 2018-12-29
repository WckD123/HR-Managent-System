routerApp.controller('leaveController',function($scope,  $http, $localStorage, $rootScope, $state,$mdToast ){


        $scope.minDate = new Date();

        this.submit = function(){
                var formatDate = function (date) {
                    var d = new Date(date),
                        month = '' + (d.getMonth() + 1),
                        day = '' + d.getDate(),
                        year = d.getFullYear();

                    if (month.length < 2) month = '0' + month;
                    if (day.length < 2) day = '0' + day;

                    return [year, month, day].join('-');
                }
                console.log(formatDate(this.startDate));
                var data ={
                        start_date : formatDate(this.startDate),
                        end_date : formatDate(this.endDate),
                        emp_id : $rootScope.globals.currentUser.empId
                };
                console.log(data);
                $http.post("http://localhost:8080/hrms/user/addl", data).then(function(res){
                    console.log(res);
                    $scope.leaveArray.push({
                        start_date : data.start_date,
                        end_date : data.end_date,
                        emp_id : data.emp_id,
                        status : "Applied"
                    });
                        $mdToast.show($mdToast.simple().position('bottom right')
                        .textContent('Make sure to convey this information to your Manager!').hideDelay(10000).parent(document.getElementById('modalToast')));
                },function(err){
                    console.log(err);
                })

        }



        $http.post("http://localhost:8080/hrms/user/caplll", {emp_id : $rootScope.globals.currentUser.empId,pageno : 0}).then(function(res){
            console.log(res.data);
            $scope.leaveArray = res.data;
        },function(err){
            console.log(err);
        });

        $scope.leaveArray = [];

        $scope.showApprovedDate = function(){

        };

        $scope.OpenViewTab = function(){
            $scope.show = true;
        };

        $scope.OpenApplyTab = function(){
            $scope.show = false;
        };


        $http.post("http://localhost:8080/hrms/user/getRemainingLeaveDays",{emp_id : $rootScope.globals.currentUser.empId}).then(function(res){
            console.log(res.data);
            if(res.data<0){
                $scope.remainingLeaveDays =0;
            }
            else{
                $scope.remainingLeaveDays = res.data;
            }

        },function(err){
            console.log(err);
        });


        this.startDate = new Date();
         this.endDate = new Date();
         this.endDate.setDate(this.endDate.getDate() + 1);

});
