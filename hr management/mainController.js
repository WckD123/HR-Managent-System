routerApp.controller('mainController',function($scope,  $http, $localStorage, $rootScope, $state,$mdToast){


    $scope.checkAdmin = function(){
        if($rootScope.globals.currentUser.role == "ADMIN"){
            return true;
        }
        else{
            $state.go(signedIn.profile.userProfile);
        }
    }


            $scope.initFunc = function (){
                if($rootScope.globals!={}){
                    $scope.LoginModal = false;
                    $scope.LoginButton = true;
                    $scope.showSuccess = false;
                }
            }

            $scope.loginModal = false;


$scope.user={'username':'','password':''};

     $scope.authFunc = function() {
         console.log("Authenicating...");

         var userData = {
             email_id : $scope.user.username,
             emp_password : $scope.user.password
         };

         console.log("Auth from service");

                 var req = {
                  method: 'POST',
                  url: 'http://localhost:8080/hrms/login',
                  data: userData
                     }
                     console.log("Test");
                     $http(req).then(function(response){
                         console.log(response.status);
                         $scope.showError = false;
                         $scope.showSuccess = true;
                         $scope.showUserError = false;
                         $scope.LoginModal =  true;
                         $scope.LoginButton = false;

                         var Base64 = {

                            keyStr: 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=',

                            encode: function (input) {
                                var output = "";
                                var chr1, chr2, chr3 = "";
                                var enc1, enc2, enc3, enc4 = "";
                                var i = 0;

                                do {
                                    chr1 = input.charCodeAt(i++);
                                    chr2 = input.charCodeAt(i++);
                                    chr3 = input.charCodeAt(i++);

                                    enc1 = chr1 >> 2;
                                    enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                                    enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                                    enc4 = chr3 & 63;

                                    if (isNaN(chr2)) {
                                        enc3 = enc4 = 64;
                                    } else if (isNaN(chr3)) {
                                        enc4 = 64;
                                    }

                                    output = output +
                                        this.keyStr.charAt(enc1) +
                                        this.keyStr.charAt(enc2) +
                                        this.keyStr.charAt(enc3) +
                                        this.keyStr.charAt(enc4);
                                    chr1 = chr2 = chr3 = "";
                                    enc1 = enc2 = enc3 = enc4 = "";
                                } while (i < input.length);

                                return output;
                            },

                            decode: function (input) {


                                var output = "";
                                var chr1, chr2, chr3 = "";
                                var enc1, enc2, enc3, enc4 = "";
                                var i = 0;

                                // remove all characters that are not A-Z, a-z, 0-9, +, /, or =
                                var base64test = /[^A-Za-z0-9\+\/\=]/g;
                                if (base64test.exec(input)) {
                                    window.alert("There were invalid base64 characters in the input text.\n" +
                                        "Valid base64 characters are A-Z, a-z, 0-9, '+', '/',and '='\n" +
                                        "Expect errors in decoding.");
                                }
                                input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

                                do {
                                    enc1 = this.keyStr.indexOf(input.charAt(i++));
                                    enc2 = this.keyStr.indexOf(input.charAt(i++));
                                    enc3 = this.keyStr.indexOf(input.charAt(i++));
                                    enc4 = this.keyStr.indexOf(input.charAt(i++));

                                    chr1 = (enc1 << 2) | (enc2 >> 4);
                                    chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
                                    chr3 = ((enc3 & 3) << 6) | enc4;

                                    output = output + String.fromCharCode(chr1);

                                    if (enc3 != 64) {
                                        output = output + String.fromCharCode(chr2);
                                    }
                                    if (enc4 != 64) {
                                        output = output + String.fromCharCode(chr3);
                                    }

                                    chr1 = chr2 = chr3 = "";
                                    enc1 = enc2 = enc3 = enc4 = "";

                                } while (i < input.length);

                                return output;
                            }
                        };

                         var x = function(email , password) {
                                     var authdata = Base64.encode(email + ':' + password) ;

                                     console.log("Test");

                                     $http.post("http://localhost:8080/hrms/getIdByEmail", {email_id : email}).then(function(response){
                                         console.log(response);

                                         //$rootScope.empId = {empId : response.data};

                                        // empId : response.data
                                        $rootScope.globals = {
                                            currentUser : {
                                                email : email ,
                                                authdata : authdata,
                                                empId : response.data.emp_id,
                                                fullName : response.data.full_name,
                                                role : response.data.role
                                             }
                                        };
                                        $http.defaults.headers.common['Authorization'] = 'Basic ' + authdata ;
                                        $localStorage.globals = $rootScope.globals ;

                                         console.log("Test");

                                         $http.post("http://localhost:8080/hrms/setAttendance", {emp_id : response.data.emp_id}).then(function(response){
                                             console.log(response);
                                             console.log(response.status);
                                         },function(error){
                                             console.log(error.status);
                                         });

                                     console.log("Test");

                                        var text = "Welcome back, " + $rootScope.globals.currentUser.fullName + ". Your attendance has been marked "

                                         $mdToast.show($mdToast.simple().position('bottom right')
                                         .textContent(text).hideDelay(10000).parent(document.getElementById('modalToast')));

                                 })};


                        x(userData.email_id, userData.emp_password);

                        $state.go(loggedIn.profile.userProfile);

                     }, function(error){
                         if(error.status==401){
                             $scope.showError = true;
                             $scope.showSuccess = false;
                             $scope.showUserError = false;
                         }
                         if(error.status==404){
                             $scope.showUserError = true;
                             $scope.showError = false;
                             $scope.showSuccess = false;
                         }
                     });


      };



     $scope.LogoutFunc = function(){
         console.log("Logging you out!");
         $scope.LoginModal =  !$scope.LoginModal;
         $scope.user.username = "";
         $scope.user.password = "";
         //$scope.myForm.email.$error.required = false;
         //$scope.myForm.pass.$error.required = false;
         $scope.showError = false;
         $scope.showSuccess = false;

         $rootScope.globals = null ;
         $localStorage.globals= {} ;
         $localStorage.credentials= {} ;
         $http.defaults.headers.common.Authorization = 'Basic' ;
         $state.go('signedOut');
     }




$scope.showUserError = false; // set Error flag
$scope.showError = false; // set Error flag
$scope.showSuccess = false; // set Success Flag



}


);
