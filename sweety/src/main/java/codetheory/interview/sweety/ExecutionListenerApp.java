package codetheory.interview.sweety;

import org.testng.IExecutionListener;

import codetheory.interview.sweety.CommonFunctions.InvokeApplication;

public class ExecutionListenerApp implements IExecutionListener  {
	@Override
	public void onExecutionStart() {
		InvokeApplication.openApp();
	}

	@Override
	public void onExecutionFinish() {
		InvokeApplication.getDriver().quit();
	}

}
