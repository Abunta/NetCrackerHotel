<%--
  Created by IntelliJ IDEA.
  User: Varvara
  Date: 4/11/2017
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Add hotel</title>
</head>
<body>
<%@include file="../../jsp_elements/_header.jsp" %>
<div id="wrapper">
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <c:set var="path" value="${contextPath}/admin/hotel/add"/>
    <c:set var="button" value="Add hotel"/>
    <%@include file="../../jsp_elements/hotel_form.jsp"%>
</div>
<%@include file="../../jsp_elements/_footer.jsp" %>
</body>
</html>
