package org.laic.artistapi.model;

import lombok.Data;

import java.util.Map;

@Data
public class WikipediaResponse {
    private Query query;

    @Data
    public static class Query {
        Map<String, Page> pages;
    }

    @Data
    public static class Page {
        private String extract;
    }
}
