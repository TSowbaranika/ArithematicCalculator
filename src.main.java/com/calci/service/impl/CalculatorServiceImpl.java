package com.calci.service.impl;

import java.text.DecimalFormat;
import java.util.Stack;

import com.calci.constants.CalculatorConstants;
import com.calci.enums.OperandsEnum;
import com.calci.expection.BussinessException;
import com.calci.service.CalculatorService;
import com.calci.service.ICalculator;
import com.calci.util.AppCommonUtil;

/**
 * 
 * @author SowbaranikaT Implements all the Calculation operations
 *
 */

public class CalculatorServiceImpl implements CalculatorService {

	private final Stack<Double> operands = new Stack<>();
	private final Stack<Character> operators = new Stack<>();

	@Override
	public void evaluateExpression(String inputExpression) throws BussinessException {

		if (!AppCommonUtil.isValidExpression(inputExpression)) {
			throw new BussinessException("Please provide Valid Expression");
		}
		char[] literals = inputExpression.toCharArray();

		boolean isNegotionOperator = literals[0] == CalculatorConstants.SYM_MINUS;
		boolean isNegativeNumber = false;

		// Evaluate the expression given by the user
		for (int i = 0; i < literals.length; i++) {

			// to handle space character.
			if (literals[i] == CalculatorConstants.SPACE) {
				throw new BussinessException("Expression has invalid character SPACE, Kindly provoide valid Expression");
			}

			// concurrent minus handling
			if (literals[i] == OperandsEnum.SUBTRACTION.value && isNegotionOperator) {
				isNegativeNumber = true;
				isNegotionOperator = false;
				i++;
			}

			//to check is given character is digit
			if (Character.isDigit(literals[i])) {
				StringBuilder currentValue = new StringBuilder();
				if (isNegativeNumber)
					currentValue.append(OperandsEnum.SUBTRACTION.value);
				// to travsel threw expression to get only the operands
				while (i < literals.length
						&& (Character.isDigit(literals[i]) || literals[i] == CalculatorConstants.SYM_DOT)) {
					currentValue.append(literals[i++]);
				}
				// Traversal happens for next value to handle that decremented the value of i.
				i--;
				// to get all the response in decimal format if it has decimal value
				operands.push(Double.parseDouble(currentValue.toString())); 
				isNegativeNumber = false;      
				isNegotionOperator = false;
			} //to check is given character is Open brace 
			else if (literals[i] == CalculatorConstants.SYM_OPEN) {
				operators.push(literals[i]);
				isNegotionOperator = true;
			}//to check is given character is Close brace 
			else if (literals[i] == CalculatorConstants.SYM_CLOSE) {
				while (operators.peek() != CalculatorConstants.SYM_OPEN) {
					operands.push(calculateValue());
				}
				operators.pop();
			}//to check is given character is Operator 
			else if (AppCommonUtil.isArithmeticOperator(literals[i])) {
				while (!operators.isEmpty()
						&& AppCommonUtil.getOperatorPriority(literals[i]) <= AppCommonUtil.getOperatorPriority(operators.peek())) {
					operands.push(calculateValue());
				}
				operators.push(literals[i]);
				isNegotionOperator = true;
			}
		}

		while (!operators.isEmpty()) {
			operands.push(calculateValue());
		}
		display();

	}

	/**
	 * To clear the calculator display
	 */
	@Override
	public void flushStacks() {
		operands.clear();
		operators.clear();
	}

	/**
	 * @param operator input value
	 * @return It return the operation based on the input type
	 */
	@Override
	public ICalculator getOperationSymbols(Character operator) {

		switch (operator) {
		case CalculatorConstants.SYM_ADD:
			return CalculatorConstants.addition;
		case CalculatorConstants.SYM_MINUS:
			return CalculatorConstants.subtraction;
		case CalculatorConstants.SYM_MUL:
			return CalculatorConstants.multiplication;
		case CalculatorConstants.SYM_DIV:
			return CalculatorConstants.division;
		default:
			return null;
		}
	}

	@Override
	public Double calculateValue() throws BussinessException {

		if (operators.isEmpty() || operands.isEmpty()) {
			throw new BussinessException(CalculatorConstants.INVALID_EXPRESSION);
		}

		Character operator = operators.pop();
		Double b = operands.pop();
		Double a = operands.pop();
		ICalculator operation = getOperationSymbols(operator);
		return operation.calculate(a, b);

	}

	public void display() {
		System.out.println("Expression Evaluated Value :");
		System.out.println(new DecimalFormat(CalculatorConstants.DECIMAL_FROMAT).format(operands.pop()));
	}

}
