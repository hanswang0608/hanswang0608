public class EmployeeTestFile
{
    public static void main (String[] args)
    {
        CommissionEmployee employee1 = new CommissionEmployee("Mark", "Ville", 101, 40000);
        BaseCommissionEmployee employee2 = new BaseCommissionEmployee("Bay", "View", 102, 30000, 5000);
        Employee employee3 = new Employee("Milliken", "Mills", 103, 75000);
        System.out.println(employee1.get_employeeID() + " has earned: " + employee1.netSalary());
        employee1.set_salary(100000);
        System.out.println(employee1.get_employeeID() + " has earned: " + employee1.netSalary());
        System.out.println("\n" + employee2.get_employeeID() + " has earned: " + employee2.netSalary());
        employee2.set_salary(40000);
        System.out.println(employee2.get_employeeID() + " has earned: " + employee2.netSalary());
        System.out.println("\n" + employee3.get_employeeID() + " has earned: " + employee3.netSalary());
        employee3.set_salary(80000);
        System.out.println(employee3.get_employeeID() + " has earned: " + employee3.netSalary());
    }
}