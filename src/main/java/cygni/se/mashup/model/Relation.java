package cygni.se.mashup.model;

public class Relation {

    private String type;
    private URL url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "type='" + type + '\'' +
                ", url=" + url +
                '}';
    }
}