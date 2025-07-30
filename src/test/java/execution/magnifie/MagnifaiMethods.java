package execution.magnifie;

import com.globant.aut.javacore.validators.exceptions.AugmentedException;
import com.globant.aut.sdk.builder.MagnifAI;
import reports.ExtentLogger;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import static org.testng.Assert.assertEquals;

public class MagnifaiMethods {

    /**
     * This test is an example of the Flex Compare test type.
     * This test allows users to compare images without depending on the sizes or dimensions
     */
    public static void figmaCompare(
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
                BigDecimal resultComparison = magnifaiResponse.getResultResponse().getFlexCompare().getObtainedSimilarity();
                String assetId = magnifaiResponse.getResultResponse().getFlexCompare().getResultImage();
                MagnifaiManager.attachResultImage(assetId, "Flex_Compare_Result_Image", resultComparison);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Utility class that provides test data for various test scenarios
     * This test is an example of the Flex Locate test type. This test allows users to locate
     * the relative position between 2 elements within an image even if searched elements
     * have a different size in the baseline image.")
     */
    public static void figmaFlexLocate(
            File inputImage,
            File baseImage,
            File relativeImage,
            String testName
    ) throws IOException, InterruptedException {
        try {
            var magnifaiResponse = MagnifAI.builder()
                    .executionId(MagnifaiManager.EXECUTION_ID)
                    .testName(testName)
                    .containerImage(inputImage)
                    .mainImage(baseImage)
                    .relativeImage(relativeImage)
                    .build()
                    .flexLocate();

            System.out.println("Response Status Code: " + magnifaiResponse.getHttpStatusCode());
            System.out.println("Response Body: " + magnifaiResponse.getResultResponse());

            assertEquals(magnifaiResponse.getHttpStatusCode(), 200);
            assertEquals(magnifaiResponse.getResultResponse().getStatus(), "Found");
            if (magnifaiResponse.getHttpStatusCode() == 200) {
                BigDecimal resultComparison = magnifaiResponse.getResultResponse().getFlexCompare().getObtainedSimilarity();
                String assetId = magnifaiResponse.getResultResponse().getFlexCompare().getResultImage();
                MagnifaiManager.attachResultImage(assetId, "Flex_Compare_Result_Image", resultComparison);
            }
            else {
                ExtentLogger.fail("Flex Locate failed: " + magnifaiResponse.getResultResponse().getStatus());
            }
        } catch (AugmentedException e) {
            System.out.println("Error: " + e.getErrors());
        }
    }


    /**
     * This test is an example of the Flex Search test type. This test allows you to search for an image
     * inside another image even if the size varies from image to image.
     */

    public static void figmaSearch(
            File parentImage,
            File childImage,
            String testName
    ) {
        try {
            var magnifaiResponse = MagnifAI.builder()
                    .executionId(MagnifaiManager.EXECUTION_ID)
                    .testName(testName)
                    .parentImage(parentImage)
                    .minSimilarity(new BigDecimal("0.8"))
                    .childImage(childImage)
                    .build()
                    .flexSearch();

            System.out.println("Response Status Code: " + magnifaiResponse.getHttpStatusCode());
            System.out.println("Response Body: " + magnifaiResponse.getResultResponse());

            assertEquals(magnifaiResponse.getHttpStatusCode(), 200);
            assertEquals(magnifaiResponse.getResultResponse().getStatus(), "Found");
            if (magnifaiResponse.getHttpStatusCode() == 200) {
                String assetId = magnifaiResponse.getResultResponse().getFlexSearch().getResultImageRef();
                MagnifaiManager.attachResultImage(assetId, "Flex_Search_Result_Image", null);
            }
            else {
                ExtentLogger.fail("Flex Search failed: " + magnifaiResponse.getResultResponse().getStatus());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            ExtentLogger.fail("Flex Search failed: " + e.getMessage());
        }
    }

}
