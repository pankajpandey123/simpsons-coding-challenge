package com.citi.scc.sccapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.citi.scc.sccapi.model.CharacterPojo;

@Repository
public interface CharacterRepository extends CrudRepository<CharacterPojo, String> {

}