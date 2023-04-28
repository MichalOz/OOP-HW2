package OOP2.Solution;

import OOP2.Provided.ConnectionAlreadyExistException;
import OOP2.Provided.Person;
import OOP2.Provided.SamePersonException;
import OOP2.Provided.Status;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;

public class StatusImpl implements Status {
	private Person publisher;
	private String content;
	private Integer id;
	private Integer likeCntr = 0;
	private LinkedList<Person> personsLiked = new LinkedList<Person>();
	/*
	 * A constructor that receives the status publisher, the text of the status
	 *  and the id of the status.
	 */
	public StatusImpl(PersonImpl publisher, String content, Integer id) {
		this.publisher=publisher;
		this.content=content;
		this.id=id;
	}

	public Integer getId(){return this.id;}

	public Person getPublisher() { return this.publisher; }

	public String getContent() {return this.content; }

	public void like(Person p) {
		for (Person person : personsLiked){
			if (person.equals(p)) { return; }
		}
		personsLiked.add(p);
		likeCntr++;
	}

	public void unlike(Person p){
			for (Person person : personsLiked){
				if (person.equals(p)) {
					personsLiked.remove(p);
					likeCntr--;
					return;
				}
			}
	}

	public Integer getLikesCount() {
		return likeCntr;
	}

	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof Status)) {
			return false;
		}
		return ((Status)other).getPublisher().equals(this.publisher) && ((Status)other).getId() == this.getId();
	}
}
