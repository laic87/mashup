package org.laic.artistapi.model;

import lombok.Data;

import java.util.Map;

@Data
public class WikidataResponse {
    private Map<String, Entity> entities;

    @Data
    public static class Entity {
        private Map<String, SiteLink> sitelinks;
    }

    @Data
    public static class SiteLink {
        private String site;
        private String title;
    }
}