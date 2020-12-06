package com.Webalk.Verseny.ACI3X3.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Webalk.Verseny.ACI3X3.models.Verseny;

@Repository
public interface VersenyRepository extends CrudRepository<Verseny, Long> {

}
