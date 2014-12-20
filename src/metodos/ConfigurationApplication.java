package metodos;

import java.util.ResourceBundle;

public class ConfigurationApplication {
	
	public static ResourceBundle resourceBundle = ResourceBundle.getBundle("properties.ConfigurationSystem");
	private static ConfigurationApplication instance;
	
	public static ConfigurationApplication getInstance() {
		if (instance == null) {
			instance = new ConfigurationApplication();
		}
		return instance;
	}
	
	public String getKey(String key){
		return resourceBundle.getString(key);
	}
}
