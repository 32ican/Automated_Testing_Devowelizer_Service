package testCases;

import static io.restassured.RestAssured.given;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Retry;
import dataGeneration.ExcelReader;
import dataGeneration.HugeInputGenerator;
import io.restassured.response.Response;

public class HugeInputTest {

	@Test(retryAnalyzer = Retry.class)
	public void testHugeIputString() throws  IOException {
		
		String input = HugeInputGenerator.getHugeInput();
		int expectedStausCode = (int) Double.parseDouble(ExcelReader.getCellFromTestCases(14, 4).toString());

		Response response = given().get(input);
		response.print();
		Assert.assertEquals(response.getStatusCode(), expectedStausCode);
	}

}
