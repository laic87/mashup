package cygni.se.mashup;

import cygni.se.mashup.model.Artist;
import cygni.se.mashup.model.Relation;

public class Utility {

    public static String getResourceIdFromArtistInfo(Artist artist) {
        System.out.println(artist.getReleaseGroups());
        Relation[] relation = artist.getRelations();
        String url = "";
        for(int i = 0; i < relation.length; i++) {
            if (relation[i].getType().equals("wikidata")) {
                url = relation[i].getUrl().getResource();
            }
        }
        String[] resourse = url.split("/");
        String id = resourse[resourse.length - 1];
        System.out.println("id: " + id);
        return id;
    }

}
