<%@      taglib prefix="resp" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Excluir Professor</title>
</head>
<body>
   <form action=" ${pageContext.request.contextPath}/excluir.professor" method="get">
	   <table style="width:50%" border = "1px" align ="center">
		   	<tr>
		    <td colspan="2"  align ="center" ><h3>Excluir Professor</h3></td>   
		  	</tr>
		   	<tr>
		   	<td  align ="right">Nome.:</td>
		    <td><input type="text" name="nomeProfessor"> <input type="submit" name="excluir" value="Excluir"></td>
		   	</tr>
		   	<tr>
		    <td colspan="2"  align ="left" ><b><resp:out value="${mensagem}" /><br>
		    </b>
			    
		    </td>
		    </tr> 
		</table>
	</form>	
	<br><center><br><a href="index.jsp" >Voltar para pagina Principal</a><br></center>
</body>
</html>