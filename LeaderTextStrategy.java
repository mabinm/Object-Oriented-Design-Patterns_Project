
import java.awt.Graphics;

public class LeaderTextStrategy implements ClimbStrategy{
	
	private static LeaderTextStrategy leaderStrategy =null;	
	
	AnimalInterface dogFigure;
	AnimalInterface catFigure;	
	AnimalInterface chickenFigure;
	AnimalInterface sparrowFigure;
	AnimalInterface rabbitFigure;
	Graphics g;
	
	private LeaderTextStrategy(AnimalInterface dogFigure,AnimalInterface catFigure,AnimalInterface chickenFigure,
			AnimalInterface sparrowFigure,AnimalInterface rabbitFigure,Graphics g){
			this.dogFigure=dogFigure;
			this.catFigure=catFigure;
			this.chickenFigure=chickenFigure;
			this.sparrowFigure=sparrowFigure;
			this.rabbitFigure=rabbitFigure;
			this.g=g;
	}
	
	public static LeaderTextStrategy getInstance(AnimalInterface dogFigure,AnimalInterface catFigure,AnimalInterface chickenFigure,
			AnimalInterface sparrowFigure,AnimalInterface rabbitFigure,Graphics g){
		if(leaderStrategy==null)
			leaderStrategy=new LeaderTextStrategy(dogFigure, catFigure, chickenFigure, sparrowFigure, rabbitFigure,g);
		return leaderStrategy;
	}
	
	public void climbStrategy() {
		int[] numbers = {dogFigure.getY(),catFigure.getY(),chickenFigure.getY(),sparrowFigure.getY(),rabbitFigure.getY()};
		int smallest = 1000;
		for(int i =0;i<numbers.length;i++) {
		    if(numbers[i] < smallest) {
		        smallest = numbers[i];
		    }
		}
		if(smallest==dogFigure.getY()){
			dogFigure.drawWinner(g, 70);
		}
		if(smallest==catFigure.getY()){
			catFigure.drawWinner(g, 170);
		}
		if(smallest==chickenFigure.getY()){
			chickenFigure.drawWinner(g, 270);
		}
		if(smallest==sparrowFigure.getY()){
			sparrowFigure.drawWinner(g, 370);
		}
		if(smallest==rabbitFigure.getY()){
			rabbitFigure.drawWinner(g, 470);			
		}		
	}
	
}
