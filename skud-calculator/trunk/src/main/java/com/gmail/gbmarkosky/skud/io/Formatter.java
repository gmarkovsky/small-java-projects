package com.gmail.gbmarkosky.skud.io;

import java.util.List;

import com.gmail.gbmarkosky.skud.engine.Duration;
import com.gmail.gbmarkosky.skud.engine.Worker;

public class Formatter {
	public String format(List<Worker> workers, List<String> lines, int daysCount) {
		for (Worker worker : workers) {
			worker.setLine(worker.getName() + ";;");
			worker.setLine2(";;");
			worker.setLine3(";;;" + worker.getTotal());
			for (int i = 1; i <= daysCount; i++) {
				Duration d = worker.getWeeks().get(i);
				String string = (d == null) ? "" : d.toString();
				worker.setLine2(worker.getLine2() + ";" + string);
				Duration duration = worker.getMarks().get(i);
				String s2 = (duration == null) ? "" : duration.toString();
				worker.setLine(worker.getLine() + ";" + s2);
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
