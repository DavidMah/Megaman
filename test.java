/* Name: David
 * File: test.java
 * Description: TODO: Describe what this file does
 */
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.event.*;
public class test extends GraphicsProgram
{	
//	Timer for 50 miliseconds per tick
	private SwingTimer clock;
//	The fields which indicate if a key is being pressed down or not
	private Boolean Right;
	private Boolean Left;
	private Boolean Shoot;
//	The int which indicates the direction that Megaman is facing.  2 meaning Left and 1 meaning Right
	private int Direct = 2;
	
//	imported Images for each animation of Megaman
	private GImage StandRight;
	private GImage StandLeft;
	private GImage ShootingRight;
	private GImage ShootingLeft;
	private GImage Running;
	private GImage RunningLeft;
	private GImage RunShooting;
	private GImage RunShootingLeft;
	private GImage ConfusedLeft;
	private GImage ConfusedRight;
	
	public void run()
	{
//		Loading the Images
		StandRight = new GImage(MediaTools.loadImage("spritesheets/Megaman/stand/StandBored.gif"),100, 100);
		StandLeft = new GImage(MediaTools.loadImage("spritesheets/Megaman/stand/StandBoredLeft.gif"), 100, 100);
		ShootingRight = new GImage(MediaTools.loadImage("spritesheets/Megaman/stand/Shoot.gif"), 100, 100);
		ShootingLeft = new GImage(MediaTools.loadImage("spritesheets/Megaman/stand/ShootLeft.gif"), 90, 100);
		Running = new GImage(MediaTools.loadImage("spritesheets/Megaman/run/Running.gif"), 100, 100);
		RunningLeft = new GImage(MediaTools.loadImage("spritesheets/Megaman/run/RunningLeft.gif"), 100, 100);
		RunShooting = new GImage(MediaTools.loadImage("spritesheets/Megaman/run/RunShooting.gif"), 100, 100);
		RunShootingLeft = new GImage(MediaTools.loadImage("spritesheets/Megaman/run/RunShootingLeft.gif"), 100, 100);
		ConfusedRight = new GImage(MediaTools.loadImage("spritesheets/Megaman/Stand/StandConfused.gif"), 100, 100);
		ConfusedLeft = new GImage(MediaTools.loadImage("spritesheets/Megaman/Stand/StandConfusedLeft.gif"), 100, 100);
		
//		Adding the Images
		add(StandLeft);
		add(StandRight);
		add(ShootingRight);
		add(ShootingLeft);
		add(Running);
		add(RunningLeft);
		add(RunShooting);
		add(RunShootingLeft);
		add(ConfusedRight);
		add(ConfusedLeft);
		
		addKeyListeners();
		
//		Setting and initializing Booleans and clock
		Left = false;
		Right = false;
		Shoot = false;
		clock = new SwingTimer(50, this);
		clock.start();
		
	}
	
//	The activation and setting of the fields which direct movement
	public void keyPressed(KeyEvent e)
	{
//		If Left is Pressed then make Left true and set Direct to 2
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			Left = true;
			Direct = 2;
		}
//		If Right is Pressed then make Right true and set Direct to 1
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			Right = true;
			Direct = 1;

		}
//		If Space is pushed then make Shoot true
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			Shoot = true;
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
	}
	
