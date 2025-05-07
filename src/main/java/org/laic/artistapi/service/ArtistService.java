package org.laic.artistapi.service;

import org.laic.artistapi.model.MusicBrainzArtistResponse;

import java.util.UUID;

public interface ArtistService {
    MusicBrainzArtistResponse getArtistById(UUID mbid);
}
