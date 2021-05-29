package cygni.se.mashup.controller;

import cygni.se.mashup.model.Artist;
import cygni.se.mashup.model.WikidataResponse;
import cygni.se.mashup.model.WikipediaResponse;
import cygni.se.mashup.service.ArtistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static cygni.se.mashup.Utility.getResourceIdFromArtistInfo;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistServiceImpl artistServiceImpl;

    @GetMapping(path = "/{mbid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<WikipediaResponse> getArtist(@PathVariable String mbid) {
        Artist artist = artistServiceImpl.getArtistInfoByMusicBraizId(mbid);
        WikidataResponse wikiData = artistServiceImpl.getWikidataByResourceId(getResourceIdFromArtistInfo(artist));
        WikipediaResponse wikipedia = artistServiceImpl.getWikipediaByTitle(wikiData.getTitle());
        return ResponseEntity.ok().body(wikipedia);
    }
}

