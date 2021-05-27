package cygni.se.mashup.model;

public class ReleaseGroup {

    private Artist artist;

    public ReleaseGroup() {}

    public ReleaseGroup(Artist artist) {
        this.artist = artist;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "ReleaseGroup{" +
                "artist=" + artist +
                '}';
    }
}
