/* Name: dmah10
 * File: ShadowLevel.java
 * Description: TODO: Describe what this file does
 */
import acm.util.*;
import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
public class LevelDesignTemplate extends GraphicsProgram
{
	private double YesNo;
	private GLabel yes;
	private GImage Level;
	private SwingTimer clock;
	private double X;
	private double Y;
	private double x;
	private double y;
	private double Ex;
	private double Ey;
	
	private int mode = 1;  //1 is for box.  2 is for spot.
	
	private double ex2;
	private double ey2;
	
	private int numba;
	private String code;
	private boolean one = true;
	
	private GRect rect;
	
	private ArrayList<GRect> List = new ArrayList<GRect>();
	public void run()
	{
		setSize(500, 400);
		Level = new GImage(MediaTools.loadImage("spritesheets/Levels/QuickLevel.gif"),0, 0);
		add(Level);
		Level.setSize(Level.getWidth() * 2, Level.getHeight() * 2);
		addMouseListeners();
		addKeyListeners();
		yes = new GLabel("BLAH" + YesNo, 5, 15);
		add(yes);
		GRect Rect = new GRect(0, 0, 100, 30);
		add(Rect);
		Rect.setFilled(true);
		Rect.setColor(Color.WHITE);
		clock = new SwingTimer(250, this);
		clock.start();
	}
	public void mouseMoved(MouseEvent e)
	{
		X = e.getX();
		Y = e.getY();
		Ex = X + x;
		Ey = Y + y;
		ex2 = Ex;
		ey2 = Ey;
		
		yes.setLabel("BLAH" + Ex + " " + Ey);
		yes.sendToFront();
		
	}
	public void mousePressed(MouseEvent e)
	{
		if(mode == 1)
		{
			if(one == true)
			{
				X = e.getX();
				Y = e.getY();
				Ex = x + X;
				Ey = y + Y;
				code = "GRect Turret" + numba + " = new GRect( " + Ex + ", " + Ey + ", ";
				one = false;
				
				rect = new GRect(e.getX(), e.getY(), Ex - ex2, Ey - ey2);
				add(rect);
				rect.setFilled(true);
				List.add(rect);
			}
		}
		if(mode == 2)
		{
			code = "GRect Turret" + numba + " = new GRect( " + (Ex - 250) + ", " + (Ey - 200) + ", ";
		}
	}
	public void mouseReleased(MouseEvent e)
	{
		if(mode == 1)
		{
			if(one == false)
			{
				code = code + (Ex - ex2) + ", " + (Ey - ey2) + ");";
				one = true;
				Ex = x + X;
				Ey = y + Y;
				System.out.println(code);
				System.out.println("TurretZone.add(Turret" + numba+ ");");
				numba = numba + 1;
			}
		}
		if(mode == 2)
		{
			code = code + (500) + ", " + (400) + ");";
			Ex = x + X;
			Ey = y + Y;
			System.out.println(code);
			System.out.println("TurretZone.add(Turret" + numba+ ");");
			numba = numba + 1;
		}
	}
	public void mouseDragged(MouseEvent e)
	{
		X = e.getX();
		Y = e.getY();
		Ex = x + X;
		Ey = y + Y;
		
		
		yes.setLabel("BLAH" + Ex + " " + Ey);
		yes.sendToFront();
		
		if(mode == 1)
		{
			if(one == false)
			{
				rect.setBounds(rect.getX(), rect.getY(), Ex - ex2, Ey - ey2);
			}
		}
	}
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			System.out.println("DESTROY ABOVE, DESTROY!!!DESTROY ABOVE, DESTROY!!!DESTROY ABOVE, DESTROY!!!");
			System.out.println("DESTROY ABOVE, DESTROY!!!DESTROY ABOVE, DESTROY!!!DESTROY ABOVE, DESTROY!!!");
			System.out.println("DESTROY ABOVE, DESTROY!!!DESTROY ABOVE, DESTROY!!!DESTROY ABOVE, DESTROY!!!");
			System.out.println("DESTROY ABOVE, DESTROY!!!DESTROY ABOVE, DESTROY!!!DESTROY ABOVE, DESTROY!!!");
			System.out.println("DESTROY ABOVE, DESTROY!!!DESTROY ABOVE, DESTROY!!!DESTROY ABOVE, DESTROY!!!");
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(X > 400)
		{
			Level.move(-25, 0);
			int array = 0;
			while(array < List.size())
			{
				List.get(array).move(-25, 0);
				array = array + 1;
			}
			array = 0;
			x = x + 25;
		}
		if(X < 150)
		{
			Level.move(25, 0);
			int array = 0;
			while(array < List.size())
			{
				List.get(array).move(25, 0);
				array = array + 1;
			}
			array = 0;
			x = x - 25;
		}
		if(Y > 350)
		{
			Level.move(0, -25);
			int array = 0;
			while(array < List.size())
			{
				List.get(array).move(0, -25);
				array = array + 1;
			}
			array = 0;
			y = y + 25;
		}
		if(Y < 100)
		{
			Level.move(0, 25);
			int array = 0;
			while(array < List.size())
			{
				List.get(array).move(0, 25);
				array = array + 1;
			}
			array = 0;
			y = y - 25;
		}
		
	}
}