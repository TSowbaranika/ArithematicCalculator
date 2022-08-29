package com.calci.enums;

/**
 * Enumeration to identify the Arithmetic Operands Value
 * 
 * @author SowbaranikaT
 *
 */
public enum OperandsEnum {

	ADDITION('+'), SUBTRACTION('-'), MULTIPLICATION('*'), DIVISION('/');

	public final Character value;

	OperandsEnum(Character value) {
		this.value = value;
	}

	/**
	 * 
	 * @param value Holds the Arithmetic Symbol
	 * @return Returns the value of Arithmetic enum value.
	 */
	public static OperandsEnum getEnumNameForValue(char value) {
		OperandsEnum[] values = OperandsEnum.values();
		Character enumValue = null;
		for (OperandsEnum eachValue : values) {
			enumValue = eachValue.value;

			if (enumValue == value) {
				return eachValue;
			}
		}
		return null;
	}

}
