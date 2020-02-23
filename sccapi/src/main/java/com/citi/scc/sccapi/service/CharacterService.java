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

	public void save(CharacterPojo characterPojo) {
		chRepository.save(characterPojo);
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

	public void deleteCharacter(String characterId) {
		chRepository.deleteById(characterId);
	}

	public CharacterPojo update(CharacterPojo characterPojo) {
		Optional<CharacterPojo> chPojoFromdb = chRepository.findById(characterPojo.getId());
		CharacterPojo newpojo = null;
		if (chPojoFromdb.isPresent()) {
			newpojo = chPojoFromdb.get();
			newpojo.setAge(characterPojo.getAge());
			newpojo.setFirstName(characterPojo.getFirstName());
			newpojo.setLastName(characterPojo.getLastName());
			newpojo.setPicture(characterPojo.getPicture());
		}
		return chRepository.save(newpojo);
	}
}
