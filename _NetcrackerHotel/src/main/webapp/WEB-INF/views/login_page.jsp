<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Log in</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />" rel="stylesheet">
</head>
<body>
<%@include file="../jsp_elements/_header.jsp" %>
<div id="wrapper">

    <div class="container">
        <c:if test="${message!=null}" >
            <div style="margin: 50px" class="alert alert-success" >
                    ${message}
            </div>
        </c:if>
        <div class="row row-offcanvas row-offcanvas-left">
            <%@include file="../jsp_elements/_sidebar.jsp" %>
        </div>
    </div>
</div>
</body>
</html>
