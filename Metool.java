/* Name: David
 * File: SniperJoe.java
 * Description: TODO: The Metool enemy
 */
import acm.graphics.*;
import acm.util.*;
import java.util.*;
public class Metool extends GCompound
{
	private GImage Tool;
	private GImage HalfTool;
	private GImage MovingTool;
	private GImage RTool;
	private GImage RHalfTool;
	private GImage RMovingTool;
	private GPoint ToolPt;
	private GRectangle ToolBound;
	private GRectangle DownBound;
	private int CountDown = 70;
	private double Health = 2;
	private boolean alive = true;
	private int Direct;
	private int dieT = 8;
	private boolean spawn;
	private double GravSpeed = 2;
	private int immunetime = 0;
	private boolean Gravity;
	private GImage blowup;
	private int damage;
	private int valret;
	private int valret2;
	private int valret3;
	private GRectangle LeftCheck;
	private GRectangle RightCheck;
	private boolean leftok;
	private boolean rightok;
	public Metool()
	{
		Tool = new GImage(MediaTools.loadImage("spritesheets/Enemies/Metool/Sleep.gif"), 0, 7);
		HalfTool = new GImage(MediaTools.loadImage("spritesheets/Enemies/Metool/Half.gif"), 0, 0);
		MovingTool = new GImage(MediaTools.loadImage("spritesheets/Enemies/Metool/Move.gif"), 0, 0);
		RTool = new GImage(MediaTools.loadImage("spritesheets/Enemies/Metool/SleepR.gif"), 0, 7);
		RHalfTool = new GImage(MediaTools.loadImage("spritesheets/Enemies/Metool/HalfR.gif"), 0, 0);
		RMovingTool = new GImage(MediaTools.loadImage("spritesheets/Enemies/Metool/MoveR.gif"), 0, 0);
		
		ToolPt = new GPoint(0, 0);
		ToolBound = new GRectangle(MovingTool.getBounds());
		DownBound = new GRectangle(0, Tool.getY(), Tool.getWidth(), Tool.getHeight());
		LeftCheck = new GRectangle(MovingTool.getX() - 5, 0, 5, MovingTool.getHeight() - 3);
		RightCheck = new GRectangle(MovingTool.getX() + MovingTool.getWidth(), 0, 5, MovingTool.getHeight() - 3);
		
		add(Tool);
		add(HalfTool);
		add(MovingTool);
		add(RTool);
		add(RHalfTool);
		add(RMovingTool);
	}
	public void Creation()
	{
		if(spawn == true)
		{
			Tool.setVisible(true);
			HalfTool.setVisible(true);
			MovingTool.setVisible(true);
			RTool.setVisible(true);
			RHalfTool.setVisible(true);
			RMovingTool.setVisible(true);
			
			CountDown = 70;
			Health = 2;
			alive = true;
			dieT = 8;
			spawn = false;
			remove(blowup);
		}
	}
	public void Attack(ArrayList<GRectangle> bullet, ArrayList<GRect> Ground,GRectangle MegaRect, ArrayList<GRect> Fall)
	{
		valret = -1;
		valret2 = -1;
		valret3 = -1;
		if(immunetime > 0)
		{
			immunetime = immunetime + 1;
			if(immunetime <= 10)
			{
				immunetime = 0;
			}
		}
		damage = 0;
		ToolBound.setLocation(getCanvasPoint(ToolPt));
		DownBound.setLocation(getCanvasPoint(ToolPt));
		DownBound.setLocation(DownBound.getX(), DownBound.getY() + 6);
		LeftCheck.setLocation(getCanvasPoint(ToolPt));
		LeftCheck.setLocation(LeftCheck.getX() -5, LeftCheck.getY());
		RightCheck.setLocation(getCanvasPoint(ToolPt));
		RightCheck.setLocation(RightCheck.getX() + MovingTool.getWidth(), RightCheck.getY());
		leftok = true;
		rightok = true;
		for(GRect gr: Ground)
		{
			if(LeftCheck.intersects(gr.getBounds()))
			{
				leftok = false;
			}
			if(RightCheck.intersects(gr.getBounds()))
			{
				rightok = false;
			}
		}
		if(alive == true)
		{
			for(GRect fall: Fall)
			{
				if(ToolBound.intersects(fall.getBounds()))
				{
					Die();
				}
			}
			int coolwhilenum = 0;
			Gravity = true;
			while(coolwhilenum < Ground.size())
			{
				if(DownBound.intersects(Ground.get(coolwhilenum).getBounds()))
				{
					double center = DownBound.getY() + DownBound.getHeight() - Ground.get(coolwhilenum).getY();
					if(center < 13)
					{
					while(center > 1)
					{
						move(0, -1);
						center = center - 1;
						
					}
					}
					GravSpeed = 2;
					Gravity = false;
				}
				coolwhilenum = coolwhilenum + 1;
			}
			coolwhilenum = 0;
			if(Gravity == true)
			{
				move(0, GravSpeed);
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
			CountDown = CountDown - 1;
			if(CountDown > 0)
			{
				Tool.setVisible(false);
				HalfTool.setVisible(false);
				MovingTool.setVisible(false);
				RTool.setVisible(false);
				RHalfTool.setVisible(false);
				RMovingTool.setVisible(false);
				if(Direct == 1)
				{
					Tool.setVisible(true);
				}
				if(Direct == 2)
				{
					RTool.setVisible(true);
				}
				ToolBound.setLocation(ToolBound.getX(), ToolBound.getY() + 10);
				if(MegaRect.getX() > ToolBound.getX())
				{
					Direct = 2;
				}
				else
				{
					Direct = 1;
				}
				int val = 0;		
				while(val < bullet.size())
				{
					if(ToolBound.intersects(bullet.get(val)))
					{
						System.out.println(Health);
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
						
					}
					val = val + 1;
				}
			}
			if((CountDown < 6 && CountDown > -1) || (CountDown < -44 && CountDown > -51))
			{
				Tool.setVisible(false);
				HalfTool.setVisible(false);
				MovingTool.setVisible(false);
				RTool.setVisible(false);
				RHalfTool.setVisible(false);
				RMovingTool.setVisible(false);
				if(Direct == 1)
				{
					HalfTool.setVisible(true);
				}
				if(Direct == 2)
				{
					RHalfTool.setVisible(true);
				}
				int val = 0;		
				while(val < bullet.size())
				{
					if(ToolBound.intersects(bullet.get(val)))
					{
						System.out.println(Health);
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
						
					}
					val = val + 1;
				}
			}
			
			if(CountDown < -1 & CountDown > -44)
			{
				Tool.setVisible(false);
				HalfTool.setVisible(false);
				MovingTool.setVisible(false);
				RTool.setVisible(false);
				RHalfTool.setVisible(false);
				RMovingTool.setVisible(false);
				if(Direct == 1)
				{
					MovingTool.setVisible(true);
					if(leftok == true)
					{
						move(-7, 0);
					}
				}
				if(Direct == 2)
				{
					RMovingTool.setVisible(true);
					if(rightok == true)
					{
						move(7, 0);
					}
				}
				
				int val = 0;		
				while(val < bullet.size())
				{
					if(ToolBound.intersects(bullet.get(val)))
					{
						System.out.println(Health);
						if((Health > 4 && bullet.get(val).getHeight() > 30)
								|| (Health > 2 && bullet.get(val).getHeight() > 16))
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
						}
						
						
						if(bullet.get(val).getHeight() == 30)
						{
							Health = Health - 3;
						}
						if(bullet.get(val).getHeight() == 16)
						{
							Health = Health - 2;
						}
						else
						{
							Health = Health - 1;
						}
						if(Health <= 0)
						{
							Die();
						}
					}
					val = val + 1;
				}
			}
			if(ToolBound.intersects(MegaRect))
			{
				damage = 2;
			}
		}
		if(CountDown < -51)
		{
			CountDown = 70;
		}
		if(dieT <= 7)
		{
			dieT = dieT - 1;
		}
		if(dieT <= 0)
		{
			remove(blowup);
		}
	}
	public void Die()
	{
		if(alive == true)
		{
			alive = false;
			Tool.setVisible(false);
			HalfTool.setVisible(false);
			MovingTool.setVisible(false);
			RTool.setVisible(false);
			RHalfTool.setVisible(false);
			RMovingTool.setVisible(false);
			dieT = dieT - 1;
			blowup = new GImage(("spritesheets/Enemies/Blow Up.gif"), 0, 5);
			add(blowup);
		}
		
	}
	public boolean ReturnAlive()
	{
		return(alive);
	}
	public void Respawn()
	{
		spawn = true;
	}
	public int ReturnDam()
	{
		return(damage);
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
}
