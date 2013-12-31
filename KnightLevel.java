
/* Name: David
 * File: KnightLevel.java
 * Description: TODO: Describe what this file does
 */
import java.util.*;

import acm.graphics.*;
import acm.util.*;
public class KnightLevel extends GCompound
{
	private GImage KnightLevel;
	private ArrayList<GRect> KnightGround = new ArrayList<GRect>();
	private ArrayList<GRect> KnightCheck = new ArrayList<GRect>();
	
	private ArrayList<GRect> LeftNo = new ArrayList<GRect>();
	private ArrayList<GRect> RightNo = new ArrayList<GRect>();
	private ArrayList<GRect> DownNo = new ArrayList<GRect>();
	private ArrayList<GRect> BossC = new ArrayList<GRect>();
	
	private ArrayList<GRect> Metzone = new ArrayList<GRect>();
	private ArrayList<GRect> Sniperzone = new ArrayList<GRect>();
	private ArrayList<GRect> BallSwingerzone = new ArrayList<GRect>();
	private ArrayList<GRect> FlyingShieldzone = new ArrayList<GRect>();
	private ArrayList<GRect> TurretZone = new ArrayList<GRect>();
	public KnightLevel()
	{
		KnightLevel = new GImage(MediaTools.loadImage("spritesheets/Levels/KnightLevel.gif"), 0, 0);
		add(KnightLevel);
		KnightLevel.setSize(KnightLevel.getWidth() * 2, KnightLevel.getHeight() * 2);
		
		GRect Ground0 = new GRect( 174.0, 115.0, 64.0, 327.0);
		KnightGround.add(Ground0);
		GRect Ground1 = new GRect( 238.0, 335.0, 127.0, 185.0);
		KnightGround.add(Ground1);
		GRect Ground2 = new GRect( 364.0, 367.0, 833.0, 87.0);
		KnightGround.add(Ground2);
		GRect Ground3 = new GRect( 461.0, 302.0, 736.0, 109.0);
		KnightGround.add(Ground3);
		GRect Ground4 = new GRect( 622.0, 270.0, 383.0, 50.0);
		KnightGround.add(Ground4);
		GRect Ground5 = new GRect( 749.0, 207.0, 128.0, 66.0);
		KnightGround.add(Ground5);
		GRect Ground6 = new GRect( 877.0, 240.0, 128.0, 31.0);
		KnightGround.add(Ground6);
		GRect Ground7 = new GRect( 1197.0, 367.0, 256.0, 80.0);
		KnightGround.add(Ground7);
		GRect Ground8 = new GRect( 1269.0, 361.0, 47.0, 18.0);
		KnightGround.add(Ground8);
		GRect Ground9 = new GRect( 1334.0, 360.0, 47.0, 12.0);
		KnightGround.add(Ground9);
		GRect Ground10 = new GRect( 1453.0, 400.0, 459.0, 54.0);
		KnightGround.add(Ground10);
		GRect Ground11 = new GRect( 1582.0, 366.0, 351.0, 45.0);
		KnightGround.add(Ground11);
		GRect Ground12 = new GRect( 1655.0, 360.0, 48.0, 20.0);
		KnightGround.add(Ground12);
		GRect Ground13 = new GRect( 1718.0, 360.0, 48.0, 19.0);
		KnightGround.add(Ground13);
		GRect Ground14 = new GRect( 1782.0, 360.0, 47.0, 12.0);
		KnightGround.add(Ground14);
		GRect Ground15 = new GRect( 1839.0, 304.0, 382.0, 143.0);
		KnightGround.add(Ground15);
		GRect Ground16 = new GRect( 2210.0, 370.0, 338.0, 81.0);
		KnightGround.add(Ground16);
		GRect Ground19 = new GRect( 2219.0, 361.0, 136.0, 12.0);
		KnightGround.add(Ground19);
		GRect Ground20 = new GRect( 2350.0, 336.0, 383.0, 96.0);
		KnightGround.add(Ground20);
		GRect Ground21 = new GRect( 2727.0, 370.0, 204.0, 278.0);
		KnightGround.add(Ground21);
		GRect Ground23 = new GRect( 2739.0, 361.0, 202.0, 13.0);
		KnightGround.add(Ground23);
		GRect Ground24 = new GRect( 2932.0, 335.0, 64.0, 685.0);
		KnightGround.add(Ground24);
		GRect Ground25 = new GRect( 3060.0, 249.0, 26.0, 485.0);
		KnightGround.add(Ground25);
		GRect Ground29 = new GRect( 3060.0, 158.0, 31.0, 584.0);
		KnightGround.add(Ground29);
		GRect Ground30 = new GRect( 2996.0, 804.0, 1967.0, 150.0);
		KnightGround.add(Ground30);
		GRect Ground31 = new GRect( 4371.0, 446.0, 193.0, 295.0);
		KnightGround.add(Ground31);
		GRect Ground32 = new GRect( 3507.0, 741.0, 705.0, 63.0);
		KnightGround.add(Ground32);
		GRect Ground33 = new GRect( 3572.0, 677.0, 253.0, 67.0);
		KnightGround.add(Ground33);
		GRect Ground34 = new GRect( 3637.0, 613.0, 125.0, 73.0);
		KnightGround.add(Ground34);
		GRect Ground35 = new GRect( 3763.0, 644.0, 63.0, 40.0);
		KnightGround.add(Ground35);
		GRect Ground36 = new GRect( 3892.0, 676.0, 127.0, 68.0);
		KnightGround.add(Ground36);
		GRect Ground37 = new GRect( 4017.0, 708.0, 194.0, 99.0);
		KnightGround.add(Ground37);
		GRect Ground38 = new GRect( 3443.0, 371.0, 594.0, 113.0);
		KnightGround.add(Ground38);
		GRect Ground39 = new GRect( 4724.0, 773.0, 1087.0, 137.0);
		KnightGround.add(Ground39);
		GRect Ground40 = new GRect( 5684.0, 676.0, 126.0, 100.0);
		KnightGround.add(Ground40);
		GRect Ground41 = new GRect( 4852.0, 708.0, 385.0, 88.0);
		KnightGround.add(Ground41);
		GRect Ground42 = new GRect( 5107.0, 677.0, 130.0, 64.0);
		KnightGround.add(Ground42);
		GRect Ground44 = new GRect( 5237.0, 740.0, 533.0, 49.0);
		KnightGround.add(Ground44);
		GRect Ground45 = new GRect( 5803.0, 806.0, 2312.0, 86.0);
		KnightGround.add(Ground45);
		GRect Ground46 = new GRect( 7957.0, 353.0, 72.0, 516.0);
		KnightGround.add(Ground46);
		GRect Ground47 = new GRect( 6291.0, 740.0, 224.0, 66.0);
		KnightGround.add(Ground47);
		GRect Ground48 = new GRect( 5908.0, 463.0, 191.0, 278.0);
		KnightGround.add(Ground48);
		GRect Ground49 = new GRect( 6903.0, 448.0, 606.0, 263.0);
		KnightGround.add(Ground49);
		
		GRect Check0 = new GRect( 3062.0, 737.0, 121.0, 67.0);
		KnightCheck.add(Check0);
		GRect Check1 = new GRect( 6903.0, 705.0, 607.0, 106.0);
		KnightCheck.add(Check1);
		
		GRect Met0 = new GRect( 880.0, -9.0, 509.0, 239.0);
		Metzone.add(Met0);
		GRect Met1 = new GRect( 1243.0, 6.0, 510.0, 384.0);
		Metzone.add(Met1);
		GRect Met2 = new GRect( 1771.0, 19.0, 517.0, 331.0);
		Metzone.add(Met2);
		GRect Met3 = new GRect( 2333.0, 24.0, 549.0, 312.0);
		Metzone.add(Met3);
		GRect Met5 = new GRect( 3092.0, 483.0, 505.0, 358.0);
		Metzone.add(Met5);
		GRect Met6 = new GRect( 3632.0, 483.0, 542.0, 302.0);
		Metzone.add(Met6);
		GRect Met7 = new GRect( 3993.0, 482.0, 557.0, 287.0);
		Metzone.add(Met7);
		GRect Met8 = new GRect( 4386.0, 454.0, 510.0, 347.0);
		Metzone.add(Met8);
		GRect Met9 = new GRect( 4793.0, 487.0, 533.0, 338.0);
		Metzone.add(Met9);
		GRect Met10 = new GRect( 5811.0, 739.0, 480.0, 66.0);
		Metzone.add(Met10);
		
		GRect Turret0 = new GRect( 565.0, -78.0, 500, 400);
		TurretZone.add(Turret0);
		GRect Turret1 = new GRect( 1425.0, 94.0, 500, 400);
		TurretZone.add(Turret1);
		GRect Turret2 = new GRect( 2376.0, 70.0, 500, 400);
		TurretZone.add(Turret2);
		GRect Turret3 = new GRect( 2707.0, 78.0, 500, 400);
		TurretZone.add(Turret3);
		GRect Turret4 = new GRect( 3008.0, 551.0, 500, 400);
		TurretZone.add(Turret4);
		GRect Turret5 = new GRect( 3698.0, 410.0, 500, 400);
		TurretZone.add(Turret5);
		GRect Turret6 = new GRect( 4530.0, 519.0, 500, 400);
		TurretZone.add(Turret6);
		GRect Turret7 = new GRect( 4657.0, 452.0, 500, 400);
		TurretZone.add(Turret7);
		GRect Turret8 = new GRect( 4921.0, 413.0, 500, 400);
		TurretZone.add(Turret8);
		GRect Turret9 = new GRect( 5364.0, 453.0, 500, 400);
		TurretZone.add(Turret9);
		GRect Turret10 = new GRect( 5977.0, 544.0, 500, 400);
		TurretZone.add(Turret10);
		GRect Turret11 = new GRect( 6552.0, 441.0, 500, 400);
		TurretZone.add(Turret11);
	}
	public ArrayList<GRect> ReturnArray()
	{
		return(KnightGround);
	}
	public ArrayList<GRect> ReturnCheck()
	{
		return(KnightCheck);
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
	public ArrayList<GRect> ReturnSniperzone()
	{
		return(Sniperzone);
	}
	public ArrayList<GRect> ReturnTurretzone()
	{
		return(TurretZone);
	}
	public ArrayList<GRect> ReturnFlyingShieldzone()
	{
		return(FlyingShieldzone);
	}
}
