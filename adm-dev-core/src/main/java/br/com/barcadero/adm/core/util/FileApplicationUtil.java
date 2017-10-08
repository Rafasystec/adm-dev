package br.com.barcadero.adm.core.util;

import java.util.Properties;

public class FileApplicationUtil {
	
	private static String urlBaseREST = "";
	private static Properties properties;
	public static final String PROP_URL_BASE = "application.rest.baseURL";

	public static void main(String[] args) {
		String url = FileApplicationUtil.getUrlBaseREST();
		System.out.println(url);
	}
	
	public FileApplicationUtil() {
		// TODO Auto-generated constructor stub
		FilePropertyUtil propUtil = new FilePropertyUtil();
		properties = propUtil.getApplication();
		
	}
	public static FileApplicationUtil getInstance() {
		return new FileApplicationUtil();
	}
	public static String getUrlBaseREST() {
		FileApplicationUtil.getInstance();
		urlBaseREST = properties.getProperty(PROP_URL_BASE);
		return urlBaseREST;
	}

	public static void setUrlBaseREST(String urlBase) {
		FileApplicationUtil.urlBaseREST = urlBase;
	}

	

}
