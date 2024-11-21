import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskService {

    private final List<Task> taskList = new ArrayList<>();

    // Generate unique ID for tasks
    private String newUniqueId() {
        return UUID.randomUUID().toString().substring(0, 10); // Ensure ID is 10 characters
    }

    // Search for task by ID
    private Task searchForTask(String id) throws Exception {
        for (Task task : taskList) {
            if (id.equals(task.getId())) {
                return task;
            }
        }
        throw new Exception("Task does not exist.");
    }

    // Create new task an unique ID
    public void newTask() {
        Task task = new Task(newUniqueId());
        taskList.add(task);
    }

    public void newTask(String name) {
        Task task = new Task(newUniqueId(), name);
        taskList.add(task);
    }

    public void newTask(String name, String description) {
        Task task = new Task(newUniqueId(), name, description);
        taskList.add(task);
    }

    // Delete task by ID
    public void deleteTask(String id) throws Exception {
        Task task = searchForTask(id);
        taskList.remove(task);
    }

    // Update task name
    public void updateName(String id, String name) throws Exception {
        Task task = searchForTask(id);
        task.setName(name);
    }

    // Update task description
    public void updateDescription(String id, String description) throws Exception {
        Task task = searchForTask(id);
        task.setDescription(description);
    }

    // Get the list of tasks
    public List<Task> getTaskList() {
        return taskList;
    }
}
