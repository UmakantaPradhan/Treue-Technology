package test;
import java.util.*;
public class TaskManager {

	private List<Task> tasks ;
	
	public TaskManager() {
		tasks = new ArrayList<>();
	}
	
	public void addTask(Task task) {
		
		tasks.add(task);
	}
	
	public void markTaskCompleted(int taskIndex) {
		
		if(taskIndex >= 0 && taskIndex < tasks.size()) {
			Task task = tasks.get(taskIndex);
			task.markCompleted();
		}
	}
	
	public List<Task> getTasks() {
		return tasks;
	}
}
