package execution.magnifie;

import com.globant.aut.sdk.builder.MagnifAI;
import java.io.File;
import java.math.BigDecimal;
import static org.testng.Assert.assertEquals;

public class MagnifaiMethods {

    public static void flexCompare(
            File inputImage,
            File baseImage,
            BigDecimal minSimilarity,
            String testName
    ) {
        try {
            var magnifaiResponse = MagnifAI.builder()
                    .executionId(MagnifaiManager.EXECUTION_ID)
                    .testName(testName)
                    .baselineImage(baseImage)
                    .inputImage(inputImage)
                    .minSimilarity(minSimilarity)
                    .build()
                    .flexCompare();

            System.out.println("Response Status Code: " + magnifaiResponse.getHttpStatusCode());
            System.out.println("Response Body: " + magnifaiResponse.getResultResponse());

            assertEquals(magnifaiResponse.getHttpStatusCode(), 200);
            assertEquals(magnifaiResponse.getResultResponse().getStatus(), "Passed");
            if (magnifaiResponse.getHttpStatusCode() == 200) {
                BigDecimal tin = magnifaiResponse.getResultResponse().getFlexCompare().getObtainedSimilarity();
                String assetId = magnifaiResponse.getResultResponse().getFlexCompare().getResultImage();
                MagnifaiManager.attachResultImage(assetId, "Flex_Compare_Result_Image", tin);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
