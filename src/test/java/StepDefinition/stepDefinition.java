package StepDefinition;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Location;
import pojo.getData;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;


public class stepDefinition extends Utils{
	
	//make these variables global to access in every method
	ResponseSpecification resSpec;
	RequestSpecification request;
	Response responseOutput;
	static String place_id;
	TestDataBuild data = new TestDataBuild();
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {

		resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		request = given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address));

		}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		
		//making our endpoint dynamic via enum classes
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		if(method.equalsIgnoreCase("post"))
			responseOutput = request.when().post(resourceAPI.getResource()).then().spec(resSpec).extract().response();
		else if(method.equalsIgnoreCase("get"))
			responseOutput = request.when().get(resourceAPI.getResource()).then().spec(resSpec).extract().response();

	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {

		Assert.assertEquals(responseOutput.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
		// Write code here that turns the phrase above into concrete actions
		

		Assert.assertEquals(getJsonPath(responseOutput, keyValue), expectedValue);

	}

	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
	    
		place_id = getJsonPath(responseOutput, "place_id");
		request = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource, "GET");
		String actualName = getJsonPath(responseOutput, "name");
		
		Assert.assertEquals(actualName, expectedName);
		
	}
	
	

	@Given("DeletePlace payload")
	public void delete_place_payload() throws IOException {
		System.out.println(place_id);
		System.out.println("test");
		System.out.println("test2");
		System.out.println("FOR THE BRANCH");
		System.out.println("More Code");
		System.out.println("GitX code");
		System.out.println("new code");
		resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		request = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	  
	}



	
	/*
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String keyValue, String method) {
		
		
		
	}
	*/
}


