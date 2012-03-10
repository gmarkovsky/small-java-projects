package com.gmail.gbmarkovsky.es;

import java.util.Map;

import com.gmail.gbmarkovsky.es.problems.Problem1;
import com.gmail.gbmarkovsky.es.problems.Problem10;
import com.gmail.gbmarkovsky.es.problems.Problem11;
import com.gmail.gbmarkovsky.es.problems.Problem12;
import com.gmail.gbmarkovsky.es.problems.Problem13;
import com.gmail.gbmarkovsky.es.problems.Problem14;
import com.gmail.gbmarkovsky.es.problems.Problem15;
import com.gmail.gbmarkovsky.es.problems.Problem16;
import com.gmail.gbmarkovsky.es.problems.Problem17;
import com.gmail.gbmarkovsky.es.problems.Problem18;
import com.gmail.gbmarkovsky.es.problems.Problem187;
import com.gmail.gbmarkovsky.es.problems.Problem19;
import com.gmail.gbmarkovsky.es.problems.Problem2;
import com.gmail.gbmarkovsky.es.problems.Problem20;
import com.gmail.gbmarkovsky.es.problems.Problem21;
import com.gmail.gbmarkovsky.es.problems.Problem22;
import com.gmail.gbmarkovsky.es.problems.Problem23;
import com.gmail.gbmarkovsky.es.problems.Problem24;
import com.gmail.gbmarkovsky.es.problems.Problem243;
import com.gmail.gbmarkovsky.es.problems.Problem25;
import com.gmail.gbmarkovsky.es.problems.Problem27;
import com.gmail.gbmarkovsky.es.problems.Problem28;
import com.gmail.gbmarkovsky.es.problems.Problem29;
import com.gmail.gbmarkovsky.es.problems.Problem3;
import com.gmail.gbmarkovsky.es.problems.Problem30;
import com.gmail.gbmarkovsky.es.problems.Problem33;
import com.gmail.gbmarkovsky.es.problems.Problem34;
import com.gmail.gbmarkovsky.es.problems.Problem35;
import com.gmail.gbmarkovsky.es.problems.Problem36;
import com.gmail.gbmarkovsky.es.problems.Problem37;
import com.gmail.gbmarkovsky.es.problems.Problem38;
import com.gmail.gbmarkovsky.es.problems.Problem39;
import com.gmail.gbmarkovsky.es.problems.Problem4;
import com.gmail.gbmarkovsky.es.problems.Problem40;
import com.gmail.gbmarkovsky.es.problems.Problem42;
import com.gmail.gbmarkovsky.es.problems.Problem43;
import com.gmail.gbmarkovsky.es.problems.Problem45;
import com.gmail.gbmarkovsky.es.problems.Problem46;
import com.gmail.gbmarkovsky.es.problems.Problem48;
import com.gmail.gbmarkovsky.es.problems.Problem49;
import com.gmail.gbmarkovsky.es.problems.Problem5;
import com.gmail.gbmarkovsky.es.problems.Problem50;
import com.gmail.gbmarkovsky.es.problems.Problem6;
import com.gmail.gbmarkovsky.es.problems.Problem7;
import com.gmail.gbmarkovsky.es.problems.Problem8;
import com.gmail.gbmarkovsky.es.problems.Problem81;
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
		problems.put(12, new Problem12());
		problems.put(11, new Problem11());
		problems.put(13, new Problem13());
		problems.put(14, new Problem14());
		problems.put(15, new Problem15());
		problems.put(16, new Problem16());
		problems.put(17, new Problem17());
		problems.put(18, new Problem18("res/18.txt"));
		problems.put(19, new Problem19());
		problems.put(20, new Problem20());
		problems.put(21, new Problem21());
		problems.put(22, new Problem22());
		problems.put(23, new Problem23());
		problems.put(24, new Problem24());
		problems.put(25, new Problem25());
		problems.put(27, new Problem27());
		problems.put(28, new Problem28());
		problems.put(29, new Problem29());
		problems.put(30, new Problem30());
		problems.put(33, new Problem33());
		problems.put(34, new Problem34());
		problems.put(35, new Problem35());
		problems.put(36, new Problem36());
		problems.put(37, new Problem37());
		problems.put(38, new Problem38());
		problems.put(39, new Problem39());
		problems.put(40, new Problem40());
		problems.put(42, new Problem42());
		problems.put(43, new Problem43());
		problems.put(45, new Problem45());
		problems.put(46, new Problem46());
		problems.put(48, new Problem48());
		problems.put(49, new Problem49());
		problems.put(50, new Problem50());
		problems.put(67, new Problem18("res/67.txt"));
		problems.put(81, new Problem81());
		problems.put(187, new Problem187());
		problems.put(243, new Problem243());
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
			Profiler.bigStart();
			for (Integer number : problems.keySet()) {
				Profiler.start();
				String result = problems.get(number).solve();
				
				double time = Profiler.finish();
				System.out.println("Problem №" + number + " ... " + result + "  (" + time + " s)");
			}
			double time = Profiler.bigFinish();
			System.out.println("Total time: " + time + " s");
			System.out.println("Total sovled: " + problems.keySet().size());
		}
	}
}
