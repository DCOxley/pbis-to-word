package ch.psi.cpt.dave.test.worddocument.model.util;

import java.util.ArrayList;
import java.util.List;

import ch.psi.cpt.dave.test.worddocument.model.PBITask;
import ch.psi.cpt.dave.test.worddocument.model.xml.Root;
import ch.psi.cpt.dave.test.worddocument.model.xml.Task;

public class XmlToPBIAdapter {
	
	public List<PBITask> construct(Root xmlExportedRoot) {
		List<PBITask> resultPBIs = new ArrayList<PBITask>();
		
		List<Task> tasks = xmlExportedRoot.getTracker().getTasks();
		List<PBITask> pBIs = new ArrayList<PBITask>();
		for (Task task : tasks) {
			System.out.println(task.getId());
		}
		
		return resultPBIs;
	}
	
}
