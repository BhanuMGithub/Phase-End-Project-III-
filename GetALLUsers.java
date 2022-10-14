package gorest;

import org.testng.annotations.Test;

import gorestlog4jdemo.BaseTest;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

public class GetALLUsers extends BaseTest{
	
	@Test
	public void getUserDetails() {
		
		RestAssured
		    .given()
		     .contentType("application/json")
		     .header("Authorization","Bearer 0f9b222566bfd8ec3421a5ed516cd140db72b2a967c07e6e85e0e2a6316c5b16")
		      .when()
		      .get(" https://gorest.co.in/public/v2/users") 
		        .then()
		         .statusCode(200)
		         .log().all();
		         logger.info("Response Captured");
		      
		
	}

}
