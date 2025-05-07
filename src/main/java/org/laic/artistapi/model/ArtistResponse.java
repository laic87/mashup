package org.laic.artistapi.model;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ArtistResponse {
    private UUID mbid;
    private String description;
    private List<Album> albums;

    @Data
    public static class Album {
        private UUID id;
        private String title;
        private String image;
    }
}
