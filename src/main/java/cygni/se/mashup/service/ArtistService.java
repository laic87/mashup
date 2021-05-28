package cygni.se.mashup.service;

import cygni.se.mashup.model.Artist;

public interface ArtistService {
    void callWikiApi(Artist artistResponse);
    void callCoverArtApi(Artist artistResponse);
    Artist getArtistInfo(String mbid);
}
