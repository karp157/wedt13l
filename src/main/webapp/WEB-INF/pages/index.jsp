<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Strona glowna--%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <title>post search - szukaj posty z serwisu tweeter</title>
    <script src="/static/jquery/jquery-1.9.1.js"></script>
    <script src="/static/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<header>
    <tiles:insertAttribute name="header"/>
</header>
<img src="/static/bootstrap/img/glyphicons-halflings-white.png">
<div class="post-search-body">
    <tiles:insertAttribute name="body"/>
</div>
<footer>
    <tiles:insertAttribute name="footer"/>
</footer>
</body>
</html>