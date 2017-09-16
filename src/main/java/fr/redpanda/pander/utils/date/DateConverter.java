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
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(date);
		} else {
			return null;
		}
	}

	/**
	 * Date parser
	 * 
	 * @param date
	 * @return
	 */
	public static String getMySqlDatetime(Date date) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(date);
		} else {
			return null;
		}
	}

	/**
	 * Date parser
	 * 
	 * @param date
	 * @return
	 */
	public static String getDate(Date date) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			return sdf.format(date);
		} else {
			return null;
		}
	}
}
