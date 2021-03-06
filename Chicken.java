
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Chicken extends AbstractAnimation {
	private static Chicken chicken =null;
	//Constructor passing id,X and Y axis positions
	private Chicken() {}
	   
	public static Chicken getInstance(){
		   if(chicken==null)
			   chicken=new Chicken();
		   return chicken;
	}
	
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
		g.setColor(Color.LIGHT_GRAY); 
		g.drawString(getID(),startX+50, startY+35);
		
		g.fillOval(startX+30, startY, 20, 20); //Head
		g.setColor(Color.RED); 
		g.fillOval(startX, startY, 40, 30);	//Body
		g.setColor(Color.BLACK);
		g.drawLine(startX+10,startY+20,startX+10, startY+30); //Left leg
		g.drawLine(startX+10, startY+30,startX-5, startY+40); //Left leg
		g.drawLine(startX+10, startY+30,startX+15, startY+40); //Left leg
		
		g.drawLine(startX+30, startY+20, startX+30, startY+30); //Right leg	
		g.drawLine(startX+30, startY+30, startX+25, startY+30); //Right leg	
		g.drawLine(startX+30, startY+30, startX+25, startY+30); //Right leg	
	}
	
	public void drawB(Graphics g) {
		int startX = getX( );
		int startY = getY( );
		
		g.setFont(new Font("TimesRoman", 10,50));
		g.setColor(Color.BLACK); 
		g.drawString(getID(),startX+50, startY+35);
		
		g.fillOval(startX+30, startY, 20, 20); //Head
		g.setColor(Color.RED); 
		g.fillOval(startX, startY, 40, 30);	//Body
		g.setColor(Color.BLACK);
		g.drawLine(startX+10,startY+20,startX+10, startY+30); //Left leg
		g.drawLine(startX+10, startY+30,startX-5, startY+40); //Left leg
		g.drawLine(startX+10, startY+30,startX+15, startY+40); //Left leg
		
		g.drawLine(startX+30, startY+20, startX+30, startY+30); //Right leg	
		g.drawLine(startX+30, startY+30, startX+25, startY+30); //Right leg	
		g.drawLine(startX+30, startY+30, startX+25, startY+30); //Right leg	
	}
	//Number of points the image should move
	   public void move(int speed ) { setY( getY( ) - speed ); }
}

