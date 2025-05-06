
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RecruitmentSystemGUI extends JFrame {

    // Input fields
    private JTextField vacancyField, designationField, jobTypeField, staffNameField,
            joiningDateField, qualificationField, appointedByField, salaryField,
            weeklyHoursField, workingHourField, wagesPerHourField, shiftsField,
            terminateField, displayField;

    private ArrayList<StaffHire> staffList;

    public RecruitmentSystemGUI() {
        super("Recruitment System");

        staffList = new ArrayList<>();

        setSize(800, 600);
        setLayout(new GridLayout(0, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Input Fields
        vacancyField = addField("Vacancy Number:");
        designationField = addField("Designation:");
        jobTypeField = addField("Job Type:");
        staffNameField = addField("Staff Name:");
        joiningDateField = addField("Joining Date:");
        qualificationField = addField("Qualification:");
        appointedByField = addField("Appointed By:");
        salaryField = addField("Salary:");
        weeklyHoursField = addField("Weekly Fractional Hours:");
        workingHourField = addField("Working Hour:");
        wagesPerHourField = addField("Wages per Hour:");
        shiftsField = addField("Shifts:");
        terminateField = addField("Terminate Vacancy Number:");
        displayField = addField("Display Index:");

        // Buttons
        addButton("Add Full Time Staff", e -> addFullTimeStaff());
        addButton("Add Part Time Staff", e -> addPartTimeStaff());
        addButton("Set Salary (Full Time)", e -> setSalary());
        addButton("Set Shift (Part Time)", e -> setShifts());
        addButton("Terminate Part Time", e -> terminatePartTime());
        addButton("Display", e -> displayStaff());
        addButton("Clear", e -> clearFields());

        setVisible(true);
    }

    private JTextField addField(String label) {
        JLabel jLabel = new JLabel(label);
        JTextField jTextField = new JTextField();
        add(jLabel);
        add(jTextField);
        return jTextField;
    }

    private void addButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        add(button);
    }

    // Utility
    private int getVacancyNumber(JTextField field) {
        try {
            return Integer.parseInt(field.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid vacancy number.");
            return -1;
        }
    }

    private void addFullTimeStaff() {
        int vacancy = getVacancyNumber(vacancyField);
        if (vacancy == -1) return;

        try {
            String designation = designationField.getText().trim();
            String jobType = jobTypeField.getText().trim();
            String staffName = staffNameField.getText().trim();
            String joiningDate = joiningDateField.getText().trim();
            String qualification = qualificationField.getText().trim();
            String appointedBy = appointedByField.getText().trim();
            boolean joined = !staffName.isEmpty();
            double salary = Double.parseDouble(salaryField.getText().trim());
            int weeklyHours = Integer.parseInt(weeklyHoursField.getText().trim());

            FullTimeStaff fullTime = new FullTimeStaff(
                    vacancy, designation, jobType, staffName, joiningDate,
                    qualification, appointedBy, joined, salary, weeklyHours
            );
            staffList.add(fullTime);
            JOptionPane.showMessageDialog(this, "Full time staff added.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Check all fields.");
        }
    }

    private void addPartTimeStaff() {
        int vacancy = getVacancyNumber(vacancyField);
        if (vacancy == -1) return;

        try {
            String designation = designationField.getText().trim();
            String jobType = jobTypeField.getText().trim();
            String staffName = staffNameField.getText().trim();
            String joiningDate = joiningDateField.getText().trim();
            String qualification = qualificationField.getText().trim();
            String appointedBy = appointedByField.getText().trim();
            boolean joined = !staffName.isEmpty();
            int workingHour = Integer.parseInt(workingHourField.getText().trim());
            double wagesPerHour = Double.parseDouble(wagesPerHourField.getText().trim());
            String shifts = shiftsField.getText().trim();

            PartTimeStaff partTime = new PartTimeStaff(
                    vacancy, designation, jobType, staffName, joiningDate,
                    qualification, appointedBy, joined, workingHour, wagesPerHour, shifts
            );
            staffList.add(partTime);
            JOptionPane.showMessageDialog(this, "Part time staff added.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Check all fields.");
        }
    }

    private void setSalary() {
        int vacancy = getVacancyNumber(vacancyField);
        String staffName = staffNameField.getText().trim();
        double newSalary = Double.parseDouble(salaryField.getText().trim());

        for (StaffHire s : staffList) {
            if (s instanceof FullTimeStaff &&
                    s.getVacancyNumber() == vacancy &&
                    s.getStaffName().equalsIgnoreCase(staffName)) {

                ((FullTimeStaff) s).setSalary(newSalary);
                JOptionPane.showMessageDialog(this, "Salary updated.");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Full-time staff not found.");
    }

    private void setShifts() {
        int vacancy = getVacancyNumber(vacancyField);
        String staffName = staffNameField.getText().trim();
        String newShift = shiftsField.getText().trim();

        for (StaffHire s : staffList) {
            if (s instanceof PartTimeStaff &&
                    s.getVacancyNumber() == vacancy &&
                    s.getStaffName().equalsIgnoreCase(staffName)) {

                ((PartTimeStaff) s).setShifts(newShift);
                JOptionPane.showMessageDialog(this, "Shift updated.");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Part-time staff not found.");
    }

    private void terminatePartTime() {
        int vacancy = getVacancyNumber(terminateField);
        for (StaffHire s : staffList) {
            if (s instanceof PartTimeStaff && s.getVacancyNumber() == vacancy) {
                ((PartTimeStaff) s).terminateStaff();
                JOptionPane.showMessageDialog(this, "Part time staff terminated.");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "No matching part-time staff to terminate.");
    }

    private void displayStaff() {
        int index = -1;
        try {
            index = Integer.parseInt(displayField.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid display index.");
            return;
        }

        if (index < 0 || index >= staffList.size()) {
            JOptionPane.showMessageDialog(this, "Display index out of range.");
            return;
        }

        StaffHire staff = staffList.get(index);
        staff.display();  // Assuming each subclass overrides this
    }

    private void clearFields() {
        for (Component comp : getContentPane().getComponents()) {
            if (comp instanceof JTextField) {
                ((JTextField) comp).setText("");
            }
        }
    }

    public static void main(String[] args) {
        new RecruitmentSystemGUI();
    }
}