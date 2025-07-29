package execution.figma;

public enum FigmaScreensData {

    SCREEN1("tin", "21827:7331", "src/test/resources/images/tin.png", "MaMffi0VsnR9vSPsSHo3A9"),
    SCREEN2("tin2", "21827:7332", "src/test/resources/images/tin2.png", "MaMffi0VsnR9vSPsSHo3A9"),
    SCREEN3("tin3", "21827:7333", "src/test/resources/images/tin3.png", "MaMffi0VsnR9vSPsSHo3A9");

    private String key;
    private String nodeId;
    private String outputPath;
    private String figmaId;

    public static final String FIGMA_URL = "MaMffi0VsnR9vSPsSHo3A9";

    FigmaScreensData(String key, String nodeId, String outputPath, String figmaId) {
        this.key = key;
        this.nodeId = nodeId;
        this.outputPath = outputPath;
        this.figmaId = figmaId;

        FigmaImageManager.getInstance().registerImage(key,
                new FigmaImageConfig.Builder()
                        .figmaId(figmaId)
                        .nodeId(nodeId)
                        .outputPath(outputPath)
                        .build());

    }

    public String getKey() {
        return key;
    }
    public String getNodeId() {
        return nodeId;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public String getFigmaId() {
        return figmaId;
    }
}
