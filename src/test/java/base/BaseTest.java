package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.testng.annotations.BeforeTest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

//	 The path to the configuration properties file.
	private String configFilePath = System.getProperty("user.dir") + "\\resources\\config.properties";

	/**
	 * 
	 * Sets up the test environment before executing any test methods. It builds a
	 * RequestSpecification with the base URI obtained from the config.properties
	 * file.
	 */
	@BeforeTest
	public void setup() {
		RequestSpecification spec = new RequestSpecBuilder().
				setBaseUri(getProperty("url")).
				build();
	}

	/**
	 * 
	 * Reads the property configuration file and retrieves the value associated with
	 * the specified key.
	 * 
	 * @param key The key whose associated value is to be retrieved.
	 * @return The value associated with the specified key, or null if the key is
	 *         not found.
	 */
	public String getProperty(String key) {

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(configFilePath));

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop.getProperty(key);

	}

}
