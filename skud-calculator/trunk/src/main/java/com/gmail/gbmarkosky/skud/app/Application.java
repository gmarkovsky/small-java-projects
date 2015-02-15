package com.gmail.gbmarkosky.skud.app;

import java.util.ArrayList;
import java.util.List;

import com.gmail.gbmarkosky.skud.engine.Worker;
import com.gmail.gbmarkosky.skud.io.Formatter;
import com.gmail.gbmarkosky.skud.io.IOUtils;

public class Application {
	public static void main(String[] args) {
		CommandReader commandReader = new CommandReader();
		Configuration configuration;
		try {
			configuration = commandReader.readConfiguration(args);
		} catch (ConfigurationException e) {
			return;
		}

		List<String> lines = IOUtils.readLines(configuration.getPathToFile());
		
		List<String> dataLines = (configuration.isSkipHeader()) ? lines.subList(1, lines.size()): lines;
		if (dataLines == null || dataLines.isEmpty())
			return;
		
		List<Worker> workers = new ArrayList<Worker>();
		
		int daysCount = configuration.getDaysCount();
		int startDay = configuration.getStartDay();
		
		for (String string : dataLines) {
			workers.add(Worker.fromString(string, startDay, daysCount, configuration.getSeparator()));
		}
		
		String outputFile = (configuration.getOutputFile().isEmpty()) ? configuration.getPathToFile() + ".out" : configuration.getOutputFile();

		IOUtils.write(outputFile, new Formatter().format(workers, dataLines, daysCount));
	}
}
