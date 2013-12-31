/* Name: David
 * File: Menu.java
 * Description: TODO: Describe what this file does
 */
import org.nmhschool.*;
import acm.util.*;
import acm.graphics.*;
public class Menu extends GCompound
{
	private GImage menu;
	private MP3 MenuMusic;
	private boolean Playing;
	private int State;
	public Menu()
	{
		menu = new GImage(MediaTools.loadImage("spritesheets/Misc/Menu/menu.gif"), 0, 0);
		add(menu);
	MenuMusic = new MP3("sound/MenuMusic.mp3"); // load from file music.mp3
	MenuMusic.loop(); // loop the song
	pause(1000);
	}
	public int PressSpace(boolean Space)
	{
		if(Space == true)
		{
			State = 1;
			if(Playing == true)
			{
			MenuMusic.stop();
			}
			menu.setVisible(false);
		}
		Playing = true;
		return(State);
	}

}
