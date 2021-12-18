package hu.tamasruszka.adventofcode.model;

import hu.tamasruszka.adventofcode.exception.CommandParseException;

import java.util.Objects;

public enum Command {

	FORWARD("forward"), DOWN("down"), UP("up");

	public final String text;

	Command(String text) {
		this.text = text;
	}

	public static Command getCommand(String text) {
		for (Command command : Command.values()) {
			if (Objects.equals(command.text, text)) {
				return command;
			}
		}

		throw new CommandParseException("Unknown command text! " + text);
	}

}
