import java.awt.Color;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JApplet;

public class TestClimbStrategy extends JApplet{

	private static final long serialVersionUID = 1L;
	Random rand = new Random();
	AudioClip audioClip;
	
	//size of window
	int xSize = 1200;
	int ySize = 768;
	int flag =0;
	
	//starting Y position for all animals for climbing
	int startY =600;
	
	//starting X position for all animals for climbing
	int startXDog =100;
	int startXCat =200;
	int startXChicken =300;
	int startXSparrow=400;
	int startXRabbit =500;
	
	//for speed of animal movement
	int dogMovement;
	int catMovement;
	int chickenMovement;
	int sparrowMovement;
	int rabbitMovement;
	
	String firstString = null;
	
	//flags to decide which animal comes first and when climb is over
	boolean flagOne;
	boolean flagAll;
	boolean flagDog;
	boolean flagCat;
	boolean flagChicken;
	boolean flagSparrow;
	boolean flagRabbit;
	boolean flagSet;
	
	Decorator outlineDecorator; //add ladders to the walls
	Decorator outlineFigure; //draw walls for climbing
	
	AnimalInterface dogFigure;
	AnimalInterface catFigure;	
	AnimalInterface chickenFigure;
	AnimalInterface sparrowFigure;
	AnimalInterface rabbitFigure;
	
	
	ClimbStrategy leaderText; //strategy to determine who is winning the climbing competition
		
	public void init( ) {
		dogFigure = Dog.getInstance();		
		catFigure = Cat.getInstance();
		chickenFigure = Chicken.getInstance();
		sparrowFigure = Sparrow.getInstance();
		rabbitFigure = Rabbit.getInstance();
		
		outlineFigure = LineFigure.getInstance(50,50); //creates walls for climbing
		outlineDecorator = LineDecorator.getInstance(outlineFigure, Color.BLACK); //adds black ladders to the walls

		dogFigure.setValues( "", startXDog, startY );
		catFigure.setValues( "", startXCat, startY );
		chickenFigure.setValues( "", startXChicken, startY );
		sparrowFigure.setValues( "", startXSparrow, startY );
		rabbitFigure.setValues("", startXRabbit, startY );
				
		setSize(xSize, ySize);
		setBackground(Color.WHITE);
	}
	
	public void paint( Graphics g ) {		 
			
		try {
			
			while (true){
				
				//determine random values for speed increase
				dogMovement = rand.nextInt(10)+5;
				catMovement = rand.nextInt(10)+5;
				chickenMovement = rand.nextInt(10)+5;
				sparrowMovement = rand.nextInt(10)+5;
				rabbitMovement = rand.nextInt(10)+5;
				Thread.sleep(200);
				g.clearRect( 0, 0, xSize, ySize );
				
				
				outlineDecorator.draw(g);
				
				dogFigure.draw(g, flag);				
				catFigure.draw(g, flag);
				chickenFigure.draw(g, flag);
				sparrowFigure.draw(g, flag);
				rabbitFigure.draw(g, flag);	
				
				//Strategy to decide who is winning dynamically
				if(!flagAll){
					leaderText = LeaderTextStrategy.getInstance(dogFigure, catFigure, chickenFigure, sparrowFigure, rabbitFigure,g);
					leaderText.climbStrategy();
				}
				
				//for animal movement
				if(!flagSet){
						if(dogFigure.getY() > 50){
								dogFigure.move(dogMovement);							
						}
						else{
							if(!flagAll){
								flagOne=true;
								firstString="Dog ";
								flagDog=true;
							}
						}
						if(catFigure.getY()>50){
								catFigure.move(catMovement);	
						}
						else{
							if(!flagAll){
								if(flagOne){
									firstString+=" and Cat ";
									flagCat=true;
								}
								else{
									flagOne=true;
									firstString="Cat ";
									flagCat=true;
								}
							}
						}
						
						if(chickenFigure.getY() >50){
								chickenFigure.move(chickenMovement);	
						}
						else{
							if(!flagAll){
								if(flagOne){
									firstString+=" and Chicken ";
									flagChicken=true;
								}
								else{
									flagOne=true;
									firstString="Chicken ";
									flagChicken=true;
								}
							}
						}
						
						if(sparrowFigure.getY()>50){
								sparrowFigure.move(sparrowMovement);
						}
						else{
							if(!flagAll){
								if(flagOne){
									firstString+=" and Sparrow ";
									flagSparrow=true;
								}
								else{
									flagOne=true;
									firstString="Sparrow ";
									flagSparrow=true;
								}
							}
						}
						
						if(rabbitFigure.getY()>50){
								rabbitFigure.move(rabbitMovement);
						}
						else{
							if(!flagAll){
								if(flagOne){
									firstString+=" and Rabbit ";
									flagRabbit=true;
								}
								else{
									flagOne=true;
									firstString="Rabbit ";
									flagRabbit=true;
								}
							}							
						}
						if(flagOne){
							flagAll=true;							
						}
					if(dogFigure.getY()<=50&&catFigure.getY()<=50&&              //all animals have completed climbing
							chickenFigure.getY()<=50&&sparrowFigure.getY()<=50&&rabbitFigure.getY()<=50){
						flagSet=true;
					}					
				}
			
				if(flagSet&&flagAll){ 
					cameFirst(g);
				}
				flag+=1;
			}
		}
			
		catch (InterruptedException ex) {
			ex.printStackTrace();
		}	
	}
		
	//for winning animal
	public void cameFirst(Graphics g){
		if(flagDog ){	
			dogFigure.setValues("FASTEST CLIMBER", 100, 400);						
			dogFigure.draw(g, flag);
			audioClip = getAudioClip(getCodeBase(), "Applause.wav");//adds the applause sound
			audioClip.play();
		}
		if(flagCat ){
			catFigure.setValues("FASTEST CLIMBER", 200, 400);
			catFigure.draw(g, flag);
			audioClip = getAudioClip(getCodeBase(), "Applause.wav"); //adds the applause sound
			audioClip.play();
		}		
		if(flagChicken ){
			chickenFigure.setValues("FASTEST CLIMBER", 300, 400);					
			chickenFigure.draw(g, flag);
			audioClip = getAudioClip(getCodeBase(), "Applause.wav");//adds the applause sound
			audioClip.play();
		}
		if(flagSparrow ){
			sparrowFigure.setValues("FASTEST CLIMBER", 400, 400);
			sparrowFigure.draw(g, flag);
			audioClip = getAudioClip(getCodeBase(), "Applause.wav");//adds the applause sound
			audioClip.play();
		}
		if(flagRabbit){				
			rabbitFigure.setValues("FASTEST CLIMBER",500, 400);
			rabbitFigure.draw(g, flag);	
			audioClip = getAudioClip(getCodeBase(), "Applause.wav");//adds the applause sound
			audioClip.play();
		}		
	}
}


