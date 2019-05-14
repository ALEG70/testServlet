<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/main.css"/>
    <title>Title</title>
</head>
<body>
    <div class="main">
    <h2>Поиск штрафов</h2>
    <div>
    <div>
        <jsp:include page="_menu.jsp" />
    </div>
<div>
<form action="../fines" method="GET">
    <table>
        <tr>
            <td>
                <label>Owners surname: </label>
            </td>
            <td>
                <input type="text" name="sec_name"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>License plate: </label>
            </td>
            <td>
                <input type="text" name="license_plate"/>
            </td>
        </tr>
    </table>
    <p><label>* - You can use both fields, one of them or none of them.</label></p>
    <p><label>** - You can use search from one letter to full surname/license plate.</label></p>
    <p><input class="smallButton" type="submit" value="Искать"/></p>
</form>
</div>
<jsp:include page="_footer.jsp" />
</body>
</html>