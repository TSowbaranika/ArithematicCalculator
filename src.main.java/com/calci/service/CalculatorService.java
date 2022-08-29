package com.calci.service;

import com.calci.expection.BussinessException;

/**
 * 
 * @author SowbaranikaT This handles the calculation functionalities.
 *
 */
public interface CalculatorService {

	public void evaluateExpression(String expression) throws BussinessException;

	public void flushStacks();

	public ICalculator getOperationSymbols(Character operator);

	public Double calculateValue() throws BussinessException;
}
