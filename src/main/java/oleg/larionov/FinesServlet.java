package oleg.larionov;

import oleg.larionov.dao.JdbcFineDao;
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
public class FinesServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/fines.jsp");

        List<Fine> list = new JdbcFineDao().findWithParameters(new Object[]{"%","%"});

        req.setAttribute("finesList", list);
        requestDispatcher.forward(req, resp);

    }
}
