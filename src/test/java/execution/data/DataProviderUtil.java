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
     * - Document Type
     *      "CC", CEDULA_CIUDADANIA
     *      "TI", TARJETA_IDENTIDAD
     *      "RC", REGISTRO_CIVIL
     *      "CE", CEDULA_EXTRANJERIA
     *      "CD", CARNE_DIPLOMATICO
     *      "PA", PASAPORTE
     *      "PE", PERMISO_ESPECIAL_PERMANENCIA
     *      "PT", PERMISO_PROTECCION_TEMPORAL
     * - Identification number (documento de identidad)
     * - Password
     * - Phone number
     * - Email address
     * - Test case description
     *
     * @return Object[][] containing test data for multiple users
     */
    @DataProvider(name = "fillTheCheckoutStepOne1")
    public static Object[][] fillTheCheckoutStepOne1() {
        return new Object[][]{
                {
                        "1023013419",
                        "Colsubsidio2025.",
                        "3001234567",
                        "caritopruebas1@hotmail.com",
                },
                {
                        "1023013504",
                        "Colsubsidio2025.",
                        "3001234567",
                        "yenisitapruebas@hotmail.com",
                },
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


    @DataProvider(name = "fillTheCheckoutStepOne")
    public static Object[][] fillTheCheckoutStepOne() {
        return new Object[][]{

//                {"CC","1023013419", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","1023013504", "Colsubsidio2025.", "3001234567", "yenisitapruebas@hotmail.com"},
//                {"CC", "80796433", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"}, //no tiene preaprobado
//                {"CC","79278366", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","52518990", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","39762639", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","1094913008", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","1014252100", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","79366788", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},// no-afiliado
//                {"CC","80925970", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","79121567", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","7617444", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","1069752939", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","53108591", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","1023921421", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","1018455124", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","1024558557", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","1020713022", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","1032419857", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","1065649902", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","35531236", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","1070954331", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
                {"CC","1110491361", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","1073157423", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","1072494265", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","39813864", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","52013437", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"} rango edad
//                {"CC","1018420554", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"}, rango meses en la empresa
//                {"CE", "600956", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"}, //tiene limite edad
//                {"CC", "401483", "Colsubsidio2025.", "pruebalistasres@mechanicspedia.com", "2/02/1994"}, //lista restricitivas
//                {"CC", "467970", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //lista restritivas
//                {"CC", "20739675", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //angie users
        };
    }
}