package com.gmail.gbmarkovsky.es.problems;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.StringTokenizer;

import com.gmail.gbmarkovsky.es.EulerProblem;
import com.google.common.io.Files;

public class Problem81 implements EulerProblem {

	@Override
	public String solve() {
		return Long.toString(countWays(load("res/81.txt")));
	}

	static long countWays(long[][] field) {
		int size = field.length;
		for (int i = 1; i < size; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (i - j == 0) {
					field[i - j][j] = field[i - j][j] + field[i - j][j - 1];
				} else if (j == 0) {
					field[i - j][j] = field[i - j][j] + field[i - j - 1][j];
				} else {
					field[i - j][j] = field[i - j][j] + Math.min(field[i - j - 1][j], field[i - j][j - 1]);
				}
			}
		}

		for (int i = 1; i < size; i++) {
			for (int j = i; j < size; j++) {
				field[j][size - j + i - 1] = field[j][size - j + i - 1] + Math.min(field[j - 1][size - j + i - 1],
						 field[j][size - j + i - 1 - 1]);
			}
		}
		return field[size - 1][size - 1];
	}
	
	static long[][] load(String file) {
		List<String> lines = null;
		try {
			lines = Files.readLines(new File(file),
					Charset.defaultCharset());
		} catch (IOException e) {
			System.err.println("Input data file not found!");
		}
		
		
		long[][] result = new long[lines.size()][lines.size()];
		for (int i = 0; i < lines.size(); i++) {
			StringTokenizer tokenizer = new StringTokenizer(lines.get(i));
			for (int j = 0; j < result[i].length; j++) {
				if (tokenizer.hasMoreTokens()) {
					result[i][j] = Integer.parseInt(tokenizer.nextToken(","));
				} else {
					System.err.println("Wrong input data file format!");
				}
			}
		}
		return result;
	}
}
