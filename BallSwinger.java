/* Name: dmah10
 * File: BallSwinger.java
 * Description: TODO: Describe what this file does
 */
import acm.program.*;
import acm.graphics.*;

import java.awt.event.*;
import java.util.*;
import acm.util.*;
public class BallSwinger extends GCompound
{
	private GImage Swinging;
	private GImage Throw;
	private GImage Ball;
	private GRectangle Bound;
	private GRectangle BallBound;
	private GPoint BoundPt;
	private GPoint BallPt;
	private int Health = 3;
	private boolean alive = true;
	private int CountDown = 100;
	private int dieT = 4;
	private boolean respawn;
	private int damage;
	public BallSwinger()
	{
		Swinging = new GImage(("spritesheets/Enemies/Ball Swinger/Swinging.gif"), 0, 0);
		Throw = new GImage(("spritesheets/Enemies/Ball Swinger/Throw.gif"),0, 0);
		Ball = new GImage(("spritesheets/Enemies/Ball Swinger/Ball.gif"), 0, 0);
		BallBound = new GRectangle();
		Bound = new GRectangle();
		BoundPt = new GPoint();
		BallPt = new GPoint();
		
		add(Swinging);
		add(Throw);
		add(Ball);
		
		BallBound.setSize(Ball.getWidth(), Ball.getHeight());
		Bound.setSize(Swinging.getWidth(), Swinging.getHeight());
	}
	public void Attack(ArrayList<GRectangle> bullet)
	{
		BallPt.setLocation(Ball.getX(), Ball.getY());
		CountDown = CountDown - 1;
		Bound.setLocation(getCanvasPoint(BoundPt));
		BallBound.setLocation(getCanvasPoint(BallPt));
		if(alive == true)
		{
			for(GRectangle bull: bullet)
			{
				if(Bound.intersects(bull))
				{
					if(bull.getHeight() == 31)
					{
					Health = Health - 3;
					}
					if(bull.getHeight() == 16)
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
			}
			Ball.move(-9, 0);
			if(CountDown > 0)
			{
				Swinging.setVisible(true);
				Throw.setVisible(false);
				Bound.setSize(Swinging.getSize());
			}
			if(CountDown == 0)
			{
				Ball.setLocation(0, 20);
			}
			if(CountDown < 0)
			{
				Swinging.setVisible(false);
				Throw.setVisible(true);
				
				Bound.setSize(Swinging.getSize());
				Bound.setLocation(Bound.getX() + 10, Bound.getY());
				
			}
			if(BallBound.getX() < 0)
			{
				CountDown = 100;
				Ball.setLocation(900000000, 0);
			}
		}
	}
	public void Die()
	{
		if(alive == true)
		{
			alive = false;
			remove(Swinging);
			remove(Throw);
		}
		dieT = dieT - 1;
		GImage blowup = new GImage(("spritesheets/Enemies/Blow Up.gif"), 0, 0);
		add(blowup);
		if(dieT == 0)
		{
			remove(blowup);
		}
	}
	public boolean ReturnAlive()
	{
		return(alive);
	}
	public void Respawn()
	{
		respawn = true;
	}
	public int ReturnDam()
	{
		return(damage);
	}
}
