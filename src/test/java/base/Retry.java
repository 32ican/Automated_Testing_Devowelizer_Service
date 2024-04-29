package base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	
	private int retryCount = 0;
	private static final int MAX_RETRY_COUNT = 3;

	/**
	Determines whether to retry a test method based on the result of the previous attempt.
	@param result The result of the previous test execution.
	@return True if the test should be retried, false otherwise.
	*/
	public boolean retry(ITestResult result) {
		
		if (retryCount < MAX_RETRY_COUNT) {
			retryCount++;
			return true;
		}
		
		return false;
	}
}
