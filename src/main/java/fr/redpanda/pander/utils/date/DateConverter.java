package fr.redpanda.pander.utils.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

	/**
	 * Date parser
	 * 
	 * @param date
	 * @return
	 */
	public static String getMySqlDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return date != null ? sdf.format(date) : null;
	}

	/**
	 * Date parser
	 * 
	 * @param date
	 * @return
	 */
	public static String getMySqlDatetime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return date != null ? sdf.format(date) : null;
	}

	/**
	 * Date parser
	 * 
	 * @param date
	 * @return
	 */
	public static String getDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return date != null ? sdf.format(date) : null;
	}
}
