/**
 * 
 */
package be.abc.bank.transaction.foundation;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * It is an utility class is used to supply the immediate required functions for
 * the service operations.
 * 
 * @author Renjith
 *
 */
public class ApplicationUtil {
	private static final Logger LOGGER = Logger.getLogger(ApplicationUtil.class);

	/**
	 * create an transaction number as per the system timestamp and the operation is
	 * locked for accessing other request at the same time
	 * 
	 * @return long
	 */
	public static String getTransNumber() {

		Date dateNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat(TransactionConstants.YYYYMMDDHHMMSSSS);
		String datetime = ft.format(dateNow);

		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			LOGGER.error(e);
		}
		return "ABC" + datetime;
	}

	/**
	 * get the current system time stamp
	 * 
	 * @return TimeStamp
	 */

	public static Timestamp currentTimeStamp() {
		Date date = new Date();
		return new Timestamp(date.getTime());
	}

}
