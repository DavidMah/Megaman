/* Name: dmah10
 * File: Bullet.java
 * Description: TODO: Describe what this file does
 */
import acm.util.*;
import acm.graphics.*;
public class Bullet extends GCompound
{
	private GImage bullet;
	private int Direction = 0;
	private int Power;
	private GPoint BoundPt;
	private GRectangle Bound;
	public Bullet()
	{
		BoundPt = new GPoint();
		Bound = new GRectangle();
	}
//	This is the method to create the bullet.
//	1 is a pellet.  2 is half charged.  3 is full charged.
	public void Creation(int Direct, int Strength)
	{
		if(Strength > 40)
		{
			Power = 3;
		}
		if(Strength < 40)
		{
			Power = 2;
		}
		if(Strength < 20)
		{
			Power = 1;
		}
		if(Power == 1)
		{
			bullet = new GImage(MediaTools.loadImage("spritesheets/Megaman/Stand/Bullet.gif"), 0, 0);
			add(bullet);
			Bound.setBounds(bullet.getBounds());
			BoundPt.setLocation(bullet.getLocation());
		}
		if(Power == 2)
		{
			if(Direct == 1)
			{
				bullet = new GImage(MediaTools.loadImage("spritesheets/Megaman/charge/Bullet/Med/BulletLeft.gif"), 0, -5);
				add(bullet);
				Bound = new GRectangle(bullet.getBounds());
			}
			if(Direct == 2)
			{
				bullet = new GImage(MediaTools.loadImage("spritesheets/Megaman/charge/Bullet/Med/Bullet.gif"), 0, -5);
				add(bullet);
				Bound = new GRectangle(bullet.getBounds());
			}
			Bound.setBounds(bullet.getBounds());
			BoundPt.setLocation(bullet.getLocation());
		}
		if(Power == 3)
		{
			if(Direct == 1)
			{
				bullet = new GImage(MediaTools.loadImage("spritesheets/Megaman/charge/Bullet/Large/BulletLeft.gif"), 0, -10);
				add(bullet);
				Bound = new GRectangle(bullet.getBounds());
			}
			if(Direct == 2)
			{
				bullet = new GImage(MediaTools.loadImage("spritesheets/Megaman/charge/Bullet/Large/Bullet.gif"), 0, -10);
				add(bullet);
				Bound = new GRectangle(bullet.getBounds());
			}
			Bound.setBounds(bullet.getBounds());
			BoundPt.setLocation(bullet.getLocation());
		}
		System.out.println(Bound.getHeight());
	}
	public void Shoot(int Direct)
	{
		Bound.setLocation(getCanvasPoint(BoundPt));
		if(Direction == 0)
		{
			Direction = Direct;
		}
		if(Direction == 1)
		{
			move(-12, 0);
		}
		if(Direction == 2)
		{
			move(12, 0);
		}
	}
	public GRectangle BoundReturn()
	{
		return(Bound);
	}
}
