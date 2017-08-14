package fr.redpanda.pander.utils;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import fr.redpanda.pander.entities.Role;

public class StringManager {
	public static String firstLetterUpperCase(String toConvert) {
		if (toConvert.length() > 1) {
			return toConvert.substring(0, 1).toUpperCase() + toConvert.substring(1);
		} else {
			return toConvert.toUpperCase();
		}

	}

	public static String splitWords(String field) {
		String res = "";
		for (int i = 0; i < field.length(); i++) {
			Character ch = field.charAt(i);
			if (Character.isUpperCase(ch))
				res += " " + Character.toUpperCase(ch);
			else
				res += ch;
		}
		return res;
	}

	public static String toTitle(String field) {
		String res = splitWords(field);
		res = firstLetterUpperCase(res);
		return res;
	}

	/**
	 * 
	 * @param role the string to parse
	 * @return the role
	 */
	public static Role getRoleFrom(String role) {
		return role == Role.CANDIDATE.toString() ? Role.CANDIDATE
				: (role == Role.COMPANY.toString() ? Role.COMPANY : Role.ADMIN);
	}
}
