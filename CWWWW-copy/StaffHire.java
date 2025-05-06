
/**
 * The StaffHire class models a staff recruiting system used to represent a general job 
 * vacancy in a company.
 * It holds information common to all staff types, whether full-time or part-time
 * The constructor sets initial values which can be changed using the methods
 * When all the values have been approved a list of staff details is printed
 * @Lucas Cato
 * @26/04/25
 */
public class StaffHire {
    // Unique ID for the vacancy
    private int vacancyNumber;
    // Job title or position name
    private String designation;
    // Type of job (full time or part time)
    private String jobType;
    // Name of the staff member who has been appointed to the job
    private String staffName;
    // Date the staff joined
    private String joiningDate;
    // Educational or professional qualifications of the staff member
    private String qualification;
    // The name of the person or department that appointed the staff member
    private String appointedBy;
    // Indicates whether a staff member has joined the job
    private boolean joined;

    /**
     * Create a system for recording hiring information
     * This can be used when advertising a vacancy
     */
    public StaffHire(int vacancyNumber, String designation, String jobType,
           String staffName,String joiningDate, String qualification,
           String appointedBy, boolean joined) {
        this.vacancyNumber = vacancyNumber;
        this.designation = designation;
        this.jobType = jobType;
        this.staffName = staffName;
        this.joiningDate = joiningDate;
        this.qualification = qualification;
        this.appointedBy = appointedBy;
        this.joined = joined;
    } 

    /**
     * Returns the vacancy number
     */
    public int getVacancyNumber() {
        return vacancyNumber;
    }
    
    /**
     * Sets the vacancy number
     */
    public void setVacancyNumber(int vacancyNumber) {
        this.vacancyNumber = vacancyNumber;
    }
    
    /**
     * Returns the job title
     */
    public String getDesignation() {
        return designation;
    }
    
    /**
     * Sets the job title
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    /**
     * Returns the type of job
     */
    public String getJobType() {
        return jobType;
    }
    
    /**
     * Sets the type of job
     */
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
    
    /**
     * Returns the name of the staff member
     */
    public String getStaffName() {
        return staffName;
    }
    
    /**
     * Sets the name of the staff member
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    
    /**
     * Returns the date on which the staff member joined
     */
    public String getJoiningDate() {
        return joiningDate;
    }
    
    /**
     * Sets the date on which the staff member joined
     */
    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }
    
    /**
     * Returns the staff member's qualifications
     */
    public String getQualification() {
        return qualification;
    } 
    
    /**
     * Sets the staff member's qualification
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    
    /**
     * Returns who, or which department hired the staff member
     */
    public String getAppointedBy() {
        return appointedBy;
    }
    
    /**
     * Sets who, or which department hired the staff member
     */
    public void setAppointedBy(String appointedBy) {
        this.appointedBy = appointedBy;
    }
    
    /**
     * Returns whether or not the staff member has been hired
     */
    public boolean getJoined() {
        return joined;
    }
    
    /**
     * Sets the joined status to indicate whether someone has taken the job
     */
    public void setJoined(boolean joined) {
        this.joined = joined;
    }

    /**
     * Prints all the vacancy and staff details to the console
     * This method is useful when listing or reviewing vacancy details
     */
    public void display() {
        // Simulate the printing of vacancy and staff details
        System.out.println("Vacancy Number: " + vacancyNumber);
        System.out.println("Designation: " + designation);
        System.out.println("Job Type: " + jobType);
        System.out.println("Staff Name: " + staffName);
        System.out.println("Joining Date: " + joiningDate);
        System.out.println("Qualification: " + qualification);
        System.out.println("Appointed By: " + appointedBy);
        System.out.println("Joined: " + joined);
    }
}
