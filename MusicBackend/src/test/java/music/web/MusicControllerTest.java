package music.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class MusicControllerTest {

	@Autowired
	private MockMvc mvc;
	private MvcResult result;
	
	@Test
	public void setFavArtists() throws Exception {
		String content = "";
		
		//build request
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/music/favorites")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(content);

//		//perform request
//		mvc.perform(builder)
//			//check http response code (isOk, isBadRequest, isNotFound, etc)
//			.andExpect(status().isOk())
//			//get values from field
//			.andExpect(jsonPath("######").value("###########"))
//			//get values from fields of objects within an array
//			.andExpect(jsonPath("$[0].id").value("2"))
//			//check if something is an array
//			.andExpect(jsonPath("$").isArray());
	
		//if you wanted to save the results of a request:
//		result = mvc.perform(builder)
//			.andExpect(status().isOk())
//			//return response 
//			.andReturn();
		
		//since there's no actual test right now
		assert(true);
	}
}
