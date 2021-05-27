package cygni.se.mashup.service;

import cygni.se.mashup.dto.ArtistDTO;
import cygni.se.mashup.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ArtistServiceImpl implements ArtistService {

    final String BASE_URL = "http://musicbrainz.org/ws/2";
    final String ARTIST = "/artist/";
    final String INC = "/inc=url-rels+release-groups";

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
    public ArtistDTO getArtistInfo(String mbid) {
        ArtistDTO artistDTO = new ArtistDTO();
        Artist artist = restTemplate.getForObject(BASE_URL + ARTIST + mbid + INC, Artist.class);
        if(artist != null) {
            artistDTO.setName(artist.getName());
            artistDTO.setCountry(artist.getCountry());
            System.out.println(artistDTO.toString());
            return artistDTO;
        }
        return null;
    }

    private void mapToDto() {

    }
}
