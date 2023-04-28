package OOP2.Solution;

import OOP2.Provided.Person;
import OOP2.Provided.Status;
import OOP2.Provided.StatusIterator;

import java.util.Iterator;
import java.util.LinkedList;

public class PopularIterator implements StatusIterator {
    private Iterator<Status> itStatus;

    public PopularIterator(Person p) {
        LinkedList<Status> statusesOfFriends = new LinkedList<Status>();
        for (Person person : p.getFriends()) {
            for (Status s : person.getStatusesPopular()) {
                statusesOfFriends.add(s);
            }
        }
        itStatus = statusesOfFriends.iterator();
    }

    public boolean hasNext() {
        return itStatus.hasNext();
    }

    public Status next() {
        return itStatus.next();
    }

    public void remove() {}
}
