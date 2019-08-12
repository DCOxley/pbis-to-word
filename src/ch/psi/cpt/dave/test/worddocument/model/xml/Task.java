package ch.psi.cpt.dave.test.worddocument.model.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Task {

	@XmlAttribute
	public String id;

	public String getId() {
		return id;
	}
	
	@XmlElement
	public Fields fields;
	
	@XmlElement
	public Description description;
}