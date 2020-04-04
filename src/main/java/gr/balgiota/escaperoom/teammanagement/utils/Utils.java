package gr.balgiota.escaperoom.teammanagement.utils;

import java.util.Collection;

public class Utils {

	public static boolean isLong(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			Long l = Long.parseLong(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static boolean isNullOrEmpty(final Collection<?> c) {
		return c == null || c.isEmpty();
	}

	public static boolean isDouble(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			Double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
