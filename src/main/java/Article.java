public class Article {
    private String usl;
    private String name;

    public Article() {
    }

    public Article(String usl, String name) {
        this.usl = usl;
        this.name = name;
    }

    public String getUsl() {
        return usl;
    }

    public void setUsl(String usl) {
        this.usl = usl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Article{" +
                "usl='" + usl + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
