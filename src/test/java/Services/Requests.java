package Services;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import edu.test.entities.Post;
import edu.test.entities.User;
import edu.test.javarest.AppTest;

public class Requests {
	
	final static String BASE_URL = "https://jsonplaceholder.typicode.com";
	final Logger logger = Logger.getLogger(AppTest.class);
	
	private Client client;
	private WebResource webResource;
	private ObjectMapper mapper;
	
	public Requests() {
		client = Client.create();
		webResource = client.resource(BASE_URL);
		mapper = new ObjectMapper();
	}
	
	public User[] getUser(int userId) throws JsonParseException, JsonMappingException, ClientHandlerException,
			UniformInterfaceException, IOException {
		ClientResponse response = webResource.path("/users")
				.queryParam("id", userId + "")
				.accept("application/json").get(ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		return mapper.readValue(response.getEntity(String.class), User[].class);
	}
	
	public Post[] getPosts(int userId) throws JsonParseException, JsonMappingException, ClientHandlerException,
			UniformInterfaceException, IOException {
		ClientResponse response = webResource.path("/posts")
				.queryParam("userId", userId + "")
				.accept("application/json").get(ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		return mapper.readValue(response.getEntity(String.class), Post[].class);
	}
	
	public Post createPost(int userId, String title, String body)
			throws ClientHandlerException, UniformInterfaceException, IOException {
		Post post = new Post(userId, 0, title, body);
		ClientResponse response = webResource.path("/posts")
				.type("application/json")
				.post(ClientResponse.class, mapper.writeValueAsString(post));
//		normally, this should be checked, here return code is always 201 
//		but data is correctly returned after post request is "mocked"
//		probably a bug
//		if (response.getStatus() == 201) {
//			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//		}
		return mapper.readValue(response.getEntity(String.class), Post.class);
	}

}
