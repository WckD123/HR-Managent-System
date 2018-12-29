routerApp.controller('homeController', function($scope,$http,$rootScope) {

    $scope.message = 'test';
    $scope.loggedIn = "Yes";

    $scope.newsList = [
      {data: "Lorem ipsum text here"},
      {data: "Lorem ipsum text here"},
      {data: "Lorem ipsum text here"},
      {data: "Lorem ipsum text here"},
      {data: "Lorem ipsum text here"},
      {data: "Lorem ipsum text here"},
      {data: "Lorem ipsum text here"}
    ];

    $scope.events = [
        {day : "Tuesday", date : "14", month : "Aug" , type : "2:00 PM onwards", reason : "Independence Day Celebrations!"},
        {day : "Wednesday", date : "15", month : "Aug" , type : "Holiday", reason : "Independence Day"},
        {day : "Saturday", date : "18", month : "Aug" , type : "Holiday", reason : "It's a Saturday!"},
        {day : "Tuesday", date : "21", month : "Aug" , type : "Holiday" ,reason : "EID"},
        {day : "Saturday", date : "25", month : "Aug" , type : "Holiday", reason : "It's a Saturday!"}
    ].splice(0,3);



});
