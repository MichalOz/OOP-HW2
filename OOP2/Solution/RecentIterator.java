package OOP2.Solution;

import OOP2.Provided.Person;
import OOP2.Provided.Status;
import OOP2.Provided.StatusIterator;

import java.util.Collection;
import java.util.Iterator;

public class RecentIterator implements StatusIterator {
    private Iterator<Person> currFriendsIterator=null;
    private Iterator<Status> currStatusIterator=null;

    public RecentIterator(Person p) {
        Iterator<Person> it = p.getFriends().iterator();
        if (it.hasNext()) {
            currFriendsIterator = it;
            currStatusIterator = it.next().getStatusesRecent().iterator();
        }
    }

    public boolean hasNext(){
        return currFriendsIterator==null;
    }

    public Status next() {
        if (currStatusIterator.hasNext()==false){ //if we finished iterating the current friend's posts
            Person nextFriend = currFriendsIterator.next();
            currStatusIterator = nextFriend.getStatusesRecent().iterator();
            return currStatusIterator.next();
        }else {
            return currStatusIterator.next();
        }
    }

    public void remove() {}
}
