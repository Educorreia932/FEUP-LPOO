import java.util.Objects;

public abstract class Person extends User implements Comparable {
    private String name;
    private int age;

    Person(String name) {
        this.name = name;
        this.age = 0;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
        setUsername(name + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        Person person = (Person) o;

        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;

        return person.getName().compareTo(name);
    }
}
