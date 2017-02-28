
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public abstract class AbstractAnimation implements AnimalInterface {
	
	AnimalInterface animal;
	private int x; 
	private int y;     
	private String ID;
	
	public AbstractAnimation() {}
	public String getID( ) { return ID; }
	public int getX( ) { return x; }
	public int getY( ) { return y; }
	public void setID( String newId ) { ID = newId; }
	public void setX( int newX ) { x = newX; }
	public void setY( int newY ) { y = newY; }
	//Number of points the image should climb
	public void move(int speed ) { setX( getX( ) - speed ); }
	
	public void setValues(String rID, int rX, int rY) {
		setID(rID);
		setX(rX);
		setY(rY);
	}
	public abstract void draw(Graphics g,int flag);
	
	public void drawWinner(Graphics g,int startX){
		g.setFont(new Font("TimesRoman", 10,20));
		g.setColor(Color.BLACK);
		g.drawString("WINNING", startX, 600);
	
	}
}