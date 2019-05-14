package oleg.larionov;

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

@WebServlet("/auto")
public class CarsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            final String SQL = "SELECT * FROM cars";
            List<Car> list = null;

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/cars.jsp");

            JdbcDaoTemplate jdbcDaoTemplate = new JdbcDaoTemplate();
            try {
                list = jdbcDaoTemplate.query(SQL, new CarMapper());
            } catch (Exception ex){
                ex.printStackTrace();
            }
            //PrintWriter printWriter = resp.getWriter();
            //printWriter.println(list.get(0).toString());
            req.setAttribute("carsList", list);

            requestDispatcher.forward(req, resp);
        }
}
