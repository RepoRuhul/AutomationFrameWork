package utils;

import java.io.IOException;
import java.util.Properties;

public class Configuration {
//	the properties class represents a persistent set of properties.
	private Properties properties;
//	this is a default constructor
//	why i am putting loadProperty () method inside constructor
//	because when configuration class is instantiated (when it will create object)
// then the default constructor will be initialized, the method loadProperty() present inside 
//	the constructor will also be initialized
	
	public Configuration() {
		loadProperty();
		
	}
	public void loadProperty() {
		properties= new Properties();
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
//	individual return type method created
	public String getProerties(String key) {
		return properties.getProperty(key);
		
	}

	
}
