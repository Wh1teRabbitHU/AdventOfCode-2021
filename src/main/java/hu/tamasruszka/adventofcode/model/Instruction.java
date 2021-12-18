package hu.tamasruszka.adventofcode.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Instruction {

	private final Command command;
	private final Integer distance;

}
