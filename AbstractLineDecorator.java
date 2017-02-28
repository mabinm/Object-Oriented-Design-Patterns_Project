import java.awt.Graphics;

public abstract class AbstractLineDecorator  implements Decorator{
	   protected Decorator decoratedShape;

	   public AbstractLineDecorator(Decorator decoratedShape){
	      this.decoratedShape = decoratedShape;
	   }

	   public void draw(Graphics g){
	      decoratedShape.draw(g);
	   }
}