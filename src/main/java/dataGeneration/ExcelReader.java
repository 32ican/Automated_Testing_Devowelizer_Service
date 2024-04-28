package dataGeneration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private static String excelFilePath = System.getProperty("user.dir") + "\\resources\\testCases.xlsx";

	public static Cell getCellFromTestCases(int row, int col) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook(excelFilePath);
		XSSFSheet sheet = workbook.getSheet("TestCases");

		Cell cell = sheet.getRow(row).getCell(col);
		return cell;
	}

	public static Object[][] getData() throws IOException {
		List<Object[]> testData = new ArrayList<>();
		XSSFWorkbook workbook = new XSSFWorkbook(excelFilePath);
		XSSFSheet sheet = workbook.getSheet("testData");

		for (Row row : sheet) {
			Cell testName = row.getCell(0);
			Cell inputCell = row.getCell(1);
			Cell expectedCell = row.getCell(2);
			
			if (inputCell != null && expectedCell != null) {
				String input = inputCell.toString();
				String expected = expectedCell.toString();
				String testCase = testName.toString();
				
				testData.add(new Object[] {testCase, input, expected});
			}
		}
		
		return testData.toArray(new Object[testData.size()][]);
	}
	
	

}
