package cygni.se.mashup.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class WikipediaResponse {

    @JsonProperty("extract")
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WikipediaResponse that = (WikipediaResponse) o;
        return Objects.equals(extract, that.extract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(extract);
    }

    @Override
    public String toString() {
        return "WikipediaResponse{" +
                "extract='" + extract + '\'' +
                '}';
    }
}
