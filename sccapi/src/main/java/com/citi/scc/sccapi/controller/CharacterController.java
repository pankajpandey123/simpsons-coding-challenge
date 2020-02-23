package com.citi.scc.sccapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.scc.sccapi.model.CharacterPojo;
import com.citi.scc.sccapi.service.CharacterService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@RequestMapping("characters")
@Log4j2
public class CharacterController {

	@Autowired
	private final CharacterService characterService;

	@PostMapping("/create")
	public void addCharacter(@RequestBody CharacterPojo characterPojo) {
		log.info("to save" + characterPojo.toString());
		characterService.save(characterPojo);
	}

	@PutMapping("/update")
	public CharacterPojo updateCharacter(@RequestBody CharacterPojo characterPojo) {
		log.info("to update" + characterPojo.toString());
		return characterService.update(characterPojo);
	}

	@GetMapping("/all")
	public List<CharacterPojo> getAllCharacters() {
		log.info("chars getall!" + characterService.getAll().size());
		return characterService.getAll();
	}

	@GetMapping("/{characterId}")
	public Optional<CharacterPojo> getCharacter(@PathVariable String characterId) {
		log.info("to find character by id " + characterId);
		return characterService.get(characterId);
	}

	@DeleteMapping("/delete/{characterId}")
	public void deleteCharacter(@PathVariable String characterId) {
		log.info("to delete character, by id " + characterId);
		characterService.deleteCharacter(characterId);
	}
}
