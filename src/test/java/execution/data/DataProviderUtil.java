package execution.data;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

    @DataProvider(name = "fillTheCheckoutStepOne")
    public static Object[][] fillTheCheckoutStepOne() {
        return new Object[][]{
                {
                        "Santiago",
                        "Correa",
                        "23114"
                }
        };
    }
}
