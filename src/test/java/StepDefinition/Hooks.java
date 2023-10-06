package StepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;
import resources.Utils;

public class Hooks extends Utils{
	//cucumber looks for hooks file while excuting
	
	stepDefinition stepDef = new stepDefinition();
	static String place_id;
	
	@Before("@DeletePlace") //we need it for DeletePlace to generate a place_id or DeletePlace ends in a 404
	public void beforeScenario() throws IOException  {
		//execute this code only when place_id is null
		//write code that will generate place_id
		
		if(stepDefinition.place_id == null) {
		stepDef.add_place_payload_with("Rick", "Japanese", "Baldwin");
		stepDef.user_calls_with_http_request("AddPlaceAPI", "POST");
		stepDef.verify_place_id_created_maps_to_using("Rick", "getPlaceAPI");
		}
	}
}
