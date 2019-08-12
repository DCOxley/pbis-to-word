package ch.psi.cpt.dave.test.worddocument.model.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Fields {
	
	@XmlElement(name ="field")
	public List<Field> fields = null;
	
	public List<Field> getFields() {
		return fields;
	}
}
