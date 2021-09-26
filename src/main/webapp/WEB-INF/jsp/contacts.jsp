<%--
  Created by IntelliJ IDEA.
  User: viraj
  Date: 4/30/2021
  Time: 3:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<html>
<head>
    <title>All Contacts</title>
    <style>
        body {
            background-color: antiquewhite;
        }
        h1 {
            font-size: 55px;
            background: -webkit-linear-gradient(#f6d327, #de4daa);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }
        h2 {
            color: antiquewhite;
        }
        h4 {
            color: navajowhite;
        }
        .customCard {
            height: auto;
            width: 40%;
            padding: 20px;
            margin: 20px;
            border-radius: 20px;
            text-align: center;
            background-color: #f6d327;
            background-image: linear-gradient(315deg, #f6d327 0%, #de4daa 74%);
            transition-duration: 0.3s;
        }
        .customCard:hover {
            transition-duration: 0.6s;
            box-shadow: 0 2.8px 2.2px rgba(0, 0, 0, 0.034),
            0 6.7px 5.3px rgba(0, 0, 0, 0.048),
            0 12.5px 10px rgba(0, 0, 0, 0.06),
            0 22.3px 17.9px rgba(0, 0, 0, 0.072),
            0 41.8px 33.4px rgba(0, 0, 0, 0.086),
            0 100px 80px rgba(0, 0, 0, 0.12);
        }
        .customCard:active {
            transition-duration: 0.6s;
            background-position:100px;
            box-shadow: 0 0 0 rgba(0, 0, 0, 0);
        }
    </style>
</head>
<body>
<h1>${title}</h1>
<c:if test="${not empty response}">
    <c:forEach items="${response}" var="contact">
        <div class="customCard">
            <h2>Name: ${contact.name}</h2>
            <h4>Phone: ${contact.phone}</h4>
            <h4>Email: ${contact.email}</h4>
            <h4>Address: ${contact.address}</h4>
        </div>
    </c:forEach>
</c:if>
</body>
</html>