package cygni.se.mashup.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist {
    private String name;
    private String country;
    private Relation[] relations;

    public Artist() { }

    public Artist(String name, String country, Relation[] relations) {
        this.name = name;
        this.country = country;
        this.relations = relations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Relation[] getRelations() {
        return relations;
    }

    public void setRelation(Relation[] relations) {
        this.relations = relations;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", relation=" + relations +
                '}';
    }
}

