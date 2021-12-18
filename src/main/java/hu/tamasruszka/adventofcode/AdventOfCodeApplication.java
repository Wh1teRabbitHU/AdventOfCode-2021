package hu.tamasruszka.adventofcode;

import hu.tamasruszka.adventofcode.solution.Day01;
import hu.tamasruszka.adventofcode.solution.Day02;

public class AdventOfCodeApplication {

	private static final Day01 day01 = new Day01();
	private static final Day02 day02 = new Day02();

	public static void main(String[] args) {
		day01.part1();
		day01.part2V1();
		day01.part2V2(Day01.PART_2_WINDOW_SIZE);

		day02.part1();
		day02.part2();
	}

}
