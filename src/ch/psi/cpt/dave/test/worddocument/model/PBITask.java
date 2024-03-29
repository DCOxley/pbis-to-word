package ch.psi.cpt.dave.test.worddocument.model;

public class PBITask {
	private String id; 
	private int priority;
	private String summary;
	private String status;
	private String resolution;
	private String category;
	private String sprint;  
	
	private String description;

	public PBITask(String id, int priority, String summary, String status, String resolution,
			String category, String sprint, String description) {
		this.id = id;
		this.priority = priority;
		this.summary = summary;
		this.status = status;
		this.resolution = resolution;
		this.category = category;
		this.sprint = sprint;
		this.description = description;
	}

	public String getID() {
		return id;
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

	@Override
	public String toString() {
		return "PBITask [parent=" + id + ", priority=" + priority + ", summary=" + summary + ", status=" + status
				+ ", resolution=" + resolution + ", category=" + category + ", sprint=" + sprint + ", description="
				+ description + "]";
	}
}
