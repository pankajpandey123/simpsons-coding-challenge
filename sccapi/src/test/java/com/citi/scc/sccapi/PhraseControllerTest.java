package com.citi.scc.sccapi;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PhraseControllerTest {
	//ToDo
	/*
	 * @Mock private PhraseService phraseService;
	 * 
	 * @InjectMocks private PhraseController phraseController;
	 * 
	 * @Autowired private WebApplicationContext webApplicationContext; private
	 * MockMvc mockMvc;
	 * 
	 * @Test public void addPhrase() throws Exception { PhrasePojo phrasePojo = new
	 * PhrasePojo("59edff64fd7790417d74b3a1", "59edee682c7acf7bfac7e66b",
	 * "Oh, caution ");
	 * this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
	 * .andExpect(content().string(containsString("Hello, World"))); }
	 * 
	 * }
	 */

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
