package oleg.larionov;

import oleg.larionov.dao.JdbcDao;
import oleg.larionov.dao.JdbcTemplate;
import oleg.larionov.utils.CarMapper;
import oleg.larionov.utils.RowMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        setPrefix("/WEB-INF/views/");
        setSuffix(".jsp");


    //showQueryParams(req, resp);

    }

    private String prefix;
    private String suffix;

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    private String buildJspURL(String queryWhat){
        return prefix+queryWhat+suffix;
    }

    private void showQueryParams(HttpServletRequest req, HttpServletResponse resp) throws IOException{

        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().println("ContextPath: "+req.getContextPath());
        resp.getWriter().println("PathInfo: "+req.getPathInfo());
        resp.getWriter().println("PathTranslated: "+req.getPathTranslated());
        resp.getWriter().println("QueryString: "+req.getQueryString());
        resp.getWriter().println("URI: "+req.getRequestURI());
        resp.getWriter().println("ServletPath: "+req.getServletPath());

        resp.getWriter().println("Путь к jsp запроса: " + buildJspURL(req.getRequestURI()));
    }

}
