package com.gmail.gbmarkosky.skud.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public final class IOUtils {
	private final static Logger LOGGER = Logger.getLogger(IOUtils.class.getName());
	
	private IOUtils() {
		
	}
	
	public static void write(String outputFile, String text) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(outputFile));
			writer.write(text);
		} catch (IOException e) {
			System.out.println("error occurred while writing of output file " + outputFile);
		} finally {
			if (writer != null)
				try {
					writer.close();
				} catch (IOException e) {
					
				}
		}
	}

	public static List<String> readLines(String pathToFile) {
		List<String> lines = new ArrayList<String>();

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(pathToFile));
			for (String line; (line = reader.readLine()) != null;) {
				lines.add(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println(String.format("file %s not found", pathToFile));
			return null;
		} catch (IOException e) {
			System.out.println("error occurred while reading of file " + pathToFile);
			return null;
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					LOGGER.warning(e.getMessage());
				}
		}
		return lines;
	}
}
