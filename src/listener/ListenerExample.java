package listener;
//Shortcut of replace:Select the text--(clt+F)--Replace it by text or blank--Apply
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerExample implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
	System.out.println("testcase started with name "+result.getName());	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
    System.out.println("testcase passed with name "+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("testcase failed with name "+result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("testcase skipped with name "+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("suite started");
		//System.out.println("suite started"+context.getName());//suite startedDefault test	
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("suite finished");
		//System.out.println("suite finished"+context.getName());//suite finishedDefault test
		
	}

}
