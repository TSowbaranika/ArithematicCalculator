package com.calci.model;

import com.calci.service.ICalculator;

/**
 * @author SowbaranikaT Handles addition operation
 */
public class Addition implements ICalculator {

	/**
	 *
	 * @param a input value in double
	 * @param b input value in double
	 * @return It return value of (a+b)
	 */
	@Override
	public Double calculate(Double a, Double b) {
		return a + b;
	}
}
