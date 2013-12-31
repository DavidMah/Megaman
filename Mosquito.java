/* Name: David
 * File: Mosquito.java
 * Description: TODO: Describe what this file does
 */
import acm.graphics.*;

import java.util.*;
public class Mosquito extends GCompound
{
	private int dieT = 8;
	private boolean alive = true;
	private GImage mosquito;
	private GImage Rmosquito;
	private GImage blowup;
	private GPoint Pt;
	private int Health = 1;
	private boolean spawn;
	private GRectangle Bound;
	private int damage;
	private int valret;
	private int valret2;
	private int valret3;
	private int Direct;
	public Mosquito()
	{
		mosquito = new GImage(("spritesheets/Enemies/Mosquito/Mosquito.gif"), 0, 0);
		Rmosquito = new GImage(("spritesheets/Enemies/Mosquito/RMosquito.gif"), 0, 0);
		Pt = new GPoint();
		Bound = new GRectangle(mosquito.getBounds());
		add(mosquito);
		add(Rmosquito);
	}
	public void Creation()
	{
		if(spawn == true)
		{
			mosquito.setVisible(true);
			Rmosquito.setVisible(true);
			blowup.setVisible(false);
			remove(blowup);
			spawn = false;
			alive = true;
			dieT = 8;
			Direct = 0;
		}
	}
	public void Attack(ArrayList<GRectangle> bullet, GRectangle MegaRect)
	{
		if(Direct == 0)
		{
			if(MegaRect.getX() > Bound.getX())
			{
				Direct = 2;
			}
			else
			{
				Direct = 1;
			}
		}
		valret = -1;
		valret2 = -1;
		valret3 = -1;
		damage = 0;
		Bound.setLocation(getCanvasPoint(Pt));
		if(alive == true)
		{
			if(Direct == 1)
			{
				move(-9, 0);
			}
			if(Direct == 2)
				move(9, 0);
			for(GRectangle bull: bullet)
			{
				if(Bound.intersects(bull))
				{
					Die();					
				}
			}
			if(Bound.intersects(MegaRect))
			{
				damage = 2;
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
					
					if(bullet.get(val).getHeight() == 31)
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
		if(alive == true)
		{
			alive = false;
		}
		dieT = dieT - 1;
		blowup = new GImage(("spritesheets/Enemies/Blow Up.gif"), 0, 0);
		mosquito.setVisible(false);
		if(dieT == 0)
		{
			remove(blowup);
		}
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
