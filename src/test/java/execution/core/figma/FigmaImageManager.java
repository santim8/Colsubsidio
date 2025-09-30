package execution.core.figma;

import com.globant.aut.sdk.figma.Figma;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FigmaImageManager {
    private static FigmaImageManager instance;
    private Map<String, FigmaImageConfig> imageConfigs = new HashMap<>();
    private Map<String, File> loadedImages =  new ConcurrentHashMap<>();

    private FigmaImageManager() {}

    public static synchronized FigmaImageManager getInstance() {
        if (instance == null) {
            instance = new FigmaImageManager();
        }
        return instance;
    }

    public void registerImage(String nameScreen, FigmaImageConfig imageConfig) {
        imageConfigs.put(nameScreen, imageConfig);
    }


    public Map<String, FigmaImageConfig> getImageConfigs() {
        return imageConfigs;
    }


    public File getImage(String nameScreen) throws IOException {
        if (imageConfigs.containsKey(nameScreen)) {
            FigmaImageConfig config = imageConfigs.get(nameScreen);
            var tin = FigmaScreensData.FIGMA_URL;
            var tin2 = config.getNodeId();
            File image  = Figma.getFigmaImage(FigmaScreensData.FIGMA_URL, config.getNodeId());
            FileUtils.copyFile(image, new File(config.getOutputPath()));
            loadedImages.put(nameScreen, image);
            return image;
        }
        if (loadedImages.containsKey(nameScreen)) {
            return loadedImages.get(nameScreen);
        }
        return null;
    }
}
