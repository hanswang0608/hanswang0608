public class Rectangle
{
    // Object Variables
    private double length;
    private double width;
    private double area;
    // Class Variables
    private static double totalArea = 0;
    private static int numOfRect = 0;
    // Constructor Methods
    public Rectangle(double length_input, double width_input)
    {
        length = length_input;
        width = width_input;
        area = length*width;
        
        totalArea += area;
        numOfRect++;
    }

    public Rectangle(double length_input)
    {
        length = length_input;
        width = length_input;
        area = length*width;
        totalArea += area;
        numOfRect++;
    }

    public Rectangle()
    {
        length = 0;
        width = 0;
        area = 0;
        numOfRect++;
    }
    
    public double get_length(){
        return length;
    }
    
    public double get_width(){
        return width;
    }
    
    public double get_area(){
        return area;
    }
    
    public static double get_totalArea(){
        return totalArea;
    }
    
    public static int get_numOfRect(){
        return numOfRect;
    }
    
    public void set_length(double l){
        totalArea -= area;
        length = l;
        area = length*width;
        totalArea += area;
    }
    
    public void set_width(double w){
        totalArea -= area;
        width = w;
        area = length*width;
        totalArea += area;
    }
    
    public static void main (String[] args)
    {
        System.out.println("Hello, there are " + Rectangle.get_numOfRect() + " Rectangle objects currently.");
        Rectangle rect1 = new Rectangle(3.5);
        System.out.println("You've just created rect1! rect1 has an area of " + rect1.get_area());
        System.out.println("There are " + Rectangle.get_numOfRect() + " Rectangle objects currently.");
        System.out.println("The total amount of area is: " + Rectangle.get_totalArea());
        Rectangle rect2 = new Rectangle(10,20);
        System.out.println("\nYou've just created rect2! rect2 has an area of " + rect2.get_area());
        System.out.println("There are " + Rectangle.get_numOfRect() + " Rectangle objects currently.");
        System.out.println("The total amount of area is: " + Rectangle.get_totalArea());
        Rectangle rect3 = new Rectangle();
        System.out.println("\nYou've just created rect3! rect3 has an area of " + rect3.get_area());
        System.out.println("There are " + Rectangle.get_numOfRect() + " Rectangle objects currently.");
        System.out.println("The total amount of area is: " + Rectangle.get_totalArea());
        System.out.println("\nLet's change the length of rect3 to 50 and the width of rect3 to 20!");
        rect3.set_length(50);
        rect3.set_width(20);
        System.out.println("There are still " + Rectangle.get_numOfRect() + " Rectangle objects currently.");
        System.out.println("However the total amount of area is now: " + Rectangle.get_totalArea());
    }
}