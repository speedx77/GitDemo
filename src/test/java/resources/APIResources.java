package resources;

//enum is a special class in java that has collection of constants or methods
public enum APIResources {
	
	//declare our variables
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	private String resource;
	
	//create methods to return our variables
	APIResources(String resource) {
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}
	
}
