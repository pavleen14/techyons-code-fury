package com.hsbc.meets.exception;

public class EmptyXmlFileException extends Exception {
	@Override
	public String toString() {
		return "No data found in XML file to add";
	}
}
