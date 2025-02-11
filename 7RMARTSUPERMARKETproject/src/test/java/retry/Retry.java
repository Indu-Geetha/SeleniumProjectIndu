package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 2;              //to re-execute the test cases 2 times

	public boolean retry(ITestResult result) {

		if (counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
