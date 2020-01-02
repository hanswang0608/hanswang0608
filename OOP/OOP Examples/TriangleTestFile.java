public class TriangleTestFile{
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