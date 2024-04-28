package testCases;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import base.Retry;
import dataGeneration.ExcelReader;
import io.restassured.response.Response;

public class DevowelizerServiceGetInputTest extends BaseTest {

  
	@Test(dataProvider = "testData",
			retryAnalyzer = Retry.class)
	public void testDevowelizerGetInput(String testName, String input, String expectedOutput) throws Exception{
	
		Response response = given().pathParam("input", input).when().get("/{input}");
		response.print();
		System.out.println(testName);
		
		Assert.assertEquals(expectedOutput, response.asString());
	
	}
	
	@DataProvider(name = "testData")
    public Object [][] provideTestData() throws IOException {      
        return ExcelReader.getData();
    }

}
