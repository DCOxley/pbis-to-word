package ch.psi.cpt.dave.test.worddocument.model.util;

import java.util.List;

import ch.psi.cpt.dave.test.worddocument.model.PBIModel;
import ch.psi.cpt.dave.test.worddocument.model.xml.Root;
import ch.psi.cpt.dave.test.worddocument.model.xml.Task;

public class XmlToPBIAdapter {
	
	public PBIModel construct(Root xmlExportedRoot) {
		PBIModel resultModel = new PBIModel();
		
		List<Task> tasks = xmlExportedRoot.getTracker().getTasks();
		for (Task task : tasks) {
			System.out.println(task.getId());
		}
		
		return resultModel;
	}
	
}
