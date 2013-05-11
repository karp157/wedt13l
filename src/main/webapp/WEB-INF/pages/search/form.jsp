<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form action="#" cssClass="form-search" method="GET">
    <div class="input-append">
        <input name="query" type="text" placeholder="wpisz frazę..." class="search-query input-xxlarge"/>
        <button type="submit" class="btn btn-primary">Szukaj <i class="icon-search icon-white"></i></button>
    </div>
</form:form>