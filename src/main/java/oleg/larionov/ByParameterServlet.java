package oleg.larionov;

import oleg.larionov.dao.JdbcCarDao;
import oleg.larionov.dao.JdbcFineDao;
import oleg.larionov.model.Car;
import oleg.larionov.model.Fine;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/byParameters")
public class ByParameterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.Достаем параметры
        Object[] parameters = {
                req.getParameter("sec_name") == null ? "%" : parameterHelper(req.getParameter("sec_name"))+"%",
                req.getParameter("license_plate") == null ? "%" : parameterHelper(req.getParameter("license_plate"))+"%",
        };
        //2.Выполняем запрос к БД
        List<Fine> list = new JdbcFineDao().findWithParameters(parameters);
        //3.Создаем диспетчер запроса, устанавливаем вид
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/fines.jsp");
        //4.Устанавливаем атрибут для отображения
        req.setAttribute("finesList", list);
        //5.Отправляем сформированный ответ контейнеру
        requestDispatcher.forward(req, resp);
        //resp.getWriter().println(list.get(0));
    }

    private String parameterHelper(String parameter){
        return parameter.replaceAll("\\s+","").toLowerCase();
    }
}
