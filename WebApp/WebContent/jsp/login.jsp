<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.webapp.utiles.Constantes"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="./Servlet" method="post">
	<table>
		<tr>
			<td><p>Nombre Usuario</p></td>
			<td><input name="nombreUsuario" type="text"></td>
		</tr>
		<tr>
			<td><p>Password:</p></td>
			<td><input name="password" type="password"></td>
		</tr>
		<tr>
			<td><p>Pagina:</p></td>
			<td><select name="pagina">
					<option value='<%=Constantes.PANTALLAS.PAGINA_1%>'>Pagina 1</option>
					<option value='<%=Constantes.PANTALLAS.PAGINA_2%>'>Pagina 2</option>
					<option value='<%=Constantes.PANTALLAS.PAGINA_3%>'>Pagina 3</option>
				</select>
			</td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value=<%=Constantes.SERVICIOS.LOGIN%>>
			</td>		
		</tr>
	</table>
	<input name="servicio" type=hidden value="Login">
</form>
</body>
</html>