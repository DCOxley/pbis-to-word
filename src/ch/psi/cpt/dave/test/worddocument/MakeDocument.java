package ch.psi.cpt.dave.test.worddocument;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import ch.psi.cpt.dave.test.worddocument.io.PBIReportReader;
import ch.psi.cpt.dave.test.worddocument.io.WordDocumentCreator;
import ch.psi.cpt.dave.test.worddocument.model.PBITask;
import ch.psi.cpt.dave.test.worddocument.model.util.XmlToPBIAdapter;
import ch.psi.cpt.dave.test.worddocument.model.xml.Root;

public class MakeDocument {
	private static final String INPUT_RESOURCE_DIRECTORY = new String("resources/input/");
	private static final String OUTPUT_RESOURCE_DIRECTORY = new String("resources/output/");

	public static void main(String[] args) throws Exception {

		String documentName = "TechnicalFull";
		// Parse PBIs from XML
		PBIReportReader reader = new PBIReportReader(new File(INPUT_RESOURCE_DIRECTORY + documentName + ".xml"));
		Root root = reader.read();

		XmlToPBIAdapter adapter = new XmlToPBIAdapter();

		List<PBITask> pbiTasks = adapter.construct(root);
		assert (pbiTasks.size() > 0);

		// Define document
		WordDocumentCreator documentCreator = new WordDocumentCreator(pbiTasks);
		XWPFDocument document = documentCreator.createWordDocument();

		// Write the Document in file system
		FileOutputStream out = new FileOutputStream(new File(OUTPUT_RESOURCE_DIRECTORY + documentName + ".docx"));
		document.write(out);
		out.close();
		System.out.println("createparagraph.docx written successfully");
	}

}
