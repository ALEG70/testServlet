package oleg.larionov.dao;

import oleg.larionov.model.FineType;

import java.util.List;

public interface FineTypeDao {

    List<FineType> findAll();

    List<FineType> topFines(Integer limit);

}
