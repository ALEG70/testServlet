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
            <h2>Штрафы</h2>
        </div>

        <div>
            <jsp:include page="_menu.jsp" />
        </div>

<table border="1">
            <tr>
                <th>ИД</th>
                <th>Марка</th>
                <th>Модель</th>
                <th>Номер</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Наименование</th>
                <th>Сумма</th>
            </tr>
            <c:forEach items="${finesList}" var="fine">
              <tr>
                <td>${fine.id_fine}</td>
                <td>${fine.car.maker}</td>
                <td>${fine.car.model}</td>
                <td>${fine.car.license_plate}</td>
                <td>${fine.car.owner.name}</td>
                <td>${fine.car.owner.sec_name}</td>
                <td>${fine.type.fine_title}</td>
                <td>${fine.type.fine_fee}</td>

              </tr>
            </c:forEach>
            </table>
            </br>

        <jsp:include page="_footer.jsp" />
    </body>
</html>