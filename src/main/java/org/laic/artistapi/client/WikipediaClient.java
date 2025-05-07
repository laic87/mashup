package org.laic.artistapi.client;

import org.laic.artistapi.model.WikipediaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "widipedia", url = "https://en.wikipedia.org/w/api.php")
public interface WikipediaClient {
    @GetMapping(path = "/w/api.php")
    WikipediaResponse getWikipedia(
            @RequestParam("action") String action,
            @RequestParam("format") String format,
            @RequestParam("props") String props,
            @RequestParam("exintro") boolean exintro,
            @RequestParam("redirects") boolean redirects,
            @RequestParam("titles") String titles
    );
}