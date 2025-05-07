package org.laic.artistapi.model;

import lombok.Data;

import java.util.List;

@Data
public class MusicBrainzArtistResponse {
    private List<Relations> relations;

    @Data
    static public class Relations {
        private String type;
        private Url url;
    }

    @Data
    static public class Url {
        private String resource;
    }
}
