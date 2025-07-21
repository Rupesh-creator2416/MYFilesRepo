public class Tutor extends Teacher {
    // variables declaration
    private double salary;
    private String specialization;
    private String academicQualifications;
    private int performanceIndex;
    private boolean isCertified;

    public Tutor(int teacherId, String teacherName, String address, String workingType,
                 String employmentStatus, int workingHours, double salary, String specialization,
                 String academicQualifications, int performanceIndex) {
        super(teacherId, teacherName, address, workingType, employmentStatus);
        super.getWorkingHours();
        this.salary = salary;
        this.specialization = specialization;
        this.academicQualifications = academicQualifications;
        this.performanceIndex = performanceIndex;
        this.isCertified = false;
    }

    // Accessor methods
    public double getSalary() {
        return salary;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getAcademicQualifications() {
        return academicQualifications;
    }

    public int getPerformanceIndex() {
        return performanceIndex;
    }

    public boolean getIsCertified() {
        return isCertified;
    }

    // Mutator method for salary
    public void setSalary(double newSalary, int newPerformanceIndex) {
        if (newPerformanceIndex > 5 && getWorkingHours() > 20) {
            double appraisalPercentage;
            if (newPerformanceIndex >= 5 && newPerformanceIndex <= 7) {
                appraisalPercentage = 0.05;
            } else if (newPerformanceIndex >= 8 && newPerformanceIndex <= 9) {
                appraisalPercentage = 0.10;
            } else { // newPerformanceIndex = 10
                appraisalPercentage = 0.20;
            }
            this.salary += appraisalPercentage * this.salary;
            isCertified = true;
        } else {
            System.out.println("Salary cannot be approved. Tutor is not certified.");
        }
    }

    // Method to remove Tutor
    public void removeTutor() {
        if (!isCertified) {
            this.salary = 0;
            this.specialization = "";
            this.academicQualifications = "";
            this.performanceIndex = 0;
            this.isCertified = false;
        }
    }

    // Display method for Tutor
    public void display() {
        if (isCertified) {
            System.out.println("Salary: " + salary);
            System.out.println("Specialization: " + specialization);
            System.out.println("Academic Qualifications: " + academicQualifications);
            System.out.println("Performance Index: " + performanceIndex);
        } else {
            super.display(); // Call display method in the parent class
        }
    }
}