package OOP2.Solution;

import OOP2.Provided.Person;

import java.util.Comparator;

public class ComparePersons implements Comparator<Person> {
    public ComparePersons() {}
    @Override
    public int compare(Person p1, Person p2){
        if (p1.getId() == p2.getId())
            return 0;
        if (p1.getId() < p2.getId())
            return -1;
        return 1;
    }
}
