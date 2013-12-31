/* Name: David
 * File: QuickMan.java
 * Description: TODO: Describe what this file does
 */
import java.util.*;
import acm.graphics.*;
import acm.util.*;
public class QuickMan extends GCompound
{
	private GImage StandingLeft;
	private GImage StandingRight;
	private GImage JumpLeft;
	private GImage JumpRight;
	private GImage RunningLeft;
	private GImage RunningRight;
	
	private int Health = 28;
	private GRectangle DownBound;
	private GRectangle Bound;
	private GPoint BoundPt;
	private GRectangle LeftCheck;
	private GRectangle RightCheck;
	private boolean LeftBlocked;
	private boolean RightBlocked;
	private boolean HoriBlock;
	private int SecToStart = 50;
	
	private int Direct = 1;
	private int JumpDirect;
	private int RunDirect;
	
	private int BounceCounter;
	private int JumpTimer = 22;
	
	private int valret;
	private int valret2;
	private int valret3;
	private int damage;
	
	private double lengthX;
	private double lengthY;
	private boolean lengthcheck;
	
	private boolean Gravity;
	private boolean Activated;
	private RandomGenerator ran;
	private int Bounce;
	
	private boolean dead = false;
	private boolean deadchecked = false;
	private int state = 0;
	private int CountDown = 100;
	private boolean Down;
	private ArrayList<GImage> FloatingExplosion = new ArrayList<GImage>();
	public QuickMan()
	{
		StandingLeft = new GImage(MediaTools.loadImage("spritesheets/Bosses/QuickMan/StandLeft.gif"),0, 0);
		StandingRight = new GImage(MediaTools.loadImage("spritesheets/Bosses/QuickMan/StandRight.gif"),0, 0);
		RunningLeft = new GImage(MediaTools.loadImage("spritesheets/Bosses/QuickMan/RunningLeft.gif"),0, 0);
		RunningRight = new GImage(MediaTools.loadImage("spritesheets/Bosses/QuickMan/RunningRight.gif"),0, 0);
		JumpLeft = new GImage(MediaTools.loadImage("spritesheets/Bosses/QuickMan/JumpLeft.gif"),0, 0);
		JumpRight = new GImage(MediaTools.loadImage("spritesheets/Bosses/QuickMan/JumpRight.gif"),0, 0);
		
		add(StandingLeft);
		add(StandingRight);
		add(JumpLeft);
		add(JumpRight);
		add(RunningLeft);
		add(RunningRight);
		
		
		Bound = new GRectangle(StandingLeft.getBounds());
		DownBound = new GRectangle(StandingLeft.getX(), StandingLeft.getY() + StandingLeft.getHeight() - 5, StandingLeft.getWidth(), 5);
		LeftCheck = new GRectangle(StandingLeft.getX() - 5, StandingLeft.getY(), 5, StandingLeft.getHeight()-3);
		RightCheck = new GRectangle(0, 0, 5, StandingLeft.getHeight()-3);
		BoundPt = new GPoint(0, 0);
		
		ran =  new RandomGenerator();
		
	}
	public void Action(ArrayList<GRect> Ground, boolean start, GRectangle MegaRect, ArrayList<GRectangle> bullet)
	{
		Die();
		Bound.setLocation(getCanvasPoint(BoundPt));
		damage = 0;
		valret = -1;
		valret2 = -1;
		valret3 = -1;
		LeftCheck.setLocation(getCanvasPoint(BoundPt));
		LeftCheck.setLocation(LeftCheck.getX() - 5, LeftCheck.getY());
		RightCheck.setLocation(getCanvasPoint(BoundPt));
		RightCheck.setLocation(RightCheck.getX() + 5 + StandingLeft.getWidth(), RightCheck.getY());
		DownBound.setLocation(getCanvasPoint(BoundPt));
		DownBound.setLocation(DownBound.getX(), DownBound.getY() + StandingLeft.getY() + StandingLeft.getHeight() - 5);
		RightBlocked = false;
		LeftBlocked = false;
		if(start == true)
		{
			Activated = true;
			SecToStart = SecToStart - 1;
		}
		if(SecToStart > 0)
		{
			Bounce = ran.nextInt(5, 8);
			StandingLeft.setVisible(true);
			StandingRight.setVisible(false);
			JumpLeft.setVisible(false);
			JumpRight.setVisible(false);
			RunningLeft.setVisible(false);
			RunningRight.setVisible(false);
			int coolwhilenum = 0;
			Gravity = true;
			while(coolwhilenum < Ground.size())
			{
				if(DownBound.intersects(Ground.get(coolwhilenum).getBounds()) )
				{
					Gravity = false;
					double center = DownBound.getY() + DownBound.getHeight() - Ground.get(coolwhilenum).getY();
					if(center < 15)
					{
						while(center > 1)
						{
							move(0, -1);
							center = center - 1;
						}
					}
				}
				coolwhilenum = coolwhilenum + 1;
			}
			if(Gravity == true)
			{
				move(0, 10);
			}
		}
		if(SecToStart < 0)
		{
		if(Activated == true)
		{
			if(dead == false)
			{
			if(Bound.intersects(MegaRect))
			{
				damage = 6;
			}
			int val = 0;		
			while(val < bullet.size())
			{
				if(Bound.intersects(bullet.get(val)))
				{
					if(valret == -1)
					{
						valret = val ;
					}
					else if(valret2 == -1)
					{
						valret2 = val ;
					}
					else if(valret3 == -1)
					{
						valret3 = val ;
					}
					if(bullet.get(val).getHeight() == 30)
					{
						Health = Health - 6;
					}
					if(bullet.get(val).getHeight() == 16)
					{
						Health = Health - 4;
					}
					else
					{
						Health = Health - 2;
					}
					if(Health <= 0)
					{
						if(deadchecked == false)
						{
							dead = true;
							Die();
						}
					}
				}
				val = val + 1;
			}
			for(GRect ground: Ground)
			{
				if(LeftCheck.intersects(ground.getBounds()) || LeftCheck.getX() < 0)
				{
					LeftBlocked = true;
				}
				if(RightCheck.intersects(ground.getBounds()))
				{
					RightBlocked = true;

				}
				if(LeftBlocked == true && RightBlocked == true)
				{
					HoriBlock = true;
				}
				if(HoriBlock == false && LeftBlocked == true)
				{
					double center = LeftCheck.getX() - ground.getX() - ground.getWidth();
					if(center < 21)
					{
						while(center > 0)
						{
							move(0, -1);
							center = center - 1;
						}
					}
				}
				if(HoriBlock == false && RightBlocked == true)
				{
					double center = RightCheck.getX() + RightCheck.getWidth() - ground.getX();
					if(center < 21)
					{
						while(center > 0)
						{
							move(0, -1);
							center = center - 1;
						}
					}
				}
				
			}
			int coolwhilenum = 0;
			Gravity = true;
			while(coolwhilenum < Ground.size())
			{
				if(DownBound.intersects(Ground.get(coolwhilenum).getBounds()) 
					&& (HoriBlock == true || (LeftBlocked == false && RightBlocked == false)))
				{
					BounceCounter = BounceCounter + 1;
					double center = DownBound.getY() + DownBound.getHeight() - Ground.get(coolwhilenum).getY();
					if(center < 15)
					{
					while(center > 1)
					{
						move(0, -1);
						center = center - 1;
					}
					}
					Gravity = false;
					Down = false;
					lengthcheck = false;
				}
				coolwhilenum = coolwhilenum + 1;
			}
			if(Down == true)
			{
				move(-lengthX/10, lengthY/10);
				
				StandingLeft.setVisible(false);
				StandingRight.setVisible(false);
				JumpLeft.setVisible(false);
				JumpRight.setVisible(false);
				RunningLeft.setVisible(false);
				RunningRight.setVisible(false);
				if(Direct == 1)
				{
					JumpLeft.setVisible(true);
				}
				if(Direct == 2)
				{
					JumpRight.setVisible(true);
				}
				}
			}
			if(JumpTimer == 20)
			{
				JumpDirect = Direct;
			}
			if(BounceCounter == 0)
			{
				Bounce = ran.nextInt(5, 8);
			}
			if(BounceCounter == Bounce)
			{
				if(lengthcheck == false)
				{
					lengthX = Bound.getX() - MegaRect.getX(); 
					lengthY = MegaRect.getY() - Bound.getY();
					lengthcheck = true;
				}
				Down = true;
			}
			if(BounceCounter > Bounce)
			{
				Run();

			}
			if(BounceCounter <= Bounce)
			{
				Jump(MegaRect);
			}
			if(dead == true)
			{
				Activated = false;
			}
		}
		}
	}
	
