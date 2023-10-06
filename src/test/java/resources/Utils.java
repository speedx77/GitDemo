package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.*;

public class Utils {
	
	public static RequestSpecification req;
	
	
	
	public RequestSpecification requestSpecification() throws IOException {
		
		if (req==null) { //if req==null then it will repeat all this code and replace data from first test
			PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
			req = new RequestSpecBuilder()
					.setContentType("application/json")
					.setBaseUri(getGlobalValue("baseUrl"))
					.addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.build();
			return req;
		}
		return req;
	}
	
	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("src/test/java/resources/global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	
	public static String getJsonPath(Response response, String key) {
		
		String responseString = response.asString();

		JsonPath js = new JsonPath(responseString); 
		
		return js.get(key);
		
	}
	

}
