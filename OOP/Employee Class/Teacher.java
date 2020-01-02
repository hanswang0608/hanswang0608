public class Teacher extends Employee
{
    // Fields
    private String department;
    private int homeroom;
    // Methods
    public String get_department()
    {
        return department;
    }

    public int get_homeroom()
    {
        return homeroom;

    }
    // Constructor Method
    public Teacher (String f, String l, int e, double s, String d, int h)
    {
        super (f, l, e, s);
        department = d;
        homeroom = h;
    }
}