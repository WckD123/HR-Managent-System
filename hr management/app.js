var routerApp = angular.module('routerApp',['ui.router', 'ngStorage','ngAria', 'ngAnimate', 'ngMessages', 'ngMaterial']);

routerApp.run(run).config(function($stateProvider, $urlRouterProvider, $localStorageProvider, $mdDateLocaleProvider,$mdThemingProvider) {

    //$localStorageProvider.set(globals) = {} ;
    //$localStorage.credentials= {} ;

    $mdThemingProvider.theme('docs-dark', 'default')
      .primaryPalette('yellow')
      .dark();


    $mdThemingProvider.theme('dark-grey').backgroundPalette('grey').dark();
  $mdThemingProvider.theme('dark-orange').backgroundPalette('orange').dark();
  $mdThemingProvider.theme('dark-purple').backgroundPalette('deep-purple').dark();
  $mdThemingProvider.theme('dark-blue').backgroundPalette('blue').dark();

    $mdDateLocaleProvider.formatDate = function(date) {
      return date ? moment(date).format('L') : '';
    };

    /**
     * @param dateString {string} string that can be converted to a Date
     * @returns {Date} JavaScript Date object created from the provided dateString
     */
    $mdDateLocaleProvider.parseDate = function(dateString) {
      var m = moment(dateString, 'L', true);
      return m.isValid() ? m.toDate() : new Date(NaN);
    };


    $localStorageProvider.setKeyPrefix('mk');
    $urlRouterProvider.otherwise('/');

    $stateProvider

        // HOME STATES AND NESTED VIEWS ========================================

        .state('signedIn', {
            url: '/home',
            templateUrl: './home/homeSignedIn.html',
            controller: 'homeController',
            controllerAs: 'hc'
        })


        .state('signedOut', {
            url: '/',
            templateUrl: './home/homeSignedOut.html',
            controller: 'homeController',
            controllerAs: 'hc'
        })

        .state('signedIn.attendance', {
            url: '/attendance',
            templateUrl: './home/attendance/attendance.html',
            controller: 'attendanceController',
            controllerAs: 'attc'
        })

        .state('signedIn.leave', {
            url: '/leave',
            templateUrl: './home/leave/leave.html',
            controller: 'leaveController',
            controllerAs: 'ctrl'
        })

        .state('signedIn.profile.posdep', {
            url: '/userHistory',
            templateUrl: './home/profile/posdep/posdep.html',
            controller: 'posdepController',
            controllerAs: 'pdc'
        })

        .state('signedIn.profile', {
            url: '/profile',
            templateUrl: './home/profile/profile.html',
            controller: 'profileController',
            controllerAs: 'hc'
        })

        .state('signedIn.profile.userProfile', {
            url: '/profile',
            templateUrl: './home/profile/userProfile/userProfile.html',
            controller: 'profileController',
            controllerAs: 'hc'
        })

        .state('signedIn.profile.salaryPaid', {
            url: '/salaryPaid',
            templateUrl: './home/profile/salaryPaid/salaryPaid.html',
            controller: 'profileController',
            controllerAs: 'hc'
        })







        // ROUTING FOR ADMIN //

        .state('adminSignedIn', {
            url: '/admin',
            templateUrl: './admin/adminHome.html',
            controller: 'adminController',
            controllerAs: 'ac'
        })

        .state('adminSignedIn.leaves', {
            url: '/leaves',
            templateUrl: './admin/approveLeaves/approveLeaves.html',
            controller: 'adminController',
            controllerAs: 'ac'
        })
        .state('adminSignedIn.employee', {
            url: '/leaves',
            templateUrl: './admin/employee/employee.html',
            controller: 'adminController',
            controllerAs: 'ac'
        })
        .state('adminSignedIn.posdep', {
            url: '/leaves',
            templateUrl: './admin/viewPositionHistory/posdep.html',
            controller: 'adminController',
            controllerAs: 'ac'
        })
        .state('adminSignedIn.salaryPaid', {
            url: '/leaves',
            templateUrl: './admin/salaryPaid/salaryPaid.html',
            controller: 'adminController',
            controllerAs: 'ac'
        })
        .state('adminSignedIn.addNewEmployee', {
            url: '/newEmployee',
            templateUrl: './admin/addNewEmployee/addNewEmployee.html',
            controller: 'addNewEmployeeController',
            controllerAs: 'ane'
        })
        .state('adminSignedIn.updateEmployee', {
            url: '/updateEmployee',
            templateUrl: './admin/updateEmployee/updateEmployee.html',
            controller: 'updateEmployeeController',
            controllerAs: 'ane'
        })







        // ROUTING FOR ADMIN //










        /* nested list with custom controller
        .state('home.list', {
            url: '/list',
            templateUrl: './partial-home-list/partial-home-list.html',
            controller: 'homeListController'
        })

        // nested list with just some random string data
        .state('home.paragraph', {
            url: '/paragraph',
            template: 'I could sure use a drink right now oz Viji randi hai!'
        })

        // ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
        .state('about', {
            url: '/about',
            templateUrl: 'about/about.html'

        })*/;

});


    run.$inject = ['$rootScope', '$location', '$http'] ;

    function run($rootScope, $location, $http) {

        console.log(JSON.parse(localStorage.getItem('mkglobals')));
        $rootScope.globals = JSON.parse(localStorage.getItem('mkglobals')) || {};

        if($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata ;
            //console.log(JSON.parse('Basic ' + $rootScope.globals.currentUser.authdata));
        }
        $rootScope.$on('$locationChangeStart', function(event, next, current) {
            var notRestrictedPages = [ '/' , ''] ;
            var notRestrictedPagesForAdmin = [ '/admin' , ''] ;
            console.log($location.path()) ;
            var isRestrictedPage = $.inArray($location.path(), notRestrictedPages) === -1 ;
            var loggedIn=false;
            if($rootScope.globals=={}){loggedIn = true;}else{loggedIn = false;};
            console.log(loggedIn);
            if(isRestrictedPage && !loggedIn) {
                $location.path('') ;
            }
        });
    }
