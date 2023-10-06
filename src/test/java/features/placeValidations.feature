Feature: Validating Place API's

@AddPlace @Regression
Scenario Outline: Verify if Place is being succesfully aded using AddPlaceAPI
	Given Add Place Payload with "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" with "post" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_id created maps to "<name>" using "getPlaceAPI"
      
Examples:
	|name        |language |address        |
	|Trap House  |English  |arnold street  |
	#|Anime House |Japanese |Whipple Street |
	
@DeletePlace @Regression
Scenario: Verify is Delete Place functionality is working
	Given DeletePlace payload
	When user calls "deletePlaceAPI" with "post" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"