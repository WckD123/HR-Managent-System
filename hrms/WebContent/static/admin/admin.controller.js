(function () {
    'use strict';

    angular
        .module('app')
        .controller('AdminController', AdminController);

    AdminController.$inject = ['$location','AuthenticationService','UserService','AdminService','BookService','$rootScope'];
	function AdminController($location,AuthenticationService,UserService,AdminService, BookService, $rootScope) {
	var vm = this;
		vm.allBooks=[];
		vm.allUsers=[];
        vm.removebooks = removebooks;
        vm.addusers = addusers;
        vm.logout = logout;
        vm.loadAllUsers = loadAllUsers;
        vm.removeusers = removeusers;
        vm.addbooks=addbooks;
        vm.loadAllBooks = loadAllBooks;
        
		(function initController() {
			// reset login status
			loadAllBooks();
			loadAllUsers();
			AuthenticationService.ClearCredentials();
			alert(vm.book);
		})();

	
		function loadAllBooks(){
			BookService.GetAll()
			.then(function (books) {
				vm.allBooks = books;
			});
		}
		
		function loadAllUsers(){
			alert('inside loadAllUsers of admin service');
			AdminService.GetAllUsers()
			.then(function (users) {
				vm.allUsers = users;
				alert(vm.allUsers);
			});
		}
		
		function addbooks(){
			vm.dataLoading = true;
			alert('inside addbooks');
			 
	           BookService.Create(vm.book)
	                .then(function (response) {
	                    if (response.success) {
	                    	
	                        FlashService.Success('Registration successful', true);
	                        $location.path('/admin');
	                        vm.dataLoading = false;
	                    } else {
	                        FlashService.Error(response.message);
	                        vm.dataLoading = false;
	                    }
	                });
		}
		
		
		function removebooks(id){
			alert('inside removebooks of admin controller')
			BookService.DeleteBook(id);
		}
		
		
		function removeusers(id){
			alert('inside removeusers of admin controller')
			UserService.DeleteUser(id);
		}
		
		
		function addusers(){
			 vm.dataLoading = true;
	            UserService.Create(vm.user)
	                .then(function (response) {
	                    if (response.success) {
	                        FlashService.Success('Registration successful', true);
	                        $location.path('/admin');
	                        vm.dataLoading = false;
	                    } else {
	                        FlashService.Error(response.message);
	                        vm.dataLoading = false;
	                    }
	                });
		}
		
		function logout(){
			UserService.logout()
            .then(function (response) {
            	alert(response);
            	alert('Logout Successful');
                $location.path('/login');
                
            });
		}
	}

})();
