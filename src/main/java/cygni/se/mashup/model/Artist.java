package cygni.se.mashup.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist {
    private String name;
    private String country;
    private Relation[] relations;
    @JsonProperty("release-groups")
    private ReleaseGroup[] release_groups;

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

    public ReleaseGroup[] getReleaseGroups() {
        return release_groups;
    }

    public void setReleaseGroups(ReleaseGroup[] release_groups) {
        this.release_groups = release_groups;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", relations=" + Arrays.toString(relations) +
                ", releaseGroups=" + Arrays.toString(release_groups) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(name, artist.name) && Objects.equals(country, artist.country) && Arrays.equals(relations, artist.relations);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, country);
        result = 31 * result + Arrays.hashCode(relations);
        return result;
    }
}

