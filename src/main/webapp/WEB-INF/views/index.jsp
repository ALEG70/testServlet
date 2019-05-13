<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Index</title>
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
            <style type="text/css">
                .main{
                    height: 30px;
                    overflow: false;
                    padding-left: 15px;
                    background: #c0c0c0;
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
            <h2>Основная страница приложения.</h2>
        </div>

        <div>
            <jsp:include page="_menu.jsp" />
        </div>

        <div>
        Работа с базой даных, в проекте использованны технологии - JSP, H2, Servlet, flywaydb.
        </br></br>
        В проекте реализованны:
            <ul>
                <li>Создание БД используя VCS базы данных flyway</li>
                <li>Работа с БД(запросы на выборку)</li>
                <li>Работа с JSP для генерации динамического содержимого веб-страниц</li>
            </ul>
        </div>

        <jsp:include page="_footer.jsp" />
    </body>
</html>