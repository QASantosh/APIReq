package assignment1;



import org.hamcrest.core.Is;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import usersPack.UsersPojo;


public class Scenario1 {

	@BeforeClass
	public static void init() {
		
		//Declare base uri and base path
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/users";
	}
	@Test
	public void createNewUser() {
		//Created objects of userpojo class file
		UsersPojo user=new UsersPojo();
		
		//Set the values w.r.t parameter
		user.setName("morpheus");
		user.setJob("leader");
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.when()
		.body(user)
		.post()
		.then()
		//a. Verify that after POST request the status code returned is 201.
		.statusCode(201) 
		//b. Verify the name,job returned in response is the same that you entered while creating the record.
		.body("name", Is.is("morpheus"))
		.body("job", Is.is("leader"));
		
	}
	//c. Perform a GET request at route #2 with id as ‘2’ andverify that you received the following response programmatically :
	@Test
	public void getUserInformation() {
		
			/*
			 *RESPONSE ARE GIVEN AS BELOW
			 * {
	  		* "data": {
	    "id": 2,
	    "email": "janet.weaver@reqres.in",
	    "first_name": "Janet",
	    "last_name": "Weaver",
	    "avatar": "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"
	  },
	  "ad": {
	    "company": "StatusCode Weekly",
	    "url": "http://statuscode.org/",
	    "text": "A weekly newsletter focusing on software development, infrastructure, the server, performance, and the stack end of things."
	  }
	}
		 */
		
		RestAssured.given()
				   .when()
				   .get("/2")
				   .then()
				   //Json response are validated below
				   .body("data.id", equalTo(2))
				   .body("data.email", equalTo("janet.weaver@reqres.in"))
				   .body("data.first_name", equalTo("Janet"))
				   .body("data.last_name", equalTo("Weaver"))
				   .body("data.avatar", equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"))
				   .body("ad.company", equalTo("StatusCode Weekly"))
				   .body("ad.url", equalTo("http://statuscode.org/"))
				   .body("ad.text", equalTo("A weekly newsletter focusing on software development, infrastructure, the server, performance, and the stack end of things."));
		}
		
			
					
					
	}

