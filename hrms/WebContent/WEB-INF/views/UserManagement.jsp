<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html ng-app="app">
<head>
<meta charset="utf-8" />
<title>Reflexis Employee Portal</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="static/app-css/app.css" rel="stylesheet" />
<style>
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: auto;
	right:auto;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	color: #262727;
}

/* Modal Content */
.modal-content {
	background-color: #fefefe;
	margin: auto;
	padding: 20px;
	border: 1px solid #888;
	width: 40%;
	height:50%;
	overflow-y:auto;
	color: #262727;
}

/* The Close Button */
.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover,.close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}

a {
	cursor: pointer
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
    position: relative;
}

img.avatar {
    width: 20%;
    border-radius: 40%;
}
</style>

</head>
<body>

	<div class="">
		<div class="">
			<div
				ng-class="{ 'alert': flash, 'alert-success': flash.type === 'success', 'alert-danger': flash.type === 'error' }"
				ng-if="flash" ng-bind="flash.message"></div>
			<div ng-view></div>

		</div>
	</div>


	<script src="//code.jquery.com/jquery-2.0.3.min.js"></script>
	<script src="//code.angularjs.org/1.5.7/angular.js"></script>
	<script src="//code.angularjs.org/1.5.7/angular-route.js"></script>
	<script src="//code.angularjs.org/1.5.7/angular-cookies.js"></script>
	<script src="//code.angularjs.org/1.5.7/angular-animate.js"></script>
	
	<script src="static/admin/admin.controller.js"></script>
	<!-- 
	 <script src="static/app.js"></script>
	<script src="static/app-services/authentication.service.js"></script>
	<script src="static/app-services/flash.service.js"></script>
	-->
	<!-- Real user service that uses an api -->
	<!--
	<script src="static/app-services/user.service.js"></script>
	<script src="static/app-services/book.service.js"></script>
	<script src="static/app-services/order.service.js"></script>
	<script src="static/app-services/admin.service.js"></script>
	-->
	
	<!-- Fake user service for demo that uses local storage -->
	<!--    <script src="app-services/user.service.local-storage.js"></script> -->
	
	<!-- 
	<script src="static/home/home.controller.js"></script>
	<script src="static/login/login.controller.js"></script>
	<script src="static/register/register.controller.js"></script>
	<script src="static/admin/admin.controller.js"></script>
	<script src="static/user/user.controller.js"></script>
	<script src="static/cart/cart.controller.js"></script>
	<script src="static/history/history.controller.js"></script>
	-->
	
</body>


</html>