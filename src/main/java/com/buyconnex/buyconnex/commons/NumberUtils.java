package com.buyconnex.buyconnex.commons;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {
	/** Regex pour séparer les milers dans les nombres **/
	
	private static final String SEPARATEUR_MILIERS_PATTERN = "(\\d{1,3})(?=(\\d{3})+(?!\\d))";
	
	public static Integer notNull(Integer value) {
		return value == null ? 0 : value;
	}
	
	public static BigDecimal notNull(BigDecimal value) {
		return value == null ? BigDecimal.ZERO : value;
	}
	
	public static Integer castToInteger(Long value) {
		return Math.toIntExact(value);
	}
	
	public static Integer castToInteger(String value) {
		if(value.contains(".")) {
			return Integer.parseInt(value.substring(0, value.indexOf('.')));
		} else {
			return Integer.parseInt(value);
		}
	}
	
	/**
	 * Retourne un BigDecimal arrondi au million près
	 */
	public static BigDecimal roundMontantToMillion(BigDecimal value) {
		if(value == null) {
			return null;
		} else {
			return value.divide(new BigDecimal(1000000), 2, RoundingMode.HALF_UP);
		}
	}
	
	/**
	 * Retourne un BigDecimal arrondi au milier près
	 */
	public static BigDecimal roundMontantToKilo(BigDecimal value) {
		if(value == null) {
			return null;
		} else {
			return value.divide(new BigDecimal(1000), 2, RoundingMode.HALF_UP);
		}
	}
	
	/**
	 * Retourne un BigDecimal arrondi au milier près
	 */
	public static boolean isNumber(String s) {
		try {
			s = s == null ? s : s.replace(',', '.');
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Retourne un BigDecimal arrondi au milier près
	 */
	public static BigDecimal castToBigdecimal(Object value) {
		if(value == null) {
			return null;
		} else {
			if(value instanceof Integer) {
				return new BigDecimal((Integer) value);
			} else if(value instanceof Long) {
				return new BigDecimal((Long) value);
			} else if(value instanceof String) {
				return new BigDecimal((String) value);
			}
			return (BigDecimal) value;
		}
	}
	
	/**
	 * Formater un BigDecimal en mettant des espaces comme séparateurs de miliers
	 */
	public static String formatAmount(BigDecimal number) {
		return number.setScale(2).toString().replaceAll(SEPARATEUR_MILIERS_PATTERN, "$1 ");
	}
}
