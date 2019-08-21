package ch.psi.cpt.dave.test.worddocument.io;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;

import ch.psi.cpt.dave.test.worddocument.model.xml.Root;

public class PBIReportReader {

	private File file; 
	
	public PBIReportReader(File file) {
		this.file = file;
	}
	
	public Root read() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Root root = (Root) jaxbUnmarshaller.unmarshal(file);	
		return root;
	}
}
