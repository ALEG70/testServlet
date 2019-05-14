<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Index</title>
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
            <style type="text/css">
                .main{
                    height: 30px;
                    overflow: false;
                    padding-left: 15px;
                    background: #fc0;
                }

                ul.hr li {
                    display: inline;
                    margin-right: 5px;
                    padding: 3px;
               }
          </style>
    </head>
    <body>
         <div class="main">
            <h2>Машины</h2>
        </div>
        </br>
        <div>
            <jsp:include page="_menu.jsp" />
        </div>

        <table border="1">
            <tr>
                <th>ИД</th>
                <th>Производитель</th>
                <th>Модель</th>
                <th>Номер</th>
                <th>ИД Владельца</th>
            </tr>
            <c:forEach items="${carsList}" var="cars">
              <tr>
                <td><a href=/car?id_car=${cars.id}>${cars.id}</a></td>
                <td>${cars.maker}</td>
                <td>${cars.model}</td>
                <td>${cars.license_plate}</td>
                <td>${cars.id_owner}</td>
              </tr>
            </c:forEach>
        </table>

        <jsp:include page="_footer.jsp" />
    </body>
</html>