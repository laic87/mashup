package org.laic.artistapi.client;

import org.laic.artistapi.model.WikidataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "wikidata", url = "https://www.wikidata.org/w/api.php")
public interface WikidataClient {

    @GetMapping("/w/api.php")
    WikidataResponse getSitelinks(
            @RequestParam("action") String action,
            @RequestParam("ids") String ids,
            @RequestParam("format") String format,
            @RequestParam("props") String props
    );
}
