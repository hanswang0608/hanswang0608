public class RectangleTestFile
{
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