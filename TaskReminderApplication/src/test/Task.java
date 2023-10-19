package test;

public class Task {

		private String categorization;
		private String title;
		private String dueDate;
		private String prLevel;
		private boolean completed;
		
		public Task(String categorization,String title,String dueDate,String prLevel) {
			
			super();
			this.categorization = categorization;
			this.title = title;
			this.dueDate = dueDate;
			this.prLevel = prLevel;
		}
		
		public String getCategorization() {
			return categorization;
		}
		
		public String getTitle() {
			return title;
		}
		
		public String getDueDate() {
			return dueDate;
		}
		
		public String getPrLevel() {
			return prLevel;
		}
		
		public boolean isCompleted() {
			return completed;
		}
		
		public void markCompleted() {
			completed = true;
		}
}
