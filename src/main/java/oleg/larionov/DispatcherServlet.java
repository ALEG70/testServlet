package oleg.larionov;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    FrontController controller = getController(req);
        controller.init(getServletContext(), resp, req);
    controller.process();

    }

    private FrontController getController(HttpServletRequest request){
        try{
            System.out.println(String.format("oleg.larionov.%s", request.getRequestURI().substring(1)+"Controller"));
            Class type = Class.forName(
                    String.format("oleg.larionov.%s", request.getRequestURI().substring(1)+"Controller"));
            return (FrontController) type.asSubclass(FrontController.class).newInstance();
        } catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
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
