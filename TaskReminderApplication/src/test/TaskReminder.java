package test;
import java.util.*;
public class TaskReminder {

	public static void main(String[] args) {
		
		TaskManager taskManager = new TaskManager();
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.println("Task Reminder");
			System.out.println("1. Add Task");
			System.out.println("2. Mark Task  as Completed");
			System.out.println("3. View Task");
			System.out.println("4. Exit");
			System.out.println("Enter Your Choice :");
			int choice = s.nextInt();
			s.nextLine();
			
			switch(choice) {
			case 1: 
				System.out.println("Enter Task Categorization :");
				String categorization = s.nextLine();
				System.out.println("Enter Task Title :");
				String title = s.nextLine();
				System.out.println("Ente Due Date(e.x. , yyyy-mm-dd) :");
				String dueDate = s.nextLine();
				System.out.println("Enter Task PrLevel(e.x. , High / Low :");
				String prLevel = s.nextLine();
				
				Task task = new Task(categorization,title,dueDate,prLevel);
				taskManager.addTask(task);
				System.out.println("Task added Sucessfully.");
				break;
				
			case 2:
				System.out.println("Enter the index of the task to mark as completed: ");
				int taxIndex = s.nextInt();
				taskManager.markTaskCompleted(taxIndex);
				System.out.println("Task mark as completed.");
				break;
			
			case 3:
				List<Task> tasks = taskManager.getTasks();
				System.out.println("Tasks :");
				for(int i = 0; i < tasks.size(); i++) {
					Task t = tasks.get(i);
					String status = t.isCompleted() ? "Completed" : "Pending";
					System.out.println(" Categorization :" + t.getCategorization());
					System.out.println(i + ". " + t.getTitle() + " (" + status + ")");
					System.out.println(" Due Date :" + t.getDueDate());
					System.out.println(" Priority Level :" + t.getPrLevel());
				}
				break;
				
			case 4:
				System.out.println("Exit Task Reminder.");
				System.exit(0);
				break;
				
			default :
				System.out.println("Invalid Choice ! Please try again.");
			}
		}
	}

}
