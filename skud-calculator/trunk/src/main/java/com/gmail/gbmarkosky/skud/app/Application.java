package com.gmail.gbmarkosky.skud.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gmail.gbmarkosky.skud.engine.Calculator;
import com.gmail.gbmarkosky.skud.engine.Worker;
import com.gmail.gbmarkosky.skud.io.Formatter;
import com.gmail.gbmarkosky.skud.io.IOUtils;

public class Application {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("usage: java -jar skud-calculator <input-file> [<output-file>]");
			return;
		}
		
		String pathToFile = args[0];
		
		List<String> lines = IOUtils.readLines(pathToFile);
		
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
		
		String outputFile = (args.length == 2) ? args[1] : pathToFile + ".out";

		IOUtils.write(outputFile, new Formatter().format(workers, lines, monthLine));
	}
}
