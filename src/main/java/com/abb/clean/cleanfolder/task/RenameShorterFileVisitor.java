package com.abb.clean.cleanfolder.task;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class RenameShorterFileVisitor extends SimpleFileVisitor<Path> {

	private static String PREFIX = "a";

	int index;

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		File oldName = file.toFile();
		File newName = new File(oldName.getParent() + "\\" + PREFIX + (index++));

		System.out.format("[F] %s -> %s%n", oldName, newName);
		oldName.renameTo(newName);
		return CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		File oldName = dir.toFile();
		File newName = new File(oldName.getParent() + "\\" + PREFIX + (index++));

		System.out.format("[D] %s -> %s%n", oldName, newName);
		oldName.renameTo(newName);
		return CONTINUE;
	}

}
