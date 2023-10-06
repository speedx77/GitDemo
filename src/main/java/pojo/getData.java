package pojo;

import java.util.List;

public class getData {
	
	//highlight all strings and then alt+shift+s to create getters and setters
			//use Array Lists when nested Json has multiple objects in it
			private Location location; //nested objects in Location so we need a seperate file
			private int accuracy;
			private String name;
			private String phone_number;
			private String address;
			private List<String> types; //think "List of String" we don't need a Types file because there aren't any nested keys in there just string/values
			private String website;
			private String language;
			
			public Location getLocation() {
				return location;
			}
			public void setLocation(Location location) {
				this.location = location;
			}
			public int getAccuracy() {
				return accuracy;
			}
			public void setAccuracy(int accuracy) {
				this.accuracy = accuracy;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getPhone_number() {
				return phone_number;
			}
			public void setPhone_number(String phone_number) {
				this.phone_number = phone_number;
			}
			public String getAddress() {
				return address;
			}
			public void setAddress(String address) {
				this.address = address;
			}
			public List<String> getTypes() {
				return types;
			}
			public void setTypes(List<String> types) {
				this.types = types;
			}
			public String getWebsite() {
				return website;
			}
			public void setWebsite(String website) {
				this.website = website;
			}
			public String getLanguage() {
				return language;
			}
			public void setLanguage(String language) {
				this.language = language;
			}
		

}
