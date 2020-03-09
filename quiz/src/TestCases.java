import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

import org.junit.*;

public class TestCases {
    /**
     * Tests if all class field are private, protected
     * or package-protected. You don't have to understand
     * this code.
     * @param classes classes to be tested.
     */
    private void fieldsArentPublic(Class<?> ... classes) {
        for (Class<?> c: classes)
            for (Field f : c.getDeclaredFields())
                assertFalse(Modifier.isPublic(f.getModifiers()));
    }

    /**
     * Tests if a class is abstract. You don't have to 
     * understand this code.
     * @param c class to be tested.
     */
    private void isAbstract(Class<?> c) {
        assertTrue(Modifier.isAbstract(c.getModifiers()));
    }

    abstract class Act{
        private String name;
        private String country;

        Act(String name, String country) {
            this.name = name;
            this.country = country;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

    class Band extends Act {
        Band(String name, String country) {
            super(name, country);
        }
    }

    class Artist extends Act{
        Artist(String name, String country) {
            super(name, country);
        }
    }

    class Concert {
        private String country;
        private String city;
        private String date;
        private List<Act> acts = new ArrayList<>();

        Concert(String city, String country, String date) {
            this.city = city;
            this.country = country;
            this.date = date;
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

        public boolean equals(Concert concert) {
            return city.equals(concert.getCity()) && country.equals(concert.getCountry()) && date.equals(concert.getDate());
        }
    }

    @Test
    public void testActs() {
        Act radiohead = new Band("Radiohead", "UK");
        Act bob = new Artist("Bob Dylan", "USA");

        assertEquals("Radiohead", radiohead.getName());
        assertEquals("UK", radiohead.getCountry());

        assertEquals("Bob Dylan", bob.getName());
        assertEquals("USA", bob.getCountry());

        // Make sure your fields aren't public
        fieldsArentPublic(Artist.class);
        fieldsArentPublic(Band.class);

        // Make sure your Act class is abstract
        isAbstract(Act.class);
    }

    @Test
    public void testConcert() {
        Band radiohead = new Band("Radiohead", "UK");
        Artist bob = new Artist("Bob Dylan", "USA");

        Concert concert = new Concert("London", "UK", "2019/10/10");
        concert.addAct(radiohead);
        concert.addAct(bob);

        List<Act> acts = concert.getActs();
        assertEquals(2, acts.size());
        assertEquals("London", concert.getCity());
        assertEquals("UK", concert.getCountry());
        assertEquals("2019/10/10", concert.getDate());

        fieldsArentPublic(Concert.class);
    }

    @Test
    public void testEquals() {
        Concert concert1 = new Concert("Paris", "France", "2019/10/10");
        Concert concert2 = new Concert("Paris", "USA", "2019/10/10");

        assertNotEquals(concert1, concert2);

        Concert concert3 = new Concert("New York", "USA", "2019/10/10");
        assertNotEquals(concert2, concert3);

        Concert concert4 = new Concert("New York", "USA", "2019/05/20");
        assertNotEquals(concert3, concert4);

        Concert concert5 = new Concert("New York", "USA", "2019/05/20");
        assertEquals(concert4, concert5);
    }

/*
    @Test
    public void testSet() {
        Concert concert1 = new Concert("Paris", "France", "2019/10/10");
        Concert concert2 = new Concert("Paris", "USA", "2019/10/10");
        Concert concert3 = new Concert("New York", "USA", "2019/10/10");
        Concert concert4 = new Concert("New York", "USA", "2019/05/20");
        Concert concert5 = new Concert("New York", "USA", "2019/05/20");

        Set<Concert> tour = new HashSet<>();
        tour.add(concert1);
        tour.add(concert2);
        tour.add(concert3);
        tour.add(concert4);
        tour.add(concert5);

        assertEquals(4, tour.size());
    }
*/

/*
    @Test
    public void testTicket() throws InvalidTicket {
        Concert concert = new Concert("London", "UK", "2019/10/10");
        Concert nextDayConcert = new Concert("London", "UK", "2019/10/11");
        Ticket ticket = new Ticket(1234, concert);

        assertEquals(1234, ticket.getNumber());
        assertEquals(concert, ticket.getConcert());

        // isValid checks if ticket is for the correct concert
        assertTrue(concert.isValid(ticket));
        assertFalse(nextDayConcert.isValid(ticket));

        fieldsArentPublic(Ticket.class);
    }

*/

/*
    // This test expects the code to throw an InvalidTicket exception
    @Test(expected = InvalidTicket.class)
    public void testInvalidTicket() throws InvalidTicket {
        Concert concert = new Concert("London", "UK", "2019/10/10");
        Ticket ticket = new Ticket(-1, concert);
    }
*/

/*
    @Test
    public void testBandArtists() {
        Band radiohead = new Band("Radiohead", "UK");

        Artist thom = new Artist("Thom Yorke", "UK");
        Artist jonny = new Artist("Jonny Greenwood", "UK");
        Artist colin = new Artist("Colin Greenwood", "UK");
        Artist philip = new Artist("Philip Selway", "UK");
        Artist ed = new Artist("Ed O'Brien", "UK");

        radiohead.addArtist(thom);
        radiohead.addArtist(jonny);
        radiohead.addArtist(colin);
        radiohead.addArtist(philip);
        radiohead.addArtist(ed);

        List<Artist> artists = radiohead.getArtists();
        assertEquals(artists.get(0).getName(), "Thom Yorke");
        assertEquals(artists.get(1).getName(), "Jonny Greenwood");
        assertEquals(artists.get(2).getName(), "Colin Greenwood");
        assertEquals(artists.get(3).getName(), "Philip Selway");
        assertEquals(artists.get(4).getName(), "Ed O'Brien");
        
        assertEquals(5, artists.size());
    }
*/

/*
    @Test
    public void testContains() {
        Band radiohead = new Band("Radiohead", "UK");

        Artist thom = new Artist("Thom Yorke", "UK");
        Artist jonny = new Artist("Jonny Greenwood", "UK");
        Artist colin = new Artist("Colin Greenwood", "UK");
        Artist philip = new Artist("Philip Selway", "UK");
        Artist ed = new Artist("Ed O'Brien", "UK");

        radiohead.addArtist(thom);
        radiohead.addArtist(jonny);
        radiohead.addArtist(colin);
        radiohead.addArtist(philip);
        radiohead.addArtist(ed);

        assertTrue(thom.equals(new Artist("Thom Yorke", "UK")));

        assertTrue(radiohead.containsArtist(new Artist("Thom Yorke", "UK")));
        assertFalse(radiohead.containsArtist(new Artist("Thom Yorke", "USA")));
        assertFalse(radiohead.containsArtist(new Artist("Tom Yorke", "UK")));
    }
*/

/*
    @Test
    public void testParticipates() {
        Concert concert = new Concert("London", "UK", "2019/10/10");

        Band radiohead = new Band("Radiohead", "UK");

        Artist thom = new Artist("Thom Yorke", "UK");
        Artist jonny = new Artist("Jonny Greenwood", "UK");
        Artist colin = new Artist("Colin Greenwood", "UK");
        Artist philip = new Artist("Philip Selway", "UK");
        Artist ed = new Artist("Ed O'Brien", "UK");

        radiohead.addArtist(thom);
        radiohead.addArtist(jonny);
        radiohead.addArtist(colin);
        radiohead.addArtist(philip);
        radiohead.addArtist(ed);

        concert.addAct(radiohead);

        Artist bob = new Artist("Bob Dylan", "USA");
        concert.addAct(bob);

        // Concert.participates only needs to work for artists
        assertTrue(concert.participates(new Artist("Bob Dylan", "USA")));
        assertTrue(concert.participates(new Artist("Thom Yorke", "UK")));

        assertFalse(concert.participates(new Artist("Bob Dylan", "UK")));
        assertFalse(concert.participates(new Artist("Thom Yorke", "USA")));
        assertFalse(concert.participates(new Artist("Bob the Builder", "USA")));
        assertFalse(concert.participates(new Artist("Tom Tom", "UK")));
    }
*/

/*
    @Test
    public void testBoxOffice() throws InvalidTicket {
        Act bob = new Artist("Bob Dylan", "USA");
        Band radiohead = new Band("Radiohead", "UK");

        Concert concertLondon = new Concert("London", "UK", "2019/10/10");
        concertLondon.addAct(bob);

        Concert concertParis = new Concert("Paris", "France", "2019/05/20");
        concertParis.addAct(bob);
        concertParis.addAct(radiohead);

        // Buying three tickets for the London concert
        List<Ticket> tickets1 = BoxOffice.buy(concertLondon, 3);
        // Buying three tickets for the Paris concert
        List<Ticket> tickets2 = BoxOffice.buy(concertParis, 3);
        // Buying three more tickets for the London concert
        List<Ticket> tickets3 = BoxOffice.buy(concertLondon, 3);

        assertEquals(1, tickets1.get(0).getNumber());
        assertEquals(2, tickets1.get(1).getNumber());
        assertEquals(3, tickets1.get(2).getNumber());

        assertEquals(4, tickets3.get(0).getNumber());
        assertEquals(5, tickets3.get(1).getNumber());
        assertEquals(6, tickets3.get(2).getNumber());

        assertEquals(tickets1.get(0).getConcert(), concertLondon);
        assertEquals(tickets2.get(0).getConcert(), concertParis);
        assertEquals(tickets3.get(0).getConcert(), concertLondon);
    }
*/

}