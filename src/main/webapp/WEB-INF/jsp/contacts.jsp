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

    </style>
</head>
<body>
<c:if test="${not empty response}">
    <c:forEach items="${response}" var="contact">
        <h2>${contact.name}</h2>
        <h4>${contact.phone}</h4>
        <h4>${contact.email}</h4>
        <h4>${contact.address}</h4>
    </c:forEach>
</c:if>
</body>
</html>

<%--
<web-app
        xmlns="http://java.sun.com/xml/ns/j2ee"
        xmlns="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemeLocation="http://java.sun.com/xml/ns/javaee
                            http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
        version="3.0">

    <display-name>Spring MVC Application</display-name>

    <servlet>
        <servlet-name>HelloWeb</servlet-name>
        <servlet-class>
            org.springframework.web.servlet.DispatcherServlet
        </servlet-class>

        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>HelloWeb</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>
--%>