package com.gmail.gbmarkosky.skud.app;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CommandReader {
	private Options options;

	@SuppressWarnings("static-access")
	public CommandReader() {
		options = new Options();
		
		Option skip = new Option("headeroff", "Skip header row" );
		
		options.addOption(skip);
		
		Option separator = OptionBuilder.withArgName("separator")
                .hasArg()
                .withDescription("Use custom separator instead of ;")
                .create( "separator" );
		
		Option days = OptionBuilder.withArgName( "days" )
                .hasArg()
                .isRequired(true)
                .withDescription("Number of days in month")
                .create("days");
		
		Option start = OptionBuilder.withArgName("start")
                .hasArg()
                .isRequired(true)
                .withDescription("Number of days in month")
                .create("start");
		
		options.addOption(separator);
		options.addOption(days);
		options.addOption(start);
	}
	
	public Configuration readConfiguration(String[] args) throws ConfigurationException {
		CommandLineParser parser = new BasicParser();
		CommandLine cmd = null;
		String pathToFile = null;
		try {
			cmd = parser.parse(options, args);
			
			String[] arguments = cmd.getArgs();
			
			if (arguments.length < 1) {
				HelpFormatter formatter = new HelpFormatter();
				System.out.println("missing FILE");
				formatter.printHelp( "skud-calculator FILE [OPTIONS]", options );
				throw new ConfigurationException();
			}
			pathToFile = arguments[0];
		} catch (ParseException e) {
			String message = e.getMessage();
			if (message.contains("Missing required option:")) {
				System.out.println(message);
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp( "skud-calculator FILE [OPTIONS]", options );
			} else {

				System.err.println("Fatal error: " + message);
				throw new ConfigurationException();
			}
		}
		
		Configuration configuration = new Configuration();
		configuration.setPathToFile(pathToFile);
		configuration.setSkipHeader(cmd.hasOption("headeroff"));
		
		configuration.setDaysCount(Integer.parseInt(cmd.getOptionValue("days")));
		configuration.setStartDay(Integer.parseInt(cmd.getOptionValue("start")));
		configuration.setSeparator(cmd.getOptionValue("separator", ";"));
		return configuration;
	}
}
