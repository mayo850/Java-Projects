import java.awt.Graphics;

/*
 * This is a simple client program to use the Point class
 */
public class PointMain {
    public static void main(String[] args) {
        // create three Point objects
        Point p1 = new Point(1, 5);
        
        Point p2 = new Point(3, -1);
           
        Point p3 = new Point();
    	
    	
        
        
        System.out.println("The quadrant of the point ("+ p2.getX() + " , "+ p2.getY()+ ") is "+  p2.quadrant());
        
        
        
        if (p1.closerToOriginThan(p2)) {
        	System.out.println("The point ("+ p2.getX() + " , "+ p2.getY()+ ") is closer to orgin");
        }else {
        	System.out.println("The point ("+ p1.getX() + " , "+ p1.getY()+ ") is closer to orgin");
        
        }
    
        p1.add(p2);
        System.out.println("After add " + p1.toString());
        
        
        System.out.print("Flip of the point ("+ p2.getX() + " , "+ p2.getY()+ ") is " );
        p2.flip();
        System.out.println(p2.toString());
        //double distance2 = p1.distanceBetween(p2);
        //System.out.println("p1 to p2 is " + distance2);	
        
        //double distance3 = p2.distanceBetween(p3);
        //System.out.println("p2 to p3 is " + distance3);	
     }
}
