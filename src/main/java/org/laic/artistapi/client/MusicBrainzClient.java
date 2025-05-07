package org.laic.artistapi.client;

import org.laic.artistapi.model.MusicBrainzResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(name = "musicbrainz", url = "http://musicbrainz.org/ws/2")
public interface MusicBrainzClient {
    @GetMapping("/artist/{mbid}")
    MusicBrainzResponse getArtistById(
            @PathVariable("mbid") UUID mbid,
            @RequestParam("fmt") String format,
            @RequestParam("inc") String includes
    );
}
