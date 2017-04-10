<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form id="reviewForm" style="margin: 20px" action="send-review"
           method="post" ><!--modelAttribute="user"-->

    <div class="form-group">
        <form:label path="review_text">Last name</form:label>
        <form:input path="review_text" type="text" class="form-control"
                    placeholder="Text" required="required"
                    data-validation="length alphanumeric"
                    data-validation-length="20-2000"
                    data-validation-error-msg="Last name has to be an alphanumeric value (5-15 chars)"
        />
        <form:errors path="review_text" cssClass="ui-state-error-text"/>
    </div>

    <div class="form-group">
        <form:button type="submit" class="btn btn-primary">Send</form:button>
    </div>
</form:form>