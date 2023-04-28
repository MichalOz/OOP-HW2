package OOP2.Solution;

import OOP2.Provided.*;

import java.util.*;

public class FaceOOPImpl implements FaceOOP {
    private int peopleCntr = 0;
    private LinkedList<Person> members = new LinkedList<Person>();

    /**
     * Constructor - receives no parameters and initializes the system.
     */

    public Iterator<Person> iterator() {
        return members.iterator();
    }

    public FaceOOPImpl() {
    }

    public Person joinFaceOOP(Integer id, String name) throws PersonAlreadyInSystemException {
        Person p = new PersonImpl(id, name);
        for (Person person : members) {
            if (person.equals(p))
                throw new PersonAlreadyInSystemException();
        }
        members.add(p);
        ComparePersons cmp = new ComparePersons();
        members.sort(cmp);
        peopleCntr++;
        return p;
    }

    public int size() {
        return this.peopleCntr;
    }

    public Person getUser(Integer id) throws PersonNotInSystemException {
        for (Person person : members) {
            if (person.getId() == id)
                return person;
        }
        throw new PersonNotInSystemException();
    }

    public void addFriendship(Person p1, Person p2) throws PersonNotInSystemException, SamePersonException, ConnectionAlreadyExistException {
        if (p1.equals(p2)) {
            throw new SamePersonException();
        }
        int existCntr = 0;
        for (Person person : members) {
            if (person.equals(p1) || person.equals(p2)) {
                existCntr++;
            }
        }
        if (existCntr != 2) {
            throw new PersonNotInSystemException();
        }
        try {
            p1.addFriend(p2);
            p2.addFriend(p1);
        } catch (ConnectionAlreadyExistException e) {
            throw e;
        }
    }


    public StatusIterator getFeedByRecent(Person p) throws PersonNotInSystemException {
        boolean flag = false;
        for (Person person : members) {
            if (person.equals(p)) {
                flag = true;
            }
        }
        if (!flag) {
            throw new PersonNotInSystemException();
        }
        return new RecentIterator(p);
    }

    public StatusIterator getFeedByPopular(Person p) throws PersonNotInSystemException {
        boolean flag = false;
        for (Person person : members) {
            if (person.equals(p)) {
                flag = true;
            }
        }
        if (flag == false)
            throw new PersonNotInSystemException();
        return new PopularIterator(p);
    }

    public Integer rank(Person source, Person target) throws PersonNotInSystemException, ConnectionDoesNotExistException {
        int cntr = 0;
        for (Person p : members) {
            if (p.equals(source) || p.equals(target)) {
                cntr++;
            }
        }
        if (cntr != 2) {
            throw new PersonNotInSystemException();
        }

        int delta = 0;
        LinkedList<Person> queue = new LinkedList<Person>();
        queue.add(source);
        Person head = source;

        while (!queue.isEmpty()) {
            if (head.equals(target)) {
                return delta;
            }
            Collection<Person> friends = head.getFriends();
            for (Person p : friends) {
                queue.add(p);
            }
            head = queue.pop();
            delta++;
        }
        throw new ConnectionDoesNotExistException();
    }

}

