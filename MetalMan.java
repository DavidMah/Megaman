/* Name: David
 * File: MetalMan.java
 * Description: TODO: Describe what this file does
 */
import java.util.*;
import acm.graphics.*;
import acm.util.*;
public class MetalMan extends GCompound
{
	private GImage StandingLeft;
	private GImage StandingRight;
	private GImage JumpingLeft;
	private GImage JumpingRight;
	private GImage ThrowLeft;
	private GImage ThrowRight;
	private GImage ReleaseLeft;
	private GImage ReleaseRight;
	private GImage RunningLeft;
	private GImage RunningRight;
	
	private GRectangle DownBound;
	private GRectangle Bound;
	private GPoint BoundPt;
	private ArrayList<MetalBlade> BladeList = new ArrayList<MetalBlade>();
	
	private int Direct;
	
	private int CountDown = 200;
	private int JumpTimer = 15;
	private int ThrowTimer;
	private int ranvalue;
	private int RunTimer = 440;
	
	private double GravSpeed;
	private boolean Gravity;
	private boolean Activated;
	private RandomGenerator ran;
	public MetalMan()
	{
		StandingLeft = new GImage(MediaTools.loadImage("spritesheets/Bosses/MetalMan/StandLeft.gif"),0, 0);
		StandingRight = new GImage(MediaTools.loadImage("spritesheets/Bosses/MetalMan/StandRight.gif"),0, 0);
		JumpingLeft = new GImage(MediaTools.loadImage("spritesheets/Bosses/MetalMan/RunningLeft.gif"),0, 0);
		JumpingRight = new GImage(MediaTools.loadImage("spritesheets/Bosses/MetalMan/RunningRight.gif"),0, 0);
		ThrowLeft = new GImage(MediaTools.loadImage("spritesheets/Bosses/MetalMan/JumpToThrowLeft.gif"),0, 0);
		ThrowRight = new GImage(MediaTools.loadImage("spritesheets/Bosses/MetalMan/JumpToThrowRight.gif"),0, 0);
		ReleaseLeft = new GImage(MediaTools.loadImage("spritesheets/Bosses/MetalMan/AfterJumpThrowLeft.gif"),0, 0);
		ReleaseRight = new GImage(MediaTools.loadImage("spritesheets/Bosses/MetalMan/AfterJumpThrowRight.gif"),0, 0);
		RunningLeft = new GImage(MediaTools.loadImage("spritesheets/Bosses/MetalMan/StandLeft.gif"),0, 0);
		RunningRight = new GImage(MediaTools.loadImage("spritesheets/Bosses/MetalMan/StandLeft.gif"),0, 0);
		
		add(StandingLeft);
		add(StandingRight);
		add(JumpingLeft);
		add(JumpingRight);
		add(ThrowLeft);
		add(ThrowRight);
		add(ReleaseLeft);
		add(ReleaseRight);
		add(RunningLeft);
		add(RunningRight);
		
		Bound = new GRectangle(StandingLeft.getBounds());
		DownBound = new GRectangle(StandingLeft.getX(), StandingLeft.getY() + StandingLeft.getHeight() - 5, StandingLeft.getWidth(), 5);
		BoundPt = new GPoint(0, 0);
		ran =  new RandomGenerator();
		
	}
	public void Action(ArrayList<GRect> Ground, boolean start)
	{
		DownBound.setLocation(getCanvasPoint(BoundPt));
		DownBound.setLocation(DownBound.getX(), DownBound.getY() + StandingLeft.getHeight() -5);
		int coolwhilenum = 0;
		Gravity = true;
		while(coolwhilenum < Ground.size())
		{
			if(DownBound.intersects(Ground.get(coolwhilenum).getBounds()))
			{
				double center = DownBound.getY() + DownBound.getHeight() - Ground.get(coolwhilenum).getY();
				while(center > 1)
				{
					move(0, -1);
					center = center - 1;
				}
				Gravity = false;
				System.out.println("" + getCanvasPoint(BoundPt));
			}
			coolwhilenum = coolwhilenum + 1;
		}
		if(Gravity == true)
		{
			move(0, GravSpeed);
			System.out.println("falling");
			System.out.println("" + getCanvasPoint(BoundPt));
			System.out.println("" + BoundPt.getLocation());
		}
		if(start == true)
		{
			Activated = true;
		}
		if(Activated == true)
		{				
			StandingLeft.setVisible(false);
			StandingRight.setVisible(false);
			JumpingLeft.setVisible(false);
			JumpingRight.setVisible(false);
			ThrowLeft.setVisible(false);
			ThrowRight.setVisible(false);
			ReleaseLeft.setVisible(false);
			ReleaseRight.setVisible(false);
			RunningLeft.setVisible(false);
			if(Direct == 1)
			{
				StandingLeft.setVisible(true);
			}
			if(Direct == 2)
			{
				StandingRight.setVisible(true);
			}
			for(MetalBlade blade: BladeList)
			{
				blade.Fly();
			}
			CountDown = CountDown - 1;
			ThrowTimer = ThrowTimer - 1;
			if(ThrowTimer > 0)
			{
				StandingLeft.setVisible(false);
				StandingRight.setVisible(false);
				JumpingLeft.setVisible(false);
				JumpingRight.setVisible(false);
				ThrowLeft.setVisible(false);
				ThrowRight.setVisible(false);
				ReleaseLeft.setVisible(false);
				ReleaseRight.setVisible(false);
				RunningLeft.setVisible(false);
				RunningRight.setVisible(false);
				if(Direct == 1)
				{
					ReleaseLeft.setVisible(true);
				}
				if(Direct == 2)
				{
					ReleaseRight.setVisible(true);
				}
			}
			if(CountDown > 0)
			{
				JumpThrow();
			}
			if(CountDown < 0)
			{
				Run();
			}
		}
	}
	public void JumpThrow()
	{
		if(JumpTimer > 0)
		{
			if(JumpTimer < 15)
			{
				JumpTimer = JumpTimer - 1;
				Gravity = false;
				move(0, -JumpTimer - 5);
				Throw();
				if(Direct == 1)
				{
					JumpingLeft.setVisible(true);
				}
				if(Direct == 2)
				{
					JumpingRight.setVisible(true);
				}
			}
		}
	}
	public void Throw()
	{
		ranvalue =  ran.nextInt(1, 20);
		if(ranvalue == 1)
		{
			ThrowTimer = 5;
			MetalBlade blade = new MetalBlade();
			add(blade);
			BladeList.add(blade);
		}
		
	}
	public void Run()
	{
		if(Direct == 1)
		{
		move(-6, 0);
		RunningLeft.setVisible(true);
		}
		if(Direct == 2)
		{
		move(6, 0);
		RunningRight.setVisible(true);
		}
		RunTimer = RunTimer - 6;
		if(RunTimer < 0)
		{
			if(Direct == 1)
			{
				Direct = 2;
			}
			if(Direct == 2)
			{
				Direct = 1;
			}
		}
	}
}
