/* Name: David
 * File: TurretGun.java
 * Description: TODO: Describe what this file does
 */
import acm.graphics.*;
import acm.util.*;
import java.util.*;
public class TurretGun extends GCompound
{
	private GImage NotLeft;
	private GImage NotRight;
	private GImage Bullet;
	private GImage ShotLeft;
	private GImage ShotRight;
	private GImage Turn;
	private GImage blowup;
	private GRectangle Bound;
	private GRectangle BulletBound;
	private GRectangle DownBound;
	private GPoint BoundPt;
	private GPoint TurnPt;
	private GPoint BulletPt;
	private int Health = 10;
	private int damage;
	private boolean alive = true;
	private int CountDown = 100;
	private int dieT = 8;
	private double GravSpeed;
	private boolean Gravity;
	private boolean respawn = false;
	private int valret;
	private int valret2;
	private int valret3;
	private int Direct;
	public TurretGun()
	{
		NotLeft = new GImage(MediaTools.loadImage("spritesheets/ENemies/Turret Gunner/Not.gif"), 0, 0);
		NotRight = new GImage(MediaTools.loadImage("spritesheets/ENemies/Turret Gunner/NotRight.gif"), 0, 0);
		ShotLeft = new GImage(MediaTools.loadImage("spritesheets/ENemies/Turret Gunner/Shot.gif"), 0, 0);
		ShotRight = new GImage(MediaTools.loadImage("spritesheets/ENemies/Turret Gunner/ShotRight.gif"), 0, 0);
		Turn = new GImage(MediaTools.loadImage("spritesheets/Enemies/Turret Gunner/Turn.gif"), 10, 0);
		Bullet = new GImage(MediaTools.loadImage("spritesheets/Enemies/SniperJoe/Bullet.gif"), 17, 15);
		
		BulletBound = new GRectangle(Bullet.getBounds());
		Bound = new GRectangle();
		BoundPt = new GPoint();
		BulletPt = new GPoint();
		DownBound = new GRectangle(0, NotLeft.getY() - NotLeft.getHeight() - 5, NotLeft.getWidth(), 5);
		TurnPt = new GPoint(Turn.getX(), Turn.getY());
		
		add(NotLeft);
		add(NotRight);
		add(Bullet);
		add(ShotLeft);
		add(ShotRight);
		add(Turn);
		
		BulletBound.setSize(Bullet.getWidth(), Bullet.getHeight());
		Bound.setSize(NotRight.getSize());
		
	}
	public void Creation()
	{
		if(respawn == true)
		{
			NotLeft.setVisible(true);
			NotRight.setVisible(true);
			Bullet.setVisible(true);
			ShotLeft.setVisible(true);
			ShotRight.setVisible(true);
			Turn.setVisible(true);
			
			BulletBound.setSize(Bullet.getWidth(), Bullet.getHeight());
			Bound.setSize(NotRight.getSize());
			alive = true;
			dieT = 8;
			respawn = false;
			Health = 3;
			CountDown = 35;
			remove(blowup);
		}
	}
	public void Action(ArrayList<GRect> Ground, GRectangle MegaRect, ArrayList<GRectangle> bullet, ArrayList<GRect> Fall)
	{
		if(getX() > MegaRect.getX())
		{
			if(Direct == 2)
			{
				
			}
			Direct = 1;
		}
		else
		{
			if(Direct == 1)
			{
				
			}
			Direct = 2;
		}
		CountDown = CountDown - 1;
		damage = 0;
		valret = -1;
		valret2 = -1;
		valret3 = -1;
		DownBound.setLocation(getCanvasPoint(BoundPt));
		DownBound.setLocation(DownBound.getX(), DownBound.getY() + NotLeft.getHeight() - 5);
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
		Bullet.move(-9, 0);
		if(alive == true)
		{
			
			if(CountDown < 0 && CountDown > -15)
			{
				NotLeft.setVisible(false);
				NotRight.setVisible(false);
				Bullet.setVisible(false);
				ShotLeft.setVisible(false);
				ShotRight.setVisible(false);
				Turn.setVisible(true);
				Bound.setSize(Turn.getSize());
				Bound.setLocation(getCanvasPoint(TurnPt));
			}
			if(CountDown == 20)
			{
				Bullet.setLocation(0, 7);
			}
			if(CountDown > 0)
			{
				NotLeft.setVisible(false);
				NotRight.setVisible(false);
				Bullet.setVisible(false);
				ShotLeft.setVisible(false);
				ShotRight.setVisible(false);
				Turn.setVisible(false);
				if(Direct == 1)
				{
					NotLeft.setVisible(true);
					Bound.setSize(NotLeft.getSize());
					Bound.setLocation(Bound.getX() + 10, Bound.getY());
				}
				if(Direct == 2)
				{
					NotRight.setVisible(true);
					Bound.setSize(NotRight.getSize());
					Bound.setLocation(Bound.getX() + 10, Bound.getY());
				}
				if(CountDown < 10 && CountDown > 20)
				{
					NotLeft.setVisible(false);
					NotRight.setVisible(false);
					if(Direct == 1)
					{
						ShotLeft.setVisible(true);
					}
					if(Direct == 2)
					{
						ShotRight.setVisible(true);
					}
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
			NotLeft.setVisible(false);
			NotRight.setVisible(false);
			Bullet.setVisible(false);
			ShotLeft.setVisible(false);
			ShotRight.setVisible(false);
			Turn.setVisible(false);
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