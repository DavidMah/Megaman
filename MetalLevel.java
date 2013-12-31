/* Name: David
 * File: MetalLevel.java
 * Description: TODO: Describe what this file does
 */
import java.util.*;
import acm.graphics.*;
import acm.util.*;
public class MetalLevel extends GCompound
{
	private GImage MetalLevel;
	private ArrayList<GRect> MetalGround = new ArrayList<GRect>();
	private ArrayList<GRect> MetalCheck = new ArrayList<GRect>();
	private ArrayList<GRect> MetalFallDeath = new ArrayList<GRect>();
	
	private ArrayList<GRect> LeftNo = new ArrayList<GRect>();
	private ArrayList<GRect> RightNo = new ArrayList<GRect>();
	private ArrayList<GRect> DownNo = new ArrayList<GRect>();
	private ArrayList<GRect> BossC = new ArrayList<GRect>();
	
	private ArrayList<GRect> Metzone = new ArrayList<GRect>();
	private ArrayList<GRect> FlyShieldzone = new ArrayList<GRect>();
	private ArrayList<GRect> JumpingEyezone = new ArrayList<GRect>();
	private ArrayList<GRect> TurretGunnerzone = new ArrayList<GRect>();
	public MetalLevel()
	{
		MetalLevel = new GImage(MediaTools.loadImage("spritesheets/Levels/MetalLevel.gif"), 0, 0);
		add(MetalLevel);
		MetalLevel.setSize(MetalLevel.getWidth() * 2, MetalLevel.getHeight() * 2);
		GRect Ground0 = new GRect( -1.0, 371.0, 659.0, 64.0);
		MetalGround.add(Ground0);
		GRect Ground1 = new GRect( 624.0, 304.0, 127.0, 130.0);
		MetalGround.add(Ground1);
		GRect Ground2 = new GRect( 752.0, 338.0, 123.0, 97.0);
		MetalGround.add(Ground2);
		GRect Ground4 = new GRect( 876.0, 372.0, 255.0, 80.0);
		MetalGround.add(Ground4);
		GRect Ground5 = new GRect( 1072.0, 304.0, 58.0, 103.0);
		MetalGround.add(Ground5);
		GRect Ground6 = new GRect( 1207.0, 371.0, 82.0, 84.0);
		MetalGround.add(Ground6);
		GRect Ground7 = new GRect( 1271.0, 340.0, 180.0, 85.0);
		MetalGround.add(Ground7);
		GRect Ground8 = new GRect( 1328.0, 304.0, 63.0, 81.0);
		MetalGround.add(Ground8);
		GRect Ground9 = new GRect( 1452.0, 372.0, 63.0, 83.0);
		MetalGround.add(Ground9);
		GRect Ground10 = new GRect( 1589.0, 371.0, 182.0, 91.0);
		MetalGround.add(Ground10);
		GRect Ground11 = new GRect( 1649.0, 304.0, 123.0, 106.0);
		MetalGround.add(Ground11);
		GRect Ground12 = new GRect( 1841.0, 272.0, 60.0, 209.0);
		MetalGround.add(Ground12);
		GRect Ground13 = new GRect( 1968.0, 240.0, 64.0, 455.0);
		MetalGround.add(Ground13);
		GRect Ground14 = new GRect( 2033.0, 305.0, 62.0, 146.0);
		MetalGround.add(Ground14);
		GRect Ground15 = new GRect( 2093.0, 369.0, 230.0, 40.0);
		MetalGround.add(Ground15);
		GRect Ground16 = new GRect( 2160.0, 240.0, 251.0, 352.0);
		MetalGround.add(Ground16);
		GRect Ground17 = new GRect( 2480.0, -3.0, 132.0, 947.0);
		MetalGround.add(Ground17);
		GRect Ground18 = new GRect( 2160.0, 848.0, 582.0, 157.0);
		MetalGround.add(Ground18);
		GRect Ground19 = new GRect( 1924.0, 535.0, 167.0, 822.0);
		MetalGround.add(Ground19);
		GRect Ground20 = new GRect( 2082.0, 1328.0, 584.0, 31.0);
		MetalGround.add(Ground20);
		GRect Ground21 = new GRect( 2416.0, 1263.0, 253.0, 105.0);
		MetalGround.add(Ground21);
		GRect Ground22 = new GRect( 2669.0, 1327.0, 774.0, 27.0);
		MetalGround.add(Ground22);
		GRect Ground23 = new GRect( 3038.0, 1231.0, 512.0, 104.0);
		MetalGround.add(Ground23);
		GRect Ground24 = new GRect( 3230.0, 1135.0, 255.0, 100.0);
		MetalGround.add(Ground24);
		GRect Ground25 = new GRect( 3293.0, 1071.0, 128.0, 74.0);
		MetalGround.add(Ground25);
		GRect Ground26 = new GRect( 3005.0, 864.0, 800.0, 137.0);
		MetalGround.add(Ground26);
		GRect Ground27 = new GRect( 3484.0, 1200.0, 65.0, 37.0);
		MetalGround.add(Ground27);
		GRect Ground29 = new GRect( 3543.0, 1265.0, 69.0, 162.0);
		MetalGround.add(Ground29);
		GRect Ground30 = new GRect( 3613.0, 1362.0, 894.0, 50.0);
		MetalGround.add(Ground30);
		GRect Ground31 = new GRect( 4503.0, 1296.0, 63.0, 63.0);
		MetalGround.add(Ground31);
		GRect Ground32 = new GRect( 4522.0, 1230.0, 63.0, 63.0);
		MetalGround.add(Ground32);
		GRect Ground33 = new GRect( 4538.0, 1166.0, 62.0, 63.0);
		MetalGround.add(Ground33);
		GRect Ground34 = new GRect( 4639.0, 1102.0, 61.0, 310.0);
		MetalGround.add(Ground34);
		GRect Ground35 = new GRect( 4700.0, 1168.0, 64.0, 243.0);
		MetalGround.add(Ground35);
		GRect Ground36 = new GRect( 4762.0, 1232.0, 66.0, 186.0);
		MetalGround.add(Ground36);
		GRect Ground37 = new GRect( 4825.0, 1264.0, 376.0, 170.0);
		MetalGround.add(Ground37);
		GRect Ground38 = new GRect( 4959.0, 1136.0, 250.0, 147.0);
		MetalGround.add(Ground38);
		GRect Ground39 = new GRect( 5208.0, 1203.0, 380.0, 68.0);
		MetalGround.add(Ground39);
		GRect Ground40 = new GRect( 5412.0, 1138.0, 214.0, 215.0);
		MetalGround.add(Ground40);
		GRect Ground41 = new GRect( 5624.0, 1329.0, 494.0, 63.0);
		MetalGround.add(Ground41);
		GRect Ground42 = new GRect( 6078.0, 956.0, 229.0, 443.0);
		MetalGround.add(Ground42);
		GRect Ground43 = new GRect( 5208.0, 920.0, 550.0, 82.0);
		MetalGround.add(Ground43);
		GRect Ground44 = new GRect( 4409.0, 933.0, 425.0, 70.0);
		MetalGround.add(Ground44);
		GRect Ground45 = new GRect( -119.0, -15.0, 118.0, 601.0);
		MetalGround.add(Ground45);
		GRect Ground46 = new GRect( 2910.0, 1266.0, 127.0, 61.0);
		MetalGround.add(Ground46);
		GRect Ground47 = new GRect( 3102.0, 1170.0, 125.0, 64.0);
		MetalGround.add(Ground47);
		GRect Ground48 = new GRect( 3613.0, 1296.0, 124.0, 62.0);
		MetalGround.add(Ground48);
		GRect Ground49 = new GRect( 4830.0, 1199.0, 126.0, 65.0);
		MetalGround.add(Ground49);
		GRect Ground50 = new GRect( 5502.0, 1075.0, 125.0, 63.0);
		MetalGround.add(Ground50);
		
		GRect Check0 = new GRect( 2089.0, 1007.0, 327.0, 322.0);
		MetalCheck.add(Check0);
		GRect Check1 = new GRect( 5211.0, 1000.0, 417.0, 225.0);
		MetalCheck.add(Check1);
		
		GRect Fall0 = new GRect( 575.0, 448.0, 1461.0, 222.0);
		MetalFallDeath.add(Fall0);
		
		GRect LeftNo0 = new GRect( -7.0, -17.0, 516.0, 424.0);
		LeftNo.add(LeftNo0);
		GRect LeftNo1 = new GRect( 5625.0, 991.0, 491.0, 406.0);
		LeftNo.add(LeftNo1);
		
		GRect RightNo0 = new GRect( 5625.0, 991.0, 491.0, 406.0);
		RightNo.add(RightNo0);
		
		GRect BossC0 = new GRect( 5625.0, 991.0, 491.0, 406.0);
		BossC.add(BossC0);

	}
	public ArrayList<GRect> ReturnArray()
	{
		return(MetalGround);
	}
	public ArrayList<GRect> ReturnCheck()
	{
		return(MetalCheck);
	}
	public ArrayList<GRect> ReturnFallDeath()
	{
		return(MetalFallDeath);
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
	public ArrayList<GRect> ReturnTurretGunnerzone()
	{
		return(TurretGunnerzone);
	}
	
}
