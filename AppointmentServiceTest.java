import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppointmentServiceTest {
    
    LocalDate today = LocalDate.now();
    AppointmentService myAppointments = new AppointmentService();
        
    Appointment turkey = new Appointment("1", today, "Turkey cheese Sandwich.");
    Appointment sandwich = new Appointment("6", today, "Bake bread at 375°.");

    // Appointment can be successfully retrieved from the AppointmentService object by ID
    @Test
    public void testGetAppointmentByID() {
        myAppointments.addAppointment(turkey);
        
        assertEquals(turkey, myAppointments.getAppointmentByID("1"));
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myAppointments.getAppointmentByID("3");
        });
    }

    // Appointment can be successfully added to the AppointmentService object
    @Test
    public void testAddAppointment() {
        assertEquals(0, myAppointments.getSize());
        
        myAppointments.addAppointment(turkey);
        myAppointments.addAppointment(sandwich);
        
        assertEquals(2, myAppointments.getSize());
    }

    // Appointment can be deleted from the AppointmentService object
    @Test
    public void testDeleteAppointment() {
        myAppointments.addAppointment(turkey);
        myAppointments.addAppointment(sandwich);
        
        assertEquals(2, myAppointments.getSize());
        
        myAppointments.deleteAppointment("1");
        
        assertEquals(1, myAppointments.getSize());
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            myAppointments.deleteAppointment("3");
        });
    }
}
