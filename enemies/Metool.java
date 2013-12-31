/* Name: David
 * File: Metool.java
 * Description: TODO: Describe what this file does
 */
package enemies;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.event.*;
public class Metool extends GraphicsProgram
{
	private GImage Tool;
	private double AttackTimer = 37;
	private SwingTimer clock;
	private double Health;
	public void run()
	{
		Tool = new GImage(MediaTools.loadImage("spritesheets/Enemies/Metool/Sleep.gif"), 500, 40);
		MediaTools.loadImage("spritesheets/Enemies/Metool/Move.gif");
		add(Tool);
		
		clock = new SwingTimer(50, this);
		clock.start();
	}
	public void actionPerformed(ActionEvent e)
	{
		AttackTimer = AttackTimer - 1;
		if(AttackTimer < 36 & AttackTimer > 0)
		{
			Tool.setImage(MediaTools.loadImage("spritesheets/Enemies/Metool/Move.gif"));
			Tool.move(-6, 0);

		}
		if(AttackTimer < 0)
		{
			Tool.setImage(MediaTools.loadImage("spritesheets/Enemies/Metool/Sleep.gif"));
		}
		if(AttackTimer == -37)
		{
			AttackTimer = 37;
		}
	}
	public void attack()
	{
		AttackTimer = AttackTimer - 1;
		if(AttackTimer < 36 & AttackTimer > 0)
		{
			Tool.setImage(MediaTools.loadImage("spritesheets/Enemies/Metool/Move.gif"));
			Tool.move(-6, 0);

		}
		if(AttackTimer < 0)
		{
			Tool.setImage(MediaTools.loadImage("spritesheets/Enemies/Metool/Sleep.gif"));
		}
		if(AttackTimer == -37)
		{
			AttackTimer = 37;
		}
	}
}
