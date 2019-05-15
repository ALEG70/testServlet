package oleg.larionov.dao;

import oleg.larionov.model.Car;

import java.util.List;

public interface Dao<T> {

    List<T> findAll();

    T findById(Integer id);

    List<T> findWithParameters(Object [] parameters);

}