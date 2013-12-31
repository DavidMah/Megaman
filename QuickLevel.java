
/* Name: dmah10
 * File: QuickLevel.java
 * Description: TODO: Describe what this file does
 */
import java.util.*;
import acm.graphics.*;
import acm.util.*;
public class QuickLevel extends GCompound
{
	private GImage QuickLevel;
	private ArrayList<GRect> QuickGround = new ArrayList<GRect>();
	private ArrayList<GRect> QuickCheck = new ArrayList<GRect>();
	private ArrayList<GRect> QuickFalltoDeath = new ArrayList<GRect>();
	
	
	private ArrayList<GRect> LeftNo = new ArrayList<GRect>();
	private ArrayList<GRect> RightNo = new ArrayList<GRect>();
	private ArrayList<GRect> DownNo = new ArrayList<GRect>();
	private ArrayList<GRect> BossC = new ArrayList<GRect>();
	
	private ArrayList<GRect> Metzone = new ArrayList<GRect>();
	private ArrayList<GRect> Sniperzone = new ArrayList<GRect>();
	private ArrayList<GRect> NadeZone = new ArrayList<GRect>();
	private ArrayList<GRect> MosquitoZone = new ArrayList<GRect>();
	public QuickLevel()
	{
		QuickLevel = new GImage(MediaTools.loadImage("spritesheets/Levels/QuickLevel.gif"), 0, 0);
		add(QuickLevel);
		QuickLevel.setSize(QuickLevel.getWidth() * 2, QuickLevel.getHeight() * 2);
		GRect G0 = new GRect( 492.0, -1.0, 97.0, 409.0);
		QuickGround.add(G0);
		GRect G1 = new GRect( 625.0, 338.0, 128.0, 145.0);
		QuickGround.add(G1);
		GRect G2 = new GRect( 589.0, 371.0, 293.0, 82.0);
		QuickGround.add(G2);
		GRect G3 = new GRect( 945.0, 369.0, 448.0, 83.0);
		QuickGround.add(G3);
		GRect G4 = new GRect( 1137.0, 338.0, 256.0, 65.0);
		QuickGround.add(G4);
		GRect G5 = new GRect( 1490.0, 370.0, 416.0, 109.0);
		QuickGround.add(G5);
		GRect G6 = new GRect( 1970.0, 307.0, 381.0, 223.0);
		QuickGround.add(G6);
		GRect G7 = new GRect( 1978.0, 507.0, 118.0, 443.0);
		QuickGround.add(G7);
		GRect G8 = new GRect( 2092.0, 658.0, 67.0, 96.0);
		QuickGround.add(G8);
		GRect G10 = new GRect( 2094.0, 852.0, 1409.0, 82.0);
		QuickGround.add(G10);
		GRect G11 = new GRect( 2228.0, 596.0, 443.0, 93.0);
		QuickGround.add(G11);
		GRect G12 = new GRect( 2484.0, 307.0, 315.0, 286.0);
		QuickGround.add(G12);
		GRect G13 = new GRect( 2526.0, 15.0, 100.0, 295.0);
		QuickGround.add(G13);
		GRect G14 = new GRect( 3697.0, 828.0, 199.0, 25.0);
		QuickGround.add(G14);
		GRect G15 = new GRect( 3693.0, 827.0, 177.0, 146.0);
		QuickGround.add(G15);
		GRect G16 = new GRect( 3940.0, 804.0, 27.0, 87.0);
		QuickGround.add(G16);
		GRect G17 = new GRect( 4038.0, 804.0, 28.0, 98.0);
		QuickGround.add(G17);
		GRect G18 = new GRect( 4130.0, 805.0, 27.0, 103.0);
		QuickGround.add(G18);
		GRect G19 = new GRect( 4227.0, 804.0, 27.0, 115.0);
		QuickGround.add(G19);
		GRect G20 = new GRect( 4322.0, 805.0, 27.0, 95.0);
		QuickGround.add(G20);
		GRect G21 = new GRect( 4416.0, 805.0, 27.0, 106.0);
		QuickGround.add(G21);
		GRect G22 = new GRect( 4511.0, 805.0, 28.0, 95.0);
		QuickGround.add(G22);
		GRect G23 = new GRect( 4591.0, 788.0, 315.0, 173.0);
		QuickGround.add(G23);
		GRect G25 = new GRect( 4905.0, 795.0, 319.0, 98.0);
		QuickGround.add(G25);
		GRect G26 = new GRect( 5226.0, 792.0, 193.0, 81.0);
		QuickGround.add(G26);
		GRect G27 = new GRect( 5423.0, 794.0, 1883.0, 89.0);
		QuickGround.add(G27);
		GRect G28 = new GRect( 7112.0, 728.0, 172.0, 83.0);
		QuickGround.add(G28);
		GRect G29 = new GRect( 7178.0, 665.0, 337.0, 152.0);
		QuickGround.add(G29);
		GRect G30 = new GRect( 7511.0, 729.0, 1202.0, 96.0);
		QuickGround.add(G30);
		GRect G31 = new GRect( 8638.0, 250.0, 200.0, 480.0);
		QuickGround.add(G31);
		GRect G32 = new GRect( 7582.0, 353.0, 605.0, 246.0);
		QuickGround.add(G32);
		GRect G33 = new GRect( 6602.0, 591.0, 121.0, 74.0);
		QuickGround.add(G33);
		GRect G34 = new GRect( 6091.0, 590.0, 252.0, 73.0);
		QuickGround.add(G34);
		GRect G35 = new GRect( 3566.0, 855.0, 59.0, 98.0);
		QuickGround.add(G35);
		
		GRect Check1 = new GRect( 3134.0, 538.0, 368.0, 316.0);
		QuickCheck.add(Check1);
		GRect Check2 = new GRect( 7584.0, 585.0, 603.0, 164.0);
		QuickCheck.add(Check2);
		
		GRect Death1 = new GRect( 580.0, 451.0, 1469.0, 88.0);
		QuickFalltoDeath.add(Death1);
		GRect Death2 = new GRect( 3496.0, 932.0, 289.0, 87.0);
		QuickFalltoDeath.add(Death2);
		GRect Death3 = new GRect( 3869.0, 860.0, 725.0, 34.0);
		QuickFalltoDeath.add(Death3);
		
		GRect Met0 = new GRect( 944.0, 59.0, 550.0, 313.0);
		Metzone.add(Met0);
		GRect Met1 = new GRect( 1000.0, 76.0, 550.0, 315.0);
		Metzone.add(Met1);
		GRect Met2 = new GRect( 1113.0, 87.0, 550.0, 302.0);
		Metzone.add(Met2);
		GRect Met3 = new GRect( 1181.0, 64.0, 550.0, 323.0);
		Metzone.add(Met3);
		GRect Met4 = new GRect( 1959.0, 103.0, 550.0, 194.0);
		Metzone.add(Met4);
		GRect Met5 = new GRect( 2144.0, 84.0, 550.0, 227.0);
		Metzone.add(Met5);
		GRect Met6 = new GRect( 2109.0, 295.0, 550.0, 304.0);
		Metzone.add(Met6);
		GRect Met8 = new GRect( 2232.0, 676.0, 550.0, 217.0);
		Metzone.add(Met8);
		GRect Met9 = new GRect( 2778.0, 524.0, 550.0, 332.0);
		Metzone.add(Met9);
		GRect Met11 = new GRect( 4554.0, 531.0, 550.0, 265.0);
		Metzone.add(Met11);
		
		GRect Sniper0 = new GRect( 976.0, 192.0, 500.0, 190.0);
		Sniperzone.add(Sniper0);
	//	GRect Sniper1 = new GRect( 1313.0, 141.0, 600.0, 145.0);
		//Sniperzone.add(Sniper1);
		GRect Sniper2 = new GRect( 1977.0, 135.0, 550.0, 158.0);
		Sniperzone.add(Sniper2);
		GRect Sniper3 = new GRect( 2157.0, 688.0, 550.0, 185.0);
		Sniperzone.add(Sniper3);
		GRect Sniper4 = new GRect( 2667.0, 613.0, 550.0, 245.0);
		Sniperzone.add(Sniper4);
		GRect Sniper5 = new GRect( 3299.0, 579.0, 550.0, 269.0);
		Sniperzone.add(Sniper5);
		GRect Sniper6 = new GRect( 3936.0, 617.0, 550.0, 153.0);
		Sniperzone.add(Sniper6);
		GRect Sniper7 = new GRect( 3899.0, 512.0, 690.0, 284.0);
		Sniperzone.add(Sniper7);
		GRect Sniper8 = new GRect( 4619.0, 562.0, 515.0, 223.0);
		Sniperzone.add(Sniper8);
		GRect Sniper9 = new GRect( 5222.0, 576.0, 550.0, 207.0);
		Sniperzone.add(Sniper9);
		GRect Sniper10 = new GRect( 5747.0, 605.0, 562.0, 176.0);
		Sniperzone.add(Sniper10);
		GRect Sniper11 = new GRect( 6251.0, 597.0, 531.0, 192.0);
		Sniperzone.add(Sniper11);
		GRect Sniper12 = new GRect( 6518.0, 593.0, 504.0, 196.0);
		Sniperzone.add(Sniper12);
		GRect Sniper13 = new GRect( 7112.0, 472.0, 550.0, 184.0);
		Sniperzone.add(Sniper13);
		
		GRect Mosquit0 = new GRect( 962.0, 119.0, 527.0, 223.0);
		MosquitoZone.add(Mosquit0);
		GRect Mosquit1 = new GRect( 1367.0, 201.0, 508.0, 199.0);
		MosquitoZone.add(Mosquit1);
		GRect Mosquit2 = new GRect( 1975.0, 133.0, 500.0, 167.0);
		MosquitoZone.add(Mosquit2);
		GRect Mosquit3 = new GRect( 2416.0, 692.0, 551.0, 170.0);
		MosquitoZone.add(Mosquit3);
		GRect Mosquit5 = new GRect( 3023.0, 615.0, 550.0, 233.0);
		MosquitoZone.add(Mosquit5);
		GRect Mosquit6 = new GRect( 3696.0, 649.0, 558.0, 186.0);
		MosquitoZone.add(Mosquit6);
		GRect Mosquit7 = new GRect( 4017.0, 649.0, 595.0, 169.0);
		MosquitoZone.add(Mosquit7);
		GRect Mosquit8 = new GRect( 4292.0, 635.0, 542.0, 180.0);
		MosquitoZone.add(Mosquit8);
		GRect Mosquit9 = new GRect( 4586.0, 623.0, 550.0, 196.0);
		MosquitoZone.add(Mosquit9);
		GRect Mosquit10 = new GRect( 5171.0, 642.0, 550.0, 160.0);
		MosquitoZone.add(Mosquit10);
		GRect Mosquit11 = new GRect( 5606.0, 619.0, 550.0, 183.0);
		MosquitoZone.add(Mosquit11);
		GRect Mosquit12 = new GRect( 6069.0, 623.0, 578.0, 176.0);
		MosquitoZone.add(Mosquit12);
		GRect Mosquit13 = new GRect( 6528.0, 611.0, 577.0, 195.0);
		MosquitoZone.add(Mosquit13);
		GRect Mosquit14 = new GRect( 6789.0, 572.0, 560.0, 250.0);
		MosquitoZone.add(Mosquit14);
		
		GRect Nade1 = new GRect( 1100.0, 113.0, 554.0, 320.0);
		NadeZone.add(Nade1);
		GRect Nade2 = new GRect( 1618.0, 129.0, 550.0, 265.0);
		NadeZone.add(Nade2);
		GRect Nade3 = new GRect( 2067.0, 97.0, 550.0, 236.0);
		NadeZone.add(Nade3);
		GRect Nade4 = new GRect( 2228.0, 683.0, 617.0, 159.0);
		NadeZone.add(Nade4);
		GRect Nade5 = new GRect( 2807.0, 552.0, 510.0, 283.0);
		NadeZone.add(Nade5);
		GRect Nade6 = new GRect( 3998.0, 531.0, 515.0, 255.0);
		NadeZone.add(Nade6);
		GRect Nade7 = new GRect( 4342.0, 553.0, 495.0, 215.0);
		NadeZone.add(Nade7);
		GRect Nade8 = new GRect( 4597.0, 574.0, 503.0, 212.0);
		NadeZone.add(Nade8);
		GRect Nade9 = new GRect( 4879.0, 516.0, 550.0, 259.0);
		NadeZone.add(Nade9);
		GRect Nade10 = new GRect( 5210.0, 490.0, 550.0, 293.0);
		NadeZone.add(Nade10);
		GRect Nade11 = new GRect( 5648.0, 501.0, 576.0, 276.0);
		NadeZone.add(Nade11);
		GRect Nade12 = new GRect( 6443.0, 542.0, 550.0, 217.0);
		NadeZone.add(Nade12);
		GRect Nade13 = new GRect( 7088.0, 456.0, 547.0, 209.0);
		NadeZone.add(Nade13);
		
		GRect boss = new GRect( 8191.0, 405.0, 550.0, 321.0);
		BossC.add(boss);
	}
	public ArrayList<GRect> ReturnArray()
	{
		return(QuickGround);
	}
	public ArrayList<GRect> ReturnCheck()
	{
		return(QuickCheck);
	}
	public ArrayList<GRect> ReturnFall()
	{
		return(QuickFalltoDeath);
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
	public ArrayList<GRect> ReturnMosquitozone()
	{
		return(MosquitoZone);
	}
	public ArrayList<GRect> ReturnNadezone()
	{
		return(NadeZone);
	}
}
