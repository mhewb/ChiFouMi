<%--
  Created by IntelliJ IDEA.
  User: mhe
  Date: 14/04/2023
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Chifoumi</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>

<div class="container-md p-3">

  <c:if test="${empty alreadyLogged}">

    <form action="${pageContext.request.contextPath}/login" method="post">
      <input type="text" name="username">
      <input type="password" name="password">
      <button class="btn btn-primary" type="submit">Login</button>
    </form>

  </c:if>

  <c:if test="${LoginError == true}">
    <script>alert('Bad Credential')</script>
  </c:if>

  <c:if test="${!empty alreadyLogged}">

    <form action="${pageContext.request.contextPath}/logout" method="post">
      <button class="btn btn-danger" type="submit">Logout</button>
    </form>

  </c:if>



</div>

</body>
</html>