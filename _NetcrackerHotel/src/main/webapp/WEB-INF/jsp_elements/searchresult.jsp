<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="margin: 50px">
    <c:if test="${not empty hotels}">

        <c:forEach var="hotel" items="${hotels}">
            <a href="/hotel_page/${hotel.id}">
            <%@include file="../jsp_elements/hotelMin.jsp"%>
            </a>
        </c:forEach>

    </c:if>
    <c:if test="${empty hotels}">
    <div class="form-group">
        <p>
            ${message}
        </p>
    </div>
    </c:if>
</div>