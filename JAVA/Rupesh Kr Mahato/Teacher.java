public class Teacher{
    // variables declaration 
    private int teacherId;
    private String teacherName;
    private String address;
    private String workingType;
    private String employmentStatus;
    private int workingHours;
    
    // parameter constructor 
    public Teacher(int teacherId, String teacherName, String address, String workingType, String employmentStatus){
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.address = address;
        this.workingType = workingType;
        this.employmentStatus = employmentStatus;
    }
    
    // accessor method for each attributes
    public int getTeacherId(){
        return teacherId;
    }
    public String getTeacherName(){
        return teacherName;
    }
    public String getAddress(){
        return address;
    }
    public String getWorkingType(){
        return workingType;
    }
    public String getEmploymentStatus(){
        return employmentStatus;
    }
    
    public int getWorkingHours(){
        return workingHours;
    }
    
    // mutator method to set working hours
   public void setWorkingHours(int newWorkingHours){
       this.workingHours = newWorkingHours;
   }
   
   public void display(){
       System.out.println("Teacher Id = " + teacherId);
        System.out.println("Teacher Name = " + teacherName);
         System.out.println("Address= " + address);
        System.out.println("Working Type= " + workingType);
         System.out.println("Employment Status = " + employmentStatus);
         if(workingHours > 0){
            
          System.out.println("Working hours = " + workingHours);}
          else{
          System.out.println("working hour is not assigned");
   }
}

}