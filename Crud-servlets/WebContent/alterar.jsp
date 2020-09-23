<%@  taglib prefix="resp" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualizar Professor</title>
</head>
<body>

 <form action=" ${pageContext.request.contextPath}/atualizar.professor" method="get">

<table style="width:50%" border = "1px" align ="center">
  <tr>
      <td colspan="2"  align ="center" ><h3>Atualizar Professor</h3></td>   
  </tr>
  <tr>
    <th>Nome.:</th>
    <td><input type="text" name="nomeProfessor" value="<resp:out value="${mensagem0}" />">
    <input type="hidden" name="nomeProfessor" value="<resp:out value="${mensagem0}" />">
    <input type="submit" name="enviar" value="buscar"></td>     
  </tr>
  <tr>
    <th>Pis.:</th>
    <td><input type="text" name="pisProfessor" value="<resp:out value="${mensagem1}" />"></td>   
  </tr>
  <tr>
    <th>Pasep.:</th>
    <td><input type="text" name="pasepProfessor" value="<resp:out value="${mensagem2}" />"></td>     
  </tr>  <tr>

      <td colspan="2"  align ="center" ><input type="submit" name="enviar" value="salvar"></td>   
  </tr>
</table>
</form>
<center><resp:out value="${mensagem}" /></center>
<br><center><br><a href="index.jsp" >Voltar para pagina Principal</a><br></center>
</body>
</html>