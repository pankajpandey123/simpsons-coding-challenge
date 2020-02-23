package com.citi.scc.sccapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.scc.sccapi.model.CharacterPojo;
import com.citi.scc.sccapi.repository.CharacterRepository;

@Service
public class CharacterService {
	@Autowired
	private CharacterRepository chRepository;

	public CharacterService(CharacterRepository chRepository) {
		this.chRepository = chRepository;
	}

	public void save(CharacterPojo character) {
		chRepository.save(character);
	}

	public void saveAll(List<CharacterPojo> chars) {
		chRepository.saveAll(chars);
	}

	public Optional<CharacterPojo> get(String characterId) {
		return chRepository.findById(characterId);
	}

	public List<CharacterPojo> getAll() {
		return (List<CharacterPojo>) chRepository.findAll();
	}

	public void delete(String characterId) {
		chRepository.deleteById(characterId);
	}

	public void update(CharacterPojo characterPojo) {

	}

}
