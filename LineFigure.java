
import java.awt.Color;
import java.awt.Graphics;

public class LineFigure implements Decorator{
	private static LineFigure lineFigure =null;	
	private int x; 
	private int y;  
	
	private LineFigure(int rX, int rY) {
		this.x=rX;
		this.y=rY;
	}


	public static LineFigure getInstance(int rX, int rY){
		if(lineFigure==null)
			lineFigure=new LineFigure(rX, rY);
		return lineFigure;
	}	
	
	public void draw( Graphics g) {		   
		int startX = this.x;
	 	int startY =this.y;		 	
	 	
	 	g.setColor(new Color(177, 193, 196));
	    g.fillRect(startX, startY,100,1250);
	    g.setColor(new Color(159, 153, 250));
	    g.fillRect(150, startY,100,1250);
	    g.setColor(new Color(253, 134, 215));
	    g.fillRect(250, startY,100,1250);
	    g.setColor(new Color(237, 165, 237));
	    g.fillRect(350, startY,100,1250);
	    g.setColor(new Color(237, 200, 187));
	    g.fillRect(450, startY,100,1250);
	    
	}
}

