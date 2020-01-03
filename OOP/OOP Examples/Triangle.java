public class Triangle{
    public double sideA;
    public double sideB;
    public double sideC;
    public double area;
    public static double totalArea;
    public static int numOfTri;
    
    public Triangle(double A, double B, double C){
        sideA = A;
        sideB = B;
        sideC = C;
        area = calcArea();
        totalArea += area;
        numOfTri++;
    }
    
    public Triangle(double A, double C){
        sideA = A;
        sideB = A;
        sideC = C;
        area = calcArea();
        totalArea += area;
        numOfTri++;
    }
    
    public Triangle(double A){
        sideA = A;
        sideB = A;
        sideC = A;
        area = calcArea();
        totalArea += area;
        numOfTri++;
    }
    
    public Triangle(){
        sideA = 0;
        sideB = 0;
        sideC = 0;
        area = calcArea();
        totalArea += area;
        numOfTri++;
    }
    
    private double calcArea(){
        double s = (sideA + sideB + sideC)/2;
        return Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
    }
    
    public double get_sideA(){
        return sideA;
    }
    
    public double get_sideB(){
        return sideB;
    }
    
    public double get_sideC(){
        return sideC;
    }
    
    public double get_area(){
        return area;
    }
    
    public static double get_totalArea(){
        return totalArea;
    }
    
    public static int get_numOfTri(){
        return numOfTri;
    }
    
    public void set_sideA(double A){
        totalArea -= area;
        sideA = A;
        area = calcArea();
        totalArea += area;
    }
    
    public void set_sideB(double B){
        totalArea -= area;
        sideB = B;
        area = calcArea();
        totalArea += area;
    }
    
    public void set_sideC(double C){
        totalArea -= area;
        sideC = C;
        area = calcArea();
        totalArea += area;
    }
    
    public static void main(String[] args){
        Triangle triangle1 = new Triangle(5,6,7);
        Triangle triangle2 = new Triangle(5,6);
        Triangle triangle3 = new Triangle(5);
        Triangle triangle4 = new Triangle();
        System.out.println(triangle1.get_area());
        System.out.println(triangle2.get_area());
        System.out.println(triangle3.get_area());
        System.out.println(triangle4.get_area());
        System.out.println(Triangle.get_totalArea());
        System.out.println(Triangle.get_numOfTri());
        triangle1.set_sideA(0);
        System.out.println(Triangle.get_totalArea());
    }
}