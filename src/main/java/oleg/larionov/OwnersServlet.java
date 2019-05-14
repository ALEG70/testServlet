package oleg.larionov;

import oleg.larionov.dao.JdbcDaoTemplate;
import oleg.larionov.model.Owner;
import oleg.larionov.utils.OwnerMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/owners")
public class OwnersServlet extends HttpServlet {

    String SQL = "SELECT * FROM owners";
    List<Owner> list = null;
    JdbcDaoTemplate jdbcDaoTemplate = new JdbcDaoTemplate();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/owners.jsp");
        try{
           list = jdbcDaoTemplate.query(SQL, new OwnerMapper());
        }catch(Exception ex){ ex.printStackTrace();}
        req.setAttribute("ownersList", list);
        requestDispatcher.forward(req, resp);
    }
}
