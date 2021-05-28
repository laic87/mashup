package cygni.se.mashup.service;

import cygni.se.mashup.model.Artist;

public interface ArtistService {
    Object getWikidataByResourceId(String id);
    void getWikipediaByTitle(String id, Artist artistResponse);
    void getCoverArtByReleaseGroup(Artist artistResponse);
    Artist getArtistInfoByMusicBraizId(String mbid);
}
