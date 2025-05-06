
/**
 * The FullTimeStaff class represents a job role that is filled by
 * a full-time employee.
 * It extends StaffHire, meaning it inherits common attributes and
 * methods, while adding full-time-specific information such as 
 * salary and weekly working hours.
 */
public class FullTimeStaff extends StaffHire {
    // Annual salary for the full-time position
    private double salary;
    // Number of hours worked per week
    private int weeklyFractionalHours;
    
    /**
     * Create a class that gives information about a full-time employee
     * using both inherited and full-time specific attributes.
     */
    public FullTimeStaff(int vacancyNumber, String designation, 
                         String jobType,String staffName,
                         String joiningDate, String qualification,
                         String appointedBy, boolean joined,
                         double salary, int weeklyFractionalHours) 
                         {
        // Call the superclass constructor to initialize common fields
        super(vacancyNumber, designation, jobType, staffName, 
        joiningDate, qualification, appointedBy, joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }
    
    /**
     * Returns the salary of the staff
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Updates the salary of the staff.
     * Only allows salary update if the staff has already joined
     * the job.
     * Prevents salary changes on vacant roles.
     *
     * @param newSalary The updated salary value
     */
    public void setSalary(double newSalary) {
        if (getJoined()) {
            this.salary = newSalary;
            System.out.println("Salary updated to: " + newSalary);
        } else {
            System.out.println("Cannot set salary. No staff has joined this position yet.");
        }
    }
    
    /**
     * Returns the number of hours worked per week for the 
     * full-time staff
     */
    public int getWeeklyFractionalHours() {
        return weeklyFractionalHours;
    }

    /**
     * Updates the number of hours worked per week for the 
     * full-time staff.
     *
     * @param newWeeklyHours Updated number of hours per week
     */
    public void setWeeklyFractionalHours(int newWeeklyHours) {
        this.weeklyFractionalHours = newWeeklyHours;
    }

    /**
     * Displays all information about the full-time staff.
     * Calls the display method from StaffHire and then adds 
     * full-time-specific info.
     */
    @Override
    public void display() {
        super.display();  // Call the display from the superclass
        System.out.println("Salary: $" + salary);
        System.out.println("Weekly Working Hours: " + weeklyFractionalHours + " hours");
    }
}
