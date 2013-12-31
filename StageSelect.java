/* Name: David
 * File: StageSelect.java
 * Description: TODO: Describe what this file does
 */

import acm.graphics.*;
import acm.util.*;

public class StageSelect extends GCompound
{
	private double BossChoose = 0;
	private boolean EventCheck;
	
	private GImage Gauntlet;
	private GImage ShadowMan;
	private GImage KnightMan;
	private GImage QuickMan;
	private GImage MetalMan;
	private GImage ElecMan;
	private GImage BG;
	
	//for alive people
	private boolean Shadow = true;
	private boolean Knight = true;
	private boolean Quick = true;
	private boolean Metal = true;
	private boolean Elec = true;
	
	private GImage Megaman;

	private int BossChosen;
	
	public StageSelect()
	{
		Gauntlet = new GImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/GauntletMugNotChosen.gif"), 204, 0);
		ShadowMan = new GImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/ShadowNotChosen.gif"), 208, 5);
		KnightMan = new GImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/KnightNotChosen.gif"), 12, 200);
		QuickMan = new GImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/QuickNotChosen.gif"), 132, 300);
		MetalMan = new GImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/MetalNotChosen.gif"), 280, 300);
		ElecMan = new GImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/ElecNotChosen.gif"), 400, 200);
		Megaman = new GImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/MegaHead/Straight.gif"), 202, 186);
		
		BG = new GImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/StageSelect.gif"), 0, 0);
		
		add(ShadowMan);
		add(KnightMan);//1
		add(QuickMan);//2
		add(MetalMan);//3
		add(ElecMan);//4
		
		add(Megaman);
		add(BG);
		
		BG.sendToBack();
		
		Gauntlet.setSize(Gauntlet.getWidth() * 2, Gauntlet.getHeight() * 2);
		ShadowMan.setSize(ShadowMan.getWidth() * 2, ShadowMan.getHeight() * 2);
		KnightMan.setSize(KnightMan.getWidth() * 2, KnightMan.getHeight() * 2);
		QuickMan.setSize(QuickMan.getWidth() * 2, QuickMan.getHeight() * 2);
		MetalMan.setSize(MetalMan.getWidth() * 2, MetalMan.getHeight() * 2);
		ElecMan.setSize(ElecMan.getWidth() * 2, ElecMan.getHeight() * 2);
		
		Megaman.setSize(Megaman.getWidth() * 2, Megaman.getHeight() * 2);
	}
	public int BossPick(boolean Left, boolean Right, boolean Up, boolean Down, boolean Pick)
	{
		EventCheck = false;
		if(EventCheck == false)
		{
			if(BossChoose == 0)
			{
				if(Left == true)
				{
					if(Knight == true)
					{
						
					KnightMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/KnightChosen.gif"));
					}
					else 
					{
					KnightMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/DefeatedChosen.gif"));
					}
					Megaman.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/MegaHead/Left.gif"));
					BossChoose = 1;
				}
				if(Right == true)
				{
					ElecMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/ElecChosen.gif"));
					Megaman.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/MegaHead/Right.gif"));
					BossChoose = 4;
				}
				EventCheck = true;
			}
		}
		if(EventCheck == false)
		{
			if(BossChoose == 1)
			{
				{
					if(Right == true)
					{				
						if(Knight == true)
						{
							
						KnightMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/KnightNotChosen.gif"));
						}
						else 
						{
						KnightMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/Defeated.gif"));
						}
					
						ElecMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/ElecChosen.gif"));
						Megaman.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/MegaHead/Right.gif"));
						BossChoose = 4;
					}
					if(Down == true)
					{
						KnightMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/KnightNotChosen.gif"));
						if(Quick == true)
						{
						QuickMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/QuickChosen.gif"));
						}
						else
						{
							QuickMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/DefeatedChosen.gif"));
						}
						Megaman.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/MegaHead/DownLeft.gif"));
						BossChoose = 2;
					}
					if(Pick == true)
					{
						if(Knight == true)
						{
						BossChosen = 1;
						}
					}
				}
				EventCheck = true;
			}
		}
		if(EventCheck == false)
		{
			if(BossChoose == 2)
			{
				if(Up == true)
				{
					if(Quick == true)
					{
					QuickMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/QuickNotChosen.gif"));
					}
					else
					{
						QuickMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/Defeated.gif"));
					}
					if(Knight == true)
					{
					KnightMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/KnightChosen.gif"));
					}
					else 
					{
					KnightMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/DefeatedChosen.gif"));
					}
					Megaman.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/MegaHead/Left.gif"));
					BossChoose = 1;
				}
				if(Right == true)
				{
					if(Quick == true)
					{
					QuickMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/QuickNotChosen.gif"));
					}
					else
					{
						QuickMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/Defeated.gif"));
					}
					MetalMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/MetalChosen.gif"));
					Megaman.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/MegaHead/DownRight.gif"));
					BossChoose = 3;
				}
				if(Pick == true)
				{
					if(Quick == true)
					{
					BossChosen = 2;
					}
				}
				EventCheck = true;
			}
		}
		if(EventCheck == false)
		{
			if(BossChoose == 3)
			{
				if(Left == true)
				{
					MetalMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/MetalNotChosen.gif"));
					if(Quick == true)
					{
					QuickMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/QuickChosen.gif"));
					}
					else
					{
						QuickMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/DefeatedChosen.gif"));
					}
					Megaman.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/MegaHead/DownLeft.gif"));
					BossChoose = 2;
				}
				if(Up == true)
				{
					MetalMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/MetalNotChosen.gif"));
					ElecMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/ElecChosen.gif"));
					Megaman.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/MegaHead/Right.gif"));
					BossChoose = 4;
				}
				EventCheck = true;
				if(Pick == true)
				{
					BossChosen = 3;
				}
			}
		}
		if(EventCheck == false)
		{
			if(BossChoose == 4)
			{
				if(Left == true)
				{
					ElecMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/ElecNotChosen.gif"));
					
					if(Knight == true)
					{
					KnightMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/KnightChosen.gif"));
					}
					else 
					{
					KnightMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/DefeatedChosen.gif"));
					}
					Megaman.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/MegaHead/Left.gif"));
					BossChoose = 1;
				}
				if(Down == true)
				{
					ElecMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/ElecNotChosen.gif"));
					MetalMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/MetalChosen.gif"));
					Megaman.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/MegaHead/DownRight.gif"));
					BossChoose = 3;
				}
				EventCheck = true;
				if(Pick == true)
				{
					BossChosen = 4;
				}
			}
		}
		return(BossChosen);		
	}
	public void BossKill(int Pick)
	{
		if(Pick == 2)
		{
			Quick = false;
			QuickMan.setImage(MediaTools.loadImage("spritesheets/Misc/StageSelect/DefeatedChosen.gif"));
		}
		BossChosen = 0;
		
	}
}