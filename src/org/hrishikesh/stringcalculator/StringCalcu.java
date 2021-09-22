package org.hrishikesh.stringcalculator;

import java.util.regex.Pattern;

/**
 * Created by Hrishi
 */


public class StringCalcu {
	
	public class StringCalculator {

	    private static final String SEPARATOR = "[,\n]";

	    public int add(String input) {

	        String separator = null;
	        String operations = null;

	        if (isCustomSeparatorDefined(input)) {
	            separator = extractSeparator(input);
	            operations = removeSeparatorDeclaration(input);
	        } else {
	            separator = SEPARATOR;
	            operations = input;
	        }

	        return add(operations, separator);
	    }

	    private boolean isCustomSeparatorDefined(String input) {
	        return input.startsWith("//");
	    }

	    private String removeSeparatorDeclaration(String input) {
	        return input.substring(4);
	    }

	    private String extractSeparator(String input) {
	        return input.substring(2, 3);
	    }

	    private int add(String input, String separator) {
	        return Pattern.compile(separator).splitAsStream(input).mapToInt(Integer::parseInt).sum();
	    }
	}

}
