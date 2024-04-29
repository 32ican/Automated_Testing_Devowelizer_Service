package testCases;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import base.Retry;
import dataGeneration.ExcelReader;
import io.restassured.response.Response;

public class DevowelizerServiceGetInputTest extends BaseTest {
	
	/**
	Executes the test cases for the Devowelizer service using the provided test data from excel.
	Retries the test if it fails, up to a maximum number of retries defined by the Retry analyzer (3).
	@param testName The name of the test case.
	@param input The input string to be processed by the Devowelizer service.
	@param expectedOutput The expected output after processing the input string.
	@throws Exception If an error occurs during test execution.
	*/
	@Test(dataProvider = "testData",
			retryAnalyzer = Retry.class)
	public void testDevowelizerGetInput(String testName, String input, String expectedOutput) throws Exception{
	
		Response response = given().pathParam("input", input).when().get("/{input}");
		response.print();
		System.out.println(testName);
		
		Assert.assertEquals(expectedOutput, response.asString());
	
	}
	

	/**
	Provides test data for the test cases by reading it from an Excel file.
	@return A two-dimensional array containing the test data.
	*/
	@DataProvider(name = "testData")
    public Object [][] provideTestData() throws IOException {      
        return ExcelReader.getData();
    }

}
