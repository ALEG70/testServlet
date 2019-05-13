package oleg.larionov.dao;

import oleg.larionov.model.Owner;

import java.util.List;

public interface OwnerDao {

    List<Owner> findAll();

    Owner findById(Integer id);

}
