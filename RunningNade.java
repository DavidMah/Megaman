/* Name: David
 * File: RunningNade.java
 * Description: TODO: Describe what this file does
 */
import java.util.*;

import acm.graphics.*;
public class RunningNade extends GCompound
{
	private GImage Running;
	private GImage Jump;
	private GImage blowup;
	private GPoint Pt;
	private GRectangle Bound;
	private GRectangle DownBound;
	private GRectangle LeftBound;
	private GRectangle LeftCheck;
	private boolean spawn;
	private int Health = 2;
	private int dieT = 8;
	private int damage;
	private boolean alive = true;
	private boolean Gravity;
	private double GravSpeed = 2;
	private boolean Jumpy;
	private int JumpSpeed = 10;
	private boolean LeftOk;
	private int valret;
	private int valret2;
	private int valret3;
	public RunningNade()
	{
		Running = new GImage(("spritesheets/Enemies/Running Grenade/Running.gif"), 0, 0);
		Jump = new GImage(("spritesheets/Enemies/Running Grenade/Jump.gif"), 0, 0);
		Bound = new GRectangle(Running.getBounds());
		DownBound = new GRectangle(Running.getX() + 5, Running.getY(), Running.getWidth() - 5, Running.getHeight());
		LeftBound = new GRectangle(Running.getX(), Running.getY(), 5, Running.getHeight());
		LeftCheck = new GRectangle(Running.getX() - 5, Running.getHeight(), 5, Running.getHeight());
		Pt = new GPoint();
		
		add(Running);
		add(Jump);
	}
	public void Creation()
	{
		if(spawn == true)
		{
			Running.setVisible(true);
			Health = 2;
			dieT = 8;
			spawn = false;
			alive = true;
		}
	}
	public void Action(ArrayList<GRect> Ground, GRectangle MegaRect, ArrayList<GRectangle> bullet, ArrayList<GRect> Fall)
	{
		valret = -1;
		valret2 = -1;
		valret3 = -1;
		damage = 0;
		Bound.setLocation(getCanvasPoint(Pt));
		DownBound.setLocation(getCanvasPoint(Pt));
		DownBound.setLocation(DownBound.getX() + 5, DownBound.getY());
		LeftBound.setLocation(getCanvasPoint(Pt));
		LeftBound.setLocation(LeftBound.getX(), LeftBound.getY() + 4);
		LeftCheck.setLocation(getCanvasPoint(Pt));
		LeftCheck.setLocation(LeftCheck.getX() - 5, LeftCheck.getY() - 5);
		LeftOk = true;
		if(alive == true)
		{
			for(GRect fall: Fall)
			{
				if(Bound.intersects(fall.getBounds()))
				{
					Die();
				}
			}
			int coolwhilenum = 0;
			Gravity = true;
			for(GRect wall: Ground)
			{
				if(wall.getBounds().intersects(LeftCheck))
				{
					LeftOk = false;
				}
			}
			if(LeftOk == true)
			{
				move(-8, 0);
			}
			while(coolwhilenum < Ground.size())
			{
				
				if(DownBound.intersects(Ground.get(coolwhilenum).getBounds()))
				{
					GravSpeed = 2;
					Running.setVisible(true);
					Jump.setVisible(false);
					Jumpy = true;
					double center = DownBound.getY() + DownBound.getHeight() - Ground.get(coolwhilenum).getY();
					while(center > 1)
					{
						move(0, -1);
						center = center - 1;
					}
					GravSpeed = 2;
					Gravity = false;
				}
				if(LeftBound.intersects(Ground.get(coolwhilenum).getBounds()))
				{		
					Jumpy = false;
				}
				coolwhilenum = coolwhilenum + 1;
			}
			coolwhilenum = 0;
			if(Jumpy == true)
			{
				Gravity = false;
				
				Running.setVisible(false);
				Jump.setVisible(true);
				move(0, -JumpSpeed/3);
				JumpSpeed = JumpSpeed - 1;
				if(JumpSpeed == 0)
				{
					Gravity = true;
					Jumpy = false;
					JumpSpeed = 10;
				}
			}
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
			
			damage = 0;
			if(Bound.intersects(MegaRect))
			{
				Die();
				damage = 3;
			}
			int val = 0;		
			while(val < bullet.size())
			{
				if(Bound.intersects(bullet.get(val)))
				{
					if((Health > 4 && bullet.get(val).getHeight() > 30)
							|| (Health > 2 && bullet.get(val).getHeight() > 16))
					{
						if(valret == -1)
						{
							valret = val ;
							System.out.println(val);
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
		alive = false;
		dieT = 7;
		Running.setVisible(false);
		Jump.setVisible(false);
		blowup = new GImage(("spritesheets/Enemies/Blow Up.gif"), 0, 0);
		add(blowup);
	}
	public boolean ReturnAlive()
	{
		return(alive);
	}
	public void Spawn()
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
