package cygni.se.mashup.controller;

import cygni.se.mashup.dto.ArtistDTO;
import cygni.se.mashup.model.Artist;
import cygni.se.mashup.model.Relation;
import cygni.se.mashup.model.ReleaseGroup;
import cygni.se.mashup.model.URL;
import cygni.se.mashup.service.ArtistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ArtistServiceImpl artistServiceImpl;

    //http://musicbrainz.org/ws/2/artist/5b11f4ce-a62d-471e-81fc-a69a8278c7da?&fmt=json&inc=url-rels+release-groups

    @GetMapping(path = "/{mbid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> getArtist(@PathVariable String mbid) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.setContentType(MediaType.APPLICATION_JSON);
        ArtistDTO artist = artistServiceImpl.getArtistInfo(mbid);
        return ResponseEntity.ok().headers(headers).body(artist.toString());
    }
}

