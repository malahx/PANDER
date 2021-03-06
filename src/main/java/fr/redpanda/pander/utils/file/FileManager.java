package fr.redpanda.pander.utils.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {
	public final static String FILE_SCHEME = "file://";
	public final static String URL_SCHEME = "http://";

	private ArrayList<String> content = new ArrayList<String>();
	private String path;
	private String fileName;
	private URI uri;

	/**
	 * 
	 * @return the content of a file
	 */
	public ArrayList<String> getContent() {
		return this.content;
	}

	/**
	 * 
	 * @return the URI of a file
	 */
	public URI getUri() {
		return this.uri;
	}

	/**
	 * The constructor from a file
	 * 
	 * @param path
	 * @param fileName
	 */
	public FileManager(String path, String fileName) {
		this.path = path;
		this.fileName = fileName;

		if (!this.path.endsWith(File.separator)) {
			this.path += File.separator;
		}
		try {
			this.uri = new URI(FILE_SCHEME + (new File(path + fileName).getAbsolutePath()
					.substring(2, new File(path + fileName).getAbsolutePath().length()).replace('\\', '/')));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The constructor from an URI
	 * 
	 * @param uri
	 */
	public FileManager(URI uri) {
		this.uri = uri;

	}

	/**
	 * Write the content to a file
	 *
	 * @param content
	 */
	public void writeToFile(ArrayList<String> content) {
		this.writeToFile(content, StandardOpenOption.APPEND);
	}

	public void writeToFile(ArrayList<String> content, StandardOpenOption openOption) {
		File file = new File(this.path);

		if (!file.exists()) {
			System.out.println("creating directory: " + this.path);
			boolean result = false;

			try {
				result = file.mkdirs();
			} catch (SecurityException se) {
				se.printStackTrace();
			}

			if (result) {
				System.out.println("DIR created");
			}
		}

		file = new File(this.path + this.fileName);
		Path writableFile = Paths.get(file.getAbsolutePath());

		try {
			file.createNewFile();
			Files.write(writableFile, content, Charset.forName("UTF-8"), openOption);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return load content from a file
	 */
	public ArrayList<String> loadFromFile() {
		String thisLine = null;
		try {
			FileReader myFile = new FileReader(path + fileName);
			// open input stream test.txt for reading purpose.
			BufferedReader br = new BufferedReader(myFile);
			while ((thisLine = br.readLine()) != null) {
				this.content.add(thisLine);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.content;
	}

	/**
	 * 
	 * @return extract datas from a default pattern
	 */
	public Map<String, Object> extractFromPattern() {
		Pattern p = Pattern.compile("(\\w+)=\"*((?<=\")[^\"]+(?=\")|([^\\s]+))\"*");
		return extractFromPattern(p);
	}

	/**
	 * extract datas from a pattern
	 * 
	 * @param p
	 * @return
	 */
	public Map<String, Object> extractFromPattern(Pattern p) {
		Map<String, Object> map = new HashMap<String, Object>();

		ArrayList<String> fileStrings = loadFromFile();

		for (String string : fileStrings) {
			Matcher m = p.matcher(string);
			while (m.find()) {
				map.put(m.group(1), m.group(2));
			}
		}

		return map;
	}
}
