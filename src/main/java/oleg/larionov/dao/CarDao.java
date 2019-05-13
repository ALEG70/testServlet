package oleg.larionov.dao;

import oleg.larionov.model.Car;

import java.util.List;

public interface CarDao {

    List<Car> findAll();

    Car findById(Integer id);

    List<Car> findWithParameters(Integer id_car, String maker, Integer owner);

}
