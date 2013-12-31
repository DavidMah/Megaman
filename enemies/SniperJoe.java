/* Name: David
 * File: SniperJoe.java
 * Description: TODO: Describe what this file does
 */
package enemies;
import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;
import acm.util.*;

public class SniperJoe extends GraphicsProgram
{
	private GImage Shield;
	private GImage Shoot;
	private SniperJoeBullet bullet;
	private double ShootTimer = 40;

	public void run()
	{
		Shield = new GImage(MediaTools.loadImage("spritesheets/Enemies/SniperJoe/Shield.gif"), 100, 100);
		Shoot = new GImage(MediaTools.loadImage("spritesheets/Enemies/SniperJoe/Shoot.gif"), 104, 101);
		bullet = new SniperJoeBullet();
		
		add(Shield);
		add(Shoot);
		add(bullet);
		
		bullet.setLocation(100, 110);
		
		Shoot.setVisible(false);
	}
	public void Attack()
	{
		ShootTimer = ShootTimer - 1;
		bullet.move(-3, 0);
		if(ShootTimer < 0)
		{
			Shoot.setVisible(true);
			Shield.setVisible(false);
		}
		if(ShootTimer > 0)
		{
			Shoot.setVisible(false);
			Shield.setVisible(true);
			
		}
		if(ShootTimer == 250)
		{
			ShootTimer = 40;
			bullet.setLocation(100, 110);
		}
	}
}
