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

    @DataProvider(name = "fillDataApi")
    public static Object[][] fillDataApi() {
        return new Object[][]{

//                {"CE", "446444"},
//                {"CE", "673434"},
//                {"CE", "415319"},
//                {"CE", "604626"},
//                {"CE", "1007413"},
//                {"CC", "80163761"},
//                {"CC", "91156652"},
//                {"CE", "446444"},
//                {"CC", "79562819"},
//                {"CC", "79562819"},
//                {"CC", "79562819"},
//                {"CE", "382429"},
//                {"CC", "1010169616"},
//                {"CC", "1010179176"},
//                {"CC", "1020750217"}, //
//                {"CC", "79826658"},
//                {"CC", "17976879"},
//                {"CC", "63477452"},
//                {"CC", "1030547999"}, //
//                {"CC", "10867250341017"},
//                {"CC", "79562819"},//funciona
//                {"CC", "79492132"},//funciona
//                {"CC", "1086725034"},
//                {"CC", "1026564175"}, //funciona
//                {"CC", "10193973"},
//                {"CC", "1030691913"}, //funciona
//                {"CC", "52775031"},
//                {"CC", "547911"},
//                {"CC", "51660655"},
//                {"CC", "52526685"}, //funciona
//                {"CC", "52966724"},
//                {"CC", "52775031"},
//                {"CC", "53054049"},

//
                //Moducacion cupo
//                {"CC", "1030533215"},
//                {"CC", "673434"},
//                {"CC", "9154736"},
//                {"CC", "7277260"},
//                {"CC", "1054551595"},
//                {"CC", "79562819"},   //funciona Vida crediticia Fija
//                {"CC", "79492132"},   //funciona Vida crediticia Fija
//                {"CC", "1100519"}, //funciona Cupo Normal Fija y Variable ///paila
//                {"CC", "2968928"}, //funciona Cupo Variable Fija y Variable
//                {"CC", "1108454611"}, //Subsidio

                /// Listas
//                {"CC", "1067941636"},
//                {"CC", "72207142"},
//                {"CC", "1102831728"},
//                {"CC", "1065010752"},
//                {"CC", "1065607489"},
//                {"CC", "94475046"},
//                {"CC", "1047400320"},
//                {"CC", "72436687"},
//                {"CC", "72283478"},
//                {"CC", "105240157"},
//                {"CC", "1123629556"},
//                {"CC", "1047389785"},
//                {"CC", "78105559"},
//                {"CC", "1127390822"},
//                {"CC", "1116542995"},
//                {"CC", "12539317"},
//                {"CC", "1057600790"},
//                {"CC", "1193155397"},
//                {"CC", "85150335"},
//                {"CC", "1115063173"},
//                {"CC", "8785061"},
//                {"CC", "72241658"},
//                {"CC", "1129581984"},
//                {"CC", "1047454369"},
//                {"CC", "72161941"},
//                {"CC", "1082930788"},
//                {"CC", "1116862251"},
//                {"CC", "1122725463"},
//                {"CC", "15174286"},
//                {"CC", "22617913"},
//                {"CC", "17868381"},
//                {"CC", "1121889890"},
//                {"CC", "1121879720"},
//                {"CC", "1120577063"},
//                {"CC", "74380981"},
//                {"CC", "1143235673"},
//                {"CC", "2234357"},
//                {"CC", "28741560"},
//                {"CC", "9816684"},
//                {"CC", "71985817"},
//                {"CC", "94416735"},
//                {"CC", "3174667"},
//                {"CC", "20064816"},
//                {"CC", "43059701"},
//                {"CC", "52187092"},
//                {"CC", "2690939"},
//                {"CC", "17647267"},
//                {"CC", "4584739"},
//                {"CC", "43620290"},
//                {"CC", "79988339"},
//                {"CC","1104637957"},
//                {"CC", "1010169616"},
//                {"CC", "79826658"},
//                {"CC","1104637957"},
//                {"CC","1104638007"},
//                {"CC","1104638007"},
//                {"CC","1104638003"},
//                {"CC","4119384"},
//                {"CC","1007295347"},
//                {"CC","53119321"},
//                {"CC","39762639"},
//                {"CC","39762639"},   // Funciona
//                {"CC","7617444"},
//                {"CC","1023013419"},
//                {"CC","80796433"},
//                {"CC","79278366"},
//                {"CC","52518990"},
//                {"CC","39762639"},   // Funciona
//                {"CC","1094913008"},
//                {"CC","1014252100"},
//                {"CC","79366788"},
//                {"CC","1013622493"},
//                {"CC","80925970"},
//                {"CC","79121567"},
//                {"CC","7617444"},    // duplicate
//                {"CC","1069752939"},
//                {"CC","53108591"},
//                {"CC","1023921421"},
//                {"CC","1018455124"},
//                {"CC","1024558557"},
//                {"CC","1020713022"},
//                {"CC","1032419857"},
//                {"CC","1065649902"},
//                {"CC","35531236"},
//                {"CC","1070954331"},
//                {"CC","1110491361"},
//                {"CC","1073157423"},
//                {"CC","1072494265"},
//                {"CC","39813864"},
//                {"CC","52013437"},   // rango edad
//                {"CC","1018420554"}, // rango meses en la empresa
//                {"CE","600956"},     // tiene limite edad
//                {"CC","401483"},     // listas restrictivas x
//                {"CC","467970"},     // listas restrictivas
//                {"CC","20739675"},   // angie users
//                {"CC","93341102"},   // menos del salario mínimo
//                {"PA","95123024932"},// pasaporte
//                {"PT","96062406280"},// temporal
//                {"CC","19246507"},   // estados redenan
//                {"CC","1024539415"}, // temporal
//                {"CC","1030691913"}, // temporal
//                {"CC","94379336"}
//                {"CC", "19184974"},
//                {"CC", "1026276044"},
//                {"CC", "36496078"},


                /// ///////////////
//                {"CC", "1030691913"},
//                {"CC", "1012434884"},
//                {"CC", "1015410690"},
//                {"CC", "1012434884"},
//                {"CC", "1015445931"},
//                {"CC", "1049564184"},
//                {"CC", "1116433032"},
//                {"CC", "1130675547"},
//                {"CC", "12539777"},
//                {"CC", "16361849"},
//                {"CC", "16495202"},
//                {"CC", "16536885"},
//                {"CC", "16540154"},
//                {"CC", "16549265"},
//                {"CC", "16670949"},
//                {"CC", "16789461"},
//                {"CC", "17636441"},
//                {"CC", "18514924"},
//                {"CC", "18595577"},
//                {"CC", "19479324"},
//                {"CC", "6000305"},
//                {"CC", "72041856"},
//                {"CC", "77030697"},
//                {"CC", "79153157"},
//                {"CC", "79276198"},
//                {"CC", "79309826"},
//                {"CC", "80009997"},
//                {"CC", "8025874"},
//                {"CC", "86056233"},
//                {"CC", "93133209"},
//                {"CC", "98557816"},
//                {"CC", "98560559"},
//                {"CE", "345760"},
//                {"CE", "380400"},
//                {"CE", "983718"}


                // ——— ascards validations———
//                {"CC", "19184974"},   //K FUNCIONA TODO: VALIDAR
//                {"CC", "10216105"},   //Funciona
//                {"CC", "52526685"},   //O funciona
//                {"CC", "80833648"},   //C
//                {"CC", "10216105"},   //RANGO EDAD
//                {"CC", "1023944601"}, //Y funciona
//                {"CC", "19246507"},   //M
//                {"CC", "1024539415"}, //CONTRASEÑA INCORRECTA
//                {"CC", "51951303"},   //CONTRASEÑA INCORRECTA
//                {"CC", "1013595547"}, //titular no afiliado
//                {"CC", "1040111207"}, //CONTRASEÑA INCORRECTA
//                {"CC", "52634111"},   //CONTRASEÑA INCORRECTA
//                {"CC", "37713491"},   //L TODO: BUG
//                {"CC", "51736584"},   //no está afiliado
//                {"CC", "79584194"},   //R
//                {"CC", "547911"},     //B
//                {"CC", "80810798"},   //tarjeta mal
//                {"CC", "28917807"},   //F
//                {"CC", "52429413"},   //tarjeta mal
//                {"CC", "20156603"},   //no tiene contraseña
//                {"CC", "80179000"},   //validar muestra error generico
//                {"CC", "1016051607"}, //validar muestra error generico amparado
//                {"CC", "51951303"},   //no está afiliado, RETIRADO
//                {"CC", "1040111204"}, //estado T
//                {"CC", "1030636396"}, //estado T
//                {"CC", "1097397286"}, //estado T
//                {"CC", "1140814422"}, //estado Z
//                {"CC", "11259747"},   //estado J
//                {"CC", "41336668"},   //estado J


                ///SIFFF
//                Corriente 1    SI
//                Vencido 2      NO
//                Base Cero 3       NO
//                Deudas de dudoso recaudo 4    NO
//                Deudas de dudoso recaudo 5    NO
//                Deudas de dudoso recaudo 6    NO
//                Deudas de dudoso recaudo 7    NO
//                CANCELADO 900     SI
//                CASTIGADO 901     NO
//                CASTIGADO 10     SI

/// /////////////////////

//                {"CC", "1004921429"},     //Estado 2 x
//                {"CC", "1069734918"},   //Estado 1 x
//                {"CC", "38140673"},   //Estado 1 x
//                {"CC", "1018475123"},   //Estado 6 x
//                {"CC", "79301399"},   //900 NO tiene tarjeta
//                {"CC", "1022366366"},   //estado 901 tiene tarjeta
//                {"CC", "1016080743"},   //Estado 3 tiene tarjeta
//                {"CC", "1235339266"},    //Estado 5 tiene tarjeta
//                {"CC", "1122651592"},   //Estado 3 tiene tarjeta
//
//                {"CC", "1022329396"},   //estado 901
//                {"CC", "1102842070"},   //estado 3
//                {"CC", "1014195485"},   //estado 901
//                {"CC", "75103224"},   //estado 901
//                {"CC", "1069734918"},   //estado 901
//                {"CC", "1018475123"},   //estado 3
//                {"CC", "1030597301"},   //estado 901
//                {"CC", "1090438416"},   //estado 901
//                {"CC", "1026572621"},   //Cancelado 900 OK
//                {"CC", "1033778271"},   //Cancelado 900 OK
//                {"CC", "38140673"},   //Vencido 2 INVALID REQUIREMENTS
//                {"CC", "79941488"},   //Cancelado  900 INVALID REQUIREMENTS
//                {"CC", "1022366366"},   //Castigado 901 INVALID REQUIREMENTS
//                {"CC", "1016040256"},   //Base Cero 3 INVALID REQUIREMENTS
//                {"CC", "3188084"},      //Cancelado 900 OK
//                {"CC", "79947963"},     //Castigado 901 INVALID REQUIREMENTS
//                {"CC", "51782912"},     //NO tarjeta
//                {"CC", "1004921429"},     //Estado 1
//                {"CC", "26009337"},     //Estado 6
//                 Estado 3
//                {"CC", "52015092"},
//                {"CC", "52085696"},
//                {"CC", "79301399"},
//                {"CC", "79604965"},

//                 Estado 4
//                {"CC", "1120924374"}, //

                /// ///////////////////////////////////New codes
//                {"CC", "13617086"},   // Code A
//                {"CC", "52970147"},   // Code B
//                {"CC", "53090127"},   // Code C
//                {"CC", "79209440"},   // Code D
//                {"CC", "79837324"},   // Code F
//                {"CC", "52784932"},   // Code G
//                {"CC", "79528108"},   // Code I
//                {"CC", "35414229"},   // Code J
//                {"CC", "79449686"},   // Code K
//                {"CC", "37713491"},   // Code L
//                {"CC", "41478750"},   // Code M
//                {"CC", "51683314"},   // Code N
//                {"CC", "1095915781"}, // Code O
//                {"CC", "55169220"},   // Code P
//                {"CC", "79560689"},   // Code R
//                {"CC", "5322900346"}, // Code T
//                {"CC", "51760693"},   // Code V
//                {"CC", "20202266"},   // Code W
//                {"CC", "20500981"},   // Code Y
//                {"CC", "20156603"},   // Code 1
//                {"CC", "31937142"},   // Code 2
//                {"CC", "32557892"},   // Code 3
//                {"CC", "51810488"},   // Code 7
//                {"CC", "79143841"},   // Code 9

//                {"CC", "51646912"},    // Code 3 - PERDIDA
//                {"CC", "51815492"},    // Code 7 - CAMBIO DE CLAVE OBLIGATORIO
//                {"CC", "41454221"},    // Code 2 - ROBADA
//                {"CC", "80141342"},    // Code 2-I - TARJETA ROBADA / CUPO INACTIVO
//                {"CC", "39581030"},    // Code 2-V - TARJETA ROBADA / CUPO DEVOLUCIÓN VOLUNTARIA
//                {"CC", "51606592"},    // Code 4 - BLOQUEO PREVENTIVO COLSUBSIDIO
//                {"CC", "52966724"},    // Code 0 - PENDIENTE POR ACTIVAR
//                {"CC", "1097397286"},  // Code S - SOBRECUPO / SUSPENDIDO

 ///////////data aprobados en firme y preaprobados

//                {"CC", "1040111207"},   // PREAPROBADO CUPO NORMAL NO VIGENTE
//                {"CC", "1075662894"},   // OFERTA EN FIRME INICIA TU VIDA CREDITICIA NO VIGENTE
//                {"CC", "80764109"},     // OFERTA EN FIRME CUPO NORMAL NO VIGENTE
//                {"CE", "256726"},       // OFERTA EN FIRME CUPO NORMAL VIGENTE CE
//                {"CE", "281111"},       // OFERTA EN FIRME CUPO NORMAL NO VIGENTE CE
//                {"CE", "285632"},       // PREAPROBADO CONSUMO VIGENTE SIN PREAPROBADO CUPO
//                {"CE", "304706"},       // PREAPROBADO CUPO NORMAL VIGENTE
//                {"CC", "52544835"},     // OFERTA EN FIRME CUPO NORMAL VIGENTE Y PREAPROBADO CUPO NORMAL NO VIGENTE
//                {"CC", "192492"},       // OFERTA EN FIRME CUPO NORMAL VIGENTE
//                {"CC", "1003844571"},   // OFERTA EN FIRME CUPO NORMAL VIGENTE
//                {"CC", "1023940045"},   // OFERTA EN FIRME CUPO SUBSIDIO NO VIGENTE
//                {"CC", "1003908455"},   // OFERTA EN FIRME CUPO NORMAL VIGENTE Y OFERTA EN FIRME CUPO SUBSIDIO NO VIGENTE
//                {"CE", "343929"},   // OFERTA EN FIRME CUPO NORMAL VIGENTE Y OFERTA EN FIRME CUPO SUBSIDIO NO VIGENTE

//                {"CC", "10151820"},
//                {"CC", "1003844571"}, // OFERTA EN FIRME CUPO SUBSIDIO VIGENTE
//                {"CC", "1003635154"}, // OFERTA EN FIRME BAJO MONTO VIGENTE
//                {"CC", "286454"},     // PREAPROBADO CUPO SUBSIDIO VIGENTE
//                {"CC", "368882"}      // PREAPROBADO BAJO MONTO VIGENTE



//                {"CC", "1075662894"}, //56 INICIA TU VIDA CREDITICIA(195) y 56 inicia Vida crediticia(2600), diferente cupo
//                {"CC", "1003844571"}, //56 INICIA TU VIDA CREDITICIA(195) y 56 inicia Vida crediticia(2600), diferente cupo
//                {"CC", "1075662894"},

//                {"CC", "1003844571"},
//                {"CC", "1023940045"}, //55 cupo subisidio y 56 vida crediticia
//                {"CC", "1003908455"},
//                {"CC", "91156652"},
//                {"CC", "1048847599"},

                {"CC", "1003908455"},
                {"CE", "384185"},
                {"CE", "256726"},

        };
    }
}