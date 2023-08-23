/**
 * @author Izan Khan
 * @assignment CSC212-Program10
 * @version (09 May, 2019)
 * 
 * Tile class represents a graphical rectangular colored tile.
 * 
 * Citations of assistance (who and what):
 */
import java.awt.*;

class Tile implements Comparable<Tile>{
	private int x_coordinates;
	private int y_coordinates;
	private int width;
	private int height;
	private Color color;
	
	public Tile() {
		
	}
	
	public Tile(int x, int y, int z, int a, Color b) {
		this.x_coordinates=x;
		this.y_coordinates=y;
		this.width=z;
		this.height=a;
		this.color=b;
	}
	
	public void setX_Coordinates(int value) {
		this.x_coordinates=value;
	}
	
	public void setY_Coordinates(int value) {
		this.y_coordinates=value;
	}
	
	public void setWidth(int value) {
		this.width=value;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setHeight(int value) {
		this.height=value;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void setColor(Color value) {
		this.color=value;
	}
	
	public int getxCoordinates() {
		return this.x_coordinates;
	}
	
	public int getyCoordinates() {
		return this.y_coordinates;
	}
	
	/**
	 * instance method containsPoint that accepts two parameters (an x and a y) and returns true if (x, y) lies
     * inside of the tile, not on the border, and false otherwise.
	 * @param x 
	 * @param y
	 * @return - true or false
	 */
	public boolean containsPoint (int x, int y) {
		
		 return (x >= getxCoordinates() && x <= getxCoordinates() + this.width && y >= getyCoordinates() && y <= getxCoordinates() + this.height);
		
	}
	
	public String toString() {
		
		return "Tile [x = " + this.getxCoordinates()+ " , y = " + this.getyCoordinates()+ " , width = "+ this.width+" , height = "+this.height+ " , color = "+this.color+ " ]";
	}
	
	@Override
	public int compareTo(Tile st) {
		int area = this.getHeight() * this.getWidth();
	if(area == (st.height * st.width))  
		return 0;  
	else if(area<(st.height * st.width))  
		return 1;  
	else  
			return -1;  
	
	}
}