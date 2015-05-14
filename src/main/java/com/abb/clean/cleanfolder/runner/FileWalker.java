package com.abb.clean.cleanfolder.runner;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWalker {
	private String path;

	public FileWalker(String path) {
		this.path = path;
	}

	public void walk(FileVisitor<? super Path> visitor) throws IOException {
		Files.walkFileTree(new File(path).toPath(), visitor);
	}
}
