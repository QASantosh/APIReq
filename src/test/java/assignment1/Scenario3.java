package assignment1;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import usersPack.UsersPojo;


public class Scenario3 {

	@BeforeClass
	public static void init() {
		//Set base uri and base path
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/users";
	}
	@Test
	public void deleteUser() {
		//Delete a user record with the “id” key generated above using route #5.
		RestAssured.given()
		.contentType(ContentType.JSON)
		.when()
		.delete("/2")		//Record of id 2 is deleted
		.then()
		.statusCode(204); //validation for status code 204
		

	}
}
