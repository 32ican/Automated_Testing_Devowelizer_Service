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

	private String configFilePath = System.getProperty("user.dir") + "\\resources\\config.properties";
	
	private String excelFilePath = System.getProperty("user.dir") + "\\resources\\testCases.xlsx";
	

	@BeforeTest
	public void setup() {
		RequestSpecification spec = new RequestSpecBuilder().
				setBaseUri(getProperty("url")).
				build();
	}
	
	public String getProperty(String key) {

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(configFilePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop.getProperty(key); 

	}
	

}















