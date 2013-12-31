/* Name: David
 * File: Megaman.java
 * Description: TODO: This is the file that represents Megaman.
 */
/*	
 * 	Search Terms:  Push Ctrl+F and type these Terms into "Find:"
 * | Collision | Shoot |
 */
/* Info
 * Direct refers to where Megaman is facing.  1 is left.  2 is right.
 */
import acm.graphics.*;
import acm.util.*;
import java.util.*;
import java.applet.*;
public class Megaman extends GCompound
{
	//Other GCompound Referencing
	
	//ArrayList
	ArrayList<Bullet> BulletList = new ArrayList<Bullet>();
//	imported Images for each animation of Megaman.
	private GImage StandRight;
	private GImage StandLeft;
	private GImage ShootingRight;
	private GImage ShootingLeft;
	private GImage RunningRight;
	private GImage RunningLeft;
	private GImage RunShootingRight;
	private GImage RunShootingLeft;
	private GImage ConfusedLeft;
	private GImage ConfusedRight;
	private GImage JumpLeft;
	private GImage JumpRight;
	private GImage JumpShootingLeft;
	private GImage JumpShootingRight;
	private GImage PainLeft;
	private GImage PainRight;
	private GImage SlideLeft;
	private GImage SlideRight;
	private GImage StandRightCharge1;
	private GImage StandRightCharge2;
	private GImage StandLeftCharge1;
	private GImage StandLeftCharge2;
	private GImage RunRightCharge1;
	private GImage RunRightCharge2;
	private GImage RunLeftCharge1;
	private GImage RunLeftCharge2;
	private GImage JumpRightCharge1;
	private GImage JumpRightCharge2;
	private GImage JumpLeftCharge1;
	private GImage JumpLeftCharge2;
	
	//Sound
	private AudioClip pew = MediaTools.loadAudioClip("sound/sound effects/shewt.WAV");
//	GObjects used to create Collision
	private GRect LeftBound;
	private GRect RightBound;
	private GRect UpBound;
	private GRect DownBound;
	
//	The Point that the Bounds set to.
	private GPoint LeftPt;
	private GPoint RightPt;
	private GPoint UpPt;
	private GPoint DownPt;
	private GPoint MegaPt;
//	The Dimensions that make up Megaman's directional values and Bounds.
	private GRectangle LeftRect;
	private GRectangle RightRect;
	private GRectangle UpRect;
	private GRectangle DownRect;
	private GRectangle MegaRect;
	
	//A boolean that represents Megaman sliding
	private boolean Sliding;
	
//	Fields for return
	boolean JumpReturn;
	int PainReturn;
	int ShootReturn;
	
	//Permanent Fields
	private int PermaJumpTime;
	private boolean PermaGravity;
	private double GravSpeed;
	private int Strength;
	private int BulletListWhile;
	private int Lives = 4;
	private boolean dead = false;
	private boolean deadchecked = false;
	private ArrayList<GRectangle> BulletBoundList = new ArrayList<GRectangle>();
	private ArrayList<GImage> FloatingExplosion = new ArrayList<GImage>();
	private int CountDown = 100;
	private int HPRec = 28;
	private int PermaHP = 28;
	//Fields for Collision Objects
	boolean LeftBlock;
	boolean RightBlock;
	boolean UpBlock;
	boolean HoriBlock;
	boolean VertBlock;
	
	//Fields for sidescroll blocking
	boolean LeftStop;
	boolean RightStop;
	boolean UpStop;
	boolean DownStop;
	public Megaman()
	{
//		Loading the Images.
		StandRight = new GImage(MediaTools.loadImage("spritesheets/Megaman/stand/StandBored.gif"),0, 0);
		StandLeft = new GImage(MediaTools.loadImage("spritesheets/Megaman/stand/StandBoredLeft.gif"), 0, 0);
		ShootingRight = new GImage(MediaTools.loadImage("spritesheets/Megaman/stand/Shoot.gif"),0, 0);
		ShootingLeft = new GImage(MediaTools.loadImage("spritesheets/Megaman/stand/ShootLeft.gif"), -10, 0);
		RunningRight = new GImage(MediaTools.loadImage("spritesheets/Megaman/run/RunningRight.gif"), 0, 0);
		RunningLeft = new GImage(MediaTools.loadImage("spritesheets/Megaman/run/RunningLeft.gif"), 0, 0);
		RunShootingRight = new GImage(MediaTools.loadImage("spritesheets/Megaman/run/RunShootingRight.gif"), 0, 0);
		RunShootingLeft = new GImage(MediaTools.loadImage("spritesheets/Megaman/run/RunShootingLeft.gif"), -6, 0);
		ConfusedRight = new GImage(MediaTools.loadImage("spritesheets/Megaman/Stand/StandConfused.gif"), 0, 0);
		ConfusedLeft = new GImage(MediaTools.loadImage("spritesheets/Megaman/Stand/StandConfusedLeft.gif"), 0, 0);
		JumpLeft = new GImage(MediaTools.loadImage("spritesheets/Megaman/Jump/JumpLeft.gif"), 0, -6);
		JumpRight = new GImage(MediaTools.loadImage("spritesheets/Megaman/Jump/Jump.gif"), 0, -6);
		JumpShootingLeft = new GImage(MediaTools.loadImage("spritesheets/Megaman/Jump/JumpShootLeft.gif"), -3, -6);
		JumpShootingRight = new GImage(MediaTools.loadImage("spritesheets/Megaman/Jump/JumpShoot.gif"), 0, -6);
		PainLeft = new GImage(MediaTools.loadImage("spritesheets/Megaman/Pain/OuchyLeft.gif"), 0, -6);
		PainRight = new GImage(MediaTools.loadImage("spritesheets/Megaman/Pain/OuchyRight.gif"), -6, -6);
		SlideLeft = new GImage(MediaTools.loadImage("spritesheets/Megaman/Stand/SlideLeft.gif"), 0, 5);
		SlideRight = new GImage(MediaTools.loadImage("spritesheets/Megaman/Stand/SlideRight.gif"), 0, 5);
		StandRightCharge1 = new GImage(MediaTools.loadImage("spritesheets/Megaman/Charge/Stand/lowright.gif"),0, 0);
		StandRightCharge2 = new GImage(MediaTools.loadImage("spritesheets/Megaman/Charge/Stand/highright.gif"),0, 0);
		StandLeftCharge1 = new GImage(MediaTools.loadImage("spritesheets/Megaman/Charge/Stand/lowleft.gif"),0, 0);
		StandLeftCharge2 = new GImage(MediaTools.loadImage("spritesheets/Megaman/Charge/Stand/highleft.gif"),0, 0);
		RunRightCharge1 = new GImage(MediaTools.loadImage("spritesheets/Megaman/Charge/Run/lowright.gif"),0, 0);
		RunRightCharge2 = new GImage(MediaTools.loadImage("spritesheets/Megaman/Charge/Run/highright.gif"),0, 0);
		RunLeftCharge1 = new GImage(MediaTools.loadImage("spritesheets/Megaman/Charge/Run/lowleft.gif"),0, 0);
		RunLeftCharge2 = new GImage(MediaTools.loadImage("spritesheets/Megaman/charge/Run/highleft.gif"),0, 0);
		JumpRightCharge1 = new GImage(MediaTools.loadImage("spritesheets/Megaman/charge/Jump/lowright.gif"), 0, -6);
		JumpRightCharge2 = new GImage(MediaTools.loadImage("spritesheets/Megaman/charge/Jump/highright.gif"), 0, -6);
		JumpLeftCharge1 = new GImage(MediaTools.loadImage("spritesheets/Megaman/charge/Jump/lowleft.gif"), 0, -6);
		JumpLeftCharge2 = new GImage(MediaTools.loadImage("spritesheets/Megaman/charge/Jump/highleft.gif"), 0, -6);
		
		//Rectangles which may be added to help visually test the bounds.  For Testing Purposes.
		LeftBound = new GRect(StandRight.getX(), StandRight.getY() + 1, 3, StandRight.getHeight() - 5);
		RightBound = new GRect(StandRight.getX() + StandRight.getWidth() - 3, StandRight.getY() + 1, 3, StandRight.getHeight() - 5);
		UpBound = new GRect(StandRight.getX() + 1, StandRight.getY(), StandRight.getWidth() - 2, 3);
		DownBound = new GRect(StandRight.getX() + 1, StandRight.getY() + StandRight.getHeight() - 3, StandRight.getWidth() - 2, 3);
		
		//GPoints
		LeftPt = new GPoint(LeftBound.getLocation());
		RightPt = new GPoint(RightBound.getLocation());
		UpPt = new GPoint(UpBound.getLocation());
		DownPt = new GPoint(DownBound.getLocation());
		MegaPt = new GPoint(0, 0);
		
		//Bounds for Megaman's Collision.
		LeftRect = new GRectangle(StandRight.getX(), StandRight.getY() + 1, 3, StandRight.getHeight() - 5);
		RightRect = new GRectangle(StandRight.getX() + StandRight.getWidth() - 3, StandRight.getY() + 1, 3, StandRight.getHeight() - 5);
		UpRect = new GRectangle(StandRight.getX() + 1, StandRight.getY() + StandRight.getHeight() - 3, StandRight.getWidth() - 2, 3);
		DownRect = new GRectangle(StandRight.getX() + 1, StandRight.getY() -3, StandRight.getWidth() - 2, 3);
		MegaRect = new GRectangle(StandRight.getBounds());
		
		//Rectangles which may be added to help visually test the bounds.  For Testing Purposes.
		LeftBound.setBounds(LeftRect.getBounds());
		RightBound.setBounds(RightRect.getBounds());
		UpBound.setBounds(UpRect.getBounds());
		DownBound.setBounds(DownRect.getBounds());
		
//		Adding the Images.
		add(StandLeft);
		add(StandRight);
		add(ShootingRight);
		add(ShootingLeft);
		add(RunningRight);
		add(RunningLeft);
		add(RunShootingRight);
		add(RunShootingLeft);
		add(ConfusedRight);
		add(ConfusedLeft);	
		add(JumpLeft);
		add(JumpRight);
		add(JumpShootingLeft);
		add(JumpShootingRight);
		add(PainLeft);
		add(PainRight);
		add(SlideLeft);
		add(SlideRight);
		add(StandRightCharge1);
		add(StandRightCharge2);
		add(StandLeftCharge1);
		add(StandLeftCharge2);
		add(RunLeftCharge2);
		add(RunRightCharge1);
		add(RunRightCharge2);
		add(RunLeftCharge1);
		add(RunLeftCharge2);
		add(JumpRightCharge1);
		add(JumpRightCharge2);
		add(JumpLeftCharge1);
		add(JumpLeftCharge2);
		
	}
	
