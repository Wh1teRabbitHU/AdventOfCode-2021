package hu.tamasruszka.adventofcode.solution;

import hu.tamasruszka.adventofcode.exception.CommandParseException;
import hu.tamasruszka.adventofcode.exception.UnknownValueException;
import hu.tamasruszka.adventofcode.model.Command;
import hu.tamasruszka.adventofcode.model.Instruction;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

import static hu.tamasruszka.adventofcode.util.FileUtil.readSourceFile;

@Slf4j
public class Day02 {

	private static final String INPUT_FILE_PATH = "sources/source-02.txt";
	private static final String INSTRUCTION_SEPARATOR = " ";

	public static void main(String[] args) {
		part1();
		part2();
	}

	private static void part1() {
		List<String> sourceLines = readSourceFile(INPUT_FILE_PATH);

		int posX = 0;
		int posY = 0;

		for (String line : sourceLines) {
			var optionalInstruction = parseInstruction(line);

			if (optionalInstruction.isEmpty()) {
				return;
			}

			var instruction = optionalInstruction.get();

			switch (instruction.getCommand()) {
				case UP:
					posY -= instruction.getDistance();
					break;
				case DOWN:
					posY += instruction.getDistance();
					break;
				case FORWARD:
					posX += instruction.getDistance();
					break;
				default:
					throw new UnknownValueException("Unknown command value: " + instruction.getCommand());
			}
		}

		int finalPosition = posX * posY;

		log.info("Part 1 solution");
		log.info("Final position: {}", finalPosition);
	}

	private static void part2() {
		List<String> sourceLines = readSourceFile(INPUT_FILE_PATH);

		int posX = 0;
		int posY = 0;
		int aim = 0;

		for (String line : sourceLines) {
			var optionalInstruction = parseInstruction(line);

			if (optionalInstruction.isEmpty()) {
				return;
			}

			var instruction = optionalInstruction.get();

			switch (instruction.getCommand()) {
				case UP:
					aim -= instruction.getDistance();
					break;
				case DOWN:
					aim += instruction.getDistance();
					break;
				case FORWARD:
					posX += instruction.getDistance();
					posY += aim * instruction.getDistance();
					break;
				default:
					throw new UnknownValueException("Unknown command value: " + instruction.getCommand());
			}
		}

		int finalPosition = posX * posY;

		log.info("Part 2 solution");
		log.info("Final position: {}", finalPosition);
	}

	private static Optional<Instruction> parseInstruction(String instruction) {
		String[] instructionParts = instruction.split(INSTRUCTION_SEPARATOR);

		if (instructionParts.length != 2) {
			log.error("Unknown command structure! {}", instruction);

			return Optional.empty();
		}

		try {
			Command command = Command.getCommand(instructionParts[0]);
			int distance = Integer.parseInt(instructionParts[1]);

			return Optional.of(new Instruction(command, distance));
		} catch (NumberFormatException ex) {
			log.error("The input distance value is malformed or missing! {}", instructionParts[1]);

			return Optional.empty();
		} catch (CommandParseException ex) {
			log.error("The input command is malformed or missing! {}", instructionParts[0]);

			return Optional.empty();
		}
	}
}
