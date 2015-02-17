package com.gmail.gbmarkosky.skud.app;

public class Configuration {
	private String pathToFile;
	private boolean skipHeader;
	private int daysCount;
	private int startDay;
	private String separator;
	private String outputFile;
	private boolean printHelp;
	public String getPathToFile() {
		return pathToFile;
	}
	public void setPathToFile(String pathToFile) {
		this.pathToFile = pathToFile;
	}
	public boolean isSkipHeader() {
		return skipHeader;
	}
	public void setSkipHeader(boolean skipHeader) {
		this.skipHeader = skipHeader;
	}
	public int getDaysCount() {
		return daysCount;
	}
	public void setDaysCount(int daysCount) {
		this.daysCount = daysCount;
	}
	public int getStartDay() {
		return startDay;
	}
	public void setStartDay(int startDay) {
		this.startDay = startDay;
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
