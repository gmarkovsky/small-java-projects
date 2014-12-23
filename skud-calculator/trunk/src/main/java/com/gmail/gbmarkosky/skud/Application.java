package com.gmail.gbmarkosky.skud;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("usage: java -jar skud-calculator <input-file> [<output-file>]");
			return;
		}
		
		String pathToFile = args[0];
		
		List<String> lines = readLines(pathToFile);
		
		if (lines == null)
			return;
		
		if (lines.size() < 2) {
			System.out.println("invalid input file format");
			return;
		}
		
		String[] header = lines.get(0).split(";");
		
		if (header.length < 32) {
			System.out.println("invalid input file format");
			return;
		}
		
		List<Worker> workers = new ArrayList<Worker>();
		
		String[] monthLine = Arrays.copyOfRange(header, 3, header.length);
		
		for (String string : lines.subList(1, lines.size())) {
			workers.add(Worker.fromString(string, monthLine));
		}
		
		for (Worker worker : workers) {
			Calculator.agregate(monthLine, worker);
		}
		
		for (int i = 0; i < header.length; i++) {
			for (Worker worker : workers) {
				if (i == 0) {
					worker.setLine(worker.getName());
					worker.setLine2(";;");
				} else if (i > 0 && i <= 2) {
					worker.setLine(worker.getLine() + ";");
				} else {
					String string = worker.getWeeks().get(header[i]);
					if (string == null)
						string = "";
					worker.setLine2(worker.getLine2() + ";" + string);
					worker.setLine(worker.getLine() + ";" + worker.getMarks().get(header[i]));
				}
			}
		}
		for (Worker worker : workers) {
			worker.setLine3(";;;" + worker.getTotal());
		}
		
		String outputFile = (args.length == 2) ? args[1] : pathToFile + ".out";

		StringBuilder builder = new StringBuilder();
		
			for (String l : lines) {
				builder.append(l).append("\n");
			}
			for (Worker worker : workers) {
				builder.append("\n\n").append(worker.getLine());
				builder.append("\n").append(worker.getLine2());
				builder.append("\n").append(worker.getLine3());
			}

			write(outputFile, builder.toString());
	}

	private static void write(String outputFile, String text) {
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

	private static List<String> readLines(String pathToFile) {
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

				}
		}
		return lines;
	}
}
