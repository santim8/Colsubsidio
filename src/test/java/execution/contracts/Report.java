package execution.contracts;

import com.aventstack.extentreports.Status;

public interface Report {

    public void setTest(String testName);
    public void sendLog(Status status, String message);
}
