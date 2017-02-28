import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Dog extends AbstractAnimation {

	private static Dog dog =null;		
	int flag = 0;
	//Constructor passing id,X and Y axis positions
	private Dog() {}
   
	//Creating single object for Angry Figure
	public static Dog getInstance(){
		if(dog==null)
			dog=new Dog();
		return dog;
	}	
	//creating Angry Emoji image using graphics
	public void draw(Graphics g,int flag){
			if(flag%2==0){
				drawB(g);					
			}
			else{
				drawA(g);
			}
	}
	
	public void drawA(Graphics g){
		int startX = getX( );
		int startY = getY( );
		
		g.setFont(new Font("TimesRoman", 10,20));
		g.setColor(Color.RED); 
		g.drawString(getID(),startX+50, startY+35);
		
		g.fillOval(startX+40, startY, 20, 20); //Head
		g.setColor(Color.DARK_GRAY);
		g.fillOval(startX, startY, 50, 30);	//Body
		g.fillOval(startX, startY-10, 10, 30); //tail
		g.setColor(Color.BLACK);
		g.drawLine(startX+10,startY+20,startX+10, startY+40); //Left leg		
		g.drawLine(startX+40, startY+20, startX+40, startY+40); //Right leg		
	}
	
	public void drawB(Graphics g) {
		int startX = getX( );
		int startY = getY( );
		
		g.setFont(new Font("TimesRoman", 10,50));
		g.setColor(Color.RED); 
		g.drawString(getID(),startX+50, startY+35);
		
		g.fillOval(startX+40, startY, 20, 20); //Head
		g.setColor(Color.DARK_GRAY);
		g.fillOval(startX, startY, 50, 30);	//Body
		g.fillOval(startX-2, startY-10, 10, 30); //tail
		g.setColor(Color.BLACK);
		g.drawLine(startX+10,startY+20,startX+10, startY+40); //Left leg		
		g.drawLine(startX+40, startY+20, startX+40, startY+40); //Right leg		
	}
	//Number of points the image should move
	   public void move(int speed ) { setY( getY( ) - speed ); }
	
}