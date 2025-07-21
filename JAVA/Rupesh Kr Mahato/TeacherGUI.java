import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.*;
import java.util.*;
import java.awt.event.*;

public class TeacherGUI{
    public static void main (String args[]){
        ArrayList <Teacher> tlist = new ArrayList <Teacher> ();
        
        JFrame jf = new JFrame("coursework");
        jf.setSize(1300,1000);
        jf.setLayout(null);
        jf.setVisible(true);
        
        JPanel p1 = new JPanel();
        p1.setBounds(0,0,1300,315);
        p1.setBackground(Color.LIGHT_GRAY);
        p1.setLayout(null);
        jf.add(p1);
        
        JLabel heading = new JLabel("LECTURER");
        heading.setFont(new Font("Times new Roman", Font.PLAIN, 35));
        heading.setBounds(475,5,230,30);
        
        JLabel l1 = new JLabel("Teacher ID: ");
        l1.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        l1.setBounds(10,60,115,30);
        JTextField t1 = new JTextField();
        t1.setBounds(138,65,130,25);
        
        
        JLabel l2 = new JLabel("Teacher Name: ");
        l2.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        l2.setBounds(10,100,130,30);
        JTextField t2 = new JTextField();
        t2.setBounds(138,103,130,25);
        
        
        JLabel l3 = new JLabel("Address: ");
        l3.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        l3.setBounds(10,140,100,30);
        JTextField t3 = new JTextField();
        t3.setBounds(138,143,130,25);
        
        
        JLabel l4 = new JLabel("Working Type: ");
        l4.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        l4.setBounds(350,60,140,30);
        JTextField t4 = new JTextField();
        t4.setBounds(516,65,130,25);
        
        
        JLabel l5 = new JLabel("Employment Status: ");
        l5.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        l5.setBounds(350,100,180,30);
        JTextField t5 = new JTextField();
        t5.setBounds(516,103,130,25);
        
        
        JLabel l6 = new JLabel("Working Hours: ");
        l6.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        l6.setBounds(350,140,180,30);
        JTextField t6 = new JTextField();
        t6.setBounds(516,143,130,25);
        
        
        JLabel l7 = new JLabel("Department: ");
        l7.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        l7.setBounds(685,60,130,30);
        JTextField t7 = new JTextField();
        t7.setBounds(870,65,130,25);
        
        
        /*JLabel l8 = new JLabel("Graded Score: ");
        l8.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        l8.setBounds(685,100,130,30);
        JTextField t8 = new JTextField();
        t8.setBounds(870,103,130,25);*/
        
        
        
        JLabel l9 = new JLabel("Year Of Experience: ");
        l9.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        l9.setBounds(685,140,140,30);
        JTextField t9 = new JTextField();
        t9.setBounds(870,143,143,25);
        
        
        JLabel sh1 = new JLabel("Grade Assignment ");
        sh1.setFont(new Font("Times new Roman", Font.PLAIN, 25));
        sh1.setBounds(535,180,200,30);
        
        
        JLabel l10 = new JLabel("Department: ");
        l10.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        l10.setBounds(10,230,130,30);
        JTextField t10 = new JTextField();
        t10.setBounds(138,233,130,25);
        
        
        JLabel l11 = new JLabel("Graded Score: ");
        l11.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        l11.setBounds(350,230,130,30);
        JTextField t11 = new JTextField();
        t11.setBounds(500,233,130,25);
        
        
        
        JLabel l12 = new JLabel("Year Of Experience: ");
        l12.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        l12.setBounds(685,230,140,30);
        JTextField t12 = new JTextField();
        t12.setBounds(855,233,143,25);
        
        
        JLabel l13 = new JLabel("Teacher ID: ");
        l13.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        l13.setBounds(1020,230,140,30);
        JTextField t13 = new JTextField();
        t13.setBounds(1120,233,130,25);
        
        
        
        
JButton b1 = new JButton("Grade");
b1.setBounds(840, 270, 120, 30);
b1.setBackground(Color.MAGENTA);
b1.setFont(new Font("Times new Roman", Font.PLAIN, 14));
b1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
        try {
            String teacherID = t13.getText();  // Assuming t13 is your JTextField for Teacher ID
            String gradedScoreStr = t11.getText();
            String department = t10.getText();
            String yearsOfExperienceStr = t12.getText();

            // Check if any field is empty
            if (teacherID.isEmpty() || gradedScoreStr.isEmpty() || department.isEmpty() || yearsOfExperienceStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields.");
                return;
            }

            int gradedScore = 0;
            int yearsOfExperience = 0;

            try {
                gradedScore = Integer.parseInt(gradedScoreStr);
                yearsOfExperience = Integer.parseInt(yearsOfExperienceStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Enter correct numerical values for Graded Score and Years of Experience");
                return;
            }

            boolean teacherFound = false;
            for (Teacher t : tlist) {
                if (t13.getText().equals(t1.getText())) {
                    if (t instanceof Lecturer) {
                        //downcasting
                        Lecturer L1 = (Lecturer) t;
                        L1.gradeAssignment(gradedScore, department, yearsOfExperience);
                        teacherFound = true;
                        String message = "Teacher ID: " + teacherID + "\n"
                                + "Graded Score: " + gradedScore + "\n"
                                + "Department: " + department + "\n"
                                + "Years of Experience: " + yearsOfExperience;
                        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);

                        break;
                        // No need to continue if teacher is found
                    }
                }
            }

            if (teacherFound) {
                JOptionPane.showMessageDialog(null, "!!!Thank You!!! Graded Score Successful");
            } else {
                JOptionPane.showMessageDialog(null, "Teacher not found with the given ID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter Correct Information to Add Graded Score");
        }
    }
});


        
        JButton b2 = new JButton("Display");
        b2.setBounds(20,270,120,30);
        b2.setBackground(Color.GREEN);
        b2.setFont(new Font("Times new Roman", Font.PLAIN, 14));
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                 for(Teacher t : tlist)
                    {
                      if(t instanceof Lecturer)
                      {
                          t.display();
                      }
                    }


                    }
                });
        
        
