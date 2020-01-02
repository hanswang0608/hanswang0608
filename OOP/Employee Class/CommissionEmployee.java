public class CommissionEmployee extends BaseCommissionEmployee
{
    // Fields
    // We do not need any new fields since we have declared all the necessary fields already
    // Methods
    // Note that we do not need a new method to calculate netSalary
    // The netSalary from the superclass will work as the percentage is still 10%
    // Constructor Method
    public CommissionEmployee(String f, String l, int e, double sls)
    {
        super(f,l,e, 0, sls);
    }
    
    public void set_salary(double new_salary)
    {
        salary = 0;
    }
    
    public double netSalary()
    {
        return sales*0.5;
    }
}