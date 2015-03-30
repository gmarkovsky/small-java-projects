package com.gmail.gbmarkosky.skud.io;

import java.io.File;

public final class OutputFileFormatter {
	public static String format(String inputFilePath) {
		File file = new File(inputFilePath);

		String name = file.getName();

		File pathFile = file.getParentFile();

		String path = (pathFile != null) ? pathFile.getPath() + File.separator : "";
		
		name = getNameWithoutExtension(name);
			
		return path + name + "-output.csv";
	}

	private static String getNameWithoutExtension(String file) {
		String fileName = new File(file).getName();
		int dotIndex = fileName.lastIndexOf('.');
		return (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
	}
}
