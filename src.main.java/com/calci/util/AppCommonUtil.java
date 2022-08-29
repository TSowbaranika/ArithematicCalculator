package com.calci.util;

import java.util.regex.Pattern;

import com.calci.enums.OperandsEnum;

public class AppCommonUtil {

	/**
	 * @param input user given value
	 * @throws InvalidExpressionException If the given value is invalid it throws
	 *                                    exception
	 */
	public static boolean isValidExpression(String input) {
		String expressionPattern = "^[0-9|+|*|(|)|\\/|\\-|. ]*";
		if (!Pattern.matches(expressionPattern, input)) {
			return false;
		}
		return true;
	}

	/**
	 * @param operator arithmetic operator is a input value
	 * @return It return the boolean value based on the input
	 */
	public static boolean isArithmeticOperator(char operator) {
		return (operator == OperandsEnum.ADDITION.value || operator == OperandsEnum.SUBTRACTION.value
				|| operator == OperandsEnum.MULTIPLICATION.value || operator == OperandsEnum.DIVISION.value);
	}

	/**
	 * @param operator arithmetic operator is a input value
	 * @return It return the priority number
	 */
	public static int getOperatorPriority(char operator) {
		{
			OperandsEnum operatorValue = OperandsEnum.getEnumNameForValue(operator);
			if (operatorValue == null)
				return 0;
			switch (operatorValue) {
			case ADDITION:
			case SUBTRACTION:
				return 1;
			case MULTIPLICATION:
			case DIVISION:
				return 2;
			default:
				return 0;
			}
		}
	}

}
