public class Lecturer extends Teacher{
    // variables declaration
    private String department;
    private int yearsOfExperience;
    private int gradedScore;
    private boolean hasGraded;

    // Constructor
    public Lecturer(int teacherId, String teacherName, String address, String workingType, int workingHours, String employmentStatus,
                    String department, int yearsOfExperience) {
        super(teacherId, teacherName, address, workingType, employmentStatus);
        this.department = department;
        this.yearsOfExperience = yearsOfExperience;
        this.gradedScore = 0; // Initialize gradedScore to 0
        this.hasGraded = false; // Initialize hasGraded to false
    }
    // Accessor methods
    public String getDepartment() {
        return department;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public int getGradedScore() {
        return gradedScore;
    }

    public boolean hasGraded() {
        return hasGraded;
    }

    // Mutator method for gradedScore
    public void setGradedScore(int newGradedScore) {
        gradedScore = newGradedScore;
    }
public void gradeAssignment(int gradedScore, String department , int yearsOfExperience) {
        if (!hasGraded) {
            if (yearsOfExperience >= 5 && department.equals(department)) {
                if (gradedScore >= 70) {
                   System.out.println("Graded score = A");
                } else if (gradedScore >= 60) {
                    System.out.println("Graded score = B");
                } else if (gradedScore >= 50) {
                    System.out.println("Graded score = C");
                } else if (gradedScore >= 40) {
                     System.out.println("Graded score = D");
                } else {
                     System.out.println("Graded score = E");
                }
                hasGraded = true;
            } else {
                System.out.println("Lecturer cannot grade assignment for this student.");
            }
        } else {
            System.out.println("Assignment has already been graded.");
        }
    }

    // Display method
    
    public void display() {
        super.display(); // Call the display method in the Teacher class

        System.out.println("Department: " + department);
        System.out.println("Years of Experience: " + yearsOfExperience);

        if (hasGraded) {
            System.out.println("Graded Score: " + gradedScore);
        } else {
            System.out.println("Assignment has not been graded yet.");
        }
    }
}


