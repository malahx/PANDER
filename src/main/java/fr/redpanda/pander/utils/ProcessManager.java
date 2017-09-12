/**
 * 
 */
package fr.redpanda.pander.utils;

import java.io.IOException;

/**
 * @author Gwénolé LE HENAFF
 *
 */
public class ProcessManager {

	public static final String START_MYSQL = "/bin/sudo /bin/systemctl start mariadb";
	public static final String STOP_MYSQL = "/bin/sudo /bin/systemctl stop mariadb";
	public static final String WAMP = "C:\\wamp64\\wampmanager.exe";

	private Process process;
	private String programName;

	public ProcessManager(String program) {
		programName = program;
		try {
			System.out.println("Opening " + program);
			Runtime runTime = Runtime.getRuntime();
			process = runTime.exec(program);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close(String program) {
		try {
			System.out.println("Closing with " + program);
			Runtime runTime = Runtime.getRuntime();
			process = runTime.exec(program);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		System.out.println("Closing " + programName);
		process.destroy();
	}

}
