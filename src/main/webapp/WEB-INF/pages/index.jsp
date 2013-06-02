<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="/static/infiniScroll.js"></script>
    <link rel="stylesheet" type="text/css" href="/static/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/static/post-search.css"/>
</head>
<body class="post-search">
<div class="container">
    <header class="post-search-main post-search-header page-header">
        <tiles:insertAttribute name="header"/>
    </header>

    <c:if test="${not empty message}">
        <div class="row">
            <div class="span3"></div>
            <div class="span5 alert alert-info post-search-alert fade in">
                ${message}
                <button type="button" class="close" data-dismiss="alert">x</button>
            </div>
        </div>
    </c:if>

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