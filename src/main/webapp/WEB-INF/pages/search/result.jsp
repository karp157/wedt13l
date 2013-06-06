<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Komunikat do wynikow--%>

<c:if test="${not empty suggestion}">
    <div class="row">
        <div class="span3"></div>
        <div class="span5 alert alert-danger post-search-alert fade in">
            Czy chodziło o: <a href="?query=${suggestion}">${suggestion}</a> ?
            <button type="button" class="close" data-dismiss="alert">x</button>
        </div>
    </div>
</c:if>

<c:if test="${not empty postsPage}">
    <div class="row">
        <div class="span3"></div>
        <div class="span5 alert alert-info post-search-alert fade in">
            <c:if test="${not empty query}">
                Zapytanie: ${query},
            </c:if> Liczba wyników: ${postsPage.totalElements}
            <button type="button" class="close" data-dismiss="alert">x</button>
        </div>
    </div>
</c:if>



<%--Wyniki--%>
<div id="posts">
<c:forEach var="post" items="${posts}">
<div class="row">
<div class="span2"></div>
<div class="span8">
<pre style="text-align: left">
<img src="${post.user.avatarURL}" onerror="this.src='/static/twitter.png'">  <strong><a href="http://twitter.com/${post.user.username}">${post.user.username}</a></strong>

${post.message}
<%--<h6>(${post.creationDate})</h6>--%>
</pre>
</div>
</div>
</c:forEach>
</div>

<script type="text/javascript">
    $(function () {
        <c:if test="${query != null}">

        $("#posts").infiniScroll({
            'interval'     : 100
            ,'root_url'     : '/?query=${query}'
            ,'loading_elem' : 'spinner'
            ,'data_elem'    : 'posts'
            ,'freshest_id'  : 1000000
            ,'num'          : 1
            ,'lowest_id'    : 1
            ,'sort'         : 'desc'
        });
        $("#posts").infiniScroll('pollLevel');
        </c:if>
    });
</script>
