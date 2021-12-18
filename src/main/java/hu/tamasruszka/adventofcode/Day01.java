package hu.tamasruszka.adventofcode;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;


@Slf4j
public class Day01 {

	private static final ClassLoader CLASS_LOADER = Day01.class.getClassLoader();
	private static final String INPUT_FILE_PATH = "sources/source-01.txt";

	public static void main(String[] args) throws IOException {
		part1();
		part2();
	}

	private static void part1() throws IOException {
		List<String> sourceLines = readSourceFile();
		List<Integer> depthValues = sourceLines.stream()
											   .mapToInt(Integer::parseInt)
											   .boxed()
											   .collect(Collectors.toList());
		int increasedCount = 0;

		for (int i = 0; i < depthValues.size() - 1; i++) {
			int currentDepth = depthValues.get(i);
			int nextDepth = depthValues.get(i + 1);

			if (nextDepth > currentDepth) {
				increasedCount++;
			}
		}

		log.info("Part 1 solution");
		log.info("Depth increased {} times", increasedCount);
	}

	private static void part2() throws IOException {
		List<String> sourceLines = readSourceFile();
		List<Integer> depthValues = sourceLines.stream()
											   .mapToInt(Integer::parseInt)
											   .boxed()
											   .collect(Collectors.toList());
		int increasedCount = 0;

		for (int i = 0; i < depthValues.size() - 3; i++) {
			int currentDepth1 = depthValues.get(i);
			int currentDepth2 = depthValues.get(i + 1);
			int currentDepth3 = depthValues.get(i + 2);
			int nextDepth1 = depthValues.get(i + 1);
			int nextDepth2 = depthValues.get(i + 2);
			int nextDepth3 = depthValues.get(i + 3);

			int currentDepthAggregated = currentDepth1 + currentDepth2 + currentDepth3;
			int nextDepthAggregated = nextDepth1 + nextDepth2 + nextDepth3;

			if (nextDepthAggregated > currentDepthAggregated) {
				increasedCount++;
			}
		}

		log.info("Part 2 solution");
		log.info("Depth increased {} times", increasedCount);
	}

	private static List<String> readSourceFile() throws IOException {
		List<String> lines = new ArrayList<>();

		try (var reader = new BufferedReader(new InputStreamReader(requireNonNull(CLASS_LOADER.getResourceAsStream(INPUT_FILE_PATH))))) {
			while (reader.ready()) {
				lines.add(reader.readLine());
			}
		}

		return lines;
	}
}
