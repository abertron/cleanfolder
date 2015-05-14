Cleanfolder
===========

Clean folders and files from a given directory.

This utility can be used on Windows when folder depth is too long (folder can not be removed from explorer).
I often face this case with folder such as `bower_components`, `node_modules` or java packages and long filename.

## Usage

`java -jar cleanfolder.jar fullpath [mode]`

With:

	fullpath is the absolute path of a folder
	
	mode is an optional parameter. Value is p, r or d
	
		p to print all folders and files. It is the default behaviour, 
		
		r to rename with a very short name all folders and files, 
		
		d to delete all folders and files
		
Example:
`java -jar cleanfolder.jar C:\Temp\myfolder d`

## Build

Cleanfolder is a java project (java 1.7).
