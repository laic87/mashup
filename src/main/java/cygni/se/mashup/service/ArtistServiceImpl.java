package cygni.se.mashup.service;

import cygni.se.mashup.model.Artist;
import cygni.se.mashup.model.WikidataResponse;
import cygni.se.mashup.model.WikipediaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

import static cygni.se.mashup.Utility.getResourceIdFromArtistInfo;

@Service
public class ArtistServiceImpl implements ArtistService {

    // MUSICBRAINZ
    final String MBZ_BASE_URL = "http://musicbrainz.org/ws/2";
    final String ARTIST = "/artist/";
    final String INC = "inc=url-rels+release-groups";
    final String QUERY_FMT ="?fmt=json&";
    final String MBZ_ARTIST_INC = MBZ_BASE_URL + ARTIST + "{mbid}" + QUERY_FMT + INC;

    // WIKIDATA
    final String WD_BASE_URL = "https://www.wikidata.org/w/api.php";
    final String QUERY_ACTION = "?action=wbgetentities&";
    final String QUERY_IDS = "ids=";
    final String QUERY_FMT_PROPS ="&format=json&props=sitelinks";
    final String WD_QUERY_ACTION_IDS_FMT_PROPS = WD_BASE_URL + QUERY_ACTION + QUERY_IDS + "{id}" + QUERY_FMT_PROPS;

    // WIKIPEDIA inte klar än
    //final String WP_BASE_URL = "https://en.wikipedia.org/w/api.php";
    //final String WP_QUERY_ACTION = "?action=query&";
    //final String QUERY_IDS = "ids=";
    //final String QUERY_FMT_PROPS ="&format=json&props=sitelinks";
    //final String WD_QUERY_ACTION_IDS_FMT_PROPS = WD_BASE_URL + QUERY_ACTION + QUERY_IDS + "{id}" + QUERY_FMT_PROPS;
    final String WP_BASE_URL = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&exintro=true&redirects=true&titles=Nirvana_(band)";

    // Cover Art Archive
    final String CA_BASE_URL = "http://coverartarchive.org";
    final String CA_RELEASE_GROUP = "/release-group/";
    final String CA_BASE_URL_RELEASE_GROUP = CA_BASE_URL + CA_RELEASE_GROUP;

    // 5b11f4ce-a62d-471e-81fc-a69a8278c7da mbid for nirvana

    // http://coverartarchive.org/release-grpup/fe317a1e-4339-4c45-86f4-229c33aa27ad

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WikidataResponse getWikidataByResourceId(String id) {
        HashMap<String, HashMap>  hashMapHashMap = (HashMap<String, HashMap>) restTemplate.getForObject(WD_QUERY_ACTION_IDS_FMT_PROPS, Object.class, id);
        HashMap<String, HashMap>  entitiesHashMap = hashMapHashMap.get("entities");
        HashMap<String, HashMap> sitelinks = (HashMap<String, HashMap>) entitiesHashMap.get(id).get("sitelinks");
        HashMap<String, HashMap> enWikiHashMap = sitelinks.get("enwiki");
        String site = sitelinks.get("enwiki").get("site").toString();
        String title = sitelinks.get("enwiki").get("title").toString();
        WikidataResponse wikidataResponse = new WikidataResponse(site, title);
        return wikidataResponse;
    }

    @Override
    public WikipediaResponse getWikipediaByTitle(String title) {
        HashMap<String, HashMap> hashMapHashMap = (HashMap<String, HashMap>) restTemplate.getForObject(WP_BASE_URL, Object.class);
        HashMap<String, HashMap> queryHashMap = hashMapHashMap.get("query");
        HashMap<String, HashMap> pages = queryHashMap.get("pages");
        HashMap<String, HashMap> pageId = pages.get("21231");
        String description = pageId.get("extract").toString();
        System.out.println("This will call the wikipedia API");
        //return wikipediaResponse;
        WikipediaResponse wikipediaResponse = new WikipediaResponse(description);
        return wikipediaResponse;
    }

    @Override
    public void getCoverArtByReleaseGroupId(String id, Artist artist) {
        System.out.println("This will call the Cover Art API");
        Object object = restTemplate.getForObject(CA_BASE_URL_RELEASE_GROUP, Object.class);
        System.out.println(object);
    }

    @Override
    public Artist getArtistInfoByMusicBraizId(String mbid) {
        Artist artist = restTemplate.getForObject(MBZ_ARTIST_INC, Artist.class, mbid);
        if (artist != null) {
            getResourceIdFromArtistInfo(artist);
            return artist;
        }
        // ToDo: need to send exception
       return null;
    }
}
