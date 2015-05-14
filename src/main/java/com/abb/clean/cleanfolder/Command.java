package com.abb.clean.cleanfolder;

/**
 * Describes a command.
 */
public interface Command {

	/**
	 * Checks valid arguments.
	 * @param args Arguments from command line
	 * @return true if arguments are valid
	 */
	boolean accept(String[] args);

	/**
	 * Shows contextual help.
	 * @return contextual help message
	 */
	String show();

	/**
	 * Executes the command.
	 */
	void exe();

}
