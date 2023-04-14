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

<jsp:include page="menu.jsp"></jsp:include>

    <div class="container-md p-3">

        <div class="border text-center">

                <h1 class="p-3 border">Play ChiFouMi!</h1>

            <p>${!empty askLog ? askLog : 'Play with us!'}</p>

            <c:if test="${empty askLog}">

                <form id="game" method="post" action="${pageContext.request.contextPath}/">
                    <div class="btn-group btn-group-lg" role="group" aria-label="Basic outlined example">
                        <c:forEach var="action" items="${actions}">
                            <button class="btn btn-outline-primary"
                                    value="${action.toString()}"
                                    name="player-action"
                                    type="submit">
                                    ${action.toString()}
                            </button>
                        </c:forEach>
                    </div>
                </form>

            </c:if>

        </div>

    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
