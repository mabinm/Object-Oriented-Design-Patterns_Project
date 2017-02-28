import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Rabbit extends AbstractAnimation {
	private static Rabbit rabbit=null;
	//Constructor passing id,X and Y axis positions
	private Rabbit() {}
	   
	public static Rabbit getInstance(){
	  if(rabbit==null)
		  rabbit=new Rabbit();
	  return rabbit;
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
		
		g.setColor(Color.black); 
		g.setFont(new Font("TimesRoman", 10,20));
		g.setColor(Color.WHITE); 
		g.drawString(getID(),startX+50, startY+35);
		
		g.fillOval(startX+30, startY, 25, 25); //Head
		g.fillOval(startX+30, startY, 5, 40);
		g.fillOval(startX, startY, 40, 30);	//Body
		g.fillOval(startX, startY-10, 20, 20); //tail
		
	}
	
	public void drawB(Graphics g) {
		int startX = getX( );
		int startY = getY( );
		
		g.setFont(new Font("TimesRoman", 10,50));
		g.setColor(Color.GRAY); 
		g.drawString(getID(),startX+50, startY+35);
		
		g.fillOval(startX+30, startY, 25, 25); //Head
		g.fillOval(startX+30, startY, 5, 40);
		g.fillOval(startX, startY, 40, 30);	//Body
		g.fillOval(startX, startY-10, 20, 20); //tail
	}
	//Number of points the image should move
	   public void move(int speed ) { setY( getY( ) - speed ); }
}