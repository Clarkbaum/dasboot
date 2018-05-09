package com.boot;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

//run with spring junit class runn. makes it a integration test.
//actually runs the app
@RunWith(SpringJUnit4ClassRunner.class)
//spring boot annotation and add your main class. tells spring boot how to start app
@SpringApplicationConfiguration(App.class)
//sets test as a web integration test
@WebIntegrationTest
//this test fails because its checking to see if the response body is empty.
//i am using stubs so it wont be. the error sounds like the stub response isnt in a proper html format either
public class ShipwreckControllerWebIntegrationTest {

	@Test
	public void testListAll() throws IOException {
		//resttemplate is for communitcaiton with http servers and this is just the test version

		RestTemplate restTemplate = new TestRestTemplate();
		//getforentity retrives an entity by doing a git on the URL.  string.class is the response type
		//should move url to application.properties on a real app
		ResponseEntity<String> response = restTemplate.getForEntity("https://localhost:8080/api/v1/shipwrecks", String.class);

		//make sure i get 200 ok back
		assertThat( response.getStatusCode(), equalTo(HttpStatus.OK));

		//for reading and writing json
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode responseJson = objectMapper.readTree(response.getBody());

		//this is checking to make sure the response body is empty.
		//since i am using stub tho its not going to be empty
		assertThat( responseJson.isMissingNode(), is(false) );
		assertThat( responseJson.toString(), equalTo("[]"));
	}
}

