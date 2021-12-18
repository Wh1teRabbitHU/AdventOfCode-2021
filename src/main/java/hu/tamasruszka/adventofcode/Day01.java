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
	}

	private static void part1() throws IOException {
		List<String> sourceLines = readSourceFile();
		List<Integer> depthValues = sourceLines.stream()
											   .mapToInt(Integer::parseInt)
											   .boxed()
											   .collect(Collectors.toList());
		Integer increasedCount = 0;

		for (int i = 0; i < depthValues.size() - 1; i++) {
			Integer currentDepth = depthValues.get(i);
			Integer nextDepth = depthValues.get(i + 1);

			if (nextDepth > currentDepth) {
				increasedCount++;
			}
		}

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
