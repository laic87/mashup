package cygni.se.mashup.service;

import cygni.se.mashup.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ArtistServiceImpl implements ArtistService {

    final String BASE_URL = "http://musicbrainz.org/ws/2";
    final String ARTIST = "/artist/";
    final String INC = "inc=url-rels+release-groups";
    final String QUERY_FMT ="?fmt=json&";
    final String ARTIST_INC = BASE_URL + ARTIST + "{mbid}" + QUERY_FMT + INC;
   // http://musicbrainz.org/ws/2/artist/5b11f4ce-a62d-471e-81fc-a69a8278c7da?fmt=json&inc=url-rels+release-groups

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void callWikiApi(Artist artistResponse) {
        System.out.println("This will call the wikipedia API");
    }

    @Override
    public void callCoverArtApi(Artist artistResponse) {
        System.out.println("This will call the Cover Art API");
    }

    @Override
    public Artist getArtistInfo(String mbid) {
        Artist artist = restTemplate.getForObject(ARTIST_INC, Artist.class, mbid);
        if (artist != null) {
            return artist;
        }
        // ToDo: need to send exception
       return null;
    }

    private void mapToDto() {

    }
}
