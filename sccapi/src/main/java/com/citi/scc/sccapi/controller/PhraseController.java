package com.citi.scc.sccapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.scc.sccapi.model.PhrasePojo;
import com.citi.scc.sccapi.service.PhraseService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@RequestMapping("phrases")
@Log4j2
public class PhraseController {
	@Autowired
	private final PhraseService phraseService;

	@PostMapping("/create")
	public void addPhrase(@RequestBody PhrasePojo phrasePojo) {
		log.info("to save" + phrasePojo.toString());
		phraseService.save(phrasePojo);
	}

	@PutMapping("/update")
	public PhrasePojo updatePhrase(@RequestBody PhrasePojo phrasePojo) {
		log.info("to update phrase " + phrasePojo.toString());
		return phraseService.update(phrasePojo);
	}

	@GetMapping("/all")
	public List<PhrasePojo> getAllPhrases() {
		log.info("to findAll Phrases");
		return phraseService.getAll();
	}

	@GetMapping("/{phraseId}")
	public Optional<PhrasePojo> getPhrase(@PathVariable String phraseId) {
		log.info("to find phrase " + phraseId);
		return phraseService.get(phraseId);
	}

	@DeleteMapping("/delete/{phraseId}")
	public void deletePhrase(@PathVariable String phraseId) {
		log.info("to delete phrase " + phraseId);
		phraseService.deletePhrase(phraseId);
	}

	@GetMapping("/quotes/{characterId}")
	public List<String> getQuotesOfCharacter(@PathVariable String characterId) {
		log.info("to find all quotes of char ", characterId);
		List<String> allquotesOfCharacter = phraseService.getAll().stream()
				.filter(i -> i.getCharacter().equals(characterId)).map(PhrasePojo::getPhrase)
				.collect(Collectors.toList());
		return allquotesOfCharacter;
	}

}
