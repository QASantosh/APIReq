package assignment1;


import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import usersPack.UsersPojo;


public class Scenario2 {

	@BeforeClass
	public static void init() {
		//Set base path and base uri
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/users";
	}
	@Test
	public void updateUser() {
		
		/*
		 * RESPONSE ARE GIVEN BELOW
		 * {
  "name": "morpheus",
  "job": "zion resident",
  "updatedAt": "2020-04-22T02:47:20.951Z"
}
		 */
		//Create object of user pojo class
		UsersPojo user=new UsersPojo();
		
		user.setName("morpheus");
		user.setJob("zion resident");
		
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.when()
		.body(user)
		.put("/2") //users/{id}
		.then()
		.statusCode(200)
		
		   .body("name", equalTo("morpheus")) //Validate json response
		   .body("job", equalTo("zion resident")); //Validate json response
		   
		
		
		

		
		

	}
}
