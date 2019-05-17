package oleg.larionov;

import oleg.larionov.dao.JdbcCarDao;
import oleg.larionov.model.Car;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

public class CarController extends FrontController {
    @Override
    public void process() throws ServletException, IOException {
        String id = request.getParameter("id_car");
        Car car = new JdbcCarDao().findById(Integer.valueOf(id));
        request.setAttribute("car", car);
        System.out.println(car.toString());
    }
}