//	Setting the changes of movement once a Key is released
	public void keyReleased(KeyEvent e)
	{
//			If left is released then put Direct to 1 and leave Megaman facing left
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
				{
				StandLeft.setVisible(true);
				StandRight.setVisible(false);
				ShootingLeft.setVisible(false);
				ShootingRight.setVisible(false);
				Running.setVisible(false);
				RunningLeft.setVisible(false);
				RunShooting.setVisible(false);
				RunShootingLeft.setVisible(false);
				ConfusedRight.setVisible(false);
				ConfusedLeft.setVisible(false);
				Direct = 1;
//					If left is released and space is held then leave Megaman aiming left
					if(Shoot == true)
					{
						RunShooting.setVisible(false);
						RunShootingLeft.setVisible(false);
						StandLeft.setVisible(false);
						StandRight.setVisible(false);
						ShootingLeft.setVisible(true);
						ShootingRight.setVisible(false);
						Running.setVisible(false);
						RunningLeft.setVisible(false);
						ConfusedRight.setVisible(false);
						ConfusedLeft.setVisible(false);
					}
//				Boolean Left is set to false
				Left = false;
				}
			
//			If right is released then put Direct to 2 and leave Megaman facing right
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
				StandLeft.setVisible(false);
				StandRight.setVisible(true);
				ShootingLeft.setVisible(false);
				ShootingRight.setVisible(false);
				Running.setVisible(false);
				RunningLeft.setVisible(false);
				RunShooting.setVisible(false);
				RunShootingLeft.setVisible(false);
				ConfusedRight.setVisible(false);
				ConfusedLeft.setVisible(false);
				Direct = 2;
//				If right is released and space is held then leave Megaman aiming right
				if(Shoot == true)
					{
						RunShooting.setVisible(false);
						RunShootingLeft.setVisible(false);
						StandLeft.setVisible(false);
						StandRight.setVisible(false);
						ShootingLeft.setVisible(false);
						ShootingRight.setVisible(true);
						Running.setVisible(false);
						RunningLeft.setVisible(false);
						ConfusedRight.setVisible(false);
						ConfusedLeft.setVisible(false);
					}
//				Boolean Right is set to false
			Right = false;
			}
//			If space is released then turn off shoot
			if(e.getKeyCode() == KeyEvent.VK_SPACE)
			Shoot = false;
			}
	
