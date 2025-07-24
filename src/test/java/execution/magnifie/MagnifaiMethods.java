package execution.magnifie;

import com.globant.aut.sdk.builder.MagnifAI;
import com.globant.aut.sdk.figma.Figma;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class MagnifaiMethods {

    public static void flexCompare(
            File file,
            File baseImage,
            BigDecimal minSimilarity,
            String testName
    ) {
        String newFigma = "MaMffi0VsnR9vSPsSHo3A9";
        String node = "21827:7331";
        try {
            File figmaImage = Figma.getFigmaImage(newFigma, node);
            FileUtils.copyFile(figmaImage, new File("src/test/resources/images/tin.png"));
            var magnifaiResponse = MagnifAI.builder()
                    .executionId(MagnifaiManager.EXECUTION_ID)
                    .testName(testName)
                    .baselineImage(figmaImage)
                    .inputImage(file)
                    .minSimilarity(minSimilarity)
                    .build()
                    .flexCompare();

            System.out.println("Response Status Code: " + magnifaiResponse.getHttpStatusCode());
            System.out.println("Response Body: " + magnifaiResponse.getResultResponse());

            assertEquals(magnifaiResponse.getHttpStatusCode(), 200);
            assertEquals(magnifaiResponse.getResultResponse().getStatus(), "Passed");
            if (magnifaiResponse.getHttpStatusCode() == 200) {
                String assetId = magnifaiResponse.getResultResponse().getFlexCompare().getResultImage();
//                attachResultImage(assetId, "Flex Compare Result Image");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
