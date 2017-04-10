<%@ page import="by.netcracker.hotel.enums.ROLE" %>
<%
    ROLE role = (ROLE) request.getAttribute("role");
%>

<nav class="navbar navbar-fixed-top navbar-toggleable-md navbar-light bg-faded">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="home">Netcracker</a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
            </li>
            <% if (role != ROLE.GUEST) {%>
            <li class="nav-item">
                <a class="nav-link" href="profile">Profile</a>
            </li>
            <%}%>
            <li class="nav-item">
                <a class="nav-link " href="#">Hotels</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="search-page">Search hotels</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="leave_review">Reviews</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="about">About</a>
            </li>
            <% if (role == ROLE.GUEST) {%>
            <li class="nav-item">
                <a class="nav-link" href="login">Log in</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="registration">Sign up</a>
            </li>
            <%} else {%>
            <li class="nav-item">
                <a class="nav-link" href="j_spring_security_logout">Log out</a>
            </li>
            <%}%>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>