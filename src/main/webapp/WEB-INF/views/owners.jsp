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
                <th>ИД Авто</th>
                <th>ИД Типа</th>
            </tr>
            <c:forEach items="${ownersList}" var="owner">
              <tr>
                <td>${owner.id}</td>
                <td>${owner.name}</td>
                <td>${owner.sec_name}</td>
              </tr>
            </c:forEach>
            </table>
            </br>

        <jsp:include page="_footer.jsp" />
    </body>
</html>