package com.calci.constants;

import com.calci.model.Addition;
import com.calci.model.Division;
import com.calci.model.Multiplication;
import com.calci.model.Subtraction;

/**
 * 
 * @author SowbaranikaT Constant details used in whole application
 *
 */
public class CalculatorConstants {

	// constants
	public static final String INVALID_EXPRESSION = "Expression is InValid";
	public static final Character SPACE = ' ';
	public static final String EXPRESSION_REGEX = "^[0-9|+|*|(|)|\\/|\\-|. ]*";
	public static final char SYM_OPEN = '(';
	public static final char SYM_CLOSE = ')';
	public static final char SYM_MINUS = '-';
	public static final char SYM_ADD = '+';
	public static final char SYM_MUL = '*';
	public static final char SYM_DIV = '/';
	public static final char SYM_DOT = '.';
	public static final String DECIMAL_FROMAT = "##.##";

	public static final Addition addition = new Addition();
	public static final Subtraction subtraction = new Subtraction();
	public static final Multiplication multiplication = new Multiplication();
	public static final Division division = new Division();

}
