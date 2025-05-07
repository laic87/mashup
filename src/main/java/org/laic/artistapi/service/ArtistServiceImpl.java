package org.laic.artistapi.service;

import org.laic.artistapi.client.CoverArtClient;
import org.laic.artistapi.client.MusicBrainzClient;
import org.laic.artistapi.client.WikidataClient;
import org.laic.artistapi.client.WikipediaClient;
import org.laic.artistapi.model.ArtistResponse;
import org.laic.artistapi.model.MusicBrainzResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ArtistServiceImpl implements ArtistService{

    private final MusicBrainzClient musicBrainzClient;
    private final WikidataClient wikidataClient;
    private final WikipediaClient wikipediaClient;
    private final CoverArtClient coverArtClient;

    @Autowired
    public ArtistServiceImpl(
            MusicBrainzClient musicBrainzClient,
            WikidataClient wikidataClient,
            WikipediaClient wikipediaClient,
            CoverArtClient coverArtClient) {
        this.musicBrainzClient = musicBrainzClient;
        this.wikidataClient = wikidataClient;
        this.wikipediaClient = wikipediaClient;
        this.coverArtClient = coverArtClient;
    }

    public ArtistResponse getArtistById(UUID mbid) {
        System.out.println(mbid);
        var musicbrainzResponse = musicBrainzClient.getArtistById(mbid, "json", "url-rels+release-groups");
        var wikidataId = extractIdFromUrl(musicbrainzResponse);
        System.out.println(wikidataClient.getSitelinks("wbgetentities", wikidataId, "json", "sitelinks"));
        System.out.println(wikidataId);
        return null;
    }

    private String extractIdFromUrl(MusicBrainzResponse musicBrainzResponse) {
        if (musicBrainzResponse.getRelations() == null) {
            return null;
        }

        return musicBrainzResponse.getRelations().stream()
                .filter(relation -> "wikidata".equals(relation.getType()))
                .findFirst()
                .map(relation -> {
                    String resource = relation.getUrl().getResource();
                    return resource.substring(resource.lastIndexOf('/') + 1);
                })
                .orElse(null); // returnerar null om ingen matchande typ hittades
    }
}