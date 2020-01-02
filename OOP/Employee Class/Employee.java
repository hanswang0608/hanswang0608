public class Employee
{
    // Fields
    protected String firstName;
    protected String lastName;
    protected int employeeID;
    protected double salary;
    // Methods
    public String get_firstName()
    {
        return firstName;
    }

    public String get_lastName()
    {
        return lastName;
    }

    public int get_employeeID()
    {
        return employeeID;
    }

    public double get_salary()
    {
        return salary;
    }

    public void set_firstName(String new_firstName)
    {
        firstName = new_firstName;
    }

    public void set_lastName(String new_lastName)
    {
        lastName = new_lastName;
    }

    public void get_employeeID(int new_employeeID)
    {
        employeeID = new_employeeID;
    }   

    public void set_salary(double new_salary)
    {
        salary = new_salary;
    }
    
    public double netSalary()
    {
        return salary;
    }
    // Constructor Method
    public Employee(String f, String l, int e, double s)
    {
        firstName = f;
        lastName = l;
        employeeID = e;
        salary = s;
    }
}