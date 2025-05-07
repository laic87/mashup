package org.laic.artistapi.client;

import org.laic.artistapi.model.CoverArtResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "coverart", url = "http://coverartarchive.org")
public interface CoverArtClient {
    @GetMapping(path = "/release-group/{coverArtId}")
    CoverArtResponse getCoverArt(@PathVariable UUID coverArtId);
}
