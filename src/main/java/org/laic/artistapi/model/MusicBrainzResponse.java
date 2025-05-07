package org.laic.artistapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class MusicBrainzResponse {
    private UUID mbid;
    @JsonProperty(value = "release-groups")
    private List<ReleaseGroups> releaseGroups;
    private List<Relations> relations;

    @Data
    public static class ReleaseGroups {
        private UUID id;
        private String title;
    }

    @Data
    public static class Relations {
        private String type;
        private Url url;
    }

    @Data
    public static class Url {
        private String resource;
    }
}