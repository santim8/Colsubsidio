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
     * "CC", CEDULA_CIUDADANIA
     * "TI", TARJETA_IDENTIDAD
     * "RC", REGISTRO_CIVIL
     * "CE", CEDULA_EXTRANJERIA
     * "CD", CARNE_DIPLOMATICO
     * "PA", PASAPORTE
     * "PE", PERMISO_ESPECIAL_PERMANENCIA
     * "PT", PERMISO_PROTECCION_TEMPORAL
     * - Identification number (documento de identidad)
     * - Password
     * - Phone number
     * - Email address
     * - Test case description
     *
     * @return Object[][] containing test data for multiple users
     */

    @DataProvider(name = "fillTheCheckoutStepOne2")
    public static Object[][] fillTheCheckoutStepOne2() {
        return new Object[][]{
//                {"CC","1104637957", "Colsubsidio2025.", "3001234567", "test1@hotmail.com"},
//                {"CC","1104637957", "Colsubsidio2025.", "3001234567", "test1@hotmail.com"},
//                {"CC","1104638007", "Colsubsidio2025.", "3001234567", "test2@hotmail.com"},
//                {"CC","1104638007", "Colsubsidio2025.", "3001234567", "test2@hotmail.com"},
//                {"CC","1104638003", "Colsubsidio2025.", "3001234567", "test3@hotmail.com"},
//                {"CC","4119384", "Colsubsidio2025.", "3001234567", "test4@hotmail.com"},
//                {"CC","1007295347", "Colsubsidio2025.", "3001234567", "test5@hotmail.com"},//TODO preaprobado
//                {"CC","53119321", "Colsubsidio2025.", "3001234567", "test6@hotmail.com"}, //TODO preaprobado
//                {"CC","39762639", "Colsubsidio2025.", "3001234567", "test6@hotmail.com"}, //TODO modificacion
//                {"CC","39762639", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"}, //TODO modificacion de cupo
//                {"CC","7617444", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"}, //TODO modificacion de cupo
//                {"CC","1023013419", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},//TODO
//                {"CC", "80796433", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"}, //no tiene preaprobado
//                {"CC","79278366", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},//no tiene preaprobado TODO: funciona
//                {"CC","52518990", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","39762639", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"}, //TODO modificacion de cupo
//                {"CC","1094913008", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"}, //tiene solicitud en curso
//                {"CC","1014252100", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},//tiene solicitud en curso
//                {"CC","79366788", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},// no-afiliado
//                {"CC","1013622493", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},// no-afiliado  ....
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
//                {"CC","1110491361", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","1073157423", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","1072494265", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","39813864", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},
//                {"CC","52013437", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"} rango edad
//                {"CC","1018420554", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"}, rango meses en la empresa
//                {"CE", "600956", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"}, //tiene limite edad
//                {"CC", "401483", "Colsubsidio2025.", "pruebalistasres@mechanicspedia.com", "2/02/1994"}, //lista restricitivas x
//                {"CC", "467970", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //lista restritivas
//                {"CC", "20739675", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //angie users
//                {"CC", "93341102", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //con menos del salario minimon
//                {"PA", "95123024932", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //pasaporte
//                {"PT", "96062406280", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //temporal
//                {"CC", "19246507", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //estados redenan
//                {"CC", "1024539415", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //temporal
//                {"CC", "1030691913", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //temporal
//                {"CC", "94379336", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //temporal
        };
    }

    @DataProvider(name = "fillTheCheckoutStepOne")
    public static Object[][] fillTheCheckoutStepOne() {
        return new Object[][]{
                {"CC", "79278366", "Colsubsidio2025.", "3001234567", "caritopruebas1@hotmail.com"},//no tiene preaprobado TODO: funciona
//                {"CC", "19184974", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //K
//                {"CC", "10216105", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, // V VALIDAR
//                {"CC", "52526685", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //NO
//                {"CC", "80833648", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //C
//                {"CC", "10216105", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //RANGO EDAD
//                {"CC", "1023944601", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //Y
//                {"CC", "19246507", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //M
//                {"CC", "1024539415", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //CONTRASEÑA INCORRECTA
//                {"CC", "51951303", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"},//CONTRASEÑA INCORRECTA
//                {"CC", "1013595547", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"},//titular no afiliado
//                {"CC", "1040111207", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //CONTRASEÑA INCORRECTA
//                {"CC", "52634111", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"},   //CONTRASEÑA INCORRECTA
//                {"CC", "37713491", "Colsubsidio2025.", "pruebalistasres1@mecha10216105 nicspedia.com", "2/02/1994"}, //L TODO: BUG
//                {"CC", "51736584", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //no está afiliado
//                {"CC", "79584194", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //R
//                {"CC", "547911", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //B
//                {"CC", "80810798", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //tarjeta mal
//                {"CC", "28917807", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //F
//                {"CC", "52429413", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"} //tarjeta mal
//                {"CC", "20156603", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //no tiene contraseña
//                {"CC", "80179000", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //validar muestra error generico
//                {"CC", "1016051607", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //validar muestra error generico amparado
//                {"CC", "51951303", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //no está afiliado, RETIRADO
//                {"CC", "1040111204", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //estado T
//                {"CC", "1030636396", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //estado T
//                {"CC", "1097397286", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //estado T
//                {"CC", "1140814422", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //estado Z
//                {"CC", "11259747", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //estado J
//                {"CC", "41336668", "Colsubsidio2025.", "pruebalistasres1@mechanicspedia.com", "2/02/1994"}, //estado J
        };
    }

    @DataProvider(name ="fillDataApi")
    public static Object[][] fillDataApi() {
        return new Object[][]{
//                {"CC", "1023013504"}, //
//                {"CC", "10867250341017"},
                {"CC", "1086725034"},
                {"CC", "1026564175"}, //funciona
                {"CC", "10193973"},
                {"CC", "1030691913"}
//                {"CC", "52775031"},

        };
    }
}