package ch.psi.cpt.dave.test.worddocument;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.BreakClear;
import org.apache.poi.xwpf.usermodel.BreakType;
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

		// Parse PBIs from XML
		PBIReportReader reader = new PBIReportReader(new File(INPUT_RESOURCE_DIRECTORY + "TechnicalFull.xml"));
		Root root = reader.read();

		XmlToPBIAdapter adapter = new XmlToPBIAdapter();

		List<PBITask> pbiTasks = adapter.construct(root);
		assert(pbiTasks.size() > 0);

		
		// Blank Document
		@SuppressWarnings("resource")
		XWPFDocument document = new XWPFDocument();
		
		// Define document
		for (PBITask pbiTask : pbiTasks) {
			System.out.println(pbiTask.getPriority() + "  " + pbiTask.getSummary() + "  " + pbiTask.getStatus());


		// create Paragraph
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun title = paragraph.createRun();
		title.setBold(true);
		title.setFontSize(20);
		title.setText(pbiTask.getSummary());;
		title.addCarriageReturn();

		XWPFRun priority = paragraph.createRun();
		priority.setBold(false);
		priority.setFontSize(14);
		priority.setText("Priority : "+pbiTask.getPriority()+"\t ID: "+pbiTask.getID()+" \t Status :"+pbiTask.getStatus());
		priority.addCarriageReturn();
		priority.addBreak(BreakType.PAGE);
		priority.addBreak(BreakType.TEXT_WRAPPING);

		}
		// Write the Document in file system
		FileOutputStream out = new FileOutputStream(new File(OUTPUT_RESOURCE_DIRECTORY + "Technical.docx"));
		document.write(out);
		out.close();
		System.out.println("createparagraph.docx written successfully");
	}

}
