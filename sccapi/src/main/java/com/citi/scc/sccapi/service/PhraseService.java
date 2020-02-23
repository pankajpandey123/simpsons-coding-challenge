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

	public void save(PhrasePojo phrase) {
		phraseRepository.save(phrase);
	}

	public void saveAll(List<PhrasePojo> phrases) {
		phraseRepository.saveAll(phrases);
	}

	public Optional<PhrasePojo> get(String phraseId) {
		return phraseRepository.findById(phraseId);

	}

	public Iterable<PhrasePojo> getAll() {
		return phraseRepository.findAll();

	}

	public void delete(String phraseId) {
		phraseRepository.deleteById(phraseId);
	}

	public void update(PhrasePojo phrase) {

	}

}
