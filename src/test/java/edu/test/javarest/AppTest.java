package edu.test.javarest;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import Services.Requests;
import edu.test.entities.Post;
import edu.test.entities.User;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	final Logger logger = Logger.getLogger(AppTest.class);

	public AppTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Get'a'random'user'(userID)','print'its'address'to'output'and'verify'email'format'is'correct
	 * Using'userID'Get'their'associated'posts'and'verify'they'contains'a'valid'id,'title'and'body'
	 * Do'a'post'using'same'userID'with'a'valid'title'and'body
	 * @throws IOException 
	 * @throws UniformInterfaceException 
	 * @throws ClientHandlerException 
	 */
	public void testUser() throws ClientHandlerException, UniformInterfaceException, IOException {

		final int MIN_USER_ID = 1;
		final int MAX_USER_ID = 10;

		Requests requests = new Requests();
		int userId = ThreadLocalRandom.current().nextInt(MIN_USER_ID, MAX_USER_ID + 1);

		//		verify user's email
		User[] users = requests.getUser(userId);

		assertTrue("Multiple users with id: '" + userId + "' found!", users.length == 1);
		User user = users[0];
		
		logger.info("\n" + StringUtils.repeat("=", 100));
		logger.info("User:" + prettyPrint(user));
		logger.info("Address:" + prettyPrint(user.getAddress()));
		logger.info("Email address:" + prettyPrint(user.getEmail()));

		assertTrue("Email '" + user.getEmail() + "' is not valid!",
				EmailValidator.getInstance().isValid(user.getEmail()));

		//		verify user's posts
		Post[] existingPosts = requests.getPosts(userId);
		assertTrue("User with id: " + userId + " has no posts!", existingPosts.length > 0);
		for (Post post : existingPosts) {
			logger.info("Post: " + prettyPrint(post));
			assertTrue("Post id: '" + post.getId() + "' is not valid!", post.hasValidId());
			assertTrue("Post title: '" + post.getTitle() + "' is not valid!", post.hasValidTitle());
			assertTrue("Post body: '" + post.getBody() + "' is not valid!", post.hasValidBody());
		}

//		do post with valid title and body
		String title = "foo";
		String body = "bar";
		Post createdPost = requests.createPost(userId, "foo", "bar");
		
		logger.info("Created post: " + prettyPrint(createdPost));
		
		assertTrue("Created post id: '" + createdPost.getId() + "' is not valid!", createdPost.hasValidId());

		assertTrue("Created post title '" + createdPost.getTitle() + "' is not valid!",
				createdPost.getTitle().compareTo(title) == 0);

		assertTrue("Post body: '" + createdPost.getBody() + "' is not valid!",
				createdPost.getBody().compareTo(body) == 0);
		
		logger.info("\n" + StringUtils.repeat("=", 100));
	}

	private String prettyPrint(Object object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper().configure(MapperFeature.USE_ANNOTATIONS, false);
		return "\n" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object) + "\n";
	}

}
