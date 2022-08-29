package com.calci.service;

import com.calci.expection.BussinessException;

/**
 * @author SowbaranikaT calculator interface used to compute different
 *         arithmetic operations
 */
public interface ICalculator {

	/**
	 *
	 * @param a input value
	 * @param b input value
	 * @return It returns a result as Double type
	 */
	public Double calculate(Double a, Double b) throws BussinessException;
}
