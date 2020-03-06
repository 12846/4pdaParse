public class Settings {
    private String path;
    private boolean isNull;

    public Settings() {
    }

    public Settings(String path, boolean isNull) {
        this.path = path;
        this.isNull = isNull;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isNull() {
        return isNull;
    }

    public void setNull(boolean aNull) {
        isNull = aNull;
    }

}
