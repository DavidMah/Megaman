/* Name: dmah10
 * File: ElecLevel.java
 * Description: TODO: Describe what this file does
 */
import acm.graphics.*;
import acm.util.*;
import java.util.*;
public class ElecLevel extends GCompound
{
	private GImage ElecLevel;
	private ArrayList<GRect> ElecGround = new ArrayList<GRect>();
	private ArrayList<GRect> ElecCheck = new ArrayList<GRect>();
	private ArrayList<GRect> ElecFallDeath = new ArrayList<GRect>();
	
	private ArrayList<GRect> LeftNo = new ArrayList<GRect>();
	private ArrayList<GRect> RightNo = new ArrayList<GRect>();
	private ArrayList<GRect> DownNo = new ArrayList<GRect>();
	private ArrayList<GRect> BossC = new ArrayList<GRect>();
	
	private ArrayList<GRect> Metzone = new ArrayList<GRect>();
	private ArrayList<GRect> Sniperzone = new ArrayList<GRect>();
	private ArrayList<GRect> BallSwingerzone = new ArrayList<GRect>();
	private ArrayList<GRect> Mosquitozone = new ArrayList<GRect>();
	public ElecLevel()
	{
		ElecLevel = new GImage(MediaTools.loadImage("spritesheets/Levels/ElecLevel.gif"), 0, 0);
		add(ElecLevel);
		ElecLevel.setSize(ElecLevel.getWidth() * 2, ElecLevel.getHeight() * 2);
		
		GRect G0 = new GRect( -2.0, 106.0, 59.0, 314.0);
		add(G0);
		ElecGround.add(G0);
		GRect G1 = new GRect( 57.0, 379.0, 293.0, 54.0);
		ElecGround.add(G1);
		GRect G2 = new GRect( 335.0, 316.0, 382.0, 68.0);
		ElecGround.add(G2);
		GRect G3 = new GRect( 352.0, 384.0, 365.0, 91.0);
		ElecGround.add(G3);
		GRect G4 = new GRect( 463.0, 439.0, 190.0, 187.0);
		ElecGround.add(G4);
		GRect G5 = new GRect( 452.0, 612.0, 71.0, 324.0);
		ElecGround.add(G5);
		GRect G6 = new GRect( 524.0, 882.0, 452.0, 54.0);
		ElecGround.add(G6);
		GRect G7 = new GRect( 976.0, 818.0, 847.0, 255.0);
		ElecGround.add(G7);
		GRect G8 = new GRect( 1463.0, 1056.0, 84.0, 453.0);
		ElecGround.add(G8);
		GRect G9= new GRect( 1546.0, 1394.0, 769.0, 148.0);
		ElecGround.add(G9);
		GRect G10 = new GRect( 2190.0, 1329.0, 126.0, 65.0);
		ElecGround.add(G10);
		GRect G11 = new GRect( 2255.0, 1266.0, 62.0, 72.0);
		ElecGround.add(G11);
		GRect G12 = new GRect( 2361.0, 1330.0, 33.0, 247.0);
		ElecGround.add(G12);
		GRect G13 = new GRect( 2442.0, 1312.0, 32.0, 239.0);
		ElecGround.add(G13);
		GRect G14 = new GRect( 2472.0, 1345.0, 36.0, 205.0);
		ElecGround.add(G14);
		GRect G15 = new GRect( 2607.0, 1297.0, 30.0, 233.0);
		ElecGround.add(G15);
		GRect G16 = new GRect( 2702.0, 1328.0, 32.0, 202.0);
		ElecGround.add(G16);
		GRect G17 = new GRect( 2752.0, 1379.0, 31.0, 167.0);
		ElecGround.add(G17);
		GRect G18 = new GRect( 2894.0, 1328.0, 65.0, 213.0);
		ElecGround.add(G18);
		GRect G19 = new GRect( 3034.0, 1328.0, 32.0, 247.0);
		ElecGround.add(G19);
		GRect G20 = new GRect( 3151.0, 1329.0, 126.0, 207.0);
		ElecGround.add(G20);
		GRect G21 = new GRect( 3271.0, 1394.0, 1377.0, 142.0);
		ElecGround.add(G21);
		GRect G22 = new GRect( 3918.0, 1362.0, 477.0, 85.0);
		ElecGround.add(G22);
		GRect G23 = new GRect( 4270.0, 1328.0, 127.0, 66.0);
		ElecGround.add(G23);
		GRect G24 = new GRect( 4527.0, 1067.0, 122.0, 353.0);
		ElecGround.add(G24);
		GRect G25 = new GRect( 3994.0, 958.0, 589.0, 114.0);
		ElecGround.add(G25);
		GRect G26 = new GRect( 3586.0, 955.0, 493.0, 278.0);
		ElecGround.add(G26);
		GRect G27 = new GRect( 3472.0, 1196.0, 446.0, 70.0);
		ElecGround.add(G27);
		GRect G28 = new GRect( 3345.0, 1009.0, 285.0, 126.0);
		ElecGround.add(G28);
		GRect G29 = new GRect( 3408.0, 1133.0, 203.0, 67.0);
		ElecGround.add(G29);
		GRect G30 = new GRect( 2134.0, 978.0, 1284.0, 95.0);
		ElecGround.add(G30);
		GRect G31 = new GRect( 2119.0, 1034.0, 134.0, 103.0);
		ElecGround.add(G31);
		GRect G32 = new GRect( 2018.0, 1025.0, 173.0, 178.0);
		ElecGround.add(G32);
		GRect G33 = new GRect( 1994.0, 1103.0, 131.0, 162.0);
		ElecGround.add(G33);
		GRect G34 = new GRect( 1945.0, 1224.0, 116.0, 107.0);
		ElecGround.add(G34);
		GRect G35 = new GRect( 1679.0, 1202.0, 339.0, 128.0);
		ElecGround.add(G35);
		GRect G36 = new GRect( 1871.0, 1139.0, 156.0, 66.0);
		ElecGround.add(G36);
		GRect G37 = new GRect( -28.0, -8.0, 847.0, 193.0);
		ElecGround.add(G37);
		GRect G38 = new GRect( 783.0, 173.0, 1275.0, 450.0);
		ElecGround.add(G38);
		GRect G39 = new GRect( 1936.0, 620.0, 227.0, 539.0);
		ElecGround.add(G39);
		GRect G40 = new GRect( 1871.0, 1313.0, 126.0, 48.0);
		ElecGround.add(G40);
		//Enemies
		GRect Met0 = new GRect( 335.0, 178.0, 500.0, 137.0);
		Metzone.add(Met0);
		GRect Met2 = new GRect( 510.0, 613.0, 500.0, 283.0);
		Metzone.add(Met2);
		GRect Met3 = new GRect( 784.0, 612.0, 500.0, 284.0);
		Metzone.add(Met3);
		GRect Met4 = new GRect( 1104.0, 607.0, 500.0, 228.0);
		Metzone.add(Met4);
		GRect Met5 = new GRect( 1424.0, 607.0, 399.0, 242.0);
		Metzone.add(Met5);
		GRect Met6 = new GRect( 1540.0, 914.0, 408.0, 330.0);
		Metzone.add(Met6);
		GRect Met7 = new GRect( 1540.0, 1053.0, 457.0, 343.0);
		Metzone.add(Met7);
		GRect Met8 = new GRect( 1699.0, 1077.0, 637.0, 322.0);
		Metzone.add(Met8);
		GRect Met9 = new GRect( 3274.0, 1053.0, 505.0, 343.0);
		Metzone.add(Met9);
		GRect Met10 = new GRect( 3473.0, 1036.0, 507.0, 368.0);
		Metzone.add(Met10);
		GRect L0 = new GRect( 50.0, 172.0, 250.0, 237.0);

		GRect Sniper0 = new GRect( 414.0, 170.0, 500.0, 149.0);
		Sniperzone.add(Sniper0);
		GRect Sniper1 = new GRect( 968.0, 612.0, 500.0, 214.0);
		Sniperzone.add(Sniper1);
		GRect Sniper2 = new GRect( 1469.0, 609.0, 500.0, 204.0);
		Sniperzone.add(Sniper2);
		GRect Sniper3 = new GRect( 3267.0, 1019.0, 430.0, 371.0);
		Sniperzone.add(Sniper3);
		
		LeftNo.add(L0);
		//GRect LR0 = new GRect( 1544.0, 1067.0, 205.0, 350.0);
	//	RightNo.add(LR0);
		//LeftNo.add(LR0);
		GRect D0 = new GRect( 2242.0, 1030.0, 918.0, 492.0);
		DownNo.add(D0);
		GRect Boss = new GRect( 4061.0, 1057.0, 335.0, 276.0);
		BossC.add(Boss);
		
		GRect Check1 = new GRect( 1680.0, 1061.0, 203.0, 154.0);
		ElecCheck.add(Check1);
		GRect Check2 = new GRect( 3471.0, 1257.0, 452.0, 144.0);
		ElecCheck.add(Check2);
		
		GRect Fall0 = new GRect( 2313.0, 1521.0, 930.0, 98.0);
		ElecFallDeath.add(Fall0);

	}
	public ArrayList<GRect> ReturnArray()
	{
		return(ElecGround);
	}
	public ArrayList<GRect> ReturnCheck()
	{
		return(ElecCheck);
	}	
	public ArrayList<GRect> ReturnFallDeath()
	{
		return(ElecFallDeath);
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
	public ArrayList<GRect> ReturnBallSwingerzone()
	{
		return(BallSwingerzone);
	}
	public ArrayList<GRect> ReturnMosquitozone()
	{
		return(Mosquitozone);
	}
}
