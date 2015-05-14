package com.abb.clean.cleanfolder;

import com.abb.clean.cleanfolder.command.CleanCommand;

/**
 * Executable class.
 */
public class App {
	public static void main(String[] args) {
		Command command = new CleanCommand(args);

		if (!command.accept(args)) {
			command.show();
			return;
		}

		command.exe();
	}

}
