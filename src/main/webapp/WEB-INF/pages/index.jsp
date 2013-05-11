<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Strona glowna--%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <title>post search - szukaj posty z serwisu tweeter</title>
    <script src="/static/jquery/jquery-1.9.1.js"></script>
    <script src="/static/bootstrap/js/bootstrap.js"></script>
    <link rel="stylesheet" type="text/css" href="/static/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/static/post-search.css"/>
</head>
<body class="post-search">
<div class="container">
    <header class="post-search-main post-search-header page-header">
        <tiles:insertAttribute name="header"/>
    </header>
    <div class="post-search-main">
        <tiles:insertAttribute name="body"/>
    </div>
</div>
<%--TODO poprawić stopkę--%>
<%--<div id="footer">--%>
    <%--<div class="container">--%>
        <%--<div class="post-search-footer">--%>
            <%--<tiles:insertAttribute name="footer"/>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
</body>
</html>