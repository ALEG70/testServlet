package oleg.larionov;

import oleg.larionov.dao.JdbcOwnerDao;
import oleg.larionov.dao.JdbcTemplate;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/owners.jsp");

        List<Owner> list = new JdbcOwnerDao().findAll();

        req.setAttribute("ownersList", list);
        requestDispatcher.forward(req, resp);
    }
}
