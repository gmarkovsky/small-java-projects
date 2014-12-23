package com.gmail.gbmarkosky.skud;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class Application {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("usage: skud-calculator <input-file> [<output-file>]");
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
					worker.setLine2(worker.getName());
					worker.setLine(";;;");
				} else if (i > 0 && i <= 3) {
					worker.setLine2(worker.getLine2() + ";");
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
				builder.append("\n").append(worker.getLine());
				builder.append("\n").append(worker.getLine2());
				builder.append("\n").append(worker.getLine3());
			}

		try {
			Files.write(builder.toString(), new File(outputFile), Charsets.UTF_8);
		} catch (IOException e) {
			System.out.println("error occurred while writing of output file " + outputFile);
		}
	}

	private static List<String> readLines(String pathToFile) {
		try {
			return Files.readLines(new File(pathToFile), Charsets.UTF_8);
		} catch (IOException e) {
			System.out.println("error occurred while reading of file " + pathToFile);
			return null;
		}
	}
}