JButton b3 = new JButton("Add");
b3.setBounds(1040, 70, 120, 30);
b3.setBackground(Color.GREEN);
b3.setFont(new Font("Times new Roman", Font.PLAIN, 14));
b3.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
        try {
            String teacherIdStr = t1.getText();
            String teacherName = t2.getText();
            String address = t3.getText();
            String workingType = t4.getText();
            String employmentStatus = t5.getText();
            String workingHoursStr = t6.getText();
            String department = t7.getText();
            String yearsOfExperienceStr = t9.getText();

            // Check if any field is empty
            if (teacherIdStr.isEmpty() || teacherName.isEmpty() || address.isEmpty() ||
                workingType.isEmpty() || employmentStatus.isEmpty() || workingHoursStr.isEmpty() ||
                department.isEmpty() || yearsOfExperienceStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields.");
                return;
            }

            int teacherId = 0;
            int workingHours = 0;
            int yearsOfExperience = 0;

            try {
                teacherId = Integer.parseInt(teacherIdStr);
                workingHours = Integer.parseInt(workingHoursStr);
                yearsOfExperience = Integer.parseInt(yearsOfExperienceStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input for numeric fields. Please enter valid integers.");
                return; // Exit the method if parsing fails
            }

            // Check if teacherId already exists
            boolean idExists = false;
            for (Teacher lecturer : tlist) {
                if (lecturer.getTeacherId() == teacherId) {
                    idExists = true;
                    break;
                }
            }

            if (idExists) {
                JOptionPane.showMessageDialog(null, "Teacher ID already exists! Please enter a unique ID.");
            } else {
                Lecturer lecturer = new Lecturer(teacherId, teacherName, address, workingType, workingHours, employmentStatus, department, yearsOfExperience);

                tlist.add(lecturer);

                JOptionPane.showMessageDialog(null, "Lecturer added successfully!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error occurred. Please make sure you have filled all the fields correctly.");
        }
    }
});

        
        JButton b4 = new JButton("clear");
        b4.setBounds(1040,120,120,30);
        b4.setBackground(Color.ORANGE);
        b4.setFont(new Font("Times new Roman", Font.PLAIN, 14));
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, "Do you want to clear?");
                if (choice == JOptionPane.YES_OPTION){
                    
                
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                //t8.setText("");
                t9.setText("");
                t10.setText("");
                t11.setText("");
                t12.setText("");
                t13.setText("");
            }
            else{
                
            }
            }
        });
        
        
        
        p1.add(t1);
        p1.add(l1);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);
        p1.add(l4);
        p1.add(t4);
        p1.add(l5);
        p1.add(t5);
        p1.add(l6);
        p1.add(t6);
        p1.add(l7);
        p1.add(t7);
        //p1.add(l8);
        //p1.add(t8);
        p1.add(l9);
        p1.add(t9);
        p1.add(b1);
        p1.add(b2);
        p1.add(heading);
        p1.add(b3);
        p1.add(b4);
        p1.add(sh1);
         p1.add(l10);
        p1.add(l11);
        p1.add(l12);
         p1.add(t10);
        p1.add(t11);
        p1.add(t12);
        p1.add(l13);
        p1.add(t13);
        
        
        JPanel p2 = new JPanel();
        p2.setBounds(0,325,1300,320);
        p2.setBackground(Color.LIGHT_GRAY);
        p2.setLayout(null);
        jf.add(p2);
        
        JLabel heading1 = new JLabel("TUTOR");
        heading1.setFont(new Font("Times new Roman", Font.PLAIN, 35));
        heading1.setBounds(475,5,230,30);
        
        JLabel tl1 = new JLabel("Teacher ID: ");
        tl1.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        tl1.setBounds(10,60,115,30);
        JTextField tt1 = new JTextField();
        tt1.setBounds(138,65,130,25);
        
        
        JLabel tl2 = new JLabel("Teacher Name: ");
        tl2.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        tl2.setBounds(10,100,130,30);
        JTextField tt2 = new JTextField();
        tt2.setBounds(138,103,130,25);
        
        
        JLabel tl3 = new JLabel("Address: ");
        tl3.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        tl3.setBounds(10,140,100,30);
        JTextField tt3 = new JTextField();
        tt3.setBounds(138,143,130,25);
        
        
        JLabel tl4 = new JLabel("Working Type: ");
        tl4.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        tl4.setBounds(350,60,140,30);
        JTextField tt4 = new JTextField();
        tt4.setBounds(542,65,130,25);
        
        
        JLabel tl5 = new JLabel("Employment Status: ");
        tl5.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        tl5.setBounds(350,100,180,30);
        JTextField tt5 = new JTextField();
        tt5.setBounds(542,103,130,25);
        
        
        JLabel tl6 = new JLabel("Working Hours: ");
        tl6.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        tl6.setBounds(350,140,180,30);
        JTextField tt6 = new JTextField();
        tt6.setBounds(542,143,130,25);
        
        
        JLabel tl7 = new JLabel("Salary: ");
        tl7.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        tl7.setBounds(10,180,130,30);
        JTextField tt7 = new JTextField();
        tt7.setBounds(138,183,130,25);
        
        
        JLabel tl8 = new JLabel("Specialization: ");
        tl8.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        tl8.setBounds(695,60,130,30);
        JTextField tt8 = new JTextField();
        tt8.setBounds(875,63,130,25);
        
        
        
        JLabel tl9 = new JLabel("Academic Qualification: ");
        tl9.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        tl9.setBounds(695,100,204,30);
        JTextField tt9 = new JTextField();
        tt9.setBounds(875,103,130,25);
        
        
        JLabel tl10 = new JLabel("Performance Index: ");
        tl10.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        tl10.setBounds(695,140,180,30);
        JTextField tt10 = new JTextField();
        tt10.setBounds(875,143,130,25);
        
        JLabel sh2 = new JLabel("Set Salary");
        sh2.setFont(new Font("Times new Roman", Font.PLAIN, 25));
        sh2.setBounds(540,200,180,30);
        
        JLabel sh3 = new JLabel("Remove Tutor");
        sh3.setFont(new Font("Times new Roman", Font.PLAIN, 25));
        sh3.setBounds(1050,200,180,30);
        
        
        JLabel tl11 = new JLabel("New Salary: ");
        tl11.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        tl11.setBounds(240,240,130,30);
        JTextField tns = new JTextField();
        tns.setBounds(340,243,130,25);
        
        
        JLabel tl12 = new JLabel("New performance index : ");
        tl12.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        tl12.setBounds(500,240,175,30);
        JTextField tnp = new JTextField();
        tnp.setBounds(690,243,130,25);
        
        
        JLabel tl13 = new JLabel("Teacher ID: ");
        tl13.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        tl13.setBounds(10,240,100,30);
        JTextField tt13 = new JTextField();
        tt13.setBounds(100,243,130,25);
        
        
        JLabel tl14 = new JLabel("Teacher ID: ");
        tl14.setFont(new Font("Times new Roman", Font.PLAIN, 16));
        tl14.setBounds(1000,240,100,30);
        JTextField tt14 = new JTextField();
        tt14.setBounds(1100,243,130,25);
        
        
