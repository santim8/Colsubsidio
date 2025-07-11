package execution.data;

import org.testng.annotations.DataProvider;

/**
 * Utility class that provides test data for various test scenarios
 * This class contains DataProviders that can be used across different test classes
 */
final public class DataProviderUtil {

    private DataProviderUtil() {
    }

    /**
     * DataProvider for checkout form test cases
     * Provides test data for user registration SSO
     * Each row contains:
     * - Identification number (documento de identidad)
     * - Password
     * - Phone number
     * - Email address
     * - Test case description
     *
     * @return Object[][] containing test data for multiple users
     */
    @DataProvider(name = "fillTheCheckoutStepOne")
    public static Object[][] fillTheCheckoutStepOne() {
        return new Object[][]{
//                {
//                        "1023013419",
//                        "Colsubsidio2025.",
//                        "3001234567",
//                        "caritopruebas1@hotmail.com",
//                },
//                {
//                        "1023013504",
//                        "Colsubsidio2025.",
//                        "3001234567",
//                        "yenisitapruebas@hotmail.com",
//                },
//                {
//                        "1104637957",
//                        "Colsubsidio2025.",
//                        "3001234567",
//                        "prueba11@punkproof.com",
//                },
//                {
//                        "1104638007",
//                        "Colsubsidio2025.",
//                        "3001234567",
//                        "prueba2@punkproof.com",
//                },
//                {
//                        "1104638003",
//                        "Colsubsidio2025.",
//                        "3001234567",
//                        "prueba1@punkproof.com",
//                },
//                {
//                        "4119384",
//                        "Colsubsidio2025.",
//                        "3001234567",
//                        "pruebapru1@punkproof.com",
//                },
//                {
//                        "1007295347",
//                        "Colsubsidio2025.",
//                        "3001234567",
//                        "pruebapru3@punkproof.com",
//                },
//                {
//                        "53119321",
//                        "Colsubsidio2025.",
//                        "3001234567",
//                        "pruebapru4@punkproof.com",
//                }
                {
                        "52013437",
                        "Colsubsidio2025.",
                        "3001234567",
                        "pruebapru3@punkproof.com",
                },
        };
    }
}