package oleg.larionov;

import oleg.larionov.dao.JdbcTemplate;
import oleg.larionov.model.Fine;
import oleg.larionov.utils.FineMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/fines")
public class FinesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String SQL = "select * from" +
                "(select * from cars join owners on cars.owner_id = owners.id_owner) co" +
                " join " +
                " (select * from fines join fine_types on fines.type_id=fine_types.id_ft) ft" +
                " on ft.car_id = co.id_car";
        List<Fine> list = null;
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/fines.jsp");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        try {
            list = jdbcTemplate.query(SQL, new FineMapper());
        } catch (Exception ex){
            ex.printStackTrace();
        }
        req.setAttribute("finesList", list);
        requestDispatcher.forward(req, resp);
        //resp.getWriter().println(list.size() + " " + list.get(0) + list.get(1));
    }
}
