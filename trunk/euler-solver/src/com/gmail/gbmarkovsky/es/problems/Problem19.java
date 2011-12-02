package com.gmail.gbmarkovsky.es.problems;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem19 implements EulerProblem {

    @Override
    public String solve() {
        Calendar calendar = new GregorianCalendar(1901, Calendar.JANUARY, 6);
        int counter = 0;
        while (calendar.get(Calendar.YEAR) < 2001) {
            System.out.print(calendar.get(Calendar.DAY_OF_WEEK));
            System.out.println(" " + calendar.get(Calendar.DAY_OF_MONTH));
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY && calendar.get(Calendar.DAY_OF_MONTH) == 1) {
                counter++;
            }
            calendar.add(Calendar.DAY_OF_YEAR, 7);
            
        }
        return Integer.toString(counter);
    }
}
