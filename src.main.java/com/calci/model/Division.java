package com.calci.model;

import com.calci.expection.BussinessException;
import com.calci.service.ICalculator;

/**
 * @author SowbaranikaT Handles division operation
 */
public class Division implements ICalculator {

	/**
	 * @param a input value in double
	 * @param b input value in double
	 * @return It return value of (a/b)
	 * @throws InvalidExpressionException If the given value is invalid It throws
	 *                                    exception
	 */
	@Override
	public Double calculate(Double a, Double b) throws BussinessException {
		if (b == 0) {
			throw new BussinessException("Cannot divided by zero");
		}
		return a / b;
	}
}
