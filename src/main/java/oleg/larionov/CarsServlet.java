package oleg.larionov;

import oleg.larionov.dao.JdbcCarDao;
import oleg.larionov.dao.JdbcDaoTemplate;
import oleg.larionov.model.Car;
import oleg.larionov.utils.CarMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/cars")
public class CarsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            List<Car> list = null;

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/cars.jsp");

            list = new JdbcCarDao().findAll();


            req.setAttribute("carsList", list);
            requestDispatcher.forward(req, resp);
        }

}
