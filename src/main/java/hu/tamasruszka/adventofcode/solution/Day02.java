package hu.tamasruszka.adventofcode.solution;

import hu.tamasruszka.adventofcode.exception.CommandParseException;
import hu.tamasruszka.adventofcode.exception.UnknownValueException;
import hu.tamasruszka.adventofcode.model.Command;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static hu.tamasruszka.adventofcode.util.FileUtil.readSourceFile;

@Slf4j
public class Day02 {

	private static final String INPUT_FILE_PATH = "sources/source-02.txt";
	private static final String COMMAND_SEPARATOR = " ";

	public static void main(String[] args) {
		part1();
	}

	private static void part1() {
		List<String> sourceLines = readSourceFile(INPUT_FILE_PATH);

		int posX = 0;
		int posY = 0;

		for (String cmd : sourceLines) {
			Command command;
			int distance;
			String[] cmdParts = cmd.split(COMMAND_SEPARATOR);

			if (cmdParts.length != 2) {
				log.error("Unknown command structure! {}", cmd);
				return;
			}

			try {
				command = Command.getCommand(cmdParts[0]);
				distance = Integer.parseInt(cmdParts[1]);
			} catch (NumberFormatException ex) {
				log.error("The input distance value is malformed or missing! {}", cmdParts[1]);
				return;
			} catch (CommandParseException ex) {
				log.error("The input command is malformed or missing! {}", cmdParts[0]);
				return;
			}

			switch (command) {
				case UP:
					posY -= distance;
					break;
				case DOWN:
					posY += distance;
					break;
				case FORWARD:
					posX += distance;
					break;
				default:
					throw new UnknownValueException("Unknown command value: " + command);
			}
		}

		int finalPosition = posX * posY;

		log.info("Part 1 solution");
		log.info("Final position: {}", finalPosition);
	}
}
