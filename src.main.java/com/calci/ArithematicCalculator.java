package com.calci;

import java.util.Scanner;

import com.calci.expection.BussinessException;
import com.calci.service.impl.CalculatorServiceImpl;

/**
 * 
 * @author SowbaranikaT Simple Arthmetic Desktop Evaluation program
 * 
 */
/*
 * 
 * 
 * 
 * 
 * */
public class ArithematicCalculator {

	public static void main(String[] args) {
		System.out.println("Arthmetic Calucator Started");
		//Handling and evaluating the Arithmetic Expression
		CalculatorServiceImpl calculator = new CalculatorServiceImpl(); 
		do {
			try {
				System.out.println("Enter Arthematic expression to Evaluate: (PRESS \"CLOSE\" TO EXIT) \n");
				String input = new Scanner(System.in).nextLine();
				if (input.equalsIgnoreCase("CLOSE")) break;
				//calling evaluation method
				calculator.evaluateExpression(input);
			} catch (BussinessException ex) {
				System.out.println(ex.getMessage());
				calculator.flushStacks();
			} catch (Exception ex) {
				System.out.println("UnHandled Exception");
				calculator.flushStacks();
			}
		}while (true);
		System.out.println("Application closed");

	}

}
