/* Name: dmah10
 * File: ShadowLevel.java
 * Description: TODO: Describe what this file does
 */
import acm.util.*;
import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;
import java.util.*;
public class ShadowLevel extends GCompound
{
	private GImage Level;

	private ArrayList<GRect> ShadowGround = new ArrayList<GRect>();
	private ArrayList<GRect> ShadowCheck = new ArrayList<GRect>();
	private ArrayList<GRect> ShadowFallDeath = new ArrayList<GRect>();
	
	private ArrayList<GRect> LeftNo = new ArrayList<GRect>();
	private ArrayList<GRect> RightNo = new ArrayList<GRect>();
	private ArrayList<GRect> DownNo = new ArrayList<GRect>();
	private ArrayList<GRect> BossC = new ArrayList<GRect>();
	
	private ArrayList<GRect> Metzone = new ArrayList<GRect>();
	private ArrayList<GRect> FlyShieldzone = new ArrayList<GRect>();
	private ArrayList<GRect> JumpingEyezone = new ArrayList<GRect>();
	private ArrayList<GRect> TurretGunnerzone = new ArrayList<GRect>();
	public ShadowLevel()
	{
		Level = new GImage(MediaTools.loadImage("spritesheets/Levels/Shadowlevel.gif"),0, 0);
		add(Level);
		Level.setSize(Level.getWidth() * 2, Level.getHeight() * 2);
		
		GRect Ground0 = new GRect( 188.0, 60.0, 61.0, 1630.0);
		ShadowGround.add(Ground0);
		GRect Ground1 = new GRect( 252.0, 957.0, 123.0, 318.0);
		ShadowGround.add(Ground1);
		GRect Ground2 = new GRect( 379.0, 444.0, 127.0, 259.0);
		ShadowGround.add(Ground2);
		GRect Ground3 = new GRect( 411.0, 860.0, 60.0, 31.0);
		ShadowGround.add(Ground3);
		GRect Ground4 = new GRect( 508.0, 957.0, 147.0, 770.0);
		ShadowGround.add(Ground4);
		GRect Ground5 = new GRect( 378.0, 1404.0, 202.0, 322.0);
		ShadowGround.add(Ground5);
		GRect Ground6 = new GRect( 95.0, 1614.0, 153.0, 537.0);
		ShadowGround.add(Ground6);
		GRect Ground7 = new GRect( 247.0, 1980.0, 467.0, 104.0);
		ShadowGround.add(Ground7);
		GRect Ground8 = new GRect( 378.0, 1915.0, 127.0, 70.0);
		ShadowGround.add(Ground8);
		GRect Ground9 = new GRect( 698.0, 1915.0, 382.0, 258.0);
		ShadowGround.add(Ground9);
		GRect Ground10 = new GRect( 635.0, 1723.0, 646.0, 65.0);
		ShadowGround.add(Ground10);
		GRect Ground11 = new GRect( 1146.0, 1785.0, 63.0, 960.0);
		ShadowGround.add(Ground11);
		GRect Ground12 = new GRect( 826.0, 2492.0, 342.0, 253.0);
		ShadowGround.add(Ground12);
		GRect Ground13 = new GRect( 567.0, 2140.0, 192.0, 904.0);
		ShadowGround.add(Ground13);
		GRect Ground14 = new GRect( 762.0, 2875.0, 447.0, 287.0);
		ShadowGround.add(Ground14);
		GRect Ground15 = new GRect( 1276.0, 3002.0, 684.0, 194.0);
		ShadowGround.add(Ground15);
		GRect Ground16 = new GRect( 1529.0, 2937.0, 256.0, 73.0);
		ShadowGround.add(Ground16);
		GRect Ground17 = new GRect( 1594.0, 2842.0, 190.0, 117.0);
		ShadowGround.add(Ground17);
		GRect Ground18 = new GRect( 1915.0, 2937.0, 318.0, 260.0);
		ShadowGround.add(Ground18);
		GRect Ground19 = new GRect( 2043.0, 2873.0, 124.0, 63.0);
		ShadowGround.add(Ground19);
		GRect Ground20 = new GRect( 2229.0, 3002.0, 131.0, 232.0);
		ShadowGround.add(Ground20);
		GRect Ground21 = new GRect( 2429.0, 2874.0, 61.0, 344.0);
		ShadowGround.add(Ground21);
		GRect Ground22 = new GRect( 2489.0, 2940.0, 318.0, 211.0);
		ShadowGround.add(Ground22);
		GRect Ground23 = new GRect( 2620.0, 2874.0, 125.0, 70.0);
		ShadowGround.add(Ground23);
		GRect Ground24 = new GRect( 2684.0, 2809.0, 60.0, 67.0);
		ShadowGround.add(Ground24);
		GRect Ground25 = new GRect( 2876.0, 2873.0, 316.0, 257.0);
		ShadowGround.add(Ground25);
		GRect Ground26 = new GRect( 2940.0, 2809.0, 61.0, 64.0);
		ShadowGround.add(Ground26);
		GRect Ground27 = new GRect( 3131.0, 2778.0, 62.0, 100.0);
		ShadowGround.add(Ground27);
		GRect Ground28 = new GRect( 3186.0, 2939.0, 70.0, 271.0);
		ShadowGround.add(Ground28);
		GRect Ground29 = new GRect( 3252.0, 3002.0, 900.0, 191.0);
		ShadowGround.add(Ground29);
		GRect Ground30 = new GRect( 3385.0, 2937.0, 768.0, 97.0);
		ShadowGround.add(Ground30);
		GRect Ground31 = new GRect( 4027.0, 2873.0, 125.0, 80.0);
		ShadowGround.add(Ground31);
		GRect Ground32 = new GRect( 3451.0, 2876.0, 127.0, 83.0);
		ShadowGround.add(Ground32);
		GRect Ground33 = new GRect( 3706.0, 2873.0, 190.0, 72.0);
		ShadowGround.add(Ground33);
		GRect Ground34 = new GRect( 3772.0, 2809.0, 61.0, 79.0);
		ShadowGround.add(Ground34);
		GRect Ground35 = new GRect( 4219.0, 2613.0, 183.0, 719.0);
		ShadowGround.add(Ground35);
		GRect Ground36 = new GRect( 3898.0, 3322.0, 1600.0, 64.0);
		ShadowGround.add(Ground36);
		GRect Ground37 = new GRect( 5273.0, 3385.0, 253.0, 568.0);
		ShadowGround.add(Ground37);
		GRect Ground38 = new GRect( 4819.0, 3706.0, 506.0, 133.0);
		ShadowGround.add(Ground38);
		GRect Ground39 = new GRect( 3832.0, 3514.0, 989.0, 342.0);
		ShadowGround.add(Ground39);
		GRect Ground40 = new GRect( 3614.0, 3177.0, 219.0, 523.0);
		ShadowGround.add(Ground40);
		GRect Ground41 = new GRect( 1468.0, 2968.0, 104.0, 48.0);
		ShadowGround.add(Ground41);
		GRect Ground42 = new GRect( 1530.0, 2903.0, 168.0, 102.0);
		ShadowGround.add(Ground42);
		GRect Ground43 = new GRect( 2296.0, 2932.0, 62.0, 96.0);
		ShadowGround.add(Ground43);
		
		GRect Fall0 = new GRect( 1208.0, 3094.0, 2575.0, 78.0);
		ShadowFallDeath.add(Fall0);
		
		GRect Check0 = new GRect( 832.0, 2742.0, 367.0, 135.0);
		ShadowCheck.add(Check0);
		GRect Check1 = new GRect( 4254.0, 3375.0, 567.0, 140.0);
		ShadowCheck.add(Check1);
	}
	public ArrayList<GRect> ReturnArray()
	{
		return(ShadowGround);
	}
	public ArrayList<GRect> ReturnCheck()
	{
		return(ShadowCheck);
	}
	public ArrayList<GRect> ReturnFallDeath()
	{
		return(ShadowFallDeath);
	}
	public ArrayList<GRect> ReturnLeft()
	{
		return(LeftNo);
	}
	public ArrayList<GRect> ReturnRight()
	{
		return(RightNo);
	}
	public ArrayList<GRect> ReturnDown()
	{
		return(DownNo);
	}
	public ArrayList<GRect> ReturnBoss()
	{
		return(BossC);
	}
	public ArrayList<GRect> ReturnMetzone()
	{
		return(Metzone);
	}
	public ArrayList<GRect> ReturnFlyingShieldzone()
	{
		return(FlyShieldzone);
	}
}
