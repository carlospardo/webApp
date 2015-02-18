<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.webapp.utiles.Constantes"%>
<%@ page import="com.webapp.dto.UsuarioDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina 2</title>
</head>
<body>
<%
	UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute("usuario");
%>
<form name="miFormulario"  action="./Servlet" method="post">
	<table>
		<tr>
			<td><p>Hola <%=usuario.getNombre()%></p></td>			
		</tr>
		<tr>
			<td><p>Pagina: pagina 2</p></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value=<%=Constantes.SERVICIOS.LOGOUT%>>
			</td>		
		</tr>
	</table>
	<input name="servicio" type=hidden value="Logout">
</form>
</body>
</html>