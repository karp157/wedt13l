<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:form action="/harvest"
           modelAttribute="fileUpload"
           enctype="multipart/form-data"
           method="POST"
           cssClass="form-horizontal" cssStyle="text-align: left">
    <fieldset>
        <legend>Importuj posty</legend>
        <div class="control-group">
            <label class="control-label post-search-form-label" for="file">Plik do importu</label>

            <div class="controls">
                <input type="file" id="file" name="multipartFile"/>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label post-search-form-label" for="pageSize" style="font: bold">Rozmiar strony</label>

            <div class="controls">
                <form:input path="pageSize" type="text" id="pageSize" class="input-mini"
                       placeholder=";-)"/>
            </div>
        </div>
        <button type="submit" class="btn">Prześlij</button>
    </fieldset>
</form:form>
