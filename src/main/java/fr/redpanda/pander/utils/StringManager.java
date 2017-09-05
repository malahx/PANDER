package fr.redpanda.pander.utils;

import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

import fr.redpanda.pander.entities.Role;
import fr.redpanda.pander.entities.TypeSkill;

public class StringManager {

	public static String firstLetterUpperCase(String toConvert) {
		if (toConvert.length() > 1) {
			return toConvert.substring(0, 1).toUpperCase() + toConvert.substring(1);
		} else {
			return toConvert.toUpperCase();
		}

	}

	public static String splitWords(String field) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < field.length(); i++) {
			Character ch = field.charAt(i);
			if (Character.isUpperCase(ch)) {
				stringBuilder.append(' ').append(Character.toUpperCase(ch));
			} else {
				stringBuilder.append(ch);
			}
		}
		return stringBuilder.toString();
	}

	public static String toTitle(String field) {
		String res = splitWords(field);
		res = firstLetterUpperCase(res);
		return res;
	}

	/**
	 * 
	 * @param role
	 *            the string to parse
	 * @return the role
	 */
	public static Role getRoleFrom(String role) {
		return role.equals(Role.CANDIDATE.toString()) ? Role.CANDIDATE
				: (role.equals(Role.COMPANY.toString()) ? Role.COMPANY : Role.ADMIN);
	}

	/**
	 * 
	 * @param type
	 *            the string to parse
	 * @return the type skill
	 */
	public static TypeSkill getTypeSkillFrom(String type) {
		return type.equals(TypeSkill.SOFT.toString()) ? TypeSkill.SOFT : TypeSkill.TECH;
	}

	/**
	 * @return
	 */
	public static String createString() {
		StringBuilder stringBuilder = new StringBuilder();
		int end = ThreadLocalRandom.current().nextInt(6, 12);
		for (int i = 0; i < end; i++) {
			int type = ThreadLocalRandom.current().nextInt(0, 3);
			stringBuilder.append(type == 0 ? (char) ThreadLocalRandom.current().nextInt(65, 90 + 1)
					: type == 1 ? (char) ThreadLocalRandom.current().nextInt(97, 122 + 1)
							: (char) ThreadLocalRandom.current().nextInt(48, 58));
		}
		return stringBuilder.toString();
	}
	
	public static boolean isEmail(String s) {
		return Pattern.matches("^[^@]{2,}?@[^@]{2,}\\.[^@.]{2,}$", s);
	}

}
