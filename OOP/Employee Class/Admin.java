public class Admin extends Employee
{
    // Fields
    private String position;
    private int extension;
    // Methods
    public String get_position()
    {
        return position;
    }

    public int get_extension()
    {
        return extension;

    }
    // Constructor Method
    public Admin (String f, String l, int e, double s, String p, int ex)
    {
        super (f, l, e, s);
        position = p;
        extension = ex;
    }
}