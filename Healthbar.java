/* Name: David
 * File: Healthbar.java
 * Description: TODO: Describe what this file does
 */
import acm.graphics.*;
import acm.util.*;

public class Healthbar extends GCompound
{ 
	private GImage Bar;
	public Healthbar()
	{
		//Imports the HealthBar Image.
		Bar = new GImage(MediaTools.loadImage("spritesheets/misc/Meter/28.gif"), 0, 0);
		add(Bar);
		Bar.setSize(Bar.getWidth()*2, Bar.getHeight()*2);
	}
	//Checks for a change in health and operates changes to healthbar.
	public void Update(int Health)
	{
		if(Health >= 0)
		{
		Bar.setImage(MediaTools.loadImage("spritesheets/misc/Meter/"+ Health + ".gif"));
		}
		else
		{
			Bar.setImage(MediaTools.loadImage("spritesheets/misc/Meter/"+ 0 + ".gif"));
		}
	}
}
