package ch.psi.cpt.dave.test.worddocument.model.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Field {

	@XmlAttribute
	public String title;
	
	@XmlValue
	public String value;
}
