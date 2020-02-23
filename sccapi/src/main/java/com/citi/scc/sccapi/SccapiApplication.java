package com.citi.scc.sccapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.citi.scc.sccapi.model.CharacterListPojo;
import com.citi.scc.sccapi.model.PhraseListPojo;
import com.citi.scc.sccapi.service.CharacterService;
import com.citi.scc.sccapi.service.PhraseService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SccapiApplication {
	private final static Logger LOGGER = Logger.getLogger(SccapiApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(SccapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runnerChars(CharacterService charService) {
		return args -> {

			ObjectMapper mapper = new ObjectMapper();
			TypeReference<CharacterListPojo> typeReference = new TypeReference<CharacterListPojo>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/data/characters.json");
			try {
				CharacterListPojo chars = mapper.readValue(inputStream, typeReference);
				charService.saveAll(chars.getCharacters());
				LOGGER.log(Level.INFO, "chars Saved!" + charService.getAll().size());

			} catch (IOException e) {
				LOGGER.log(Level.WARNING, "Unable to save : " + e.getMessage());
			}
		};
	}

	@Bean
	CommandLineRunner runnerPhrases(PhraseService phraseService) {
		return args -> {

			ObjectMapper mapper = new ObjectMapper();
			TypeReference<PhraseListPojo> typeReference = new TypeReference<PhraseListPojo>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/data/phrases.json");
			try {
				PhraseListPojo phrases = mapper.readValue(inputStream, typeReference);
				phraseService.saveAll(phrases.getPhrases());
				LOGGER.log(Level.INFO, "phrases Saved!" + phraseService.getAll().spliterator().estimateSize());
			} catch (IOException e) {
				LOGGER.log(Level.WARNING, "Unable to save : " + e.getMessage());
			}
		};
	}

}
