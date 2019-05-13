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
            <h2>Хозяева.</h2>
        </div>

        <div>
            <jsp:include page="_menu.jsp" />
        </div>

        <jsp:include page="_footer.jsp" />
    </body>
</html>