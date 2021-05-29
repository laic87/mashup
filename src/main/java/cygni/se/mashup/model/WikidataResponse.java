package cygni.se.mashup.model;

import java.util.Objects;

public class WikidataResponse {

    private String site;
    private String title;

    public WikidataResponse() { }

    public WikidataResponse(String site, String title) {
        this.site = site;
        this.title = title;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WikidataResponse that = (WikidataResponse) o;
        return Objects.equals(site, that.site) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(site, title);
    }

    @Override
    public String toString() {
        return "WikidataResponse{" +
                "site='" + site + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
