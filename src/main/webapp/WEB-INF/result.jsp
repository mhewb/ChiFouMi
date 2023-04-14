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

<jsp:include page="menu.jsp"></jsp:include>

<div class="container-md p-3">

        <div class="row border">

            <div class="col d-flex align-items-center">
                <h1>Play ChiFouMi!</h1>
            </div>
            <div class="col">
                <div class="d-flex flex-column  align-items-center">

                    <p>Total victory:<br/>
                    Player: ${playerTotWins}<br/>
                    Computer: ${computerTotWins}</p>

                </div>

            </div>

        </div>

        <div class="row d-flex flex-column">

            <div class="col">

                <form method="get" action="">
                    <button id="replay" class="btn btn-secondary btn-lg" type="submit">Play again!</button>
                </form>

             </div>


        <div class="col">

            <p> Players choose ${playerAction} and computer played ${computerAction} </p>
            <p>${empty winner ? 'Equality!' : winner.getName() += ' won!'}</p>

            <c:if test="${!empty bigWinner}">
                <p>${bigWinner.getName()} is the winner !</p>
            </c:if>

        </div>
        </div>





    </div>


</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>