//	Every time the timer goes boom create movement and set GImages depending on Boolean fields and Direct.....
	public void actionPerformed(ActionEvent e)
	{
//		Shooting but lacking movement
		if(Shoot == true)
		{
//			If Space is held then aim the gun from a NonMoving position
			if(Direct == 1)
			{
				RunShooting.setVisible(false);
				RunShootingLeft.setVisible(false);
				StandLeft.setVisible(false);
				StandRight.setVisible(false);
				ShootingLeft.setVisible(true);
				ShootingRight.setVisible(false);
				Running.setVisible(false);
				RunningLeft.setVisible(false);
				ConfusedRight.setVisible(false);
				ConfusedLeft.setVisible(false);
				
			}
//			If Space is held then aim the gun from a NonMoving position
			if(Direct == 2)
			{
				RunShooting.setVisible(false);
				RunShootingLeft.setVisible(false);
				StandLeft.setVisible(false);
				StandRight.setVisible(false);
				ShootingLeft.setVisible(false);
				ShootingRight.setVisible(true);
				Running.setVisible(false);
				RunningLeft.setVisible(false);
				ConfusedRight.setVisible(false);
				ConfusedLeft.setVisible(false);

			}
		}
		
		
		if (Left == true)
		{
			if (Shoot == true)
			{
			Running.move(-6, 0);
			RunningLeft.move(-6, 0);
			StandLeft.move(-6, 0);
			StandRight.move(-6, 0);
			ShootingLeft.move(-6, 0);
			ShootingRight.move(-6, 0);
			RunShooting.move(-6, 0);
			RunShootingLeft.move(-6, 0);
			ConfusedRight.move(-6, 0);
			ConfusedLeft.move(-6, 0);
			//Moves all the images together
			RunShooting.setVisible(false);
			RunShootingLeft.setVisible(true);
			StandLeft.setVisible(false);
			StandRight.setVisible(false);
			ShootingLeft.setVisible(false);
			ShootingRight.setVisible(false);
			Running.setVisible(false);
			RunningLeft.setVisible(false);
			ConfusedRight.setVisible(false);
			ConfusedLeft.setVisible(false);
			//If Left and Space are held then run left while shooting
			}
			
			else
			{
				Running.move(-6, 0);
				RunningLeft.move(-6, 0);
				StandLeft.move(-6, 0);
				StandRight.move(-6, 0);
				ShootingLeft.move(-6, 0);
				ShootingRight.move(-6, 0);
				RunShooting.move(-6, 0);
				RunShootingLeft.move(-6, 0);
				ConfusedRight.move(-6, 0);
				ConfusedLeft.move(-6, 0);
				//Moves all the images together
				RunShooting.setVisible(false);
				RunShootingLeft.setVisible(false);
				StandLeft.setVisible(false);
				StandRight.setVisible(false);
				ShootingLeft.setVisible(false);
				ShootingRight.setVisible(false);
				Running.setVisible(false);
				RunningLeft.setVisible(true);
				ConfusedRight.setVisible(false);
				ConfusedLeft.setVisible(false);
			}

		}
		
		
		if (Right == true)
		{
			if (Shoot == true)
			{
			Running.move(6, 0);
			RunningLeft.move(6, 0);
			StandLeft.move(6, 0);
			StandRight.move(6, 0);
			ShootingLeft.move(6, 0);
			ShootingRight.move(6, 0);
			RunShooting.move(6, 0);
			RunShootingLeft.move(6, 0);
			ConfusedRight.move(6, 0);
			ConfusedLeft.move(6, 0);
			//Moves all the images together
			RunShooting.setVisible(true);
			RunShootingLeft.setVisible(false);
			StandLeft.setVisible(false);
			StandRight.setVisible(false);
			ShootingLeft.setVisible(false);
			ShootingRight.setVisible(false);
			Running.setVisible(false);
			RunningLeft.setVisible(false);		
			ConfusedRight.setVisible(false);
			ConfusedLeft.setVisible(false);
			}
			
			else
			{
				Running.move(6, 0);
				RunningLeft.move(6, 0);
				StandLeft.move(6, 0);
				StandRight.move(6, 0);
				ShootingLeft.move(6, 0);
				ShootingRight.move(6, 0);
				RunShooting.move(6, 0);
				RunShootingLeft.move(6, 0);
				ConfusedRight.move(6, 0);
				ConfusedLeft.move(6, 0);
				//Moves all the images together
				RunShooting.setVisible(false);
				RunShootingLeft.setVisible(false);
				StandLeft.setVisible(false);
				StandRight.setVisible(false);
				ShootingLeft.setVisible(false);
				ShootingRight.setVisible(false);
				Running.setVisible(true);
				RunningLeft.setVisible(false);
				ConfusedRight.setVisible(false);
				ConfusedLeft.setVisible(false);
				//Hold right to just run right
			}
		}
		
		
		if(Left == true)
		{
			if(Right == true)
			{
				if(Direct == 1)
				{
					RunShooting.setVisible(false);
					RunShootingLeft.setVisible(false);
					StandLeft.setVisible(false);
					StandRight.setVisible(false);
					ShootingLeft.setVisible(false);
					ShootingRight.setVisible(false);
					Running.setVisible(false);
					RunningLeft.setVisible(false);
					ConfusedRight.setVisible(false);
					ConfusedLeft.setVisible(true);
					//Confuse and make Megaman not know which direction to go in
				}
				
				if(Direct == 2)
				{
					RunShooting.setVisible(false);
					RunShootingLeft.setVisible(false);
					StandLeft.setVisible(false);
					StandRight.setVisible(false);
					ShootingLeft.setVisible(false);
					ShootingRight.setVisible(false);
					Running.setVisible(false);
					RunningLeft.setVisible(false);
					ConfusedRight.setVisible(true);
					ConfusedLeft.setVisible(false);
					//Confuse and make Megaman not know which direction to go in
				}
			}
		}
		
		
		if(Left == false)
		{
			if(Right == false)
			{
				if(Shoot == false)
				{
					if(Direct == 1)
					{
						RunShooting.setVisible(false);
						RunShootingLeft.setVisible(false);
						StandLeft.setVisible(true);
						StandRight.setVisible(false);
						ShootingLeft.setVisible(false);
						ShootingRight.setVisible(false);
						Running.setVisible(false);
						RunningLeft.setVisible(false);
						ConfusedRight.setVisible(false);
						ConfusedLeft.setVisible(false);
						//Leave Megaman facing left
					}
					
					if(Direct == 2)
					{
						RunShooting.setVisible(false);
						RunShootingLeft.setVisible(false);
						StandLeft.setVisible(false);
						StandRight.setVisible(true);
						ShootingLeft.setVisible(false);
						ShootingRight.setVisible(false);
						Running.setVisible(false);
						RunningLeft.setVisible(false);
						ConfusedRight.setVisible(false);
						ConfusedLeft.setVisible(false);
						//Leave Megaman facing right
					}
				}
			}
		}
		
	}
}
