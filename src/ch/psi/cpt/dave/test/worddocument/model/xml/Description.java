package ch.psi.cpt.dave.test.worddocument.model.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Description {

	@XmlValue
	public String value;
	
	@XmlAttribute
	public String format;
}
