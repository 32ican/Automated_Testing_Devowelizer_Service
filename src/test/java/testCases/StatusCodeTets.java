package testCases;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataGeneration.ExcelReader;
import io.restassured.response.Response;


public class StatusCodeTets extends BaseTest {

	@Test
	public void testStatusCode() throws IOException{
		
		String input = ExcelReader.getCellFromTestCases(1,3).toString();
		int expectedStausCode = (int) Double.parseDouble(ExcelReader.getCellFromTestCases(1, 4).toString());

		Response response = given().get(input);
		response.print();
		Assert.assertEquals(response.getStatusCode(), expectedStausCode);
	}
	
}
