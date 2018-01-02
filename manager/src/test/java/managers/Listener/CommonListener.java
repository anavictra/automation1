package managers.Listener;

import org.junit.runner.Description;
import org.junit.runner.Result;

public class CommonListener {

    public void testStarted(Description description) {

        System.out.println("\n\n\nStarting .... " + description.getMethodName());
    }

    public void testFinished(Description description) {

        System.out.println("Finished .... " + description.getMethodName());
    }

    public void testRunFinished(Result result) {

        System.out.println("\n\n");
    }
}
