package cygni.se.mashup.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = false)
public class URL {
    private String id;
    private String resource;

    public URL() {}

    public URL(String id, String resource) {
        this.id = id;
        this.resource = resource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "URL{" +
                "id=" + id +
                ", resource='" + resource + '\'' +
                '}';
    }
}
