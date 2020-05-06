<%-- 
    Document   : login
    Created on : 14/04/2020, 08:31:47
    Author     : pablo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
	<title>Login Locadora Carro Bom</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================	-->
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================	-->
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="">
		<div class="">
                    
                    <c:if test="${requestScope.succ != null}">
                                <div class="alert alert-info">
                                    ${requestScope.succ}
                                </div>
                            </c:if>
                            
                            <c:if test="${requestScope.err != null}">
                                <div class="alert alert-danger">
                                    ${requestScope.err}
                                </div>
                            </c:if>
			<div class="">
				<div class="" align = "center">
                                    <img src="images/img-03.jpg" alt="IMG"
				</div>
                            
                            
                            
                            <form class="" action="app" method="POST">
                                
<!--                                se tiver form pra enviar-->
                                <input type="hidden" name="ac" value="checkLogin"/>
                                <br>
					<span class="login100-form-title">
						Login
					</span>
<br>
					<div class="" >
						<input class="input100" border="1px" type="text" name="cpLogin" placeholder="Insira o login aqui">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>

					<div class="" >
						<input class="input100" type="password" name="cpSenha" placeholder="Insira a senha aqui">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="">
						<button class="login100-form-btn">
							Entrar 
						</button>
					</div>

					

					<div class="text-center p-t-136">
						<a class="txt2" href="app?ac=cadastro">
							Cadastre-se
							<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	

<!--	
===============================================================================================	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
===============================================================================================
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
===============================================================================================
	<script src="vendor/select2/select2.min.js"></script>
===============================================================================================
	<script src="vendor/tilt/tilt.jquery.min.js"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
===============================================================================================
	<script src="js/main.js"></script>-->

</body>
</html>

