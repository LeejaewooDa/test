<%@ page pageEncoding="utf-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <c:url var="bootstrap" value="/css/bootstrap.min.css" />
        <link href="${ bootstrap }" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <tiles:insertAttribute name="header" />
            <tiles:insertAttribute name="content" />
            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>