import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

    private String id, validTaskName, description;
    private String tooLongName, tooLongDescription;

    @BeforeEach
    void setUp() {
        id = "0000000000";
        validTaskName = "A new game called Anthem";
        description = "Description of the task object.";
        tooLongName = "The task requires a name String field that cannot be longer than 20 characters.";
        tooLongDescription = "The task should have a required description String field that can't be longer than 50 characters.";
    }

    @Test
    void newTaskTest() {
        TaskService service = new TaskService();
        service.newTask();
        assertNotNull(service.getTaskList().get(0).getTaskId());
        assertNotEquals("INITIAL", service.getTaskList().get(0).getTaskId());
    }

    @Test
    void newTaskNameTest() {
        TaskService service = new TaskService();
        service.newTask(validTaskName);
        assertEquals(validTaskName, service.getTaskList().get(0).getName());
    }

    @Test
    void newTaskDescriptionTest() {
        TaskService service = new TaskService();
        service.newTask(validTaskName, description);
        assertEquals(description, service.getTaskList().get(0).getDescription());
    }

    @Test
    void newTaskTooLongNameTest() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.newTask(tooLongName));
    }

    @Test
    void newTaskTooLongDescriptionTest() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.newTask(validTaskName, tooLongDescription));
    }

    @Test
    void newTaskNameNullTest() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.newTask(null));
    }

    @Test
    void newTaskDescriptionNullTest() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.newTask(validTaskName, null));
    }

    @Test
    void deleteTaskTest() throws Exception {
        TaskService service = new TaskService();
        service.newTask();
        assertEquals(1, service.getTaskList().size());
        service.deleteTask(service.getTaskList().get(0).getTaskId());
        assertEquals(0, service.getTaskList().size());
    }

    @Test
    void deleteTaskNotFoundTest() throws Exception {
        TaskService service = new TaskService();
        service.newTask();
        assertEquals(1, service.getTaskList().size());
        assertThrows(Exception.class, () -> service.deleteTask(id));
        assertEquals(1, service.getTaskList().size());
    }

    @Test
    void updateNameTest() throws Exception {
        TaskService service = new TaskService();
        service.newTask();
        service.updateName(service.getTaskList().get(0).getTaskId(), validTaskName);
        assertEquals(validTaskName, service.getTaskList().get(0).getName());
    }

    @Test
    void updateDescriptionTest() throws Exception {
        TaskService service = new TaskService();
        service.newTask();
        service.updateDescription(service.getTaskList().get(0).getTaskId(), description);
        assertEquals(description, service.getTaskList().get(0).getDescription());
    }

    @Test
    void updateNameNotFoundTest() throws Exception {
        TaskService service = new TaskService();
        service.newTask();
        assertThrows(Exception.class, () -> service.updateName(id, validTaskName));
    }

    @Test
    void updateDescriptionNotFoundTest() throws Exception {
        TaskService service = new TaskService();
        service.newTask();
        assertThrows(Exception.class, () -> service.updateDescription(id, description));
    }

    @RepeatedTest(4)
    void uuidTest() {
        TaskService service = new TaskService();
        service.newTask();
        service.newTask();
        service.newTask();
        assertEquals(3, service.getTaskList().size());
        assertNotEquals(service.getTaskList().get(0).getTaskId(), service.getTaskList().get(1).getTaskId());
        assertNotEquals(service.getTaskList().get(0).getTaskId(), service.getTaskList().get(2).getTaskId());
        assertNotEquals(service.getTaskList().get(1).getTaskId(), service.getTaskList().get(2).getTaskId());
    }
}
