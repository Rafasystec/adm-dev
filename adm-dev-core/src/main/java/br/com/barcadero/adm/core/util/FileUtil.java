package br.com.barcadero.adm.core.util;

import java.io.File;

public class FileUtil {
	
	/**
	 * Obtem um objeto java.io.File do diretorio resources
	 * @param path
	 * @return
	 */
	public File getFromResources(String path) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(path).getFile());
		return file;
	}

}
