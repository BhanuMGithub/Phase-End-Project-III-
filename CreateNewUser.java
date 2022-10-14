package gorest;

import java.util.HashMap;
import java.util.UUID;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gorestlog4jdemo.BaseTest;
import io.restassured.RestAssured;


public class CreateNewUser extends BaseTest{
	
	public static HashMap<String,String> map= new HashMap<String,String>();
    UUID uuid=UUID.randomUUID();
	
	@BeforeMethod
	public void CreatePostData() {
	map.put("name","Test");
	logger.info("Added name");
	map.put("email", "test" +uuid+ "@example.net");
	logger.info("Added email");
	map.put("gender","male");
	logger.info("Added gender");
	map.put("status","active");
	logger.info("Added status");
	RestAssured.baseURI="https://gorest.co.in";
	RestAssured.basePath="/public/v2/users";
	logger.info("Payload created for creating thr resource");
		
	}
	@Test
	public void CreateUser() {
		RestAssured
		   .given()
		   .contentType("application/json")
		.body(map)
		  .when()
		  .header("Authorization","Bearer 0f9b222566bfd8ec3421a5ed516cd140db72b2a967c07e6e85e0e2a6316c5b16")
		   .post()
		.then()
		.statusCode(201)
		   .log().all();
				
	    logger.info("Resource created and response captured");
	
		
	}
		
	
	

}
