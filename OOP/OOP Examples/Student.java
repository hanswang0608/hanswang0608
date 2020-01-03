public class Student
{
    // Fields
    private String firstName;
    private String lastName;
    private int id;
    private int grade;

    private static int studentNumber = 0;
    private static int overallGrade = 0;
    private static double overallAverage = 0;

    // Constructor Method
    public Student(String inputFirstName, String inputLastName, int inputID, int inputGrade)
    {
        firstName = inputFirstName;
        lastName = inputLastName;
        id = inputID;
        grade = inputGrade;

        studentNumber++;
        overallGrade += inputGrade;
        overallAverage = overallGrade / studentNumber;
    }
    // Getter/Setter Method
    public String get_firstName()
    {
        return firstName;
    }

    public String get_lastName()
    {
        return lastName;
    }

    public int get_id()
    {
        return id;
    }

    public int get_grade()
    {
        return grade;
    }

    public void set_grade(int newGrade)
    {
        overallGrade -= grade;
        grade = newGrade;
        overallGrade += grade;
        overallAverage = overallGrade / studentNumber;
    }

    public void gradeBoost(){
        if (grade < 100) {
            grade++;
        }
    }

    public static double get_overallAverage(){
        return overallAverage;
    }
    
    public static int get_studentNumber(){
        return studentNumber;
    }
    
    public static void main(String[] args)
    {
        System.out.println("Number of students in school: " + Student.get_studentNumber());
        Student student1 = new Student("Mister", "Chow", 101, 76);
        System.out.println("Number of students in school: " + Student.get_studentNumber());
        Student student2 = new Student("Parry", "Hotter", 102, 57);
        System.out.println("Number of students in school: " + Student.get_studentNumber());
        Student student3 = new Student("Tonald", "Drump", 103, 7);
        System.out.println("Number of students in school: " + Student.get_studentNumber());
        Student student4 = new Student("Tustin", "Jrudeau", 104, 63);
        System.out.println("Number of students in school: " + Student.get_studentNumber());
    }
}