package org.laic.artistapi.model;

import lombok.Data;

import java.util.List;

@Data
public class CoverArtResponse {
    private List<Image> images;

    @Data
    public static class Image {
        private String image;
    }
}
