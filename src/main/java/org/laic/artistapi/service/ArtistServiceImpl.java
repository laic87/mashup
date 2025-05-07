package org.laic.artistapi.service;

import org.laic.artistapi.client.MusicBrainzClient;
import org.laic.artistapi.model.MusicBrainzArtistResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ArtistServiceImpl {

    private final MusicBrainzClient musicBrainzClient;

    @Autowired
    public ArtistServiceImpl(MusicBrainzClient musicBrainzClient) {
        this.musicBrainzClient = musicBrainzClient;
    }
    public String fetchArtist(UUID mbid) {
        var response = musicBrainzClient.getArtistById(mbid, "json", "url-rels+release-groups");

        String wikidataId = exctractWikidataId(response);

        return wikidataId;
    }

    private String exctractWikidataId(MusicBrainzArtistResponse response) {
        return response.getRelations().stream()
                .filter(rel -> "wikidata".equalsIgnoreCase(rel.getType()))
                .map(rel -> rel.getUrl().getResource())
                .filter(url -> url != null && url.contains("/wiki/"))
                .map(url -> url.substring(url.lastIndexOf('/') + 1))
                .findFirst()
                .orElse(null);

    }
}