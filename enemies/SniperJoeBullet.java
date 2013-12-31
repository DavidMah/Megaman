/* Name: David
 * File: SniperJoeBullet.java
 * Description: TODO: Describe what this file does
 */
package enemies;
import acm.graphics.*;
import acm.util.*;
public class SniperJoeBullet extends GCompound
{
	private GImage Bullet;
	public SniperJoeBullet()
	{
		Bullet = new GImage(MediaTools.loadImage("spritesheets/Enemies/SNiperJoe/Bullet.gif"), 0, 0);
		
		add(Bullet);
	}
}
