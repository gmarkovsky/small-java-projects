package com.gmail.gbmarkosky.skud.app;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.gmail.gbmarkosky.skud.engine.Calculator;
import com.gmail.gbmarkosky.skud.engine.Worker;
import com.gmail.gbmarkosky.skud.io.Formatter;
import com.gmail.gbmarkosky.skud.io.IOUtils;

public class Application {
	public static void main(String[] args) {
		Options options = new Options();
		
		Option skip = new Option("headeroff", "Skip header row" );
		
		options.addOption(skip);
		
		Option separator   = OptionBuilder.withArgName( "separator" )
                .hasArg()
                .withDescription(  "Use custom separator instead of ;" )
                .create( "separator" );
		
		Option days   = OptionBuilder.withArgName( "days" )
                .hasArg()
                .isRequired(true)
                .withDescription(  "Number of days in month" )
                .create( "days" );
		
		Option start   = OptionBuilder.withArgName( "start" )
                .hasArg()
                .isRequired(true)
                .withDescription(  "Number of days in month" )
                .create( "start" );
		
		options.addOption(separator);
		options.addOption(days);
		options.addOption(start);
		
		CommandLineParser parser = new BasicParser();
		CommandLine cmd = null;
		String pathToFile = null;
		try {
			cmd = parser.parse(options, args);
			List argList = cmd.getArgList();
			
			if (argList.size() < 1) {
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp( "skud-calculator FILE [OPTIONS]", options );
				return;
			}
			pathToFile = (String) argList.get(0);
			System.out.println(argList);
		} catch (ParseException e) {
			String message = e.getMessage();
			if (message.contains("Missing required option:")) {
				System.out.println(message);
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp( "skud-calculator FILE [OPTIONS]", options );
			}else
				
				
				
			System.err.println("Fatal error: " + message);
			return;
		}
		

		List<String> lines = IOUtils.readLines(pathToFile);
		
		List<String> dataLines = (cmd.hasOption("headeroff")) ? lines.subList(1, lines.size()): lines;
		if (dataLines == null)
			return;
		
		List<Worker> workers = new ArrayList<Worker>();
		
		int daysCount = Integer.parseInt(cmd.getOptionValue("days"));
		
		for (String string : dataLines) {
			workers.add(Worker.fromString(string, daysCount, cmd.getOptionValue("separator", ";")));
		}
		
		for (Worker worker : workers) {
			Calculator.agregate(Integer.parseInt(cmd.getOptionValue("start")), daysCount, worker);
		}
		
		String outputFile = (args.length == 2) ? args[1] : pathToFile + ".out";

		IOUtils.write(outputFile, new Formatter().format(workers, dataLines, daysCount));
	}
}
