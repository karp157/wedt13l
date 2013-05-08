<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Strona glowna--%>
<html>
<head>
    <title>post search - szukaj posty z serwisu tweeter</title>
</head>
<body>
<header>
    <tiles:insertAttribute name="header"/>
</header>
<div class="post-search-body">
    <tiles:insertAttribute name="body"/>
</div>
<footer>
    <tiles:insertAttribute name="footer"/>
</footer>
</body>
</html>