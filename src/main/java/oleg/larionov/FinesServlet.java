package oleg.larionov;

import oleg.larionov.model.Fine;
import oleg.larionov.dao.JdbcDaoTemplate;
import oleg.larionov.utils.FineMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/fines")
public class FinesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String SQL = "SELECT * FROM fines";
        List<Fine> list = null;
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/fines.jsp");
        JdbcDaoTemplate jdbcDaoTemplate = new JdbcDaoTemplate();
        try {
            list = jdbcDaoTemplate.query(SQL, new FineMapper());
        } catch (Exception ex){
            ex.printStackTrace();
        }
        req.setAttribute("finesList", list);
        requestDispatcher.forward(req, resp);
        //resp.getWriter().println(list.size() + " " + list.get(0) + list.get(1));
    }
}
