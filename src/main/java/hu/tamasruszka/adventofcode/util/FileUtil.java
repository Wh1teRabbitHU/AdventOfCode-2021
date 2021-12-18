package hu.tamasruszka.adventofcode.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Slf4j
public final class FileUtil {

	private static final ClassLoader CLASS_LOADER = FileUtil.class.getClassLoader();

	private FileUtil() {

	}

	public static List<String> readSourceFile(String filePath) {
		List<String> lines = new ArrayList<>();

		try (var reader = new BufferedReader(new InputStreamReader(requireNonNull(CLASS_LOADER.getResourceAsStream(filePath))))) {
			while (reader.ready()) {
				lines.add(reader.readLine());
			}
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}

		return lines;
	}
}
