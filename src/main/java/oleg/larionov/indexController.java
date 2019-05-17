package oleg.larionov;

import javax.servlet.ServletException;
import java.io.IOException;

public class indexController extends FrontController{
    @Override
    public void process() throws ServletException, IOException {
        response.getWriter().println("Controller's job.");
        //System.out.println("Controller's job.");
    }
}
