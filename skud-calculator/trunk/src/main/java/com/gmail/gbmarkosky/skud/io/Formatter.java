package com.gmail.gbmarkosky.skud.io;

import java.util.List;

import com.gmail.gbmarkosky.skud.engine.Worker;

public class Formatter {
	public String format(List<Worker> workers, List<String> lines,
			String[] monthLine) {
		for (Worker worker : workers) {
			worker.setLine(worker.getName() + ";;");
			worker.setLine2(";;");
			worker.setLine3(";;;" + worker.getTotal());
			for (int i = 0; i < monthLine.length; i++) {
				String string = worker.getWeeks().get(monthLine[i]);
				if (string == null)
					string = "";
				worker.setLine2(worker.getLine2() + ";" + string);
				worker.setLine(worker.getLine() + ";" + worker.getMarks().get(monthLine[i]));
			}
		}

		StringBuilder builder = new StringBuilder();

		for (String l : lines) {
			builder.append(l).append("\n");
		}
		for (Worker worker : workers) {
			builder.append("\n\n").append(worker.getLine());
			builder.append("\n").append(worker.getLine2());
			builder.append("\n").append(worker.getLine3());
		}

		return builder.toString();
	}
}
