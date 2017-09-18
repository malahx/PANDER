/**
 * 
 */
package fr.redpanda.pander.test.databases.base;

import org.apache.commons.lang.SystemUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import fr.redpanda.pander.databases.base.DAO;
import fr.redpanda.pander.utils.ProcessManager;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public abstract class BaseMysql extends DAO {

	private static ProcessManager process;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if (SystemUtils.IS_OS_LINUX) {
			process = new ProcessManager(ProcessManager.START_MYSQL);
		} else {
			process = new ProcessManager(ProcessManager.WAMP);
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		if (SystemUtils.IS_OS_LINUX) {
			process.close(ProcessManager.STOP_MYSQL);
		} else {
			process.close();
		}
	}
}
