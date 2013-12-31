/* Name: David
 * File: SniperJoe.java
 * Description: TODO: Describe what this file does
 */
import acm.graphics.*;

import java.util.*;
public class SniperJoe extends GCompound
{
	private GImage Shield;
	private GImage Shoot;
	private GImage Bullet;
	private GImage RShield;
	private GImage RShoot;
	private GImage blowup;
	private GRectangle Bound;
	private GRectangle BulletBound;
	private GRectangle DownBound;
	private GPoint BoundPt;
	private GPoint BulletPt;
	private int Health = 3; int immunetime;
	private int damage;
	private int Direct = 1;
	private int BulletDirect = 1;
	private boolean alive = true;
	private int CountDown = 100;
	private int dieT = 8;
	private double GravSpeed;
	private boolean Gravity;
	private boolean respawn = false;
	private int valret;
	private int valret2;
	private int valret3;
	public SniperJoe()
	{
		Shield = new GImage(("spritesheets/Enemies/SniperJoe/Shield.gif"), 0, 0);
		Shoot = new GImage(("spritesheets/Enemies/SniperJoe/Shoot.gif"),0, 0);
		RShield = new GImage(("spritesheets/Enemies/SniperJoe/RShield.gif"), 0, 0);
		RShoot = new GImage(("spritesheets/Enemies/SniperJoe/RShoot.gif"),0, 0);
		Bullet = new GImage(("spritesheets/Enemies/SniperJoe/Bullet.gif"), 0, 7);
		BulletBound = new GRectangle(Bullet.getBounds());
		Bound = new GRectangle();
		BoundPt = new GPoint();
		BulletPt = new GPoint();
		DownBound = new GRectangle(0, Shoot.getY() - Shoot.getHeight() - 5, Shoot.getWidth(), 5);
		
		add(Shield);
		add(Shoot);
		add(RShield);
		add(RShoot);
		add(Bullet);
		
		BulletBound.setSize(Bullet.getWidth(), Bullet.getHeight());
		Bound.setSize(Shield.getWidth(), Shield.getHeight());
		
	}
	public void Creation()
	{
		if(respawn == true)
		{
			Shield.setVisible(true);
			Shoot.setVisible(true);
			Bullet.setVisible(true);
			RShield.setVisible(true);
			RShoot.setVisible(true);
			
			BulletBound.setSize(Bullet.getWidth(), Bullet.getHeight());
			Bound.setSize(Shield.getWidth(), Shield.getHeight());
			alive = true;
			dieT = 8;
			respawn = false;
			Health = 3;
			CountDown = 100;
			remove(blowup);
		}
	}
	public void Attack(ArrayList<GRectangle> bullet, ArrayList<GRect> Ground, GRectangle MegaRect, ArrayList<GRect> Fall)
	{
		if(MegaRect.getX() > Bound.getX())
		{
			Direct = 2;
		}
		else
		{
			Direct = 1;
		}
		CountDown = CountDown - 1;
		damage = 0;
		valret = -1;
		valret2 = -1;
		valret3 = -1;
		DownBound.setLocation(getCanvasPoint(BoundPt));
		DownBound.setLocation(DownBound.getX(), DownBound.getY() + Shoot.getHeight() - 5);
		BulletPt.setLocation(Bullet.getX(), Bullet.getY());
		Bound.setLocation(getCanvasPoint(BoundPt));
		BulletBound.setLocation(getCanvasPoint(BulletPt));
		int coolwhilenum = 0;
		Gravity = true;
		for(GRect fall: Fall)
		{
			if(Bound.intersects(fall.getBounds()))
			{
				Die();
			}
		}
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
				GravSpeed = 2;
				Gravity = false;
			}
			coolwhilenum = coolwhilenum + 1;
		}
		coolwhilenum = 0;
		if(Gravity == true)
		{
			Bullet.move(0, -GravSpeed);
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
		if(BulletDirect == 1)
		{		
			Bullet.move(-9, 0);
		}
		if(BulletDirect == 2)
		{
			Bullet.move(9, 0);
		}
		
		if(alive == true)
		{
			
			if(CountDown > 0 || CountDown < -20)
			{
				Shield.setVisible(false);
				Shoot.setVisible(false);
				RShield.setVisible(false);
				RShoot.setVisible(false);
				if(Direct == 1)
				{
					Shield.setVisible(true);
				}
				if(Direct == 2)
				{
					RShield.setVisible(true);
				}
				Bound.setSize(Shield.getSize());
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
					}
					val = val + 1;
				}
			}
			if(CountDown == 0)
			{
				BulletDirect = Direct;
				Bullet.setLocation(0, 7);
			}
			if(CountDown < 0)
			{
				Shield.setVisible(false);
				Shoot.setVisible(false);
				RShield.setVisible(false);
				RShoot.setVisible(false);
				if(Direct == 1)
				{
					Shoot.setVisible(true);
				}
				if(Direct == 2)
				{
					RShoot.setVisible(true);
				}
				
				Bound.setSize(Shield.getSize());
				Bound.setLocation(Bound.getX() + 10, Bound.getY());
				
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
			if(BulletBound.getX() < 0)
			{
				Bullet.setLocation(900000000, -400);
			}
		}
		if(CountDown == -20)
		{
			CountDown = 100;
		}
		if(dieT <= 7)
		{
			dieT = dieT - 1;
		}
		if(dieT <= 0)
		{
			remove(blowup);
		}
		if(alive == true)
		{
			if(Bound.intersects(MegaRect))
			{
				damage = 2;
			}	
		}
		if(BulletBound.intersects(MegaRect))
		{
			damage = 2;
		}
	}
	public void Die()
	{
		if(alive == true)
		{
			alive = false;
			Shield.setVisible(false);
			Shoot.setVisible(false);
			RShield.setVisible(false);
			RShoot.setVisible(false);
			blowup = new GImage(("spritesheets/Enemies/Blow Up.gif"), -4, -4);
			add(blowup);
		}
		dieT = 7;
	}
	public boolean ReturnAlive()
	{
		return(alive);
	}
	public void Respawn()
	{
		respawn = true;
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
}
