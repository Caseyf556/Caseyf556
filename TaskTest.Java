import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    private String id, name, description;
    private String excessiveLengthId, excessiveLengthName, excessiveLengthDescription;

    @BeforeEach
    void setUp() {
        id = "0000000000"; // 10 characters
        name = "Task Name"; // 9 characters
        description = "Description of the task object."; // 34 characters
        excessiveLengthId = "00000000000000000000"; // 20 characters
        excessiveLengthName = "Longer than twenty characters."; // 31 characters
        excessiveLengthDescription = "Way too long and beyond the fifty character limit."; // 61 characters
    }

    @Test
    void getTaskIdTest() {
        Task task = new Task(id);
        assertEquals(id, task.getId());
    }

    @Test
    void getNameTest() {
        Task task = new Task(id, name);
        assertEquals(name, task.getName());
    }

    @Test
    void getDescriptionTest() {
        Task task = new Task(id, name, description);
        assertEquals(description, task.getDescription());
    }

    @Test
    void setNameTest() {
        Task task = new Task(id);
        task.setName(name);
        assertEquals(name, task.getName());
    }

    @Test
    void setDescriptionTest() {
        Task task = new Task(id);
        task.setDescription(description);
        assertEquals(description, task.getDescription());
    }

    @Test
    void throwsExceptionWhenTaskIdIsTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Task(excessiveLengthId));
    }

    @Test
    void throwsExceptionWhenSettingTooLongName() {
        Task task = new Task(id);
        assertThrows(IllegalArgumentException.class, () -> task.setName(excessiveLengthName));
    }

    @Test
    void throwsExceptionWhenSettingTooLongDescription() {
        Task task = new Task(id);
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(excessiveLengthDescription));
    }

    @Test
    void throwsExceptionWhenTaskIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null));
    }

    @Test
    void throwsExceptionWhenTaskNameIsNull() {
        Task task = new Task(id);
        assertThrows(IllegalArgumentException.class, () -> task.setName(null));
    }

    @Test
    void throwsExceptionWhenTaskDescriptionIsNull() {
        Task task = new Task(id);
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
    }
}
