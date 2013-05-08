<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<div class="post-search-form">
    <tiles:insertDefinition name="searchForm"/>
</div>
<div class="post-search-result">
    <tiles:insertDefinition name="searchResult"/>
</div>