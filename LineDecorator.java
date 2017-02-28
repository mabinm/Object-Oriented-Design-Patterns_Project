

import java.awt.Color;
import java.awt.Graphics;



public class LineDecorator extends AbstractLineDecorator{
	   private static LineDecorator lineDecorator ;
	   Graphics g;
	   Color c;
	   private LineDecorator(Decorator decoratedShape,Color c){
		   super(decoratedShape);
		   this.c=c;
	   }
	   
	   public static LineDecorator getInstance(Decorator decoratedShape,Color c){
			if(lineDecorator==null)
				lineDecorator=new LineDecorator(decoratedShape,c);
			return lineDecorator;
		}	
	   
	   public void draw(Graphics g){
		   decoratedShape.draw(g);	
		   createLadder(g,c);		   	  
	   }
	   private void createLadder(Graphics g,Color c){
		   	g.setColor(c);
		    g.drawLine(150,50, 150, 1250);
		    g.drawLine(170,50, 170, 1250);
		    for(int i =0;i<100;i++)
		      g.drawLine(150,50+(10*i), 170, 50+(10*i));
		    
		    g.drawLine(250,50, 250, 1250);
		    g.drawLine(270,50, 270, 1250);
		    for(int i =0;i<100;i++)
			      g.drawLine(250,50+(10*i), 270, 50+(10*i));
		    
		    g.drawLine(350,50, 350, 1250);
		    g.drawLine(370,50, 370, 1250);
		    for(int i =0;i<100;i++)
			      g.drawLine(350,50+(10*i), 370, 50+(10*i));
		    
		    g.drawLine(450,50, 450, 1250);
		    g.drawLine(470,50, 470, 1250);
		    for(int i =0;i<100;i++)
			      g.drawLine(450,50+(10*i), 470, 50+(10*i));
		    
		    g.drawLine(550,50, 550, 1250);
		    g.drawLine(570,50, 570, 1250);
		    for(int i =0;i<100;i++)
			      g.drawLine(550,50+(10*i), 570, 50+(10*i));
	   }
}
