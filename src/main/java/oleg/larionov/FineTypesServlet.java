package oleg.larionov;

import oleg.larionov.dao.JdbcTemplate;
import oleg.larionov.model.FineType;
import oleg.larionov.utils.FineTypeMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/fine_types")
public class FineTypesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<FineType> list = null;
        JdbcTemplate jdbcDaoTemplate = new JdbcTemplate();
        String SQL = "SELECT * FROM fine_types";

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/fine_types.jsp");

        try{
            list = jdbcDaoTemplate.query(SQL, new FineTypeMapper());
        }catch(Exception ex){
            ex.printStackTrace();
        }

        req.setAttribute("fineTypes", list);
        requestDispatcher.forward(req, resp);
    }
}
