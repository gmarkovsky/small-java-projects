package com.gmail.gbmarkosky.skud.app;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.gmail.gbmarkosky.skud.engine.Worker;
import com.gmail.gbmarkosky.skud.io.Formatter;
import com.gmail.gbmarkosky.skud.io.IOUtils;

public class Application {
	public static void main(String[] args) {
		Options options = new Options();
		Option help = new Option( "help", "Print help message" );
		options.addOption(help);
		CommandReader commandReader = new CommandReader();
		CommandLineParser parser = new BasicParser();
		try {
			CommandLine cmd = parser.parse(options, args, true);
			if (cmd.hasOption("help")) {
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp("skud-calculator FILE [OPTIONS]", commandReader.getOptions());
				return;
			}
		} catch (ParseException e) {

		}
		
		
		Configuration configuration;
		try {
			configuration = commandReader.readConfiguration(args);
		} catch (ConfigurationException e) {
			return;
		}

		if (configuration.isPrintHelp()) {
			
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
