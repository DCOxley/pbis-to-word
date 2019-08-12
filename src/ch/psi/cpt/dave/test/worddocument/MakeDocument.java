package ch.psi.cpt.dave.test.worddocument;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import ch.psi.cpt.dave.test.worddocument.io.PBIReportReader;
import ch.psi.cpt.dave.test.worddocument.model.PBITask;
import ch.psi.cpt.dave.test.worddocument.model.util.XmlToPBIAdapter;
import ch.psi.cpt.dave.test.worddocument.model.xml.Root;

public class MakeDocument {
	private static final String INPUT_RESOURCE_DIRECTORY = new String("resources/input/");
	private static final String OUTPUT_RESOURCE_DIRECTORY = new String("resources/output/");
	
	public static void main(String[] args) throws Exception {

		// Blank Document
		@SuppressWarnings("resource")
		XWPFDocument document = new XWPFDocument();

		
		
		
		//Define document 
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();
		run.setText("Hello, This is javatpoint. This paragraph is written " + "by using XWPFParagrah.");

		PBIReportReader reader = new PBIReportReader(new File(INPUT_RESOURCE_DIRECTORY+"TechnicalFull.xml"));
		Root root = reader.read();
		
		XmlToPBIAdapter adapter = new XmlToPBIAdapter();
		List<PBITask> pbiTasks = adapter.construct(root);
		
		// Write the Document in file system
		FileOutputStream out = new FileOutputStream(new File(OUTPUT_RESOURCE_DIRECTORY+"createdocument.docx"));
		document.write(out);
		out.close();
		System.out.println("createdocument.docx written successully");

	}

}
