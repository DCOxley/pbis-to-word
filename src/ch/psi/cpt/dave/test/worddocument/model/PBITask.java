package ch.psi.cpt.dave.test.worddocument.model;

public class PBITask {
	private String parent; 
	private int priority;
	private String summary;
	private String status;
	private String severity;
	private String resolution;
	private String category;
	private String sprint;  
	
	private String description;

	public PBITask(String parent, int priority, String summary, String status, String severity, String resolution,
			String category, String sprint, String description) {
		this.parent = parent;
		this.priority = priority;
		this.summary = summary;
		this.status = status;
		this.severity = severity;
		this.resolution = resolution;
		this.category = category;
		this.sprint = sprint;
		this.description = description;
	}

	public String getParent() {
		return parent;
	}

	public int getPriority() {
		return priority;
	}

	public String getSummary() {
		return summary;
	}

	public String getStatus() {
		return status;
	}

	public String getSeverity() {
		return severity;
	}

	public String getResolution() {
		return resolution;
	}

	public String getCategory() {
		return category;
	}

	public String getSprint() {
		return sprint;
	}

	public String getDescription() {
		return description;
	}
	
	
	
}
