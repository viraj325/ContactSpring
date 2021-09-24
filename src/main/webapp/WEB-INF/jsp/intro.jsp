<%--
  Created by IntelliJ IDEA.
  User: viraj
  Date: 9/24/2021
  Time: 1:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VirajCD</title>
    <style>
        body {
            background-color: antiquewhite;
        }
        h1 {
            color: antiquewhite;
        }
        h3 {
            color: navajowhite;
        }
        p {
            color: antiquewhite;
        }
        .customCard {
            height: 50%;
            width: 50%;
            padding: 20px;
            margin: 20px;
            border-radius: 20px;
            text-align: center;
            background-color: #f6d327;
            background-image: linear-gradient(315deg, #f6d327 0%, #de4daa 74%);
        }
    </style>
</head>
<body>
    <div class="customCard">
        <h1>${opening}</h1>
        <h3>/create(POST)</h3>
        <p>To create a new user.</p>
        <h3>/hello(GET)</h3>
        <p>To get list of all contacts.</p>
        <h3>/res/something/{id}(GET)</h3>
        <p>To search a specific contact.</p>
    </div>
</body>
</html>
