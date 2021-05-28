package cygni.se.mashup.dto;

import cygni.se.mashup.model.Relation;

import java.util.Arrays;
import java.util.Objects;

public class ArtistDTO {
    private String name;
    private String country;
    private Relation[] relations;

    public ArtistDTO() {}

    public ArtistDTO(String name, String country, Relation[] relations) {
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

    public void setRelations(Relation[] relations) {
        this.relations = relations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtistDTO artistDTO = (ArtistDTO) o;
        return Objects.equals(name, artistDTO.name) && Objects.equals(country, artistDTO.country) && Arrays.equals(relations, artistDTO.relations);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, country);
        result = 31 * result + Arrays.hashCode(relations);
        return result;
    }

    @Override
    public String toString() {
        return "ArtistDTO{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