	public void Jump(GRectangle MegaRect)
	{
		if(Down != true)
		{
			if(BounceCounter == Bounce)
			{
				if(MegaRect.getX() > Bound.getX())
				{
					Direct = 2;
					RunDirect = 2;
			}
			else
			{
				Direct = 1;
				RunDirect = 1;
			}
		}
				RunDirect = 0;
				Gravity = false;
				if(BounceCounter > 0)
				{
					move(0, -JumpTimer/4);
					move(0, -JumpTimer / 6);
				}
				JumpTimer = JumpTimer - 1;
				if(JumpTimer == -10)
				{
					JumpTimer = -9;
				}

				if(JumpDirect == 1)
				{						
				RunningLeft.setVisible(false);
				RunningRight.setVisible(false);
				JumpRight.setVisible(false);
				JumpLeft.setVisible(true);
					if(LeftBlocked == false)
					{
						move(-16, 0);
					}
					else
					{
						move(20, 0);
						Direct = 2;
						JumpDirect = 2;
						BounceCounter = BounceCounter + 1;
						JumpTimer = 15;
					}		
				}
				else if(JumpDirect == 2)
				{
					RunningLeft.setVisible(false);
					RunningRight.setVisible(false);
					JumpLeft.setVisible(false);
					JumpRight.setVisible(true);
					if(RightBlocked == false)			
					{			
						move(16, 0);	
					}
					else
					{
						move(-20, 0);
						Direct = 1;
						JumpDirect = 1;
						RunDirect = 1;
						BounceCounter = BounceCounter + 1;
						JumpTimer = 15;

					}
				}			
		}
	}
	public void Run()
	{
		if(HoriBlock == true)
		{
			if(BounceCounter > Bounce)
			{
				StandingLeft.setVisible(false);
				StandingRight.setVisible(false);
				JumpLeft.setVisible(false);
				JumpRight.setVisible(false);
				RunningLeft.setVisible(false);
				RunningRight.setVisible(false);
				if(Direct == 1)
				{
					RunDirect = 1;
				}
				if(Direct == 2)
				{
					RunDirect = 2;
				}
				if(RunDirect == 1)
				{
					if(LeftBlocked == false)
					{
						RunningLeft.setVisible(true);
						move(-20, 0);
					}
					else if(HoriBlock == false)
					{
						BounceCounter = 0;
					}
					else
					{
						Direct = 2;
						BounceCounter = 0;
						move(0, -15);
						JumpTimer = 22;
						RunningLeft.setVisible(false);
						JumpRight.setVisible(true);
					}
				}
				else if(RunDirect == 2)
				{
					if(RightBlocked == false)
					{
						RunningRight.setVisible(true);
						move(20, 0);
					}
					else if(HoriBlock == false)
					{
						BounceCounter = 0;
					}
					else
					{
						Direct = 1;
						BounceCounter = 0;
						move(0, -15);
						JumpTimer = 22;
						RunningRight.setVisible(false);
						JumpLeft.setVisible(true);
					}
				}
			}
		}
	}
	public int ReturnVal()
	{
		return(valret);
	}
	public int ReturnVal2()
	{
		return(valret2);		
	}
	public int ReturnVal3()
	{
		return(valret3);
	}
	public int ReturnDam()
	{
		return(damage);
	}
	public void Die()
	{
		if(dead == true)
		{
			if(deadchecked == false)
			{
				StandingLeft.setVisible(false);
				StandingRight.setVisible(false);
				JumpLeft.setVisible(false);
				JumpRight.setVisible(false);
				RunningLeft.setVisible(false);
				RunningRight.setVisible(false);
				
				GImage ex1 = new GImage(MediaTools.loadImage("spritesheets/Misc/Death/Blow up.gif"), StandingRight.getX() + 3, StandingRight.getY() + 3);//TopLeft
				GImage ex2 = new GImage(MediaTools.loadImage("spritesheets/Misc/Death/Blow up.gif"), StandingRight.getX() + StandingRight.getWidth() - 3, StandingRight.getY() + 3);//TopRight
				GImage ex3 = new GImage(MediaTools.loadImage("spritesheets/Misc/Death/Blow up.gif"), StandingRight.getX() + 3, StandingRight.getY() + StandingRight.getHeight() -3);//BotLeft
				GImage ex4 = new GImage(MediaTools.loadImage("spritesheets/Misc/Death/Blow up.gif"), StandingRight.getX() + StandingRight.getWidth() -3, StandingRight.getY() + StandingRight.getHeight() -3 );//BotRight
				GImage ex5 = new GImage(MediaTools.loadImage("spritesheets/Misc/Death/Blow up.gif"), StandingRight.getX() + (StandingRight.getWidth()/2), StandingRight.getY());//Top
				GImage ex6 = new GImage(MediaTools.loadImage("spritesheets/Misc/Death/Blow up.gif"), StandingRight.getX(), StandingRight.getY() + (StandingRight.getHeight()/2));//Left
				GImage ex7 = new GImage(MediaTools.loadImage("spritesheets/Misc/Death/Blow up.gif"), StandingRight.getX() + StandingRight.getWidth(), StandingRight.getY() + (StandingRight.getHeight()/2));//Right
				GImage ex8 = new GImage(MediaTools.loadImage("spritesheets/Misc/Death/Blow up.gif"), StandingRight.getX() + (StandingRight.getWidth()/2), StandingRight.getY() + StandingRight.getHeight());//Bot
				
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
		}
		if(dead == true)
		{
			StandingLeft.setVisible(false);
			StandingRight.setVisible(false);
			JumpLeft.setVisible(false);
			JumpRight.setVisible(false);
			RunningLeft.setVisible(false);
			RunningRight.setVisible(false);
			CountDown = CountDown - 1;
			int coolwhile = 0;
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
			if(CountDown <= 0)
			{
				while(coolwhile < FloatingExplosion.size())
				{
					remove(FloatingExplosion.get(coolwhile));
					FloatingExplosion.remove(FloatingExplosion.get(coolwhile));	
					coolwhile = coolwhile + 1;
				}
				state = 1;
			}
		}
	}
	public int ReturnKill()
	{
		return(state);
	}
	public int ReturnHealth()
	{
		return(Health);
	}
}
