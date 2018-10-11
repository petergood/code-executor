package pl.petergood.codeexecutor;

public class Resource {
    private String path;
    private String resourceName;

    public Resource(String path, String resourceName) {
        this.path = path;
        this.resourceName = resourceName;

        if (path.charAt(path.length() - 1) != '/') {
            this.path += "/";
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String newPath) {
        this.path = newPath;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFullPath() {
        return path + resourceName;
    }
}
