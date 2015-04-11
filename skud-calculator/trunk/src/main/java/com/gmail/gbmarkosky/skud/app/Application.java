package com.gmail.gbmarkosky.skud.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.gmail.gbmarkosky.skud.engine.Worker;
import com.gmail.gbmarkosky.skud.io.CalenderUtil;
import com.gmail.gbmarkosky.skud.io.Formatter;
import com.gmail.gbmarkosky.skud.io.IOUtils;
import com.gmail.gbmarkosky.skud.io.OutputFileFormatter;

public class Application {
	private final static Logger LOGGER = Logger.getLogger(Application.class.getName());
	
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
		
		if (lines == null || lines.isEmpty())
			return;
		
		String headerLine = lines.get(0);
		
		int daysCount = 0;
		int startDay = 0;
		
		if (headerLine.contains("Сотрудник")) {
			String[] header = headerLine.split(configuration.getSeparator());
			
			if (header.length < 32) {
				System.out.println("invalid header format");
				return;
			}
			
			String[] monthLine = Arrays.copyOfRange(header, 3, header.length);
			
			daysCount = monthLine.length;
			
			startDay = CalenderUtil.dayNumber(monthLine[0]);
		} else {
			int year = configuration.getYear();
			int month = configuration.getMonth();
			
			if (year > 0 && month > 0) {
				CalenderUtil cu = CalenderUtil.create(year, month);
				daysCount = cu.getDaysCount();
				startDay = cu.getStartDay();
			} else {
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				while (year == 0) {
				System.out.print("Type year (YYYY): ");
				
		        try {
					String s = br.readLine();
					year = Integer.parseInt(s);
					if (year < 0) {
						year = 0;
						System.err.println("Invalid year number!");
					}
				} catch (IOException e) {
					LOGGER.severe(e.getMessage());
				} catch(NumberFormatException nfe){
		            System.err.println("Invalid Format!");
		        }}
		        
				
				while (month == 0){
					System.out.print("Type month (MM): ");
		        try {
					String s = br.readLine();
					month = Integer.parseInt(s);
					if (month < 1 || month > 12) {
						month = 0;
						System.err.println("Invalid month number. Should be between 1 and 12.");
					}
				} catch (IOException e) {
					LOGGER.severe(e.getMessage());
				} catch(NumberFormatException nfe){
		            System.err.println("Invalid Format!");
		        }
				}
				CalenderUtil cu = CalenderUtil.create(year, month);
				daysCount = cu.getDaysCount();
				startDay = cu.getStartDay();
			}
		}
		
		List<Worker> workers = new ArrayList<Worker>();
		
		for (String string : lines) {
			
			// Пропускаем строку если это строка заголовка
			if (string.contains("Сотрудник"))
				continue;
			
			// Пропускаем пустые строки
			String[] split = string.split(configuration.getSeparator());
			if (split.length <= 1 || split[0].trim().isEmpty())
				continue;
			
			workers.add(Worker.fromString(string, startDay, daysCount, configuration.getSeparator()));
		}
		
		String outputFileName = configuration.getOutputFile();
		String outputFile = (outputFileName == null || outputFileName.isEmpty()) ?  OutputFileFormatter.format(configuration.getPathToFile()) : outputFileName;

		IOUtils.write(outputFile, new Formatter().format(workers, lines, daysCount));
	}
}
