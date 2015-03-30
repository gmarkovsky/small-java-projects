package com.gmail.gbmarkosky.skud.app;

public class Configuration {
	private String pathToFile;
	private int year;
	private int month;
	private String separator;
	private String outputFile;
	private boolean printHelp;
	public String getPathToFile() {
		return pathToFile;
	}
	public void setPathToFile(String pathToFile) {
		this.pathToFile = pathToFile;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getSeparator() {
		return separator;
	}
	public void setSeparator(String separator) {
		this.separator = separator;
	}
	public String getOutputFile() {
		return outputFile;
	}
	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}
	public boolean isPrintHelp() {
		return printHelp;
	}
	public void setPrintHelp(boolean printHelp) {
		this.printHelp = printHelp;
	}
	
	
}
