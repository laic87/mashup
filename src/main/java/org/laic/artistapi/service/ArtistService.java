package org.laic.artistapi.service;

import org.laic.artistapi.model.ArtistResponse;

import java.util.UUID;

public interface ArtistService {
    ArtistResponse getArtistById(UUID mbid);
}