JButton tb1 = new JButton("Add a tutor");
tb1.setBounds(1050, 70, 120, 30);
tb1.setBackground(Color.GREEN);
tb1.setFont(new Font("Times new Roman", Font.PLAIN, 14));
tb1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
        try {
            // Check if any field is empty
            if (tt1.getText().isEmpty() || tt2.getText().isEmpty() || tt3.getText().isEmpty() ||
                tt4.getText().isEmpty() || tt5.getText().isEmpty() || tt6.getText().isEmpty() ||
                tt7.getText().isEmpty() || tt8.getText().isEmpty() || tt9.getText().isEmpty() ||
                tt10.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields.");
                return;
            }

            int teacherId = Integer.parseInt(tt1.getText());
            // Check if teacherId already exists
            boolean idExists = false;
            for (Teacher tutor : tlist) {
                if (tutor.getTeacherId() == teacherId) {
                    idExists = true;
                    break;
                }
            }
            if (idExists) {
                JOptionPane.showMessageDialog(null, "Teacher ID already exists. Please enter a new ID.");
                return; // Exit the method
            }
            
            String teacherName = tt2.getText();
            String address = tt3.getText();
            String workingType = tt4.getText();
            String employmentStatus = tt5.getText();
            int workingHours = Integer.parseInt(tt6.getText());
            int salary = Integer.parseInt(tt7.getText());
            String specialization = tt8.getText();
            String academicQualifications = tt9.getText();
            int performanceIndex = Integer.parseInt(tt10.getText());
            
            // Create a new Tutor object
            Tutor tutor1 = new Tutor(teacherId, teacherName, address, workingType, employmentStatus, workingHours, salary, specialization, academicQualifications, performanceIndex);

            // Add the new tutor to the list
            tlist.add(tutor1);

            JOptionPane.showMessageDialog(null, "Tutor added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid integer values for working hours, salary, and performance index.");
        }
    }
});

        
        JButton tb2 = new JButton("clear");
        tb2.setBounds(1050,120,120,30);
        tb2.setBackground(Color.ORANGE);
        tb2.setFont(new Font("Times new Roman", Font.PLAIN, 14));
        tb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, "Do you want to clear?");
                if (choice == JOptionPane.YES_OPTION){
                    
                
                tt1.setText("");
                tt2.setText("");
                tt3.setText("");
                tt4.setText("");
                tt5.setText("");
                tt6.setText("");
                tt7.setText("");
                tt8.setText("");
                tt9.setText("");
                tt10.setText("");
                tns.setText("");
                tnp.setText("");
                tt13.setText("");
                tt14.setText("");
                
            }
            else{
                
            }
            }
        });
        
         
        
        
        JButton tb3 = new JButton("Salary");
