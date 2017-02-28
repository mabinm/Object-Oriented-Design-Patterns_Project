import java.awt.Graphics;	

public interface AnimalInterface {
	
	public void move(int speed );  
	public void setValues(String rID, int rX, int rY);
	public void draw( Graphics g,int flag);
	public void drawWinner(Graphics g,int startY);
	public int getX();
	public int getY();
	public void setX( int newX );
	public void setY( int newY );
	
}
