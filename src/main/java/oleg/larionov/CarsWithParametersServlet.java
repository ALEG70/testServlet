package oleg.larionov.utils;

import oleg.larionov.dao.JdbcCarDao;
import oleg.larionov.model.Car;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/carsParams")
public class CarsWithParametersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Car car = null;

        Object [] parameters = {
            req.getParameter("license_plate") == null ? "%" : req.getParameter("licence_plate"),
            req.getParameter("sec_name") == null ? "%" : req.getParameter("sec_name"),
        };

        List<Car> list = new JdbcCarDao().findWithParameters(parameters);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/cars.jsp");

        req.setAttribute("carsList", list);
        requestDispatcher.forward(req, resp);

    }

}