tb3.setBounds(200, 280, 150, 30);
tb3.setBackground(Color.MAGENTA);
tb3.setFont(new Font("Times new Roman", Font.PLAIN, 14));
tb3.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
        // Check if any of the required fields is empty
        if (tt13.getText().isEmpty() || tns.getText().isEmpty() || tnp.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
            return; // Exit the method if any field is empty
        }

        String teacherId = tt13.getText(); // Assuming there's a JTextField for teacherId input
        boolean teacherFound = false;
        for (Teacher t : tlist) {
            if (teacherId.equals(t.getTeacherId())) { // Compare teacherId with each teacher's ID
                try {
                    int newSalary = Integer.parseInt(tns.getText());
                    int newPerformanceIndex = Integer.parseInt(tnp.getText());
                    Tutor T1 = (Tutor) t;
                    T1.setSalary(newSalary, newPerformanceIndex);
                    JOptionPane.showMessageDialog(null, "Salary updated for teacher with ID: " + teacherId +
                            "\nNew Salary: " + newSalary + "\nNew Performance Index: " + newPerformanceIndex);
                    teacherFound = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Enter integer values for Salary and Performance Index");
                    return; // Exit the method if NumberFormatException is caught
                }
                break; // Exit loop once teacher is found and salary is set
            }
        }
        if (!teacherFound) {
            JOptionPane.showMessageDialog(null, "Teacher with ID: " + teacherId + " not found");
        }
    }
});



       
        
        
        JButton tb4 = new JButton("Display");
        tb4.setBounds(500,280,150,30);
        tb4.setBackground(Color.GREEN);
        tb4.setFont(new Font("Times new Roman", Font.PLAIN, 14));
         tb4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                 for(Teacher t : tlist)
                    {
                      if(t instanceof Tutor)
                      {
                          t.display();
                      }
                    }


                    }
                });
        
        
        
