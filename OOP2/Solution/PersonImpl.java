package OOP2.Solution;

import OOP2.Provided.ConnectionAlreadyExistException;
import OOP2.Provided.SamePersonException;
import OOP2.Provided.Person;
import OOP2.Provided.Status;

import java.util.*;

public class PersonImpl implements Person {
	private Integer id;
	private String name;
	private int statusCntr = 0;
	private LinkedList<Status> statuses = new LinkedList<Status>();
	private LinkedList<Person> friends = new LinkedList<Person>();

	/**
	 * Constructor receiving person's id and name.
	 */

	public PersonImpl(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Status postStatus(String content) {
		StatusImpl status = new StatusImpl(this, content, statusCntr);
		statusCntr++;
		statuses.add(status);
		return status;
	}

	public void addFriend(Person p) throws SamePersonException, ConnectionAlreadyExistException {
		if (p.equals(this)) {
			throw new SamePersonException();
		}
		for (Person person : friends) {
			if (person.equals(p)) {
				throw new ConnectionAlreadyExistException();
			}
		}
		friends.add(p);
	}

	public Collection<Person> getFriends() {
		friends.sort(new ComparePersons());//TODO:low to high??
		return friends;
	}

	public Iterable<Status> getStatusesRecent() {
		statuses.sort(new CompareByRecency());//TODO: low to high??
		return statuses;
	}

	public Iterable<Status> getStatusesPopular() {
		statuses.sort(new CompareByPopularity());//TODO: low to high??
		return statuses;
	}

	@Override
	public int compareTo(Person p) {
		if (p.getId() == this.getId())
			return 0;
		if (this.getId() < p.getId())
			return -1;
		return 1;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof Person)) {
			return false;
		}
		return this.getId() == ((Person)other).getId();
	}
}