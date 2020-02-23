package com.citi.scc.sccapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.citi.scc.sccapi.model.PhrasePojo;

@Repository
public interface PhraseRepository extends CrudRepository<PhrasePojo, String> {
}