JButton tb5 = new JButton("Remove");
tb5.setBounds(1050, 280, 150, 30);
tb5.setBackground(Color.RED);
tb5.setFont(new Font("Times new Roman", Font.PLAIN, 14));

/*tb5.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
        // Get the teacher ID entered by the user
        int teacherId = Integer.parseInt(tt14.getText());

        // Check if the teacher ID exists in the ArrayList
        boolean removed = false;
        for (Teacher t : tlist) {
            if (tt1.getText() == tt14.getText()) {
                Tutor tt1 = (Tutor) t;
                tt1.removeTutor();
                removed = true;
                break; // Exit loop since we found and removed the tutor
            }
        }

        // If tutor was removed, notify the user
        if (removed) {
            JOptionPane.showMessageDialog(null, "Tutor with teacher ID " + tt14.getText() + " removed successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Tutor with teacher ID " + tt14.getText() + " not found.");
        }
    }
});*/

                
                
        p2.add(tt1);
        p2.add(tl1);
        p2.add(tl2);
        p2.add(tt2);
        p2.add(tl3);
        p2.add(tt3);
        p2.add(tl4);
        p2.add(tt4);
        p2.add(tl5);
        p2.add(tt5);
        p2.add(tl6);
        p2.add(tt6);
        p2.add(tl7);
        p2.add(tt7);
        p2.add(tl8);
        p2.add(tt8);
        p2.add(tl9);
        p2.add(tt9);
        p2.add(tb1);
        p2.add(tb2); 
        p2.add(heading1);
        p2.add(tl10);
        p2.add(tt10);
        p2.add(tb3);
        p2.add(tb4);
        p2.add(tb5);
        p2.add(sh2);
        p2.add(tns);
        p2.add(tnp);
        p2.add(tl11);
        p2.add(tl12);
        p2.add(tl13);
        p2.add(tt13);
        p2.add(tl14);
        p2.add(tt14);
        p2.add(sh3);
        
       
            

        
       
        
        
        
        
        
        
                
                
            
    }
 }
