package dataGeneration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	// Path to the excel.xlsx file
	private static String excelFilePath = System.getProperty("user.dir") + "\\resources\\testCases.xlsx";

	/**
	 * 
	 * Retrieves a specific cell from the "TestCases" sheet in the testCases.xlsx
	 * Excel file.
	 * 
	 * @param row The row index of the cell.
	 * @param col The column index of the cell.
	 * @return The cell located at the specified row and column indices.
	 */
	public static Cell getCellFromTestCases(int row, int col) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook(excelFilePath);
		XSSFSheet sheet = workbook.getSheet("TestCases");

		Cell cell = sheet.getRow(row).getCell(col);
		return cell;
	}

	/**
	 * 
	 * Retrieves test data from the "testData" sheet in the testCases.xlsx Excel
	 * file. Each row in the sheet represents a test case with three columns: test
	 * name, input, and expected output.
	 * 
	 * @return A two-dimensional array containing the test data, where each row
	 *         represents a test case.
	 */
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

				testData.add(new Object[] { testCase, input, expected });
			}
		}

		return testData.toArray(new Object[testData.size()][]);
	}

}
