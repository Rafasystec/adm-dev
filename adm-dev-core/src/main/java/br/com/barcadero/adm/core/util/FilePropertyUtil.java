package br.com.barcadero.adm.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FilePropertyUtil {

	public static void main(String[] args) {
		FilePropertyUtil util = new FilePropertyUtil();
		Properties prop = util.getApplication();
	}
	
	private Properties getPropertyFile(String propName) {
		String resourceName = propName; // could also be a constant
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties properties = new Properties();
		InputStream resourceStream = loader.getResourceAsStream(resourceName);
		try {
			properties.load(resourceStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
	
	public Properties getApplication() {
		return getPropertyFile("META-INF/application.properties");
	}
	
}
