package cygni.se.mashup.service;

import cygni.se.mashup.model.Artist;
import cygni.se.mashup.model.WikipediaResponse;

public interface ArtistService {
    Object getWikidataByResourceId(String id);
    WikipediaResponse getWikipediaByTitle(String title);
    void getCoverArtByReleaseGroupId(String id, Artist artist);
    Artist getArtistInfoByMusicBraizId(String mbid);
}
