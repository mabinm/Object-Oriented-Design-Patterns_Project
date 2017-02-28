import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Cat extends AbstractAnimation {

	private static Cat cat =null;
	//Constructor passing id,X and Y axis positions
	private Cat() {}
	public static Cat getInstance(){
		   if(cat==null)
			   cat=new Cat();
		   return cat;
	}  	   
	public void draw(Graphics g,int flag){
		if(flag%2==0){
			drawA(g);					
		}
		else{
			drawB(g);
		}
	}

	public void drawA(Graphics g){
		int startX = getX( );
		int startY = getY( );
		
		g.setFont(new Font("TimesRoman", 10,20));
		g.setColor(Color.BLACK); 
		g.drawString(getID(),startX+50, startY+35);
		
		g.fillOval(startX+40, startY, 20, 20); //Head
		g.fillOval(startX+50, startY, 5, 20);//left ear
		g.fillOval(startX+55, startY, 5, 20); //right ear
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
		g.setColor(Color.BLACK); 
		g.drawString(getID(),startX+50, startY+35);
		
		g.fillOval(startX+40, startY, 20, 20); //Head
		g.fillOval(startX+50, startY, 5, 20);//left ear
		g.fillOval(startX+55, startY, 5, 20); //right ear
		g.fillOval(startX, startY, 50, 30);	//Body
		g.fillOval(startX-5, startY-10, 10, 30); //tail
		g.setColor(Color.BLACK);
		g.drawLine(startX+10,startY+20,startX+10, startY+40); //Left leg		
		g.drawLine(startX+40, startY+20, startX+40, startY+40); //Right leg	
	}
	
	//Number of points the image should move
	   public void move(int speed ) { setY( getY( ) - speed ); }
}
