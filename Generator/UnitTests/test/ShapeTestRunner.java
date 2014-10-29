package test;
import junit.framework.TestSuite;
import android.test.InstrumentationTestRunner;
import android.test.InstrumentationTestSuite;

public class ShapeTestRunner extends InstrumentationTestRunner {

    public TestSuite getAllTests(){
        InstrumentationTestSuite suite = new InstrumentationTestSuite(this);

        suite.addTestSuite(ShapeTest.class);
        return suite;
    }


    public ClassLoader getLoader() {
        return ShapeTestRunner.class.getClassLoader();
    }
}
