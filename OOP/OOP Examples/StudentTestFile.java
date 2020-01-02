public class StudentTestFile
{
    // Main Code
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