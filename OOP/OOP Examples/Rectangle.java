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
}