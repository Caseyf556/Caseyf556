import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppointmentTest {
    
    @Test
    public void testAppointmentClass() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        
        Appointment run = new Appointment("0", tomorrow, "Make me a Sandwich");
        assertEquals("0", run.getID());
        assertEquals(tomorrow, run.getDate());
        assertEquals("Make me a Sandwich", run.getDescription());
    }
    
    @Test
    public void testIllegalArgumentsForAppointmentClass() {
        
        // Test to make sure exception is thrown if ID is null or has too many chars
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567891011", LocalDate.now(), "Make me a Sandwich");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, LocalDate.now(), "Make me a Sandwich");
        });
        
        // Test to make sure exception is thrown if date is null or in the past
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("0", null, "Make me a Sandwich");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("0", LocalDate.now().minusDays(1), "Make me a Sandwich");
        });
        
        // Test to make sure exception is thrown if description is null or has too many chars
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("0", LocalDate.now(), "Make me a Sandwich. "
                    + "Please make me a Sandwich at Noon"
                    + "....... Please make me a Sandwich at Noon"
                    + ".......Please make me a Sandwich at Noon"
                    + ".......Please make me a Sandwich at Noon"
                    + ".......Please make me a Sandwich at Noon"
                    + ".......Please make me a Sandwich at Noon"
                    + ".......Please make me a Sandwich at Noon"
                    + ".......Please make me a Sandwich at Noon"
                    + ".......Please make me a Sandwich at Noon"
                    + ".......");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("0", LocalDate.now(), null);
        });
    }
}
