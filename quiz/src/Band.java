import java.util.ArrayList;
import java.util.List;

class Band extends Act {
    private List<Artist> artists = new ArrayList<>();

    Band(String name, String country) {
        super(name, country);
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public boolean containsArtist(Artist artist) {
        return artists.contains(artist);
    }
}