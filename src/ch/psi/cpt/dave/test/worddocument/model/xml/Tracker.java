package ch.psi.cpt.dave.test.worddocument.model.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Tracker {

	@XmlAttribute
	public String id;

	@XmlAttribute
	public String name;
	
	public String getId() {
		return id;
	}

	@XmlElement(name = "task")
	public List<Task> tasks;

	public List<Task> getTasks() {
		return tasks;
	}
}
