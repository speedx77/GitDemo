package resources;

import java.util.ArrayList;

import pojo.Location;
import pojo.getData;

public class TestDataBuild {
	
	public getData addPlacePayload(String name, String language, String address) {
		
		getData data = new getData();

		data.setAccuracy(50);
		data.setName(name);
		data.setPhone_number("(+91) 983 893 3937");
		data.setAddress(address);
		data.setWebsite("https://rahulshettyacademy.com");
		data.setLanguage(language);

		ArrayList<String> typesList = new ArrayList<String>();

		typesList.add(0, "shoe park");
		typesList.add(1, "shop");

		data.setTypes(typesList);

		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		// we are attaching these methods to the object location
		// when we pass the object location we pass along those lat/lng values
		data.setLocation(location);
		return data;
		
	}
	
	public String deletePlacePayload(String placeId) {
		//create genreal method outside of stepbuilder to create payload for deleteAPI
		//We want to remove as much code as we can from stepbuilder, make it dynamic
		return "{\r\n    \"place_id\": \""+ placeId +"\"\r\n}";

	}

}
