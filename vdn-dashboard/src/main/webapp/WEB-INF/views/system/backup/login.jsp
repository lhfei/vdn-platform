<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../commons/bootstrap.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <!-- Custom styles for this template -->
    <link href="${basepath}/resources/css/signin.css" rel="stylesheet">
</head>
<body>
	<div class="container">

		<form class="form-signin" action="login.do">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Email address</label> 
			<input 
				name="userName" id="inputEmail" class="form-control" 
				placeholder="User name." required autofocus > 
			
			<label for="inputPassword" class="sr-only">Password</label> 
			<input
				type="password" id="inputPassword" class="form-control"
				name="passWord" placeholder="Password" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
		</form>

	</div>
	<!-- /container -->
</body>
</html>