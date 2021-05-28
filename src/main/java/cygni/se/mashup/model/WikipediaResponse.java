package cygni.se.mashup.model;

public class WikipediaResponse {

    private String extract;

    public WikipediaResponse() { }

    public WikipediaResponse(String extract) {
        this.extract = extract;
    }

    public String getExtract() {
        return extract;
    }

    public void setExtract(String extract) {
        this.extract = extract;
    }

    @Override
    public String toString() {
        return "WikipediaResponse{" +
                "extract='" + extract + '\'' +
                '}';
    }
}
