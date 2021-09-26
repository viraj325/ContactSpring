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
        h4 {
            color: antiquewhite;
        }
        h5 {
            font-size: 30px;
            background: -webkit-linear-gradient(#f6d327, #de4daa);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            margin-left: 20px;
        }
        p {
            color: antiquewhite;
        }
        .customCard {
            height: auto;
            width: auto;
            padding: 20px;
            margin: 20px;
            border-radius: 20px;
            text-align: center;
            background-color: #f6d327;
            background-image: linear-gradient(315deg, #f6d327 0%, #de4daa 74%);
            transition-duration: 0.6s;
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
            box-shadow: 0 0 0 rgba(0, 0, 0, 0);
        }
    </style>
</head>
<body>
    <div class="customCard">
        <h1>${opening}</h1>
        <h3>/create(POST)</h3>
        <h4>Parameters: String name, String email, String phone, String address</h4>
        <p>To create a new user.</p>

        <h3>/contact(GET)</h3>
        <p>To get list of all contacts.</p>

        <h3>/search/{phone}(GET)</h3>
        <h4>Parameters: String phone</h4>
        <p>To search a specific contact.</p>

        <h3>/update(POST)</h3>
        <h4>Parameters: String name, String email, String phone, String address, String initialPhone</h4>
        <p>To update a specific contact.</p>

        <h3>/delete/{phone}(DELETE)</h3>
        <h4>Parameters: String phone</h4>
        <p>To delete a specific contact.</p>

        <h3>/delete(DELETE)</h3>
        <p>To delete all contacts.</p>
    </div>
<h5>Created by Viraj Patel, 2021</h5>
</body>
</html>
