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

	public Options getOptions() {
		return options;
	}

	@SuppressWarnings("static-access")
	public CommandReader() {
		options = new Options();
		
		Option separator = OptionBuilder.withArgName("separator")
                .hasArg()
                .withDescription("Use custom separator instead of ;")
                .create( "separator" );
		
		Option days = OptionBuilder.withArgName( "year" )
                .hasArg()
                .withDescription("Year")
                .create("year");
		
		Option start = OptionBuilder.withArgName("month")
                .hasArg()
                .withDescription("Month")
                .create("month");
		
		Option output = OptionBuilder.withArgName( "output" )
                .hasArg()
                .isRequired(false)
                .withDescription("Output file")
                .create("output");
		Option help = new Option( "help", "Print help message" );
		
		options.addOption(separator);
		options.addOption(days);
		options.addOption(start);
		options.addOption(output);
		options.addOption(help);
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
		
		if (cmd.hasOption("year"))
		configuration.setYear(Integer.parseInt(cmd.getOptionValue("year")));
		if (cmd.hasOption("month"))
		configuration.setMonth(Integer.parseInt(cmd.getOptionValue("month")));
		configuration.setOutputFile(cmd.getOptionValue("output"));
		configuration.setSeparator(cmd.getOptionValue("separator", ";"));
		configuration.setPrintHelp(cmd.hasOption("help"));
		
		if (cmd.hasOption("help")) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp( "skud-calculator FILE [OPTIONS]", options );
		}
		return configuration;
	}
}
