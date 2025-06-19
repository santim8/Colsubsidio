package execution.data;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

    @DataProvider(name = "fillTheCheckoutStepOne")
    public static Object[][] fillTheCheckoutStepOne() {
        return new Object[][]{  
                {
                        "1023013419",
                        "Colsubsidio2025.",
                        "3001234567",
                        "santiagocorea200@gmail.com"
                },
                {
                        "1023013504",
                        "Colsubsidio2025.",
                        "3001234567",
                        "santiagocorea200@gmail.com"
                }
        };
    }
}
