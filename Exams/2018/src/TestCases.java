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
     *
     * @param classes classes to be tested.
     */
    private void fieldsArentPublic(Class<?>... classes) {
        for (Class<?> c : classes)
            for (Field f : c.getDeclaredFields())
                assertFalse(Modifier.isPublic(f.getModifiers()));
    }

    /**
     * Tests if a class is abstract. You don't have to
     * understand this code.
     *
     * @param c class to be tested.
     */
    private void isAbstract(Class<?> c) {
        assertTrue(Modifier.isAbstract(c.getModifiers()));
    }

    @Test
    public void testEvent() {
        Event e = new Event("ENEI");
        assertEquals("ENEI", e.getTitle());
        assertEquals("", e.getDate());
        assertEquals("", e.getDescription());
        e = new Event("ENEI", "23 to 26 of March");
        assertEquals("ENEI", e.getTitle());
        assertEquals("23 to 26 of March", e.getDate());
        assertEquals("", e.getDescription());
        e = new Event("ENEI", "23 to 26 of March", "Encontro Nacional de Estudantes de Informatica");
        assertEquals("ENEI", e.getTitle());
        assertEquals("23 to 26 of March", e.getDate());
        assertEquals("Encontro Nacional de Estudantes de Informatica", e.getDescription());
        fieldsArentPublic(Event.class);
    }

    @Test
    public void testEventCopyConstructor() {
        Event e = new Event("A", "B", "C");
        Event e1 = new Event(e);
        assertEquals("A", e1.getTitle());
        assertEquals("B", e1.getDate());
        assertEquals("C", e1.getDescription());
        assertNotSame(e, e1);
    }

    @Test
    public void testEventAccessors() {
        Event e = new Event("TalkABit", "January 20th, 2017", "non-profit tech conference");
        e.setTitle("TalkALot");
        assertEquals("TalkALot", e.getTitle());
        e.setDate("January 20th, 2018");
        assertEquals("January 20th, 2018", e.getDate());
        e.setDescription("We take your money tech conference");
        assertEquals("We take your money tech conference", e.getDescription());
    }

    @Test
    public void testEventPrintOut() {
        Event e = new Event("WebSummit", "Next year again", "world-wide tech event");
        assertEquals("WebSummit is a world-wide tech event and will be held at Next year again.", "" + e);
        e = new Event("TalkABit", "January 20th, 2017", "non-profit tech conference");
        assertEquals("TalkABit is a non-profit tech conference and will be held at January 20th, 2017.", "" + e);
    }

    @Test
    public void testSameEvent() {
        Event e = new Event("WebSummit", "Next year again", "world-wide tech event");
        Event e1 = new Event(e);
        Event e2 = new Event(e);
        Event e3 = new Event(e);
        assertTrue(e.equals(e1));
        assertTrue(e.equals((Object) e1));
        assertTrue(e.equals(e2));
        assertTrue(e.equals((Object) e2));
        assertTrue(e.equals(e3));
        assertTrue(e.equals((Object) e3));
        assertNotSame(e, e1);
        assertNotSame(e, e2);
        assertNotSame(e, e3);
        e1.setTitle("TalkABit");
        assertFalse(e.equals(e1));
        assertFalse(e.equals((Object) e1));
        e2.setDate("January 20th, 2017");
        assertFalse(e.equals(e2));
        assertFalse(e.equals((Object) e2));
        e3.setDescription("non-profit tech conference");
        assertFalse(e.equals(e3));
        assertFalse(e.equals((Object) e3));
    }

    @Test
    public void testParticipants() {
        Person p = new Attendee("John");
        {
            assertEquals("John", p.getName());
            assertEquals(0, p.getAge());

            Person p1 = new Attendee("Mary", 27);
            assertEquals("Mary", p1.getName());
            assertEquals(27, p1.getAge());

            Person p2 = new Speaker("Jane", 38);
            assertEquals("Jane", p2.getName());
            assertEquals(38, p2.getAge());

            Attendee a = (Attendee) p1;
            assertFalse(a.hasPaid());

            Speaker s = (Speaker) p2;
            assertEquals(0, s.getFee());

            assertEquals("Speaker " + s.getName() + " has a fee value of " + s.getFee() + ".", "" + p2);
            assertEquals("Attendee " + a.getName() + (a.hasPaid() ? " has" : " hasn't") + " paid its registration.", "" + p1);

            fieldsArentPublic(Person.class, Attendee.class, Speaker.class);
            isAbstract(Person.class);
        }
    }

    @Test
    public void testAudience() {
        Event e = new Event("E1", "Whenever", "Whatever");
        e.addPerson(new Attendee("John", 21));
        e.addPerson(new Attendee("Mary", 31));
        e.addPerson(new Speaker("Jane", 51));
        assertEquals(3, e.getAudienceCount());
        e.addPerson(new Attendee("Carl", 41));
        assertEquals(4, e.getAudienceCount());
        e.addPerson(new Attendee("John", 33));
        assertEquals(4, e.getAudienceCount());
        e.addPerson(new Attendee("Mary", 15));
        assertEquals(4, e.getAudienceCount());
        e.addPerson(new Attendee("Bill", 15));
        assertEquals(5, e.getAudienceCount());
        e.addPerson(new Speaker("Bill", 60));
        assertEquals(5, e.getAudienceCount());
    }

    @Test
    public void testNoDuplicatePerson() {
        TreeSet<Person> people = new TreeSet<Person>();
        Person p = new Speaker("John");
        people.add(p);
        assertEquals(1, people.size());
        p = new Attendee("John");
        people.add(p);
        assertEquals(1, people.size());
    }

    @Test
    public void testParty() {
        Party p = new Party("FEUP Caffe", "Tonight!", "Party on!");
        p.addPerson(new Attendee("John"));
        p.addPerson(new Artist("Beck"));
        assertEquals(2, p.getAudienceCount());
        assertEquals(2, ((Event) p).getAudienceCount());
        Event e = new Event("TalkABit");
        e.addPerson(new Attendee("Mary"));
        e.addPerson(new Attendee("Jane"));
        p.addEvent(e);
        assertEquals(4, p.getAudienceCount());
        assertEquals(4, ((Event) p).getAudienceCount());
        assertEquals(2, e.getAudienceCount());
        e = new Event("WebSummit");
        e.addPerson(new Attendee("Carl"));
        e.addPerson(new Attendee("Louis"));
        e.addPerson(new Attendee("Jessica"));
        p.addEvent(e);
        assertEquals(7, p.getAudienceCount());
        assertEquals(7, ((Event) p).getAudienceCount());
        assertEquals(3, e.getAudienceCount());
    }

    @Test
    public void testUsernames() {
        ArrayList<User> users = new ArrayList<User>();

        User u = new Attendee("John", 43);
        assertEquals("John43", u.getUsername());

        users.add(u);
        users.add(new Speaker("Bill Gates", 12));
        users.add(new Artist("Beck", 20));

        Iterator<User> i = users.iterator();
        String s = "";
        while (i.hasNext()) {
            User user = i.next();
            s += "," + user.getUsername();
        }

        assertEquals(",John43,Bill Gates12,Beck20", s);
    }
}