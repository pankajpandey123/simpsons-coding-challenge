package com.citi.scc.sccapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.scc.sccapi.model.PhrasePojo;
import com.citi.scc.sccapi.repository.PhraseRepository;

@Service
public class PhraseService {
	@Autowired
	private PhraseRepository phraseRepository;

	public void save(PhrasePojo phrasePojo) {
		phraseRepository.save(phrasePojo);
	}

	public void saveAll(List<PhrasePojo> phrasePojos) {
		phraseRepository.saveAll(phrasePojos);
	}

	public Optional<PhrasePojo> get(String phraseId) {
		return phraseRepository.findById(phraseId);

	}

	public List<PhrasePojo> getAll() {
		return (List<PhrasePojo>) phraseRepository.findAll();

	}

	public void deletePhrase(String phraseId) {
		phraseRepository.deleteById(phraseId);
	}

	public PhrasePojo update(PhrasePojo phrasePojo) {
		Optional<PhrasePojo> phrasePojoFromdb = phraseRepository.findById(phrasePojo.getId());
		PhrasePojo newPhrasepojo = null;
		if (phrasePojoFromdb.isPresent()) {
			newPhrasepojo = phrasePojoFromdb.get();
			newPhrasepojo.setCharacter(phrasePojo.getCharacter());
			newPhrasepojo.setPhrase(phrasePojo.getPhrase());
		}
		return phraseRepository.save(newPhrasepojo);
	}
}
