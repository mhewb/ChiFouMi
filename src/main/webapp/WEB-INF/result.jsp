<%--
  Created by IntelliJ IDEA.
  User: mhe
  Date: 13/04/2023
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Chifoumi</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>

<div class="container-md">
    <h3 class="p-5 mx-auto text-danger">Welcome to the Chifoumi game</h3>

    <form method="get" action="">
        <button id="replay" class="btn btn-secondary" type="submit">Replay</button>
    </form>

    <p> Players choose ${playerAction} and computer played ${computerAction} </p>
    <c:set var="isAWinner" value="${winner != null}"/>
    <c:if test="${!isAWinner}">
        <p>Equality!</p>
    </c:if>
    <c:if test="${isAWinner}">
        <p>${winner.getName()} won ! </p>
    </c:if>

    <p> Player total victory ${playerTotWins}</p>
    <p> Computer total victory ${computerTotWins}</p>

    <c:if test="${bigWinner != null}">
        <p>${bigWinner.getName()} is the winner !</p>
    </c:if>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>