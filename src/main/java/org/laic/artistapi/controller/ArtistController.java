package org.laic.artistapi.controller;

import org.laic.artistapi.model.ArtistResponse;
import org.laic.artistapi.service.ArtistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public class ArtistController {

    private final ArtistServiceImpl artistService;

    @Autowired
    public ArtistController(ArtistServiceImpl artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/{mbid}")
    public ResponseEntity<ArtistResponse> getArtist(@PathVariable UUID mbid) {
        var artistResponse = artistService.getArtistById(mbid);
        return ResponseEntity.ok(artistResponse);
    }
}
