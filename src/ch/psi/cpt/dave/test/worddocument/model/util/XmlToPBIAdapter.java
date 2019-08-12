package ch.psi.cpt.dave.test.worddocument.model.util;

import java.util.ArrayList;
import java.util.List;

import ch.psi.cpt.dave.test.worddocument.model.PBITask;
import ch.psi.cpt.dave.test.worddocument.model.xml.Field;
import ch.psi.cpt.dave.test.worddocument.model.xml.Root;
import ch.psi.cpt.dave.test.worddocument.model.xml.Task;

public class XmlToPBIAdapter {

	public List<PBITask> construct(Root xmlExportedRoot) {
		List<PBITask> resultPBIs = new ArrayList<PBITask>();

		List<Task> tasks = xmlExportedRoot.getTracker().getTasks();

		if (xmlExportedRoot.getTracker().name.equals("PBI")) {

			List<PBITask> pBIs = new ArrayList<PBITask>();
			for (Task task : tasks) {
				System.out.println(task.getId());
				PBITask newTask = fieldsToPBI(task);
				System.out.println(newTask.toString());
				pBIs.add(newTask);
			}
		}

		return resultPBIs;
	}

	private PBITask fieldsToPBI(Task task) {
		String parent = null;
		int priority = 0;
		String summary = null;
		String status = null;
		String resolution = null;
		String category = null;
		String sprint = null;

		for (Field f : task.fields.getFields()) {
			String key = f.title;
			String value = f.value;
			if (key.equalsIgnoreCase("Parent")) {
				parent = value;
			} else if (key.equalsIgnoreCase("Priority")) {
				System.out.println(value);
				priority = Integer.parseInt(value);
			} else if (key.equalsIgnoreCase("Summary")) {
				summary = value;
			} else if (key.equalsIgnoreCase("Status")) {
				status = value;
			} else if (key.equalsIgnoreCase("Category")) {
				category = value;
			} else if (key.equalsIgnoreCase("Sprint")) {
				sprint = value;
			} else {
				System.out.println("field ingnored");
			}
		}

		return new PBITask(parent, priority, summary, status, resolution, category, sprint, task.description.value);
	}

}
