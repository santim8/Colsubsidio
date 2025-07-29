package execution.figma;

import java.io.File;

public class FigmaImageConfig {

    private String figmaId;
    private String nodeId;
    private String outputPath;
    private File imageFile;

    public FigmaImageConfig(Builder builder) {
        this.figmaId = builder.figmaId;
        this.nodeId = builder.nodeId;
        this.outputPath = builder.outputPath;
    }

    public String getFigmaId() {
        return figmaId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public String getOutputPath() {
        return outputPath;
    }


    public static class Builder {
        private String figmaId;
        private String nodeId;
        private String outputPath;

        public Builder figmaId(String figmaId) {
            this.figmaId = figmaId;
            return this;
        }

        public Builder nodeId(String nodeId) {
            this.nodeId = nodeId;
            return this;
        }

        public Builder outputPath(String outputPath) {
            this.outputPath = outputPath;
            return this;
        }

        public FigmaImageConfig build() {
            return new FigmaImageConfig(this);
        }
    }
}


