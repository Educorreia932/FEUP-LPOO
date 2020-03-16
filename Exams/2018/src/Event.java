import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Event {
    private String title;
    private String date;
    private String description;
    private List<Person> persons = new ArrayList<>();

    Event(String title) {
        this.title = title;
        this.date = "";
        this.description = "";
    }

    Event(String title, String date) {
        this.title = title;
        this.date = date;
        this.description = "";
    }

    Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    Event(Event event) {
        title = event.getTitle();
        date = event.getDate();
        description = event.getDescription();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return title + " is a " + description + " and will be held at " + date + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return title.equals(event.title) &&
                date.equals(event.date) &&
                description.equals(event.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date, description);
    }

    public void addPerson(Person person) {
        if (!persons.contains(person))
            persons.add(person);
    }

    public int getAudienceCount() {
        return persons.size();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void addEvent(Event e) {
        persons.addAll(e.getPersons());
    }
}
