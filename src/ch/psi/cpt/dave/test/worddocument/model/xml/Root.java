package ch.psi.cpt.dave.test.worddocument.model.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Root {

	@XmlElement
	public Tracker tracker;
	
	public Tracker getTracker() {
		return this.tracker;
	}
}
