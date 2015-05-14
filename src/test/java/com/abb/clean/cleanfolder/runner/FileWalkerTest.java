package com.abb.clean.cleanfolder.runner;

import java.nio.file.FileVisitor;
import java.nio.file.Path;

import org.junit.Ignore;
import org.junit.Test;

import com.abb.clean.cleanfolder.task.DeleteFileVisitor;
import com.abb.clean.cleanfolder.task.PrintFileVisitor;
import com.abb.clean.cleanfolder.task.RenameShorterFileVisitor;

public class FileWalkerTest {

	private static final String PATH_READ = "D:\\tmp\\test-read";
	private static final String PATH_RENAME = "D:\\tmp\\test-ren";
	private static final String PATH_DELETE = "D:\\tmp\\test-del";
	//	private static final String PATH_DELETE = "D:\\dev\\eclipse\\eclipse-java-luna\\wk-test\\yo-test\\node_modules";

	FileVisitor<Path> visitor;

	@Test
	public void walkPrint() throws Exception {
		visitor = new PrintFileVisitor();
		new FileWalker(PATH_READ).walk(visitor);
	}

	@Test
	@Ignore
	public void walkRename() throws Exception {
		visitor = new RenameShorterFileVisitor();
		new FileWalker(PATH_RENAME).walk(visitor);
	}

	@Test
	@Ignore
	public void walkDelete() throws Exception {
		visitor = new DeleteFileVisitor();
		new FileWalker(PATH_DELETE).walk(visitor);
	}

}
