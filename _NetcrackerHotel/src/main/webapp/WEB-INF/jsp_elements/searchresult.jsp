<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form style="margin: 50px">
    <c:if test="${not empty hotels}">

        <c:forEach var="listValue" items="${hotels}">
            <div class="row list-group-item">
                <div class="col-4">
                    <img src="<c:url value="/resources/pictures/${listValue.imagePath}"/>" class="rounded"
                         alt="${listValue.name}"
                         width="200">
                </div>
                <div class="col-8">
                    <p>
                            ${listValue.country},
                            ${listValue.city}
                    </p>
                    <p>
                            ${listValue.address}
                    </p>
                    <p>
                            ${listValue.name}
                            ${listValue.typeOfService}
                    </p>
                </div>
            </div>
        </c:forEach>

    </c:if>
</form>