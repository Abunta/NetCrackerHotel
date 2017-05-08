<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 01.05.2017
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Order</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <link href="<c:url value= "/resources/bootstrap-4.0.0-alpha.6-dist/css/bootstrap.css" />"
          rel="stylesheet">
    <link href="<c:url value="/resources/jQuery-Form-Validator/form-validator/theme-default.min.css"/>"
          rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="../jsp_elements/_header.jsp"%>
<div id="wrapper">
    <c:if test="${error!=null}">
        <div style="margin: 50px" class="alert alert-danger" >
                ${error}
        </div>
    </c:if>
    <div class="content">
        <p>Please enter additional information</p>
        <p>Room ID: ${roomId}</p>
        <p>Username: ${currentUser.username}</p>
        <p>Arrival date: ${searchFilter.startDate}</p>
        <p>Leave date: ${searchFilter.endDate}</p>
        <%@include file="../jsp_elements/addorderform.jsp"%>
    </div>
    <%@include file="../jsp_elements/_footer.jsp"%>
</div>
<script src="<c:url value="/resources/jquery-ui-1.12.1.custom/jquery.js"/>"
        type="text/javascript"></script>
<script src="<c:url value="/resources/jQuery-Form-Validator/form-validator/jquery.form-validator.min.js"/>"
        type="text/javascript"></script>
<script src="<c:url value="/resources/js/validator_property.js"/>"
        type="text/javascript"></script>
</body>
</html>