public class Sandwich{
    private boolean bacon;
    private boolean lettuce;
    private boolean tomatoes;
    
    private static int totalSandwich = 0;
    
    public Sandwich(boolean b, boolean l, boolean t){
        bacon = b;
        lettuce = l;
        tomatoes = t;
        
        totalSandwich ++;
    }
    
    public boolean getBacon(){
        return bacon;
    }
    
    public boolean getLettuce(){
        return lettuce;
    }
    
    public boolean getTomatoes(){
        return tomatoes;
    }
    
    public void setBacon(boolean b){
        bacon = b;
    }
    
    public void setLettuce(boolean l){
        lettuce = l;
    }
    
    public void setTomatoes(boolean t){
        tomatoes = t;
    }
    
    public static int getTotalSandwich(){
        return totalSandwich;
    }
}