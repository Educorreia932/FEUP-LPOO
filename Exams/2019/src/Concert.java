import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Concert {
    private String country;
    private String city;
    private String date;
    private List<Act> acts = new ArrayList<>();
    private int id = 1;

    Concert(String city, String country, String date) {
        this.city = city;
        this.country = country;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void incrementId() {
        id++;
    }

    public String getDate() {
        return date;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public void addAct(Act act) {
        acts.add(act);
    }

    public List<Act> getActs() {
        return acts;
    }

    @Override
    public boolean equals(Object o) {
        Concert concert = (Concert) o;

        return city.equals(concert.getCity()) && country.equals(concert.getCountry()) && date.equals(concert.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, date);
    }

    public boolean isValid(Ticket ticket) {
        return ticket.getConcert().equals(this);
    }

    public boolean participates(Artist artist) {
        for (Act act : acts)
            if (act instanceof Band && ((Band) act).getArtists().contains(artist))
                return true;

            else if (act.equals(artist))
                return true;

        return false;
    }
}