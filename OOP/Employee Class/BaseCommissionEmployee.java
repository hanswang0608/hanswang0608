public class BaseCommissionEmployee extends Employee
{
    // Fields
    protected double sales;
    // Methods
    public double get_sales()
    {
        return sales;
    }

    public void set_sales(double newSales)
    {
        sales = newSales;
    }

    public double netSalary()
    {
        return salary+0.1*sales;
    }
    // Constructor Method
    public BaseCommissionEmployee(String f, String l, int e, double slry, double sls)
    {
        super(f,l,e,slry);
        sales = sls;
    }
}