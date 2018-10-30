<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
	<link href="https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
	<link rel="stylesheet" href="/spring/css/login.css">
</head>

<body>
	<div class="form">
		<ul class="tab-group">
			<li class="tab"><a href="#signup">Sign Up</a></li>
			<li class="tab active"><a href="#login">Log In</a></li>
		</ul>
		<div class="tab-content">
			<div id="signup" style="display: none;">
				<h1>Sign Up for Free</h1>
				<form action="" method="post">
					<div class="top-row">
						<div class="field-wrap">
							<label>First Name<span class="req">*</span></label> <input
								type="text" name="newName" required autocomplete="off">
						</div>
						<div class="field-wrap">
							<label>Last Name<span class="req">*</span></label> <input
								type="text" name="newSurname" required autocomplete="off">
						</div>
					</div>
					<div class="field-wrap">
						<label>Email Address<span class="req">*</span></label> <input
							type="email" name="newEmail" required autocomplete="off">
					</div>
					<div class="field-wrap">
						<label>Set A Password<span class="req">*</span></label> <input
							name="newPassword" type="password" required autocomplete="off">
					</div>
					<button type="submit" class="button button-block">Get
						Started</button>
				</form>
			</div>

			<div id="login" style="display: block;">
				<h1>Welcome Back!</h1>
				
				<form action="${pageContext.request.contextPath}/login" method="post">
					<div class="field-wrap">
						<label>Email Address<span class="req">*</span></label>
						<input type="text" name="username" required autocomplete="off">
					</div>
					<div class="field-wrap">
						<label>Password<span class="req">*</span></label> 
						<input type="password" name="password" required autocomplete="off">
					</div>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<p class="forgot"><a href="#">Forgot Password?</a></p>
					<p class="wrong">${wrong}</p>
					<button type="submit" class="button button-block">Log In</button>
				</form>
				
			</div>
		</div>
	</div>

	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="/spring/js/index.js"></script>
</body>
</html>