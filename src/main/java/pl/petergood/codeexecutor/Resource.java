package pl.petergood.codeexecutor;

public class Resource {
    private String path;

    public Resource(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getDirectoryPath() {
        StringBuilder directoryPath = new StringBuilder();

        if (path.charAt(0) == '/')
            directoryPath.append("/");

        String[] directoryParts = path.split("/");

        for (int i = 0; i < directoryParts.length - 1; i++) {
            if (directoryParts[i].length() > 0) {
                directoryPath.append(directoryParts[i]);
                directoryPath.append("/");
            }
        }

        return directoryPath.toString();
    }
}
