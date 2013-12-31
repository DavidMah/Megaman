/* Name: David
 * File: MetalBlade.java
 * Description: TODO: Describe what this file does
 */
import acm.graphics.*;
import acm.util.*;
public class MetalBlade extends GCompound
{
	private GImage Blade;
	private GPoint Pt;
	private GRectangle Bound;
	private int Direct;
	private double GravSpeed = 2;
	public MetalBlade()
	{
	Blade = new GImage(MediaTools.loadImage("spritesheets/Bosses/MetalMan/Blade.gif"),0, 0);
	Pt = new GPoint();
	Bound = new GRectangle(Blade.getBounds());
	add(Blade);

	}
	public void Fly()
	{
		Bound.setLocation(getCanvasPoint(Pt));
		if(Direct == 2)
		{
		Blade.move(10, 0);
		}
		if(Direct == 1)
		{
			Blade.move(-10, 0);
		}
		Blade.move(0, GravSpeed);
		GravSpeed = GravSpeed * 1.05;
	}
	public GRectangle BladeBoundReturn()
	{
		return(Bound);
	}
}
