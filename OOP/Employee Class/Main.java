import java.util.*;

public class Main
{
    private static Scanner s = new Scanner(System.in);
    private static ArrayList<Employee> emparr = new ArrayList<Employee>();
    public static void main(String[] args)
    {
        while(true)
        {
            System.out.println("There are currently " + emparr.size() + " employee in the database.");
            System.out.println("What would you like to do?");
            System.out.print("Press 1 to add an employee.\nPress 2 to remove an employee.\nPress 3 to view an employee.");
            int user_input = Integer.valueOf(s.nextLine());
            if (user_input == 1)
            {
                System.out.print("Please enter first name: ");
                String firstName = s.nextLine();
                System.out.print("Please enter last name: ");
                String lastName = s.nextLine();
                System.out.print("Please enter employee ID: ");
                int employeeID = Integer.valueOf(s.nextLine());
                System.out.print("Please enter salary: ");
                double salary = Double.valueOf(s.nextLine());

                Employee e = new Employee(firstName, lastName, employeeID, salary);
                emparr.add(e);
            }
            else if (user_input == 2)
            {
                if (emparr.size() == 0)
                {
                }
                else
                {
                    System.out.print("Please select the employee position in the database to be removed. ");
                    int pos = Integer.valueOf(s.nextLine());
                    if (pos < 0 || pos > emparr.size()-1)
                    {
                        System.out.println("Invalid Position!");
                    }
                    else
                    {
                        emparr.remove(pos);
                    }
                }
            }
            else if (user_input == 3)
            {
                if (emparr.size()==0)
                {
                }
                else
                {
                    System.out.print("Please enter the employee position in the database to view employee info. ");
                    int pos = Integer.valueOf(s.nextLine());
                    if (pos < 0 || pos > emparr.size()-1)
                    {
                        System.out.println("Invalid Position!");
                    }
                    else
                    {
                        System.out.println("Employee " + emparr.get(pos).get_employeeID() + ": " + emparr.get(pos).get_firstName() +
                            " " + emparr.get(pos).get_lastName() + " is currently earning $" + emparr.get(pos).get_salary());
                    }
                }
            }
        }
    }
}