package com.abb.clean.cleanfolder.command;

import java.nio.file.FileVisitor;
import java.nio.file.Path;

import com.abb.clean.cleanfolder.task.DeleteFileVisitor;
import com.abb.clean.cleanfolder.task.PrintFileVisitor;
import com.abb.clean.cleanfolder.task.RenameShorterFileVisitor;

public enum CleanMode {
	PRINT("p", new PrintFileVisitor()),
	RENAME("r", new RenameShorterFileVisitor()),
	DELETE("d", new DeleteFileVisitor());

	private final String command;
	private final FileVisitor<Path> visitor;

	private CleanMode(String cmd, FileVisitor<Path> visitor) {
		this.command = cmd;
		this.visitor = visitor;
	}

	public FileVisitor<Path> getFileVisitor() {
		return visitor;
	}

	public static CleanMode check(String cmd) {
		for (CleanMode mode : CleanMode.values()) {
			if (mode.command.equals(cmd))
				return mode;
		}
		return null;
	}

	public static CleanMode get(String cmd) {
		CleanMode mode = check(cmd);
		if (mode == null) {
			mode = PRINT;
		}
		return mode;
	}
}
