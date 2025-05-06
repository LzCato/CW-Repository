
/**
 * The PartTimeStaff class represents a job role for a part-time 
 * staff member.
 * It extends the StaffHire class and adds attributes specific 
 * to part-time positions.
 */
public class PartTimeStaff extends StaffHire {
    // Daily working hours (e.g. 4 hours per day)
    private int workingHour;
    // Amount paid per hour of work
    private double wagesPerHour;
    // Shift timing (e.g., Morning, Day, Evening)
    private String shifts;
    // Indicates if the staff member has been terminated
    private boolean terminated;

    /**
     * Create a class that gives information about a part-time employee
     * using both inherited and part-time specific attributes.
     * When a part-time role is first created, terminated is always
     * false (i.e., vacancy is active).
     */
    public PartTimeStaff(int vacancyNumber, String designation, 
                         String jobType,String staffName, String
                         joiningDate, String qualification,String
                         appointedBy, boolean joined,int 
                         workingHour, double wagesPerHour,
                         String shifts) {
        // Call the superclass constructor to initialize shared attributes
        super(vacancyNumber, designation, jobType, staffName,
        joiningDate, qualification, appointedBy, joined);
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false; // When staff is hired, they are not terminated by default
    }
    
    /**
     * Return daily working hours
     */
    public int getWorkingHour() {
        return workingHour;
    }

    /**
     * Set daily working hours
     */
    public void setWorkingHour(int workingHour) {
        this.workingHour = workingHour;
    }

    /**
     * Return amount paid per hour of work
     */
    public double getWagesPerHour() {
        return wagesPerHour;
    }

    /**
     * Set the amount paid per hour of work
     */
    public void setWagesPerHour(double wagesPerHour) {
        this.wagesPerHour = wagesPerHour;
    }

    /**
     * Return the timing of the shift
     */
    public String getShifts() {
        return shifts;
    }

    /**
     * Returns whether or not the staff member has been terminated
     */
    public boolean isTerminated() {
        return terminated;
    }

    /**
     * Changes the shift for a part-time staff member.
     * Only allows changes if the staff has joined the position.
     *
     * @param newShift The updated shift (e.g., Morning, Evening)
     */
    public void setShifts(String newShift) {
        if (getJoined()) {
            this.shifts = newShift;
            System.out.println("Shift updated to: " + newShift);
        } else {
            System.out.println("Cannot change shift. Staff has not joined yet.");
        }
    }

    /**
     * Terminates a staff member's position.
     * If not already terminated, this method resets key staff 
     * info and updates status.
     * Prevents re-termination if already terminated.
     */
    public void terminateStaff() {
        if (terminated) {
            System.out.println("Staff is already terminated.");
        } else {
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            terminated = true;
            System.out.println("Staff has been terminated.");
        }
    }

    /**
     * Displays the full details of the part-time staff.
     * Includes general info from StaffHire, and specific fields
     * like wage, shift, and termination status.
     */
    @Override
    public void display() {
        super.display(); // Display shared details
        System.out.println("Working Hours per Day: " + workingHour);
        System.out.println("Wages Per Hour: $" + wagesPerHour);
        System.out.println("Shift: " + shifts);
        System.out.println("Terminated: " + (terminated ? "Yes" : "No"));

        // Income = hourly wage * hours per day
        if (getJoined()) {
            double dailyIncome = workingHour * wagesPerHour;
            System.out.println("Income Per Day: $" + dailyIncome);
        }
    }
}
