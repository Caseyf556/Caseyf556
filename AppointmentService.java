import java.util.ArrayList;

public class AppointmentService {
        
    private ArrayList<Appointment> appointmentServices = new ArrayList<>();
    
    // Sets up an empty ArrayList to take Appointment objects
    public AppointmentService() {
        // No need to reassign appointmentServices here
    }
    
    public int getSize() {
        return this.appointmentServices.size();
    }
    
    // Returns an Appointment object by ID from the Appointment Service ArrayList otherwise throws an exception if Appointment doesn't exist 
    public Appointment getAppointmentByID(String id) {
        for (Appointment appointment : this.appointmentServices) {
            if (id.equals(appointment.getID())) {
                return appointment;
            }
        }
        throw new IllegalArgumentException("Appointment with this ID doesn't exist");
    }
   
    // Adds an Appointment Object to the Appointment Service ArrayList
    public void addAppointment(Appointment t) {
        for (Appointment appointment : this.appointmentServices) {
            if (t.getID().equals(appointment.getID())) {
                throw new IllegalArgumentException("Appointment with this ID already exists");
            }
        }
        this.appointmentServices.add(t);
    }
    
    // Deletes an Appointment based on ID from Appointment Service ArrayList or throws an exception if that Appointment doesn't exist
    public void deleteAppointment(String id) {
        for (int i = 0; i < this.appointmentServices.size(); i++) {
            if (id.equals(this.appointmentServices.get(i).getID())) {
                this.appointmentServices.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Appointment with this ID does not exist");
    }
}
