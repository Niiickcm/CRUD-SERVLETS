<%@      taglib prefix="resp" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Professor</title>
</head>
<body>

 <form action=" ${pageContext.request.contextPath}/incluir.professor" method="get">

<table style="width:50%" border = "1px" align ="center">
  <tr>
      <td colspan="2"  align ="center" ><h3>Cadastrar Professor</h3></td>   
  </tr>
  <tr>
    <th>Nome.:</th>
    <td><input type="text" name="nomeProfessor"></td>     
  </tr>
  <tr>
    <th>Pis.:</th>
    <td><input type="text" name="pisProfessor"></td>   
  </tr>
  <tr>
    <th>Pasep.:</th>
    <td><input type="text" name="pasepProfessor"></td>   
  </tr>
  <tr>
      <td colspan="2"  align ="center" ><input type="submit" name="Enviar" value="Enviar"></td>   
  </tr>
</table>
</form>
<center><resp:out value="${mensagem}" /></center>
<br><center><br><a href="index.jsp" >Voltar para pagina Principal</a><br></center>
</body>
</html>