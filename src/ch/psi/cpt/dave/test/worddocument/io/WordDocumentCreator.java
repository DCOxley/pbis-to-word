package ch.psi.cpt.dave.test.worddocument.io;

import java.util.List;

import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import ch.psi.cpt.dave.test.worddocument.model.PBITask;

public class WordDocumentCreator {

	private List<PBITask> pbis;

	public WordDocumentCreator(List<PBITask> pbis) {
		this.pbis = pbis;
	}

	public XWPFDocument createWordDocument() {
		@SuppressWarnings("resource")
		XWPFDocument document = new XWPFDocument();

		for (PBITask pbiTask : this.pbis) {
			System.out.println(pbiTask.getPriority() + "  " + pbiTask.getSummary() + "  " + pbiTask.getStatus());

			// create Paragraph
			XWPFParagraph paragraph = document.createParagraph();
			XWPFRun title = paragraph.createRun();
			title.setBold(true);
			title.setFontSize(20);
			title.setText(pbiTask.getSummary());

			title.addCarriageReturn();

			XWPFRun priority = paragraph.createRun();
			priority.setBold(false);
			priority.setFontSize(14);
			priority.setText("Priority : " + pbiTask.getPriority() + "\t ID: " + pbiTask.getID() + " \t Status :"
					+ pbiTask.getStatus());
			priority.addCarriageReturn();
			
			XWPFRun description = paragraph.createRun();
			description.setText(pbiTask.getDescription());
			description.addCarriageReturn();
			description.addBreak(BreakType.PAGE);
			description.addBreak(BreakType.TEXT_WRAPPING);
		}
		return document;
	}
}
