package com.gmail.gbmarkovsky.es;

import java.util.Map;

import com.gmail.gbmarkovsky.es.problems.Problem1;
import com.gmail.gbmarkovsky.es.problems.Problem10;
import com.gmail.gbmarkovsky.es.problems.Problem11;
import com.gmail.gbmarkovsky.es.problems.Problem13;
import com.gmail.gbmarkovsky.es.problems.Problem14;
import com.gmail.gbmarkovsky.es.problems.Problem15;
import com.gmail.gbmarkovsky.es.problems.Problem16;
import com.gmail.gbmarkovsky.es.problems.Problem17;
import com.gmail.gbmarkovsky.es.problems.Problem18;
import com.gmail.gbmarkovsky.es.problems.Problem2;
import com.gmail.gbmarkovsky.es.problems.Problem20;
import com.gmail.gbmarkovsky.es.problems.Problem22;
import com.gmail.gbmarkovsky.es.problems.Problem24;
import com.gmail.gbmarkovsky.es.problems.Problem25;
import com.gmail.gbmarkovsky.es.problems.Problem28;
import com.gmail.gbmarkovsky.es.problems.Problem29;
import com.gmail.gbmarkovsky.es.problems.Problem3;
import com.gmail.gbmarkovsky.es.problems.Problem4;
import com.gmail.gbmarkovsky.es.problems.Problem48;
import com.gmail.gbmarkovsky.es.problems.Problem5;
import com.gmail.gbmarkovsky.es.problems.Problem6;
import com.gmail.gbmarkovsky.es.problems.Problem7;
import com.gmail.gbmarkovsky.es.problems.Problem8;
import com.gmail.gbmarkovsky.es.problems.Problem9;
import com.gmail.gbmarkovsky.es.util.Profiler;
import com.google.common.collect.Maps;

public class EulerApplication {
	private static final Map<Integer, EulerProblem> problems = Maps.newTreeMap();
	static {
		problems.put(1, new Problem1());
		problems.put(2, new Problem2());
		problems.put(3, new Problem3());
		problems.put(4, new Problem4());
		problems.put(5, new Problem5());
		problems.put(6, new Problem6());
		problems.put(7, new Problem7());
		problems.put(8, new Problem8());
		problems.put(9, new Problem9());
		problems.put(10, new Problem10());
		problems.put(11, new Problem11());
		problems.put(13, new Problem13());
		problems.put(14, new Problem14());
		problems.put(15, new Problem15());
		problems.put(16, new Problem16());
		problems.put(17, new Problem17());
		problems.put(18, new Problem18("res/18.txt"));
		problems.put(20, new Problem20());
		problems.put(22, new Problem22());
		problems.put(24, new Problem24());
		problems.put(25, new Problem25());
		problems.put(28, new Problem28());
		problems.put(29, new Problem29());
		problems.put(48, new Problem48());
		problems.put(67, new Problem18("res/67.txt"));
	}
	
	public static void main(String[] args) {
		System.out.println("*** Application for project Euler problems solving ***");
		Integer sn = null;
		if (args.length == 1) {
			sn = Integer.parseInt(args[0]);
		}
		if (sn != null) {
			if (problems.containsKey(sn)) {
				Profiler.start();
				String result = problems.get(sn).solve();
				
				double time = Profiler.finish();
				System.out.println("Problem №" + sn + " ... " + result + "(" + time + " s)");
			} else {
				System.out.println("Решения задачи с таким номером нет");
			}
		} else {
			for (Integer number : problems.keySet()) {
				Profiler.start();
				String result = problems.get(number).solve();
				
				double time = Profiler.finish();
				System.out.println("Problem №" + number + " ... " + result + "  (" + time + " s)");
			}
		}
	}
}
