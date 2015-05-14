package com.abb.clean.cleanfolder.command;

public class CleanRule {
	public static boolean validArgs(String[] args) {
		boolean isValid = true;
		if (args == null || args.length < 1 || args.length > 2) {
			isValid = false;
		}
		if (isValid && args.length > 1 && null == CleanMode.check(args[1])) {
			isValid = false;
		}
		return isValid;
	}
}
