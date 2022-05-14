package com.prueba.prueba_tecnica.repository;

import com.prueba.prueba_tecnica.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long>{

}
