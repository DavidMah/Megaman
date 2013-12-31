/* Name: David
 * File: ENEMYTEST.java
 * Description: TODO: Describe what this file does
 */
package enemies;

import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;
import acm.util.*;
public class ENEMYTEST extends GraphicsProgram
{
	private SwingTimer clock;
	private SniperJoe Joe;
	public void run()
	{
		Joe = new SniperJoe();
		
		add(Joe);
		
		Joe.setLocation(100, 100);
		
		clock = new SwingTimer(50, this);
		clock.start();
	}
	public void actionPerformed(ActionEvent e)
	{
		Joe.Attack();
	}
}