	public int MegaControl(boolean Left, boolean Right, boolean Shoot, int Direct, boolean Gravity, boolean Jump,boolean Down, boolean Slide, int JumpTimer, int Pain, int ShootTimer, int Power, int Life, int HP,
			/*The following parameters are Arrays for levels*/ ArrayList<GRect> Ground, ArrayList<GRect> LeftNo, ArrayList<GRect> RightNo, ArrayList<GRect> UpNo, ArrayList<GRect> DownNo, ArrayList<GRect> FallDeath)
	{
		//If Megaman has fallen in Spikes or in a nonleading hole, then kill him.
		for(GRect fall: FallDeath)
		{
			if(DownRect.intersects(fall.getBounds()))
			{
				HP = 0;
			}
		}
		//If Megaman's health is ever 0 or below, then kill him.
		if(HP <= 0)
		{
			dead = true;
		}
		//If Megaman is not dead, then do his ordinary actions.
		if(dead == false)
		{
			//Record Megamans Remaining Lives.
			Lives = Life;
			//Resets all of the Collision booleans to false.
			LeftBlock = false;
			RightBlock = false;
			HoriBlock = false;
			UpBlock = false;
			VertBlock = false;
			//Resets all sidescolling booleans to false;
			LeftStop = false;
			RightStop = false;
			UpStop = false;
			DownStop = false;
			//Sets the Bound GRectangles at the locations of the points.
			MegaRect.setLocation(getCanvasPoint(MegaPt));
			RightRect.setLocation(getCanvasPoint(RightPt));
			LeftRect.setLocation(getCanvasPoint(LeftPt));
			UpRect.setLocation(getCanvasPoint(UpPt));
			DownRect.setLocation(getCanvasPoint(DownPt));
			//The PreCollision check of Left and Right sides to determine HoriBlock.
			for(GRect wall: Ground)
			{
				if(LeftRect.getBounds().intersects(wall.getBounds())
						&&	  RightRect.getBounds().intersects(wall.getBounds()))
				{
					HoriBlock = true;
				}
			}
			//The PreCollision check of Up and Down sides to determin VertBlock.
			for(GRect block: Ground)
			{
				if(UpRect.getBounds().intersects(block.getBounds())
						&&	DownRect.getBounds().intersects(block.getBounds())
						&& VertBlock == false)
				{
					VertBlock = true;
				}
			}
			
			//The sidescrolling prevention checkers.  Tested for in the same way as the Collision objects.
			for(GRect left: LeftNo)
			{
				if((LeftRect.getBounds()).intersects(left.getBounds()))
				{
					LeftStop = true;
				}
			}
			for(GRect right: RightNo)
			{
				if((RightRect.getBounds()).intersects(right.getBounds()))
				{
					RightStop = true;
				}
			}
			for(GRect up: UpNo)
			{
				if((UpRect.getBounds()).intersects(up.getBounds()))
				{
					UpStop = true;
				}
			}
			for(GRect down: DownNo)
			{
				if((DownRect.getBounds()).intersects(down.getBounds()))
				{
					DownStop = true;
				}
			}
			//If the LeftRect's bound on the canvas connects to any of the level's objects, make LeftBlock true and shift Megaman back out of the wall.
			for(GRect wall: Ground)
			{
				if((LeftRect.getBounds()).intersects(wall.getBounds()))
				{
					LeftBlock = true;
					if(Math.abs(wall.getY() - DownRect.getY()) > Math.abs(wall.getY() - LeftRect.getY())
							&& Math.abs(wall.getX() - LeftRect.getX()) < Math.abs(wall.getX() - DownRect.getX())
							&& wall.getY() - UpRect.getY() < Math.abs(wall.getY() - LeftRect.getY())
							&& Math.abs(wall.getX() - LeftRect.getX()) < Math.abs(wall.getX() - UpRect.getX())
							&& Math.abs(wall.getY() + wall.getHeight() - DownRect.getY()) < Math.abs(wall.getY() + wall.getHeight() - LeftRect.getY() - LeftRect.getHeight())
							&& HoriBlock == false
							&& VertBlock == true)
					{
						double center = wall.getX() + wall.getWidth() - LeftRect.getX();
						if(center < 13)
						{
							while(center > -1)
							{
								move(1, 0);
								for(Bullet bullet: BulletList)
								{
									bullet.move(-1, 0);
								}
								center = center - 1;
							}
						}
					}
				}
			}
//			If the RightRect's bound on the canvas connects to any of the level's objects, make RightBlock true and shift Megaman back out of the wall.
			for(GRect wall: Ground)
			{
				if((RightRect.getBounds()).intersects(wall.getBounds()))
				{
					RightBlock = true;
					if(Math.abs(wall.getY() - DownRect.getY()) > Math.abs(wall.getY() - (RightRect.getY()))
							&& wall.getX() - RightRect.getX() < wall.getX() - DownRect.getX()
							/*&& Math.abs(wall.getY() - UpRect.getY()) < Math.abs(wall.getY() - RightRect.getY() + RightRect.getHeight())*/
							&& wall.getX() - RightRect.getX() < wall.getX() - UpRect.getX()
							&& Math.abs(wall.getY() + wall.getHeight() - DownRect.getY()) < Math.abs(wall.getY() + wall.getHeight() - RightRect.getY() - RightRect.getHeight())
							&& HoriBlock == false
							&& VertBlock == true)
					{
						double center = RightRect.getX() + RightRect.getWidth() - wall.getX();
						if(center < 13)
						{
							while(center > 0)
							{
								move(-1, 0);
								for(Bullet bullet: BulletList)
								{
									bullet.move(1, 0);
								}
								center = center - 1;
							}
						}
					}
				}
			}
//			If the UpRect's bound on the canvas connects to any of the level's objects, make UpBlock true and turn the Gravity on, knocking Megaman to the ground.
			for(GRect ceil : Ground)
			{
				UpRect.setLocation(getCanvasPoint(UpPt));
				if((UpRect.getBounds()).intersects(ceil.getBounds()))
				{
					if(Math.abs(ceil.getX() - UpRect.getX()) < Math.abs(ceil.getX() - RightRect.getX())
							&& Math.abs(ceil.getX() + ceil.getWidth() - UpRect.getX()) < Math.abs(ceil.getX() + ceil.getWidth() - LeftRect.getX())
							&& Gravity == false)
						UpBlock = true;
					JumpTimer = 10;
					GravSpeed = 4;
				}
			}
			//If the keys required to Slide(Down, CTRL), turn sliding on and Jumping off.
			if(Down == true && Slide ==  true && Gravity == false & JumpTimer == 10)
			{
				Sliding = true;
				Jump = false;
			}
			else
			{
				Sliding = false;
			}
			//If the JumpTimer is 0, force Jump off and reset JumpTimer.
			if(JumpTimer == 0)
			{
				Jump = false;
				JumpTimer = 10;
			}
			//If the charging power is above 0(having started charging already), then increase it again by 1.
			if(Power > 0)
			{
				Power = Power + 1;
			}
			
			//	Shoot but lack movement.
			if(Sliding == false)
			{
				// For a short period, the ShootTimer will go down and upon hitting 0, Megaman will drop his gun whether shoot is held or not.
				if(Shoot == true)
				{
					ShootTimer = ShootTimer - 1;
					
					if(ShootTimer > 0)
					{
//						If Space is held then aim the gun from a NonMoving position.
						if(Direct == 1)
						{
							RunShootingRight.setVisible(false);
							RunShootingLeft.setVisible(false);
							StandLeft.setVisible(false);
							StandRight.setVisible(false);
							ShootingLeft.setVisible(true);
							ShootingRight.setVisible(false);
							RunningRight.setVisible(false);
							RunningLeft.setVisible(false);
							ConfusedRight.setVisible(false);
							ConfusedLeft.setVisible(false);
							JumpLeft.setVisible(false);
							JumpRight.setVisible(false);
							JumpShootingLeft.setVisible(false);
							JumpShootingRight.setVisible(false);
							PainLeft.setVisible(false);
							PainRight.setVisible(false);
							SlideLeft.setVisible(false);
							SlideRight.setVisible(false);
							StandRightCharge1.setVisible(false);
							StandRightCharge2.setVisible(false);
							StandLeftCharge1.setVisible(false);
							StandLeftCharge2.setVisible(false);
							RunRightCharge1.setVisible(false);
							RunRightCharge2.setVisible(false);
							RunLeftCharge1.setVisible(false);
							RunLeftCharge2.setVisible(false);
							JumpRightCharge1.setVisible(false);
							JumpRightCharge2.setVisible(false);
							JumpLeftCharge1.setVisible(false);
							JumpLeftCharge2.setVisible(false);
						}
						if(Direct == 2)
						{
							RunShootingRight.setVisible(false);
							RunShootingLeft.setVisible(false);
							StandLeft.setVisible(false);
							StandRight.setVisible(false);
							ShootingLeft.setVisible(false);
							ShootingRight.setVisible(true);
							RunningRight.setVisible(false);
							RunningLeft.setVisible(false);
							ConfusedRight.setVisible(false);
							ConfusedLeft.setVisible(false);
							JumpLeft.setVisible(false);
							JumpRight.setVisible(false);
							JumpShootingLeft.setVisible(false);
							JumpShootingRight.setVisible(false);
							PainLeft.setVisible(false);
							PainRight.setVisible(false);
							SlideLeft.setVisible(false);
							SlideRight.setVisible(false);
							StandRightCharge1.setVisible(false);
							StandRightCharge2.setVisible(false);
							StandLeftCharge1.setVisible(false);
							StandLeftCharge2.setVisible(false);
							RunRightCharge1.setVisible(false);
							RunRightCharge2.setVisible(false);
							RunLeftCharge1.setVisible(false);
							RunLeftCharge2.setVisible(false);
							JumpRightCharge1.setVisible(false);
							JumpRightCharge2.setVisible(false);
							JumpLeftCharge1.setVisible(false);
							JumpLeftCharge2.setVisible(false);
						}
					}
				}
			}	
			
			if(Sliding == false)
			{
				if (Left == true)
				{
					if (Shoot == true)
					{
						if(Pain == 24)
						{
//							Moves all the images together.
							move(-6, 0);
							BulletListWhile = 0;
							while(BulletListWhile < BulletList.size())
							{
								BulletList.get(BulletListWhile).move(6, 0);
								BulletListWhile = BulletListWhile + 1;
							}
							BulletListWhile = 0;
							
						}
						//If Left and Space are held then run left while shooting.
						RunShootingRight.setVisible(false);
						RunShootingLeft.setVisible(true);
						StandLeft.setVisible(false);
						StandRight.setVisible(false);
						ShootingLeft.setVisible(false);
						ShootingRight.setVisible(false);
						RunningRight.setVisible(false);
						RunningLeft.setVisible(false);
						ConfusedRight.setVisible(false);
						ConfusedLeft.setVisible(false);
						JumpLeft.setVisible(false);
						JumpRight.setVisible(false);
						JumpShootingLeft.setVisible(false);
						JumpShootingRight.setVisible(false);
						PainLeft.setVisible(false);
						PainRight.setVisible(false);
						SlideLeft.setVisible(false);
						SlideRight.setVisible(false);
						StandRightCharge1.setVisible(false);
						StandRightCharge2.setVisible(false);
						StandLeftCharge1.setVisible(false);
						StandLeftCharge2.setVisible(false);
						RunRightCharge1.setVisible(false);
						RunRightCharge2.setVisible(false);
						RunLeftCharge1.setVisible(false);
						RunLeftCharge2.setVisible(false);
						JumpRightCharge1.setVisible(false);
						JumpRightCharge2.setVisible(false);
						JumpLeftCharge1.setVisible(false);
						JumpLeftCharge2.setVisible(false);
						
					}
					
					else
					{
						if(Pain == 24)
						{
//							Moves all the images together.
							if(LeftBlock == false)
							{
								move(-6, 0);
								for(Bullet bullet: BulletList)
								{
									bullet.move(6, 0);
								}
							}
							
						}
						//If Left is held then run left.
						RunShootingRight.setVisible(false);
						RunShootingLeft.setVisible(false);
						StandLeft.setVisible(false);
						StandRight.setVisible(false);
						ShootingLeft.setVisible(false);
						ShootingRight.setVisible(false);
						RunningRight.setVisible(false);
						RunningLeft.setVisible(true);
						ConfusedRight.setVisible(false);
						ConfusedLeft.setVisible(false);
						JumpLeft.setVisible(false);
						JumpRight.setVisible(false);
						JumpShootingLeft.setVisible(false);
						JumpShootingRight.setVisible(false);
						PainLeft.setVisible(false);
						PainRight.setVisible(false);
						SlideLeft.setVisible(false);
						SlideRight.setVisible(false);
						StandRightCharge1.setVisible(false);
						StandRightCharge2.setVisible(false);
						StandLeftCharge1.setVisible(false);
						StandLeftCharge2.setVisible(false);
						RunRightCharge1.setVisible(false);
						RunRightCharge2.setVisible(false);
						RunLeftCharge1.setVisible(false);
						RunLeftCharge2.setVisible(false);
						JumpRightCharge1.setVisible(false);
						JumpRightCharge2.setVisible(false);
						JumpLeftCharge1.setVisible(false);
						JumpLeftCharge2.setVisible(false);
					}
					if(Power > 20)
					{
						RunningLeft.setVisible(false);
						RunLeftCharge1.setVisible(true);
					}
					if(Power > 40)
					{
						RunLeftCharge1.setVisible(false);
						RunLeftCharge2.setVisible(true);
					}
					
				}
			}
			if(Sliding == false)
			{
				if (Right == true)
				{
					if (Shoot == true)
					{
						if(Pain == 24)
						{
							if(RightBlock == false)
							{
								move(6, 0);
								for(Bullet bullet: BulletList)
								{
									bullet.move(-6, 0);
								}
							}
							
							//Moves all the images together
						}
						RunShootingRight.setVisible(true);
						RunShootingLeft.setVisible(false);
						StandLeft.setVisible(false);
						StandRight.setVisible(false);
						ShootingLeft.setVisible(false);
						ShootingRight.setVisible(false);
						RunningRight.setVisible(false);
						RunningLeft.setVisible(false);		
						ConfusedRight.setVisible(false);
						ConfusedLeft.setVisible(false);
						JumpLeft.setVisible(false);
						JumpRight.setVisible(false);
						JumpShootingLeft.setVisible(false);
						JumpShootingRight.setVisible(false);
						PainLeft.setVisible(false);
						PainRight.setVisible(false);
						SlideLeft.setVisible(false);
						SlideRight.setVisible(false);
						StandRightCharge1.setVisible(false);
						StandRightCharge2.setVisible(false);
						StandLeftCharge1.setVisible(false);
						StandLeftCharge2.setVisible(false);
						RunRightCharge1.setVisible(false);
						RunRightCharge2.setVisible(false);
						RunLeftCharge1.setVisible(false);
						RunLeftCharge2.setVisible(false);
						JumpRightCharge1.setVisible(false);
						JumpRightCharge2.setVisible(false);
						JumpLeftCharge1.setVisible(false);
						JumpLeftCharge2.setVisible(false);
						
					}
					else
					{
						if(Pain == 24)
						{
							if(RightBlock == false)
							{
								move(6, 0);
								for(Bullet bullet: BulletList)
								{
									bullet.move(-6, 0);
								}
							}
							
						}
						//Moves all the images together
						RunShootingRight.setVisible(false);
						RunShootingLeft.setVisible(false);
						StandLeft.setVisible(false);
						StandRight.setVisible(false);
						ShootingLeft.setVisible(false);
						ShootingRight.setVisible(false);
						RunningRight.setVisible(true);
						RunningLeft.setVisible(false);
						ConfusedRight.setVisible(false);
						ConfusedLeft.setVisible(false);
						JumpLeft.setVisible(false);
						JumpRight.setVisible(false);
						JumpShootingLeft.setVisible(false);
						JumpShootingRight.setVisible(false);
						PainLeft.setVisible(false);
						PainRight.setVisible(false);
						SlideLeft.setVisible(false);
						SlideRight.setVisible(false);
						StandRightCharge1.setVisible(false);
						StandRightCharge2.setVisible(false);
						StandLeftCharge1.setVisible(false);
						StandLeftCharge2.setVisible(false);
						RunRightCharge1.setVisible(false);
						RunRightCharge2.setVisible(false);
						RunLeftCharge1.setVisible(false);
						RunLeftCharge2.setVisible(false);
						JumpRightCharge1.setVisible(false);
						JumpRightCharge2.setVisible(false);
						JumpLeftCharge1.setVisible(false);
						JumpLeftCharge2.setVisible(false);
						//Hold right to just run right
						if(Power > 20)
						{
							RunningRight.setVisible(false);
							RunRightCharge1.setVisible(true);
						}
						if(Power > 40)
						{
							RunRightCharge1.setVisible(false);
							RunRightCharge2.setVisible(true);
						}
					}
				}
			}
			if(Sliding == false)
			{
				if(Shoot == false)
				{
					if(Jump == false)
					{
						if(Left == true)
						{
							if(Right == true)
							{
								if(Direct == 1)
								{
									RunShootingRight.setVisible(false);
									RunShootingLeft.setVisible(false);
									StandLeft.setVisible(false);
									StandRight.setVisible(false);
									ShootingLeft.setVisible(false);
									ShootingRight.setVisible(false);
									RunningRight.setVisible(false);
									RunningLeft.setVisible(false);
									ConfusedRight.setVisible(false);
									ConfusedLeft.setVisible(true);
									JumpShootingLeft.setVisible(false);
									JumpShootingRight.setVisible(false);
									PainLeft.setVisible(false);
									PainRight.setVisible(false);
									SlideLeft.setVisible(false);
									SlideRight.setVisible(false);
									StandRightCharge1.setVisible(false);
									StandRightCharge2.setVisible(false);
									StandLeftCharge1.setVisible(false);
									StandLeftCharge2.setVisible(false);
									RunRightCharge1.setVisible(false);
									RunRightCharge2.setVisible(false);
									RunLeftCharge1.setVisible(false);
									RunLeftCharge2.setVisible(false);
									JumpRightCharge1.setVisible(false);
									JumpRightCharge2.setVisible(false);
									JumpLeftCharge1.setVisible(false);
									JumpLeftCharge2.setVisible(false);
									//Confuse and make Megaman not know which direction to go in
								}
								
								if(Direct == 2)
								{
									RunShootingRight.setVisible(false);
									RunShootingLeft.setVisible(false);
									StandLeft.setVisible(false);
									StandRight.setVisible(false);
									ShootingLeft.setVisible(false);
									ShootingRight.setVisible(false);
									RunningRight.setVisible(false);
									RunningLeft.setVisible(false);
									ConfusedRight.setVisible(true);
									ConfusedLeft.setVisible(false);
									JumpLeft.setVisible(false);
									JumpRight.setVisible(false);
									JumpShootingLeft.setVisible(false);
									JumpShootingRight.setVisible(false);
									PainLeft.setVisible(false);
									PainRight.setVisible(false);
									SlideLeft.setVisible(false);
									SlideRight.setVisible(false);
									StandRightCharge1.setVisible(false);
									StandRightCharge2.setVisible(false);
									StandLeftCharge1.setVisible(false);
									StandLeftCharge2.setVisible(false);
									RunRightCharge1.setVisible(false);
									RunRightCharge2.setVisible(false);
									RunLeftCharge1.setVisible(false);
									RunLeftCharge2.setVisible(false);
									JumpRightCharge1.setVisible(false);
									JumpRightCharge2.setVisible(false);
									JumpLeftCharge1.setVisible(false);
									JumpLeftCharge2.setVisible(false);
									//Confuse and make Megaman not know which direction to go in
								}
							}
						}}
				}}
			
			if(Sliding == false)
			{
				if(Left == false)
				{
					if(Right == false)
					{
						if(Shoot == false)
						{
							if(Direct == 1)
							{
								RunShootingRight.setVisible(false);
								RunShootingLeft.setVisible(false);
								StandLeft.setVisible(true);
								StandRight.setVisible(false);
								ShootingLeft.setVisible(false);
								ShootingRight.setVisible(false);
								RunningRight.setVisible(false);
								RunningLeft.setVisible(false);
								ConfusedRight.setVisible(false);
								ConfusedLeft.setVisible(false);
								JumpLeft.setVisible(false);
								JumpRight.setVisible(false);
								JumpShootingLeft.setVisible(false);
								JumpShootingRight.setVisible(false);
								PainLeft.setVisible(false);
								PainRight.setVisible(false);
								SlideLeft.setVisible(false);
								SlideRight.setVisible(false);
								StandRightCharge1.setVisible(false);
								StandRightCharge2.setVisible(false);
								StandLeftCharge1.setVisible(false);
								StandLeftCharge2.setVisible(false);
								RunRightCharge1.setVisible(false);
								RunRightCharge2.setVisible(false);
								RunLeftCharge1.setVisible(false);
								RunLeftCharge2.setVisible(false);
								JumpRightCharge1.setVisible(false);
								JumpRightCharge2.setVisible(false);
								JumpLeftCharge1.setVisible(false);
								JumpLeftCharge2.setVisible(false);
								//Leave Megaman facing left
								if(Power > 20)
								{
									StandLeft.setVisible(false);
									StandLeftCharge1.setVisible(true);
								}
								if(Power > 40)
								{
									StandLeftCharge1.setVisible(false);
									StandLeftCharge2.setVisible(true);
								}
							}
							if(Direct == 2)
							{
								RunShootingRight.setVisible(false);
								RunShootingLeft.setVisible(false);
								StandLeft.setVisible(false);
								StandRight.setVisible(true);
								ShootingLeft.setVisible(false);
								ShootingRight.setVisible(false);
								RunningRight.setVisible(false);
								RunningLeft.setVisible(false);
								ConfusedRight.setVisible(false);
								ConfusedLeft.setVisible(false);
								JumpLeft.setVisible(false);
								JumpRight.setVisible(false);
								JumpShootingLeft.setVisible(false);
								JumpShootingRight.setVisible(false);
								PainLeft.setVisible(false);
								PainRight.setVisible(false);
								SlideLeft.setVisible(false);
								SlideRight.setVisible(false);
								StandRightCharge1.setVisible(false);
								StandRightCharge2.setVisible(false);
								StandLeftCharge1.setVisible(false);
								StandLeftCharge2.setVisible(false);
								RunRightCharge1.setVisible(false);
								RunRightCharge2.setVisible(false);
								RunLeftCharge1.setVisible(false);
								RunLeftCharge2.setVisible(false);
								JumpRightCharge1.setVisible(false);
								JumpRightCharge2.setVisible(false);
								JumpLeftCharge1.setVisible(false);
								JumpLeftCharge2.setVisible(false);
								//Leave Megaman facing right
								if(Power > 20)
								{
									StandRight.setVisible(false);
									StandRightCharge1.setVisible(true);
								}
								if(Power > 40)
								{
									StandRightCharge1.setVisible(false);
									StandRightCharge2.setVisible(true);
								}
							}
						}
					}
				}
			}
			//This is checking for Ground Collision.  If Megamans DownRect is inside of the ground, then shift him up to almost out of the ground.
			if(JumpTimer == 10)
			{
				Gravity = true;
				for(GRect groundy : Ground)
				{
					DownRect.setLocation(getCanvasPoint(DownPt));
					if((DownRect.getBounds()).intersects(groundy.getBounds()))
					{
						Gravity = false;
						GravSpeed = 2;
						double center = DownRect.getY() + DownRect.getHeight() - groundy.getY();
						
						if(Math.abs(groundy.getY() - DownRect.getY()) < Math.abs(groundy.getY() - RightRect.getY())
								&& Math.abs(groundy.getY() - DownRect.getY()) < Math.abs(groundy.getY() - LeftRect.getY())
								&& VertBlock == false)
						{
							while(center > 1)
							{
								move(0, -1);
								for(Bullet bullet: BulletList)
								{
									bullet.move(0, 1);
								}
								center = center - 1;
							}
						}
					}
					
				}
			}
			//If Gravity has been turned on, then make Megaman fall down.
			if(Gravity == true)
			{
				move(0, GravSpeed);
				for(Bullet bullet: BulletList)
				{
					bullet.move(0, -GravSpeed);
				}
				//If the Speed of Gravity for Megaman is less than 18, then make it faster by 1.05*.
				if(GravSpeed < 12)
				{
					if(GravSpeed < 7)
					{
						GravSpeed = GravSpeed + 1;
					}
					else
					{
						GravSpeed = GravSpeed * 1.05;
					}
				}
				
			}
			//Megaman cannot jump while he is falling.
			if(Gravity == true)
			{
				Jump = false;
			}
			//Sets the sprite usage due to Gravity;
			if(Gravity == true)
			{
				if(Direct == 1)
				{
					RunShootingRight.setVisible(false);
					RunShootingLeft.setVisible(false);
					StandLeft.setVisible(false);
					StandRight.setVisible(false);
					ShootingLeft.setVisible(false);
					ShootingRight.setVisible(false);
					RunningRight.setVisible(false);
					RunningLeft.setVisible(false);
					ConfusedRight.setVisible(false);
					ConfusedLeft.setVisible(false);
					JumpLeft.setVisible(true);
					JumpRight.setVisible(false);
					JumpShootingLeft.setVisible(false);
					JumpShootingRight.setVisible(false);
					PainLeft.setVisible(false);
					PainRight.setVisible(false);
					SlideLeft.setVisible(false);
					SlideRight.setVisible(false);
					StandRightCharge1.setVisible(false);
					StandRightCharge2.setVisible(false);
					StandLeftCharge1.setVisible(false);
					StandLeftCharge2.setVisible(false);
					RunRightCharge1.setVisible(false);
					RunRightCharge2.setVisible(false);
					RunLeftCharge1.setVisible(false);
					RunLeftCharge2.setVisible(false);
					JumpRightCharge1.setVisible(false);
					JumpRightCharge2.setVisible(false);
					JumpLeftCharge1.setVisible(false);
					JumpLeftCharge2.setVisible(false);
					if(Shoot == true)
					{
						RunShootingRight.setVisible(false);
						RunShootingLeft.setVisible(false);
						StandLeft.setVisible(false);
						StandRight.setVisible(false);
						ShootingLeft.setVisible(false);
						ShootingRight.setVisible(false);
						RunningRight.setVisible(false);
						RunningLeft.setVisible(false);
						ConfusedRight.setVisible(false);
						ConfusedLeft.setVisible(false);
						JumpLeft.setVisible(false);
						JumpRight.setVisible(false);
						JumpShootingLeft.setVisible(true);
						JumpShootingRight.setVisible(false);
						PainLeft.setVisible(false);
						PainRight.setVisible(false);
						SlideLeft.setVisible(false);
						SlideRight.setVisible(false);
						StandRightCharge1.setVisible(false);
						StandRightCharge2.setVisible(false);
						StandLeftCharge1.setVisible(false);
						StandLeftCharge2.setVisible(false);
						RunRightCharge1.setVisible(false);
						RunRightCharge2.setVisible(false);
						RunLeftCharge1.setVisible(false);
						RunLeftCharge2.setVisible(false);
						JumpRightCharge1.setVisible(false);
						JumpRightCharge2.setVisible(false);
						JumpLeftCharge1.setVisible(false);
						JumpLeftCharge2.setVisible(false);
					}
					if(Power > 20)
					{
						JumpLeft.setVisible(false);
						JumpLeftCharge1.setVisible(true);
					}
					if(Power > 40)
					{
						JumpLeftCharge1.setVisible(false);
						JumpLeftCharge2.setVisible(true);
					}
				}
				if(Direct == 2)
				{
					RunShootingRight.setVisible(false);
					RunShootingLeft.setVisible(false);
					StandLeft.setVisible(false);
					StandRight.setVisible(false);
					ShootingLeft.setVisible(false);
					ShootingRight.setVisible(false);
					RunningRight.setVisible(false);
					RunningLeft.setVisible(false);
					ConfusedRight.setVisible(false);
					ConfusedLeft.setVisible(false);
					JumpLeft.setVisible(false);
					JumpRight.setVisible(true);
					JumpShootingLeft.setVisible(false);
					JumpShootingRight.setVisible(false);
					PainLeft.setVisible(false);
					PainRight.setVisible(false);
					SlideLeft.setVisible(false);
					SlideRight.setVisible(false);
					StandRightCharge1.setVisible(false);
					StandRightCharge2.setVisible(false);
					StandLeftCharge1.setVisible(false);
					StandLeftCharge2.setVisible(false);
					RunRightCharge1.setVisible(false);
					RunRightCharge2.setVisible(false);
					RunLeftCharge1.setVisible(false);
					RunLeftCharge2.setVisible(false);
					JumpRightCharge1.setVisible(false);
					JumpRightCharge2.setVisible(false);
					JumpLeftCharge1.setVisible(false);
					JumpLeftCharge2.setVisible(false);
					if(Shoot == true)
					{
						RunShootingRight.setVisible(false);
						RunShootingLeft.setVisible(false);
						StandLeft.setVisible(false);
						StandRight.setVisible(false);
						ShootingLeft.setVisible(false);
						ShootingRight.setVisible(false);
						RunningRight.setVisible(false);
						RunningLeft.setVisible(false);
						ConfusedRight.setVisible(false);
						ConfusedLeft.setVisible(false);
						JumpLeft.setVisible(false);
						JumpRight.setVisible(false);
						JumpShootingLeft.setVisible(false);
						JumpShootingRight.setVisible(true);
						PainLeft.setVisible(false);
						PainRight.setVisible(false);
						SlideLeft.setVisible(false);
						SlideRight.setVisible(false);
						StandRightCharge1.setVisible(false);
						StandRightCharge2.setVisible(false);
						StandLeftCharge1.setVisible(false);
						StandLeftCharge2.setVisible(false);
						RunRightCharge1.setVisible(false);
						RunRightCharge2.setVisible(false);
						RunLeftCharge1.setVisible(false);
						RunLeftCharge2.setVisible(false);
						JumpRightCharge1.setVisible(false);
						JumpRightCharge2.setVisible(false);
						JumpLeftCharge1.setVisible(false);
						JumpLeftCharge2.setVisible(false);
					}
					if(Power > 20)
					{
						JumpRight.setVisible(false);
						JumpRightCharge1.setVisible(true);
					}
					if(Power > 40)
					{
						JumpRightCharge1.setVisible(false);
						JumpRightCharge2.setVisible(true);
					}
				}
			}
			//Turn the Jump Key off if JumpTimer has begun declining.
			if(JumpTimer == 8)
			{
				Jump = false;
			}
			if(Jump == true)
			{
				JumpTimer = 9;
			}
			if(Pain == 24)
			{
				//If Sliding is true, then make Megaman move along the ground faster and cooler, but he can't do anything else.
				if(Sliding == true)
				{
					if(JumpTimer == 10)
					{
						if(Gravity == false)
						{
							if(Direct == 1)
							{
								RunShootingRight.setVisible(false);
								RunShootingLeft.setVisible(false);
								StandLeft.setVisible(false);
								StandRight.setVisible(false);
								ShootingLeft.setVisible(false);
								ShootingRight.setVisible(false);
								RunningRight.setVisible(false);
								RunningLeft.setVisible(false);
								ConfusedRight.setVisible(false);
								ConfusedLeft.setVisible(false);
								JumpLeft.setVisible(false);
								JumpRight.setVisible(false);
								JumpShootingLeft.setVisible(false);
								JumpShootingRight.setVisible(false);
								PainLeft.setVisible(false);
								PainRight.setVisible(false);
								SlideLeft.setVisible(true);
								SlideRight.setVisible(false);
								StandRightCharge1.setVisible(false);
								StandRightCharge2.setVisible(false);
								StandLeftCharge1.setVisible(false);
								StandLeftCharge2.setVisible(false);
								RunRightCharge1.setVisible(false);
								RunRightCharge2.setVisible(false);
								RunLeftCharge1.setVisible(false);
								RunLeftCharge2.setVisible(false);
								JumpRightCharge1.setVisible(false);
								JumpRightCharge2.setVisible(false);
								JumpLeftCharge1.setVisible(false);
								JumpLeftCharge2.setVisible(false);
								if(LeftBlock == false)
								{
									move(-9, 0);
									for(Bullet bullet: BulletList)
									{
										bullet.move(9, 0);
									}
								}
							}
							if(Direct == 2)
							{
								RunShootingRight.setVisible(false);
								RunShootingLeft.setVisible(false);
								StandLeft.setVisible(false);
								StandRight.setVisible(false);
								ShootingLeft.setVisible(false);
								ShootingRight.setVisible(false);
								RunningRight.setVisible(false);
								RunningLeft.setVisible(false);
								ConfusedRight.setVisible(false);
								ConfusedLeft.setVisible(false);
								JumpLeft.setVisible(false);
								JumpRight.setVisible(false);
								JumpShootingLeft.setVisible(false);
								JumpShootingRight.setVisible(false);
								PainLeft.setVisible(false);
								PainRight.setVisible(false);
								SlideLeft.setVisible(false);
								SlideRight.setVisible(true);
								StandRightCharge1.setVisible(false);
								StandRightCharge2.setVisible(false);
								StandLeftCharge1.setVisible(false);
								StandLeftCharge2.setVisible(false);
								RunRightCharge1.setVisible(false);
								RunRightCharge2.setVisible(false);
								RunLeftCharge1.setVisible(false);
								RunLeftCharge2.setVisible(false);
								JumpRightCharge1.setVisible(false);
								JumpRightCharge2.setVisible(false);
								JumpLeftCharge1.setVisible(false);
								JumpLeftCharge2.setVisible(false);
								if(RightBlock == false)
								{
									move(9, 0);
									for(Bullet bullet: BulletList)
									{
										bullet.move(-9, 0);
									}
								}
							}
						}
					}
				}
			}
			
			if(Pain == 24)
			{
				if(JumpTimer > 0)
				{
					if(JumpTimer < 10)
					{
						JumpTimer = JumpTimer - 1;
						Gravity = false;
						Jump = false;
//						Moves all the images together
						move(0, -JumpTimer - 5);
						for(Bullet bullet: BulletList)
						{
							bullet.move(0, JumpTimer + 5);
						}
						if(Direct == 1)
						{
							RunShootingRight.setVisible(false);
							RunShootingLeft.setVisible(false);
							StandLeft.setVisible(false);
							StandRight.setVisible(false);
							ShootingLeft.setVisible(false);
							ShootingRight.setVisible(false);
							RunningRight.setVisible(false);
							RunningLeft.setVisible(false);
							ConfusedRight.setVisible(false);
							ConfusedLeft.setVisible(false);
							JumpLeft.setVisible(true);
							JumpRight.setVisible(false);
							JumpShootingLeft.setVisible(false);
							JumpShootingRight.setVisible(false);
							PainLeft.setVisible(false);
							PainRight.setVisible(false);
							SlideLeft.setVisible(false);
							SlideRight.setVisible(false);
							StandRightCharge1.setVisible(false);
							StandRightCharge2.setVisible(false);
							StandLeftCharge1.setVisible(false);
							StandLeftCharge2.setVisible(false);
							RunRightCharge1.setVisible(false);
							RunRightCharge2.setVisible(false);
							RunLeftCharge1.setVisible(false);
							RunLeftCharge2.setVisible(false);
							JumpRightCharge1.setVisible(false);
							JumpRightCharge2.setVisible(false);
							JumpLeftCharge1.setVisible(false);
							JumpLeftCharge2.setVisible(false);
							if(Shoot == true)
							{
								RunShootingRight.setVisible(false);
								RunShootingLeft.setVisible(false);
								StandLeft.setVisible(false);
								StandRight.setVisible(false);
								ShootingLeft.setVisible(false);
								ShootingRight.setVisible(false);
								RunningRight.setVisible(false);
								RunningLeft.setVisible(false);
								ConfusedRight.setVisible(false);
								ConfusedLeft.setVisible(false);
								JumpLeft.setVisible(false);
								JumpRight.setVisible(false);
								JumpShootingLeft.setVisible(true);
								JumpShootingRight.setVisible(false);
								PainLeft.setVisible(false);
								PainRight.setVisible(false);
								SlideLeft.setVisible(false);
								SlideRight.setVisible(false);
								StandRightCharge1.setVisible(false);
								StandRightCharge2.setVisible(false);
								StandLeftCharge1.setVisible(false);
								StandLeftCharge2.setVisible(false);
								RunRightCharge1.setVisible(false);
								RunRightCharge2.setVisible(false);
								RunLeftCharge1.setVisible(false);
								RunLeftCharge2.setVisible(false);
								JumpRightCharge1.setVisible(false);
								JumpRightCharge2.setVisible(false);
								JumpLeftCharge1.setVisible(false);
								JumpLeftCharge2.setVisible(false);
								
							}
							if(Power > 20)
							{
								JumpLeft.setVisible(false);
								JumpLeftCharge1.setVisible(true);
							}
							if(Power > 40)
							{
								JumpLeftCharge1.setVisible(false);
								JumpLeftCharge2.setVisible(true);
							}
						}
						if(Direct == 2)
						{
							RunShootingRight.setVisible(false);
							RunShootingLeft.setVisible(false);
							StandLeft.setVisible(false);
							StandRight.setVisible(false);
							ShootingLeft.setVisible(false);
							ShootingRight.setVisible(false);
							RunningRight.setVisible(false);
							RunningLeft.setVisible(false);
							ConfusedRight.setVisible(false);
							ConfusedLeft.setVisible(false);
							JumpLeft.setVisible(false);
							JumpRight.setVisible(true);
							JumpShootingLeft.setVisible(false);
							JumpShootingRight.setVisible(false);
							PainLeft.setVisible(false);
							PainRight.setVisible(false);
							SlideLeft.setVisible(false);
							SlideRight.setVisible(false);
							StandRightCharge1.setVisible(false);
							StandRightCharge2.setVisible(false);
							StandLeftCharge1.setVisible(false);
							StandLeftCharge2.setVisible(false);
							RunRightCharge1.setVisible(false);
							RunRightCharge2.setVisible(false);
							RunLeftCharge1.setVisible(false);
							RunLeftCharge2.setVisible(false);
							JumpRightCharge1.setVisible(false);
							JumpRightCharge2.setVisible(false);
							JumpLeftCharge1.setVisible(false);
							JumpLeftCharge2.setVisible(false);
							
							if(Shoot == true)
							{
								RunShootingRight.setVisible(false);
								RunShootingLeft.setVisible(false);
								StandLeft.setVisible(false);
								StandRight.setVisible(false);
								ShootingLeft.setVisible(false);
								ShootingRight.setVisible(false);
								RunningRight.setVisible(false);
								RunningLeft.setVisible(false);
								ConfusedRight.setVisible(false);
								ConfusedLeft.setVisible(false);
								JumpLeft.setVisible(false);
								JumpRight.setVisible(false);
								JumpShootingLeft.setVisible(false);
								JumpShootingRight.setVisible(true);
								PainLeft.setVisible(false);
								PainRight.setVisible(false);
								SlideLeft.setVisible(false);
								SlideRight.setVisible(false);
								StandRightCharge1.setVisible(false);
								StandRightCharge2.setVisible(false);
								StandLeftCharge1.setVisible(false);
								StandLeftCharge2.setVisible(false);
								RunRightCharge1.setVisible(false);
								RunRightCharge2.setVisible(false);
								RunLeftCharge1.setVisible(false);
								RunLeftCharge2.setVisible(false);
								JumpRightCharge1.setVisible(false);
								JumpRightCharge2.setVisible(false);
								JumpLeftCharge1.setVisible(false);
								JumpLeftCharge2.setVisible(false);
							}
							if(Power > 20)
							{
								JumpRight.setVisible(false);
								JumpRightCharge1.setVisible(true);
							}
							if(Power > 40)
							{
								JumpRightCharge1.setVisible(false);
								JumpRightCharge2.setVisible(true);
							}
						}
					}
				}
			}
			if(Pain == 23)
			{
				HPRec = HP;
			}
			if(Pain < 24)
			{
				HP = HPRec;
				Pain = Pain - 1;
				JumpTimer = 10;
				if(Direct == 1)
				{
					RunShootingRight.setVisible(false);
					RunShootingLeft.setVisible(false);
					StandLeft.setVisible(false);
					StandRight.setVisible(false);
					ShootingLeft.setVisible(false);
					ShootingRight.setVisible(false);
					RunningRight.setVisible(false);
					RunningLeft.setVisible(false);
					ConfusedRight.setVisible(false);
					ConfusedLeft.setVisible(false);
					JumpLeft.setVisible(false);
					JumpRight.setVisible(false);
					JumpShootingLeft.setVisible(false);
					JumpShootingRight.setVisible(false);
					PainLeft.setVisible(true);
					PainRight.setVisible(false);
					SlideLeft.setVisible(false);
					SlideRight.setVisible(false);
					StandRightCharge1.setVisible(false);
					StandRightCharge2.setVisible(false);
					StandLeftCharge1.setVisible(false);
					StandLeftCharge2.setVisible(false);
					RunRightCharge1.setVisible(false);
					RunRightCharge2.setVisible(false);
					RunLeftCharge1.setVisible(false);
					RunLeftCharge2.setVisible(false);
					JumpRightCharge1.setVisible(false);
					JumpRightCharge2.setVisible(false);
					JumpLeftCharge1.setVisible(false);
					JumpLeftCharge2.setVisible(false);
					if(RightBlock == false)
					{
						move(1, 0);
						for(Bullet bullet: BulletList)
						{
							bullet.move(-1, 0);
						}
					}
				}
				if(Direct == 2)
				{
					RunShootingRight.setVisible(false);
					RunShootingLeft.setVisible(false);
					StandLeft.setVisible(false);
					StandRight.setVisible(false);
					ShootingLeft.setVisible(false);
					ShootingRight.setVisible(false);
					RunningRight.setVisible(false);
					RunningLeft.setVisible(false);
					ConfusedRight.setVisible(false);
					ConfusedLeft.setVisible(false);
					JumpLeft.setVisible(false);
					JumpRight.setVisible(false);
					JumpShootingLeft.setVisible(false);
					JumpShootingRight.setVisible(false);
					PainLeft.setVisible(false);
					PainRight.setVisible(true);
					SlideLeft.setVisible(false);
					SlideRight.setVisible(false);
					StandRightCharge1.setVisible(false);
					StandRightCharge2.setVisible(false);
					StandLeftCharge1.setVisible(false);
					StandLeftCharge2.setVisible(false);
					RunRightCharge1.setVisible(false);
					RunRightCharge2.setVisible(false);
					RunLeftCharge1.setVisible(false);
					RunLeftCharge2.setVisible(false);
					JumpRightCharge1.setVisible(false);
					JumpRightCharge2.setVisible(false);
					JumpLeftCharge1.setVisible(false);
					JumpLeftCharge2.setVisible(false);
					if(LeftBlock == false)
					{
						move(-1, 0);
						for(Bullet bullets: BulletList)
						{
							bullets.move(1, 0);
						}
					}
				}
				if(Pain <= 0)
				{
					if(Gravity == true)
					{
						Pain = 1;
					}
					else
					{
						Pain = 24;
					}
				}
			}
			PermaHP = HPRec;
			//Bullet Movement
			BulletListWhile = 0;
			while(BulletListWhile < BulletList.size())
			{
				BulletList.get(BulletListWhile).Shoot(Direct);
				if(getX() + BulletList.get(BulletListWhile).getX() < 0 || getX() + BulletList.get(BulletListWhile).getX() > 500)
				{
					BulletList.get(BulletListWhile).move(99999, -92930);
					remove(BulletList.get(BulletListWhile));
					BulletList.remove(BulletList.get(BulletListWhile));
					BulletBoundList.get(BulletListWhile).setBounds(99999, 99999, 0, 0);
					BulletBoundList.remove(BulletBoundList.get(BulletListWhile));
					if(BulletList.size() == 0)
					{
						BulletBoundList.clear();
					}
				}
				BulletListWhile = BulletListWhile + 1;
			}
			BulletListWhile = 0;
			PainReturn = Pain;
			JumpReturn = Jump;
			Strength = Power;
			PermaJumpTime = JumpTimer;
			PermaGravity = Gravity;
			ShootReturn = ShootTimer;
		}
		return(JumpTimer);
	}
	public void Shoot(int Direct, int Power, int Pain)
	{
		if(Sliding == false)
		{
			
			if(dead == false)
			{
				if(Pain == 24)
				{
					if(PermaJumpTime == 10 && PermaGravity == false)
					{
						if(BulletList.size() < 3)
						{
							if(Direct == 1)
							{
								Bullet bullet = new Bullet();
								add(bullet);
								bullet.Creation(Direct, Strength);
								bullet.setLocation(-5, 8);
								BulletList.add(bullet);
								GRectangle BullBound = bullet.BoundReturn();
								BulletBoundList.add(BullBound);
							}
							if(Direct == 2)
							{
								Bullet bullet = new Bullet();
								add(bullet);
								bullet.Creation(Direct, Strength);
								bullet.setLocation(13, 8);
								BulletList.add(bullet);
								GRectangle BullBound = bullet.BoundReturn();
								BulletBoundList.add(BullBound);
							}
							pew.play();
							
						}
					}
					else
					{
						if(BulletList.size() < 3)
						{
							if(Direct == 1)
							{
								Bullet bullet = new Bullet();
								add(bullet);
								bullet.Creation(Direct, Power);
								bullet.setLocation(-5, -2);
								BulletList.add(bullet);
								GRectangle BullBound = bullet.BoundReturn();
								BulletBoundList.add(BullBound);
							}
							if(Direct == 2)
							{
								Bullet bullet = new Bullet();
								add(bullet);
								bullet.Creation(Direct, Power);
								bullet.setLocation(18, -2);
								BulletList.add(bullet);
								GRectangle BullBound = bullet.BoundReturn();
								BulletBoundList.add(BullBound);
							}
							pew.play();
						}
					}
				}
			}}
	}
	public int Die()
	{
		if(dead == true)
		{
			if(deadchecked == false)
			{
				RunShootingRight.setVisible(false);
				RunShootingLeft.setVisible(false);
				StandLeft.setVisible(false);
				StandRight.setVisible(false);
				ShootingLeft.setVisible(false);
				ShootingRight.setVisible(false);
				RunningRight.setVisible(false);
				RunningLeft.setVisible(false);
				ConfusedRight.setVisible(false);
				ConfusedLeft.setVisible(false);
				JumpLeft.setVisible(false);
				JumpRight.setVisible(false);
				JumpShootingLeft.setVisible(false);
				JumpShootingRight.setVisible(false);
				PainLeft.setVisible(false);
				PainRight.setVisible(false);
				SlideLeft.setVisible(false);
				SlideRight.setVisible(false);
				StandRightCharge1.setVisible(false);
				StandRightCharge2.setVisible(false);
				StandLeftCharge1.setVisible(false);
				StandLeftCharge2.setVisible(false);
				RunRightCharge1.setVisible(false);
				RunRightCharge2.setVisible(false);
				RunLeftCharge1.setVisible(false);
				RunLeftCharge2.setVisible(false);
				JumpRightCharge1.setVisible(false);
				JumpRightCharge2.setVisible(false);
				JumpLeftCharge1.setVisible(false);
				JumpLeftCharge2.setVisible(false);
				
				GImage ex1 = new GImage(MediaTools.loadImage("spritesheets/Misc/Death/Blow up.gif"), StandRight.getX() + 3, StandRight.getY() + 3);//TopLeft
				GImage ex2 = new GImage(MediaTools.loadImage("spritesheets/Misc/Death/Blow up.gif"), StandRight.getX() + StandRight.getWidth() - 3, StandRight.getY() + 3);//TopRight
				GImage ex3 = new GImage(MediaTools.loadImage("spritesheets/Misc/Death/Blow up.gif"), StandRight.getX() + 3, StandRight.getY() + StandRight.getHeight() -3);//BotLeft
				GImage ex4 = new GImage(MediaTools.loadImage("spritesheets/Misc/Death/Blow up.gif"), StandRight.getX() + StandRight.getWidth() -3, StandRight.getY() + StandRight.getHeight() -3 );//BotRight
				GImage ex5 = new GImage(MediaTools.loadImage("spritesheets/Misc/Death/Blow up.gif"), StandRight.getX() + (StandRight.getWidth()/2), StandRight.getY());//Top
				GImage ex6 = new GImage(MediaTools.loadImage("spritesheets/Misc/Death/Blow up.gif"), StandRight.getX(), StandRight.getY() + (StandRight.getHeight()/2));//Left
				GImage ex7 = new GImage(MediaTools.loadImage("spritesheets/Misc/Death/Blow up.gif"), StandRight.getX() + StandRight.getWidth(), StandRight.getY() + (StandRight.getHeight()/2));//Right
				GImage ex8 = new GImage(MediaTools.loadImage("spritesheets/Misc/Death/Blow up.gif"), StandRight.getX() + (StandRight.getWidth()/2), StandRight.getY() + StandRight.getHeight());//Bot
				
				add(ex1);
				add(ex2);
				add(ex3);
				add(ex4);
				add(ex5);
				add(ex6);
				add(ex7);
				add(ex8);
				
				FloatingExplosion.add(ex1);
				FloatingExplosion.add(ex2);
				FloatingExplosion.add(ex3);
				FloatingExplosion.add(ex4);
				FloatingExplosion.add(ex5);
				FloatingExplosion.add(ex6);
				FloatingExplosion.add(ex7);
				FloatingExplosion.add(ex8);
				deadchecked = true;
			}
			CountDown = CountDown - 1;
			int coolwhile = 0;
			HPRec = 0;
			while(coolwhile < FloatingExplosion.size())
			{
				//LeftSide Explosions go left.
				if(coolwhile == 0 || coolwhile == 2 || coolwhile == 5)
				{
					FloatingExplosion.get(coolwhile).move(-3, 0);
				}
				//RightSide Explosions go right.
				if(coolwhile == 1 || coolwhile == 3 || coolwhile == 6)
				{
					FloatingExplosion.get(coolwhile).move(3, 0);
				}
				//TopSide Explosions go up.
				if(coolwhile == 0 || coolwhile == 1 || coolwhile == 4)
				{
					FloatingExplosion.get(coolwhile).move(0, 3);
				}
				//BotSide Explosions go down.
				if(coolwhile == 2 || coolwhile == 3 || coolwhile == 7)
				{
					FloatingExplosion.get(coolwhile).move(0, -3);
				}
				coolwhile = coolwhile + 1;
			}
			coolwhile = 0;
			if(CountDown == 0)
			{
				while(coolwhile < FloatingExplosion.size())
				{
					remove(FloatingExplosion.get(coolwhile));
					FloatingExplosion.remove(FloatingExplosion.get(coolwhile));	
				}
			}
		}
		return(CountDown);
	}
	public int ReturnHP()
	{
		return(PermaHP);
	}
	public boolean JumpReturn()
	{
		return(JumpReturn);
	}
	public int PainReturn()
	{
		return(PainReturn);
	}
	public int ShootReturn()
	{
		return(ShootReturn);
	}
	public int StrengthReturn()
	{
		return(Strength);
	}
	public int LivesReturn()
	{
		return(Lives);
	}
	public boolean LeftStopReturn()
	{
		return(LeftStop);
	}
	public boolean RightStopReturn()
	{
		return(RightStop);
	}
	public boolean UpStopReturn()
	{
		return(UpStop);
	}
	public boolean DownStopReturn()
	{
		return(DownStop);
	}
	public ArrayList<GRectangle> BulletBoundListReturn()
	{
		return(BulletBoundList);
	}
	public GRectangle MegaRectReturn()
	{
		return(MegaRect);
	}
	public void BulletHit(int bul, int bul2, int bul3)
	{
		if(bul != -1)
		{
			remove(BulletList.get(bul));
			BulletList.remove(bul);
			BulletBoundList.get(bul).setLocation(43020, -29039);
			BulletBoundList.remove(bul);
			bul2 = bul2 - 1;
			bul3 = bul3 - 1;
		}
		if(bul2 > -1)
		{
			remove(BulletList.get(bul2));
			BulletList.remove(BulletList.get(bul2));
			BulletBoundList.get(bul2).setLocation(43020, -29039);
			BulletBoundList.remove(bul2);
			bul3 = bul3 - 1;
		}
		if(bul3 > -1)
		{
			remove(BulletList.get(bul3));
			BulletList.remove(bul3);
			BulletBoundList.get(bul3).setLocation(43020, -29039);
			BulletBoundList.remove(bul3);
		}
		if(BulletList.size() == 0)
		{
			BulletBoundList.removeAll(BulletBoundList);
		}
		
	}
}


