package com.abb.clean.cleanfolder.command;

import java.io.IOException;

import com.abb.clean.cleanfolder.Command;
import com.abb.clean.cleanfolder.runner.FileWalker;

/**
 * This command cleans folders and files. Possible actions are listed by its modes.
 * Each mode is associated to a visitor.
 */
public class CleanCommand implements Command {

	private String[] args;

	public CleanCommand(String[] args) {
		this.args = args;
	}

	@Override
	public boolean accept(String[] args) {
		return CleanRule.validArgs(args);
	}

	@Override
	public String show() {
		String text = "Invalid arguments. Possible arguments are:%n"
				+ "fullpath [mode]%n"
				+ "\tfullpath: absolute path of a folder%n"
				+ "\tmode (optional): p|r|d%n"
				+ "\t\tp:print, r:rename, d:delete%n";
		System.out.format(text);
		return text;
	}

	@Override
	public void exe() {
		String fullpath = args[0];
		CleanMode mode = CleanMode.PRINT;
		if (args.length > 1) {
			mode = CleanMode.get(args[1]);
		}
		System.out.format("scan %s%nmode %s%n", fullpath, mode.name());

		try {
			new FileWalker(fullpath).walk(mode.getFileVisitor());
		} catch (IOException e) {
			System.err.format("Error occurs. %s", e);
		}
	}
}
