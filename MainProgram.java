    /* Name: David
 * File: MainProgram.java
 * Description: TODO: This is the main applet for the Megaman Game.
 */
import java.awt.event.*;
import java.util.*;
import org.nmhschool.*;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class MainProgram extends GraphicsProgram
{	
//	GCompounds to import
	private StageSelect Stages;
	private Megaman Megaman;
	private ShadowLevel ShadowStage;
	private ElecLevel ElecStage;
	private QuickLevel QuickStage;
	private MetalLevel MetalStage;
	private KnightLevel KnightStage;
	private GCompound Stage;
	private Menu Menu;
	
	private GImage Block;
	
	//Bosses
	private MetalMan MetalMan;
	private QuickMan QuickMan;
	//Controls Health
	private Healthbar Health;
	private int HP = 28;
	private int Lives = 4;
	//Boss
	private int BossHP = 28;
	private GImage BossBar;
	private int bossdown;
	
//	Timer for 50 miliseconds per tick
	private SwingTimer clock;
	
//	The fields which indicate if a key is being pressed down or not
	private boolean Right = false;
	private boolean Left = false;
	private boolean Shoot = false;
	private boolean Jump = false;
	private boolean Slide = false;
	private boolean Down = false;
	private boolean Up = false;
	
	
	//Sound
	private MP3 Music;
	//Arrays
	private ArrayList<GRect> Ground = new ArrayList<GRect>();
	private ArrayList<GRect> Check = new ArrayList<GRect>();
	private ArrayList<GRect> FallDeath = new ArrayList<GRect>();
	private ArrayList<GRect> LeftNo = new ArrayList<GRect>();
	private ArrayList<GRect> RightNo = new ArrayList<GRect>();
	private ArrayList<GRect> UpNo = new ArrayList<GRect>();
	private ArrayList<GRect> DownNo = new ArrayList<GRect>();
	private ArrayList<GRect> BossCenter = new ArrayList<GRect>();
	
	private ArrayList<GRectangle> BulletBoundList = new ArrayList<GRectangle>();
	private int Bulletstop;
	private int Bulletstop2;
	private int Bulletstop3;
	
	private ArrayList<GRect> Metzone = new ArrayList<GRect>();
	private ArrayList<GRect> BallSwingzone = new ArrayList<GRect>();
	private ArrayList<GRect> SniperJoezone = new ArrayList<GRect>();
	private ArrayList<GRect> Mosquitozone = new ArrayList<GRect>();
	private ArrayList<GRect> Nadezone = new ArrayList<GRect>();
	private ArrayList<GRect> HoppingEyezone = new ArrayList<GRect>();
	private ArrayList<GRect> FlyingShieldzone = new ArrayList<GRect>();
	private ArrayList<GRect> TurretGunzone = new ArrayList<GRect>();
	
	private ArrayList<Metool> MetList = new ArrayList<Metool>();
	//private ArrayList<BallSwinger> BallSwingList = new ArrayList<BallSwinger>();
	private ArrayList<SniperJoe> SniperList = new ArrayList<SniperJoe>();
	private ArrayList<Mosquito> MosquitoList = new ArrayList<Mosquito>();
	private ArrayList<RunningNade> NadeList = new ArrayList<RunningNade>();
	private ArrayList<HoppingEye> HoppingEyeList = new ArrayList<HoppingEye>();
	private ArrayList<FlyingShield> FlyingShieldList = new ArrayList<FlyingShield>();
	private ArrayList<TurretGun> TurretGunList = new ArrayList<TurretGun>();
	
	private int CheckPoint;
	
//	The int which indicates the direction that Megaman is facing.  1 meaning Left and 2 meaning Right
	private int Direct = 2;
	private boolean Gravity;
	private int JumpTimer = 10;
	private int Pain = 24;
	private int ShootTimer;
	private int Strength;
	private int State = 0;
	private int BossState;
	
	private int CountDown;
	private boolean BossStart;
	private GRectangle MegaRect;
	
//	Booleans that check to stop sidescrolling.
	private boolean stopleft;
	private boolean stopright;
	private boolean stopup;
	private boolean stopdown;
	
	//Intro
	private GImage Intro;
	
	//Controller
	//private Controller c;
	public void run()
	{
		
//		Basic settings needed on startup.
		resize(500, 400);
		addMouseListeners();
		addKeyListeners();
		Intro = new GImage(MediaTools.loadImage("spritesheets/Intro/Intro.gif"), 0, 0);
		add(Intro);
		Intro.setSize(500, 400);
			pause(5500);
			remove(Intro);
		
		Menu = new Menu();
		add(Menu);
		
		MegaRect = new GRectangle();
		Music = new MP3("sound/Quick.mp3");
		
		//Swingtimer that ticks every 50 miliseconds
		clock = new SwingTimer(50, this);
		clock.start();
	}
	public void keyPressed(KeyEvent e)
	{
//		If Left is Pressed then make Left true and set Direct to 2.
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(Pain == 24)
			{
				Left = true;
				Direct = 1;
			}
		}
//		If Right is Pressed then make Right true and set Direct to 1.
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(Pain == 24)
			{
				Right = true;
				Direct = 2;
			}
			
		}
//		If Down is pushed then make Down true.
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			Down = true;
		}
//		If Up is pushed then make up true.
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			Up = true;
		}
//		If Space is pushed then make Shoot true.
		if(e.getKeyCode() == KeyEvent.VK_SPACE /*c.isButtonPressed(2)*/)
		{
			Shoot = true;	
			if(ShootTimer < 0 || Strength > 0)
			{
				Shoot = false;
			}
			if(State == 2)
			{
				if(ShootTimer == 10)
				{
					Strength  = 1;
					
					Megaman.Shoot(Direct, Strength, Pain);
				}
			}
		}        
		//If Control is pushed then Jump shall be true.
		if(e.getKeyCode() == KeyEvent.VK_CONTROL /*c.isButtonPressed(1)*/)
		{
			if(JumpTimer == 10)
			{
				Jump = true;
			}
			Slide = true;
		}
	}
	//Key releases for Megaman control
	public void keyReleased(KeyEvent e)
	{
		//If Left is released then turn Left off.
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			Left = false;
			if(Right == true)
			{
				Direct = 2;
			}
			
		}
//		If Right is released then turn Right off.
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			
			Right = false;
			if(Left == true)
			{
				Direct = 1;
			}	
			
		}
//		If Down is released then turn Down off.
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			Down = false;
		}
//		If Up is released then turn Up off.
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			Up = false;
		}
		//If Space is released then turn Shoot off.
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			Shoot = false;
			if(State == 2)
			{
				ShootTimer = 10;
				if(Strength > 20)
				{
					Megaman.Shoot(Direct, Strength, Pain);
					Shoot = true;
				}
				Strength = 0;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_CONTROL)
		{
			Jump = false;
			Slide = false;
		}
	}
	//Every time the timer ticks...
	public void actionPerformed(ActionEvent e)
	{	
		if(ShootTimer == 0)
		{
			ShootTimer = 10;
		}
		
		if(getWidth() > 500 || getHeight() > 400)
		{
			resize(500, 400);
		}
		if(State == 0)
		{
			State = Menu.PressSpace(Shoot);
			if(State == 1)
			{
				StageSelect();
			}
		}
		if(State == 1)
		{
			Music.stop();
			CheckPoint = 0;
			Lives = 4;
			BossState = Stages.BossPick(Left, Right, Up, Down, Shoot);
			if(BossState == 5)
			{
				ShadowStage();
			}
			if(BossState == 4)
			{
				ElecStage();
			}
			if(BossState == 3)
			{
				MetalStage();
			}
			if(BossState == 2)
			{
				QuickStage();
			}
			if(BossState == 1)
			{
				KnightStage();
			}
			if(Jump == true)
			{
				ShadowStage();
			}
		}
		if(State == 2)
		{
			JumpTimer = Megaman.MegaControl(Left, Right, Shoot, Direct, Gravity, Jump, Down, Slide, JumpTimer, Pain, ShootTimer, Strength, Lives, HP,
					Ground, LeftNo, RightNo, UpNo, DownNo, FallDeath);
			Megaman.sendToFront();
			Health.Update(HP);
			HP = Megaman.ReturnHP();
			Pain = Megaman.PainReturn();
			//If Megaman happens upon a boss room, then activate the fight.
			for(GRect bossC: BossCenter)
			{
				if(MegaRect.intersects(bossC.getBounds()))
				{
					BossStart = true;
				}
			}
			//If Megaman is in MetalMan's Level, then make MetalMan fight.
			if(BossState == 3)
			{
				MetalMan.Action(Ground, BossStart);
			}	
//			If Megaman is in QuickMan's Level, then make QuickMan fight.
			if(BossState == 2)
			{
				QuickMan.Action(Ground, BossStart, MegaRect, BulletBoundList);
				if(Pain == 24)
				{
					int RecHP = HP;
					HP = HP - QuickMan.ReturnDam();
					if(HP < RecHP)
					{
						Pain = 23;
					}
					
				}
				bossdown = QuickMan.ReturnKill();
				BossHP = QuickMan.ReturnHealth();
				if(BossHP >= 0)
				{
					BossBar.setImage(MediaTools.loadImage("spritesheets/Misc/Meter/"+ BossHP +".gif"));
				}
				BossBar.setLocation(360, 20);
				//Takes bullets that make contact with an enemy, and makes them dissappear.
				Bulletstop = QuickMan.ReturnVal();
				Bulletstop2 = QuickMan.ReturnVal2();
				Bulletstop3 = QuickMan.ReturnVal3();
				Megaman.BulletHit(Bulletstop, Bulletstop2, Bulletstop3);
				//If the boss is down, then return to the stage select screen.
				if(bossdown == 1)
				{
					StageSelect();
				}
			}
			//Make Enemies all fight.
			int coolwhile = 0;
			while(coolwhile < MetList.size())
			{
				MetList.get(coolwhile).Attack(BulletBoundList, Ground, MegaRect, FallDeath);
				if(Pain == 24)
				{
					int RecHP = HP;
					HP = HP - MetList.get(coolwhile).ReturnDam();
					if(HP < RecHP)
					{
						Pain = 23;
					}
				}
				Bulletstop =  MetList.get(coolwhile).ReturnVal();
				Bulletstop2 = MetList.get(coolwhile).ReturnVal2();
				Bulletstop3 = MetList.get(coolwhile).ReturnVal3();
				Megaman.BulletHit(Bulletstop, Bulletstop2, Bulletstop3);
				coolwhile = coolwhile + 1;
			}	
			coolwhile = 0;
			while(coolwhile < SniperList.size())
			{
				SniperList.get(coolwhile).Attack(BulletBoundList, Ground, MegaRect, FallDeath);
				if(Pain == 24)
				{
					int RecHP = HP;
					HP = HP - SniperList.get(coolwhile).ReturnDam();
					if(HP < RecHP)
					{
						Pain = 23;
					}
				}
				Bulletstop = SniperList.get(coolwhile).ReturnVal();
				Bulletstop2 = SniperList.get(coolwhile).ReturnVal2();
				Bulletstop3 = SniperList.get(coolwhile).ReturnVal3();
				Megaman.BulletHit(Bulletstop, Bulletstop2, Bulletstop3);
				coolwhile = coolwhile + 1;
			}	
			coolwhile = 0;
			while(coolwhile < MosquitoList.size())
			{
				MosquitoList.get(coolwhile).Attack(BulletBoundList, MegaRect);
				if(Pain == 24)
				{
					int RecHP = HP;
					HP = HP - MosquitoList.get(coolwhile).ReturnDam();
					if(HP < RecHP)
					{
						Pain = 23;
					}
				}
				Bulletstop = MosquitoList.get(coolwhile).ReturnVal();
				Bulletstop2 = MosquitoList.get(coolwhile).ReturnVal2();
				Bulletstop3 = MosquitoList.get(coolwhile).ReturnVal3();
				Megaman.BulletHit(Bulletstop, Bulletstop2, Bulletstop3);
				coolwhile = coolwhile + 1;
			}	
			coolwhile = 0;
			while(coolwhile < NadeList.size())
			{
				NadeList.get(coolwhile).Action(Ground, MegaRect, BulletBoundList, FallDeath);
				if(Pain == 24)
				{
					int RecHP = HP;
					HP = HP - NadeList.get(coolwhile).ReturnDam();
					if(HP < RecHP)
					{
						Pain = 23;
					}
					
				}
				Bulletstop = NadeList.get(coolwhile).ReturnVal();
				Bulletstop2 = NadeList.get(coolwhile).ReturnVal2();
				Bulletstop3 = NadeList.get(coolwhile).ReturnVal3();
				Megaman.BulletHit(Bulletstop, Bulletstop2, Bulletstop3);
				coolwhile = coolwhile + 1;	
			}
			coolwhile = 0;
			while(coolwhile < TurretGunList.size())
			{
				TurretGunList.get(coolwhile).Action(Ground, MegaRect, BulletBoundList, FallDeath);
				if(Pain == 24)
				{
					int RecHP = HP;
					HP = HP - TurretGunList.get(coolwhile).ReturnDam();
					if(HP < RecHP)
					{
						Pain = 23;
					}
					
				}
				Bulletstop = TurretGunList.get(coolwhile).ReturnVal();
				Bulletstop2 = TurretGunList.get(coolwhile).ReturnVal2();
				Bulletstop3 = TurretGunList.get(coolwhile).ReturnVal3();
				Megaman.BulletHit(Bulletstop, Bulletstop2, Bulletstop3);
				coolwhile = coolwhile + 1;	
			}
			Jump = Megaman.JumpReturn();
			
			ShootTimer = Megaman.ShootReturn();
			Strength = Megaman.StrengthReturn();
			BulletBoundList = Megaman.BulletBoundListReturn();
			Lives = Megaman.LivesReturn();
			MegaRect = Megaman.MegaRectReturn();
			//If Megaman has died, then restart the level or return to the stage Select Screen depending on his life count.
			CountDown = Megaman.Die();
			if(CountDown == 0)
			{
				Music.stop();
				remove(Stage);
				if(BossState == 4)
				{
					ElecStage();
				}
				if(BossState == 3)
				{
					MetalStage();
				}
				if(BossState == 2)
				{
					QuickStage();
				}
				if(BossState == 1)
				{
					KnightStage();
				}
				HP = 28;
				Lives = Lives - 1;
				
				if(Lives == -1)
				{
					State = 1;
					StageSelect();
				}
			}
			if(ShootTimer <= 0)
			{
				Shoot = false;
			}
			
			
			/*The below is all for sidescrolling.  
			 * First checks if sidescrolling is turned off for each direction for the zones
			 * Then Moves everyone in the opposite direction of Megaman's movement at whatever rate Megaman is moving
			 * 
			 * If Megaman enters a zone for an enemy, then the game checks if there are currently as many enemies wandering about as compared to the number zone of that enemy
			 * If not, then an enemy of that type will be added to the level in the middle of that zone
			 * If so, then the game will check to see if the enemy of that zone is alive or not.
			 * If the enemy is alive, then nothing will happen.
			 * If the enemy is dead, then the game will check to see if Megaman has left the zone since the enemy died
			 * If Megaman has left since, then the Creation Method on the enemy will be called, and the enemy will be sent back to it's starting position to begin fighting again
			 * 
			 * This occurs on every side scroll in every direction.
			 */
			stopleft = Megaman.LeftStopReturn();
			stopright = Megaman.RightStopReturn();
			stopup = Megaman.UpStopReturn();
			stopdown = Megaman.DownStopReturn();
			for(GRect boss: BossCenter)
			{
				if(MegaRect.intersects(boss.getBounds()))
				{
					stopleft = true;
					stopright = true;
					stopup = true;
					stopdown = true;
					Stage.move(-boss.getX(), -boss.getY());
					if(BossState == 3)
					{
						MetalMan.move(-boss.getX(), -boss.getY());
					}
					if(BossState == 2)
					{
						QuickMan.move(-boss.getX(), -boss.getY());
					}

					for(GRect groundPiece : Ground)
					{
						groundPiece.move(-boss.getX(), -boss.getY());
					}
					for(GRect check: Check)
					{
						check.move(-boss.getX(), -boss.getY());
					}
					for(GRect fall : FallDeath)
					{
						fall.move(-boss.getX(), -boss.getY());
					}
					for(GRect block: LeftNo)
					{
						block.move(-boss.getX(), -boss.getY());
					}
					for(GRect block: RightNo)
					{
						block.move(-boss.getX(), -boss.getY());
					}
					for(GRect block: UpNo)
					{
						block.move(-boss.getX(), -boss.getY());
					}
					for(GRect block: DownNo)
					{
						block.move(-boss.getX(), -boss.getY());
					}
					for(Metool mety: MetList)
					{
						mety.move(-boss.getX(), -boss.getY());
					}
					for(SniperJoe snipe: SniperList)
					{
						snipe.move(-boss.getX(), -boss.getY());
					}
					for(Mosquito mosq: MosquitoList)
					{
						mosq.move(-boss.getX(), -boss.getY());
					}
					for(RunningNade nade: NadeList)
					{
						nade.move(-boss.getX(), -boss.getY());
					}
					Megaman.move(-boss.getX(), -boss.getY());
					GRect G = new GRect(-22, 454, 42, 66);
					Ground.add(G);
					Block = new GImage(MediaTools.loadImage("spritesheets/Levels/QuickBlock.gif"), -22, 454);
					add(Block);
					BossBar.setVisible(true);
					boss.move(-boss.getX(), -boss.getY());


				}
			}
			//SIDESCROLLING RIGHT.
			if(stopright == false)
			{
				if(Megaman.getX() > 350)
				{
					Stage.move(350 - Megaman.getX(), 0);
					
					if(BossState == 2)
					{
						QuickMan.move(350 - Megaman.getX(), 0);
					}
					if(BossState == 3)
					{
						MetalMan.move(350 - Megaman.getX(), 0);
					}
					for(GRect groundPiece : Ground)
					{
						groundPiece.move(350 - Megaman.getX(), 0);
					}
					for(GRect check: Check)
					{
						check.move(350 - Megaman.getX(), 0);
						if(Megaman.getBounds().intersects(check.getBounds()))
						{
							if(check == Check.get(0) && CheckPoint != 2)
							{
								CheckPoint = 1;
							}
							if(check == Check.get(1))
							{
								CheckPoint = 2;
							}
						}
					}
					for(GRect fall : FallDeath)
					{
						fall.move(350 - Megaman.getX(), 0);
					}
					for(GRect block: LeftNo)
					{
						block.move(350 - Megaman.getX(), 0);
					}
					for(GRect block: RightNo)
					{
						block.move(350 - Megaman.getX(), 0);
					}
					for(GRect block: UpNo)
					{
						block.move(350 - Megaman.getX(), 0);
					}
					for(GRect block: DownNo)
					{
						block.move(350 - Megaman.getX(), 0);
					}
					for(GRect boss: BossCenter)
					{
						boss.move(350 - Megaman.getX(), 0);
					}
					for(Metool mety: MetList)
					{
						mety.move(350 - Megaman.getX(), 0);
					}
					for(SniperJoe snipe: SniperList)
					{
						snipe.move(350 - Megaman.getX(), 0);
					}
					for(Mosquito mosq: MosquitoList)
					{
						mosq.move(350 - Megaman.getX(), 0);
					}
					for(RunningNade nade: NadeList)
					{
						nade.move(350 - Megaman.getX(), 0);
					}
					for(TurretGun tur: TurretGunList)
					{
						tur.move(350 - Megaman.getX(), 0);
					}
					for(FlyingShield shi: FlyingShieldList)
					{
						shi.move(350 - Megaman.getX(), 0);
					}
					coolwhile = 0;
					for(GRect met: Metzone)
					{	
						boolean alive = true;
						if(MetList.size() > coolwhile)
						{
							alive = MetList.get(coolwhile).ReturnAlive();
						}
						met.move(350 - Megaman.getX(), 0);
						if(Megaman.getBounds().intersects(met.getBounds()))
						{
							if(MetList.size() -1 < coolwhile)
							{
								Metool mety = new Metool();
								add(mety);
								MetList.add(mety);
								mety.setLocation(met.getX() + (met.getWidth()/2), met.getY() + (met.getHeight()/2));
							}
							else if(alive == false)
							{
								MetList.get(coolwhile).Creation();
								MetList.get(coolwhile).setLocation(met.getX() + (met.getWidth()/2), met.getY() + (met.getHeight()/2));
							}
						}
						else
						{
							if(MetList.size() > coolwhile)
							{
								MetList.get(coolwhile).Respawn();
							}
						}
						coolwhile = coolwhile + 1;
					}
					coolwhile = 0;
					for(GRect Joe: SniperJoezone)
					{	
						boolean alive = true;
						if(SniperList.size() > coolwhile)
						{
							alive = SniperList.get(coolwhile).ReturnAlive();
						}
						Joe.move(350 - Megaman.getX(), 0);
						if(Megaman.getBounds().intersects(Joe.getBounds()))
						{
							if(SniperList.size() -1 < coolwhile)
							{
								SniperJoe snipe = new SniperJoe();
								add(snipe);
								SniperList.add(snipe);
								snipe.setLocation(Joe.getX() + (Joe.getWidth()/2), Joe.getY() + (Joe.getHeight()/2));
							}
							else if(alive == false)
							{
								SniperList.get(coolwhile).Creation();
								SniperList.get(coolwhile).setLocation(Joe.getX() + (Joe.getWidth()/2), Joe.getY() + (Joe.getHeight()/2));
							}
						}
						else
						{
							
							if(SniperList.size() > coolwhile)
							{
								SniperList.get(coolwhile).Respawn();
							}
						}
						coolwhile = coolwhile + 1;
					}
					coolwhile = 0;
					for(GRect Mos: Mosquitozone)
					{	
						boolean alive = true;
						if(MosquitoList.size() > coolwhile)
						{
							alive = MosquitoList.get(coolwhile).ReturnAlive();
						}
						Mos.move(350 - Megaman.getX(), 0);
						
						if(Megaman.getBounds().intersects(Mos.getBounds()))
						{
							if(MosquitoList.size() -1 < coolwhile)
							{
								Mosquito mosq = new Mosquito();
								add(mosq);
								MosquitoList.add(mosq);
								mosq.setLocation(Mos.getX() + (Mos.getWidth()/2), Mos.getY() + (Mos.getHeight()/2));
							}
							else if(alive == false)
							{
								MosquitoList.get(coolwhile).Creation();
								MosquitoList.get(coolwhile).setLocation(Mos.getX() + (Mos.getWidth()/2), Mos.getY() + (Mos.getHeight()/2));
							}
						}
						else
						{
							if(MosquitoList.size() > coolwhile)
							{
								MosquitoList.get(coolwhile).Spawn();
							}
						}
						coolwhile = coolwhile + 1;
					}
					coolwhile = 0;
					for(GRect Nade: Nadezone)
					{	
						boolean alive = true;
						if(NadeList.size() > coolwhile)
						{
							alive = NadeList.get(coolwhile).ReturnAlive();
						}
						Nade.move(350 - Megaman.getX(), 0);
						if(Megaman.getBounds().intersects(Nade.getBounds()))
						{						
							if(NadeList.size() -1 < coolwhile)
							{
								RunningNade na = new RunningNade();
								add(na);
								NadeList.add(na);
								na.setLocation(Nade.getX() + (Nade.getWidth()/2), Nade.getY() + (Nade.getHeight()/2));
							}
							else if(alive == false)
							{
								NadeList.get(coolwhile).Creation();
								NadeList.get(coolwhile).setLocation(Nade.getX() + (Nade.getWidth()/2), Nade.getY() + (Nade.getHeight()/2));
							}
						}
						else
						{
							if(NadeList.size() > coolwhile)
							{
								NadeList.get(coolwhile).Spawn();
							}
						}
						coolwhile = coolwhile + 1;
					}
					for(GRect TurretGun: TurretGunzone)
					{	
						boolean alive = true;
						if(TurretGunList.size() > coolwhile)
						{
							alive = TurretGunList.get(coolwhile).ReturnAlive();
						}
						TurretGun.move(350 - Megaman.getX(), 0);
						if(Megaman.getBounds().intersects(TurretGun.getBounds()))
						{
							if(TurretGunList.size() -1 < coolwhile)
							{
								TurretGun na = new TurretGun();
								add(na);
								TurretGunList.add(na);
								na.setLocation(TurretGun.getX() + (TurretGun.getWidth()/2), TurretGun.getY() + (TurretGun.getHeight()/2));
							}
							else if(alive == false)
							{
								TurretGunList.get(coolwhile).Creation();
								TurretGunList.get(coolwhile).setLocation(TurretGun.getX() + (TurretGun.getWidth()/2), TurretGun.getY() + (TurretGun.getHeight()/2));
							}
						}
						else
						{
							if(TurretGunList.size() > coolwhile)
							{
								TurretGunList.get(coolwhile).Respawn();
							}
						}
						coolwhile = coolwhile + 1;
					}
					Megaman.move(350 - Megaman.getX(), 0);
				}
				
			}
			//SIDESCROLLING LEFT
			if(stopleft == false)
			{
				if(Megaman.getX() < 265)
				{
					
					Stage.move(265 - Megaman.getX(), 0);
					if(BossState == 2)
					{
						QuickMan.move(265 - Megaman.getX(), 0);
					}
					if(BossState == 3)
					{
						MetalMan.move(265 - Megaman.getX(), 0);
					}
					if(BossState == 3)
					{
						MetalMan.move(265 - Megaman.getX(), 0);
					}
					for(GRect groundPiece : Ground)
					{
						groundPiece.move(265 - Megaman.getX(), 0);
					}
					for(GRect check: Check)
					{
						check.move(265 - Megaman.getX(), 0);
						if(Megaman.getBounds().intersects(check.getBounds()))
						{
							if(check == Check.get(0) && CheckPoint != 2)
							{
								CheckPoint = 1;
							}
							if(check == Check.get(1))
							{
								CheckPoint = 2;
							}
						}
					}
					for(GRect fall : FallDeath)
					{
						fall.move(265 - Megaman.getX(), 0);
					}
					for(GRect block: LeftNo)
					{
						block.move(265 - Megaman.getX(), 0);
					}
					for(GRect block: RightNo)
					{
						block.move(265 - Megaman.getX(), 0);
					}
					for(GRect block: UpNo)
					{
						block.move(265 - Megaman.getX(), 0);
					}
					for(GRect block: DownNo)
					{
						block.move(265 - Megaman.getX(), 0);
					}
					for(GRect boss: BossCenter)
					{
						boss.move(265 - Megaman.getX(), 0);
					}
					for(Metool mety: MetList)
					{
						mety.move(265 - Megaman.getX(), 0);
					}
					for(SniperJoe snipe: SniperList)
					{
						snipe.move(265 - Megaman.getX(), 0);
					}
					for(Mosquito mosq: MosquitoList)
					{
						mosq.move(265 - Megaman.getX(), 0);
					}
					for(RunningNade nade: NadeList)
					{
						nade.move(265 - Megaman.getX(), 0);
					}
					for(TurretGun tur: TurretGunList)
					{
						tur.move(265 - Megaman.getX(), 0);
					}
					for(FlyingShield shi: FlyingShieldList)
					{
						shi.move(265 - Megaman.getX(), 0);
					}
					coolwhile = 0;
					for(GRect met: Metzone)
					{	
						boolean alive = true;
						if(MetList.size() > coolwhile)
						{
							alive = MetList.get(coolwhile).ReturnAlive();
						}
						met.move(265 - Megaman.getX(), 0);
						if(Megaman.getBounds().intersects(met.getBounds()))
						{
							if(MetList.size() -1 < coolwhile)
							{
								Metool mety = new Metool();
								add(mety);
								MetList.add(mety);
								mety.setLocation(met.getX() + (met.getWidth()/2), met.getY() + (met.getHeight()/2));
							}
							else if(alive == false)
							{
								MetList.get(coolwhile).Creation();
								MetList.get(coolwhile).setLocation(met.getX() + (met.getWidth()/2), met.getY() + (met.getHeight()/2));
							}
						}
						else
						{
							if(MetList.size() > coolwhile)
							{
								MetList.get(coolwhile).Respawn();
							}
						}
						coolwhile = coolwhile + 1;
					}
					coolwhile = 0;
					for(GRect Joe: SniperJoezone)
					{	
						boolean alive = true;
						if(SniperList.size() > coolwhile)
						{
							alive = SniperList.get(coolwhile).ReturnAlive();
						}
						Joe.move(265 - Megaman.getX(), 0);
						if(Megaman.getBounds().intersects(Joe.getBounds()))
						{
							if(SniperList.size() -1 < coolwhile)
							{
								SniperJoe snipe = new SniperJoe();
								add(snipe);
								SniperList.add(snipe);
								snipe.setLocation(Joe.getX() + (Joe.getWidth()/2), Joe.getY() + (Joe.getHeight()/2));
							}
							else if(alive == false)
							{
								SniperList.get(coolwhile).Creation();
							}
						}
						else
						{
							if(SniperList.size() > coolwhile)
							{
								SniperList.get(coolwhile).Respawn();
								SniperList.get(coolwhile).setLocation(Joe.getX() + (Joe.getWidth()/2), Joe.getY() + (Joe.getHeight()/2));
							}
						}
						coolwhile = coolwhile + 1;
					}
					coolwhile = 0;
					for(GRect Mos: Mosquitozone)
					{	
						boolean alive = true;
						if(MosquitoList.size() > coolwhile)
						{
							alive = MosquitoList.get(coolwhile).ReturnAlive();
						}
						
						Mos.move(265 - Megaman.getX(), 0);
						if(Megaman.getBounds().intersects(Mos.getBounds()))
						{
							if(MosquitoList.size() -1 < coolwhile)
							{
								Mosquito mosq = new Mosquito();
								add(mosq);
								MosquitoList.add(mosq);
								mosq.setLocation(Mos.getX() + (Mos.getWidth()/2), Mos.getY() + (Mos.getHeight()/2));
							}
							else if(alive == false)
							{
								MosquitoList.get(coolwhile).Creation();
								MosquitoList.get(coolwhile).setLocation(Mos.getX() + (Mos.getWidth()/2), Mos.getY() + (Mos.getHeight()/2));
							}
						}
						else
						{
							if(MosquitoList.size() > coolwhile)
							{
								MosquitoList.get(coolwhile).Spawn();
							}
						}
						coolwhile = coolwhile + 1;
					}
					coolwhile = 0;
					for(GRect Nade: Nadezone)
					{	
						boolean alive = true;
						if(NadeList.size() > coolwhile)
						{
							alive = NadeList.get(coolwhile).ReturnAlive();
						}
						Nade.move(265 - Megaman.getX(), 0);
						if(Megaman.getBounds().intersects(Nade.getBounds()))
						{
							if(NadeList.size() -1 < coolwhile)
							{
								RunningNade na = new RunningNade();
								add(na);
								NadeList.add(na);
								na.setLocation(Nade.getX() + (Nade.getWidth()/2), Nade.getY() + (Nade.getHeight()/2));
							}
							else if(alive == false)
							{
								NadeList.get(coolwhile).Creation();
								NadeList.get(coolwhile).setLocation(Nade.getX() + (Nade.getWidth()/2), Nade.getY() + (Nade.getHeight()/2));
							}
						}
						else
						{
							if(NadeList.size() > coolwhile)
							{
								NadeList.get(coolwhile).Spawn();
							}
						}
						coolwhile = coolwhile + 1;
					}
					for(GRect TurretGun: TurretGunzone)
					{	
						boolean alive = true;
						if(TurretGunList.size() > coolwhile)
						{
							alive = TurretGunList.get(coolwhile).ReturnAlive();
						}
						TurretGun.move(265 - Megaman.getX(), 0);
						if(Megaman.getBounds().intersects(TurretGun.getBounds()))
						{
							if(TurretGunList.size() -1 < coolwhile)
							{
								TurretGun na = new TurretGun();
								add(na);
								TurretGunList.add(na);
								na.setLocation(TurretGun.getX() + (TurretGun.getWidth()/2), TurretGun.getY() + (TurretGun.getHeight()/2));
							}
							else if(alive == false)
							{
								TurretGunList.get(coolwhile).Creation();
								TurretGunList.get(coolwhile).setLocation(TurretGun.getX() + (TurretGun.getWidth()/2), TurretGun.getY() + (TurretGun.getHeight()/2));
							}
						}
						else
						{
							if(TurretGunList.size() > coolwhile)
							{
								TurretGunList.get(coolwhile).Respawn();
							}
						}
						coolwhile = coolwhile + 1;
					}
					Megaman.move(265 - Megaman.getX(), 0);
				}
			}
			//SIDESCROLLING UP
			if(stopup == false)
			{
				if(Megaman.getY() > 350)
				{
					
					Stage.move(0, 350 - Megaman.getY());
					
					if(BossState == 2)
					{
						QuickMan.move(0, 350 - Megaman.getY());
					}
					if(BossState == 3)
					{
						MetalMan.move(0, 350 - Megaman.getY());
					}
					for(GRect groundPiece : Ground)
					{
						groundPiece.move(0, 350 - Megaman.getY());
					}
					for(GRect check: Check)
					{
						check.move(0, 350 - Megaman.getY());
						if(Megaman.getBounds().intersects(check.getBounds()))
						{
							if(check == Check.get(0) && CheckPoint != 2)
							{
								CheckPoint = 1;
							}
							if(check == Check.get(1))
							{
								CheckPoint = 2;
							}
						}
					}
					for(GRect fall : FallDeath)
					{
						fall.move(0, 350 - Megaman.getY());
					}
					for(GRect block: LeftNo)
					{
						block.move(0, 350 - Megaman.getY());
					}
					for(GRect block: RightNo)
					{
						block.move(0, 350 - Megaman.getY());
					}
					for(GRect block: UpNo)
					{
						block.move(0, 350 - Megaman.getY());
					}
					for(GRect block: DownNo)
					{
						block.move(0, 350 - Megaman.getY());
					}
					for(GRect boss: BossCenter)
					{
						boss.move(0, 350 - Megaman.getY());
					}
					for(Metool mety: MetList)
					{
						mety.move(0, 350 - Megaman.getY());
					}
					for(SniperJoe snipe: SniperList)
					{
						snipe.move(0, 350 - Megaman.getY());
					}
					for(Mosquito mosq: MosquitoList)
					{
						mosq.move(0, 350 - Megaman.getY());
					}
					for(RunningNade nade: NadeList)
					{
						nade.move(0, 350 - Megaman.getY());
					}	
					for(TurretGun tur: TurretGunList)
					{
						tur.move(0, 350 - Megaman.getY());
					}
					for(FlyingShield shi: FlyingShieldList)
					{
						shi.move(0, 350 - Megaman.getY());
					}
					coolwhile = 0;
					for(GRect met: Metzone)
					{	
						boolean alive = true;
						if(MetList.size() > coolwhile)
						{
							alive = MetList.get(coolwhile).ReturnAlive();
						}
						met.move(0, 350 - Megaman.getY());
						if(Megaman.getBounds().intersects(met.getBounds()))
						{
							if(MetList.size() -1 < coolwhile)
							{
								Metool mety = new Metool();
								add(mety);
								MetList.add(mety);
								mety.setLocation(met.getX() + (met.getWidth()/2), met.getY() + (met.getHeight()/2));
							}
							else if(alive == false)
							{
								MetList.get(coolwhile).Creation();
								MetList.get(coolwhile).setLocation(met.getX() + (met.getWidth()/2), met.getY() + (met.getHeight()/2));
							}
						}
						else
						{
							if(MetList.size() > coolwhile)
							{
								MetList.get(coolwhile).Respawn();
							}
						}
						coolwhile = coolwhile + 1;
					}
					coolwhile = 0;
					for(GRect Joe: SniperJoezone)
					{	
						boolean alive = true;
						if(SniperList.size() > coolwhile)
						{
							alive = SniperList.get(coolwhile).ReturnAlive();
						}
						Joe.move(0, 350 - Megaman.getY());
						if(Megaman.getBounds().intersects(Joe.getBounds()))
						{
							if(SniperList.size() -1 < coolwhile)
							{
								SniperJoe snipe = new SniperJoe();
								add(snipe);
								SniperList.add(snipe);
								snipe.setLocation(Joe.getX() + (Joe.getWidth()/2), Joe.getY() + (Joe.getHeight()/2));
							}
							else if(alive == false)
							{
								SniperList.get(coolwhile).Creation();
								SniperList.get(coolwhile).setLocation(Joe.getX() + (Joe.getWidth()/2), Joe.getY() + (Joe.getHeight()/2));
							}
						}
						else
						{
							if(SniperList.size() > coolwhile)
							{
								SniperList.get(coolwhile).Respawn();
							}
						}
						coolwhile = coolwhile + 1;
					}
					coolwhile = 0;
					for(GRect Mos: Mosquitozone)
					{	
						boolean alive = true;
						int i = 0;
						if(MosquitoList.size() > coolwhile)
						{
							alive = MosquitoList.get(coolwhile).ReturnAlive();
						}
						
						Mos.move(0, 350 - Megaman.getY());
						if(Megaman.getBounds().intersects(Mos.getBounds()))
						{
							if(MosquitoList.size() -1 < coolwhile)
							{
								Mosquito mosq = new Mosquito();
								add(mosq);
								MosquitoList.add(mosq);
								mosq.setLocation(Mos.getX() + (Mos.getWidth()/2), Mos.getY() + (Mos.getHeight()/2));
							}
							else if(alive == false)
							{
								MosquitoList.get(coolwhile).Creation();
								MosquitoList.get(coolwhile).setLocation(Mos.getX() + (Mos.getWidth()/2), Mos.getY() + (Mos.getHeight()/2));
							}
						}
						else
						{
							if(MosquitoList.size() > coolwhile)
							{
								MosquitoList.get(coolwhile).Spawn();
							}
						}
						coolwhile = coolwhile + 1;
					}
					coolwhile = 0;
					for(GRect Nade: Nadezone)
					{	
						boolean alive = true;
						if(NadeList.size() > coolwhile)
						{
							alive = NadeList.get(coolwhile).ReturnAlive();
						}
						Nade.move(0, 350 - Megaman.getY());
						if(Megaman.getBounds().intersects(Nade.getBounds()))
						{
							if(NadeList.size() -1 < coolwhile)
							{
								RunningNade na = new RunningNade();
								add(na);
								NadeList.add(na);
								na.setLocation(Nade.getX() + (Nade.getWidth()/2), Nade.getY() + (Nade.getHeight()/2));
							}
							else if(alive == false)
							{
								NadeList.get(coolwhile).Creation();
								NadeList.get(coolwhile).setLocation(Nade.getX() + (Nade.getWidth()/2), Nade.getY() + (Nade.getHeight()/2));
							}
						}
						else
						{
							if(NadeList.size() > coolwhile)
							{
								NadeList.get(coolwhile).Spawn();
							}
						}
						coolwhile = coolwhile + 1;
					}
					for(GRect TurretGun: TurretGunzone)
					{	
						boolean alive = true;
						if(TurretGunList.size() > coolwhile)
						{
							alive = TurretGunList.get(coolwhile).ReturnAlive();
						}
						TurretGun.move(0, 350 - Megaman.getY());
						if(Megaman.getBounds().intersects(TurretGun.getBounds()))
						{
							if(TurretGunList.size() -1 < coolwhile)
							{
								TurretGun na = new TurretGun();
								add(na);
								TurretGunList.add(na);
								na.setLocation(TurretGun.getX() + (TurretGun.getWidth()/2), TurretGun.getY() + (TurretGun.getHeight()/2));
							}
							else if(alive == false)
							{
								TurretGunList.get(coolwhile).Creation();
								TurretGunList.get(coolwhile).setLocation(TurretGun.getX() + (TurretGun.getWidth()/2), TurretGun.getY() + (TurretGun.getHeight()/2));
							}
						}
						else
						{
							if(TurretGunList.size() > coolwhile)
							{
								TurretGunList.get(coolwhile).Respawn();
							}
						}
						coolwhile = coolwhile + 1;
					}
					Megaman.move(0, 350 - Megaman.getY());
				}
			}
			//SIDE SCROLLING DOWN.
			if(stopdown == false)
			{
				if(Megaman.getY() < 100)
				{
					Stage.move(0, 100 - Megaman.getY());
					
					if(BossState == 2)
					{
						QuickMan.move(0, 100 - Megaman.getY());
					}
					if(BossState == 3)
					{
						MetalMan.move(0, 100 - Megaman.getY());
					}
					for(GRect groundPiece : Ground)
					{
						groundPiece.move(0, 100 - Megaman.getY());
					}
					for(GRect check: Check)
					{
						check.move(0, 100 - Megaman.getY());
						if(Megaman.getBounds().intersects(check.getBounds()))
						{
							if(check == Check.get(0) && CheckPoint != 2)
							{
								CheckPoint = 1;
							}
							if(check == Check.get(1))
							{
								CheckPoint = 2;
							}
						}
					}
			
					for(GRect fall : FallDeath)
					{
						fall.move(0, 100 - Megaman.getY());
					}
					for(GRect block: LeftNo)
					{
						block.move(0, 100 - Megaman.getY());
					}
					for(GRect block: RightNo)
					{
						block.move(0, 100 - Megaman.getY());
					}
					for(GRect block: UpNo)
					{
						block.move(0, 100 - Megaman.getY());
					}
					for(GRect block: DownNo)
					{
						block.move(0, 100 - Megaman.getY());
					}
					for(GRect boss: BossCenter)
					{
						boss.move(0, 100 - Megaman.getY());
					}
					for(Metool mety: MetList)
					{
						mety.move(0, 100 - Megaman.getY());
					}
					for(SniperJoe snipe: SniperList)
					{
						snipe.move(0, 100 - Megaman.getY());
					}
					for(Mosquito mosq: MosquitoList)
					{
						mosq.move(0, 100 - Megaman.getY());
					}
					for(RunningNade nade: NadeList)
					{
						nade.move(0, 100 - Megaman.getY());
					}
					for(TurretGun tur: TurretGunList)
					{
						tur.move(0, 100 - Megaman.getY());
					}
					for(FlyingShield shi: FlyingShieldList)
					{
						shi.move(0, 100 - Megaman.getY());
					}
					coolwhile = 0;
					for(GRect met: Metzone)
					{	
						boolean alive = true;
						if(MetList.size() > coolwhile)
						{
							alive = MetList.get(coolwhile).ReturnAlive();
						}
						met.move(350 - Megaman.getX(), 0);
						if(Megaman.getBounds().intersects(met.getBounds()))
						{
							if(MetList.size() -1 < coolwhile)
							{
								Metool mety = new Metool();
								add(mety);
								MetList.add(mety);
								mety.setLocation(met.getX() + (met.getWidth()/2), met.getY() + (met.getHeight()/2));
							}
							else if(alive == false)
							{
								MetList.get(coolwhile).Creation();
								MetList.get(coolwhile).setLocation(met.getX() + (met.getWidth()/2), met.getY() + (met.getHeight()/2));
							}
						}
						else
						{
							if(MetList.size() > coolwhile)
							{
								MetList.get(coolwhile).Respawn();
							}
						}
						coolwhile = coolwhile + 1;
					}
					coolwhile = 0;
					for(GRect Joe: SniperJoezone)
					{	
						boolean alive = true;
						if(SniperList.size() > coolwhile)
						{
							alive = SniperList.get(coolwhile).ReturnAlive();
						}
						Joe.move(0, 100 - Megaman.getY());
						if(Megaman.getBounds().intersects(Joe.getBounds()))
						{
							if(SniperList.size() -1 < coolwhile)
							{
								SniperJoe snipe = new SniperJoe();
								add(snipe);
								SniperList.add(snipe);
								snipe.setLocation(Joe.getX() + (Joe.getWidth()/2), Joe.getY() + (Joe.getHeight()/2));
							}
							else if(alive == false)
							{
								SniperList.get(coolwhile).Creation();
								SniperList.get(coolwhile).setLocation(Joe.getX() + (Joe.getWidth()/2), Joe.getY() + (Joe.getHeight()/2));
							}
						}
						else
						{
							if(SniperList.size() > coolwhile)
							{
								SniperList.get(coolwhile).Respawn();
							}
						}
						coolwhile = coolwhile + 1;
					}
					coolwhile = 0;
					for(GRect Mos: Mosquitozone)
					{	
						boolean alive = true;
						if(MosquitoList.size() > coolwhile)
						{
							alive = MosquitoList.get(coolwhile).ReturnAlive();
						}
						Mos.move(0, 100 - Megaman.getY());
						if(Megaman.getBounds().intersects(Mos.getBounds()))
						{
							if(MosquitoList.size() -1 < coolwhile)
							{
								Mosquito mosq = new Mosquito();
								add(mosq);
								MosquitoList.add(mosq);
								mosq.setLocation(Mos.getX() + (Mos.getWidth()/2), Mos.getY() + (Mos.getHeight()/2));
							}
							else if(alive == false)
							{
								MosquitoList.get(coolwhile).Creation();
								MosquitoList.get(coolwhile).setLocation(Mos.getX() + (Mos.getWidth()/2), Mos.getY() + (Mos.getHeight()/2));
							}
						}
						else
						{
							if(MosquitoList.size() > coolwhile)
							{
								MosquitoList.get(coolwhile).Spawn();
							}
						}
						coolwhile = coolwhile + 1;
					}
					coolwhile = 0;
					for(GRect Nade: Nadezone)
					{	
						boolean alive = true;
						if(NadeList.size() > coolwhile)
						{
							alive = NadeList.get(coolwhile).ReturnAlive();
						}
						Nade.move(0, 100 - Megaman.getY());
						if(Megaman.getBounds().intersects(Nade.getBounds()))
						{
							if(NadeList.size() -1 < coolwhile)
							{
								RunningNade na = new RunningNade();
								add(na);
								NadeList.add(na);
								na.setLocation(Nade.getX() + (Nade.getWidth()/2), Nade.getY() + (Nade.getHeight()/2));
							}
							else if(alive == false)
							{
								NadeList.get(coolwhile).Creation();
								NadeList.get(coolwhile).setLocation(Nade.getX() + (Nade.getWidth()/2), Nade.getY() + (Nade.getHeight()/2));
							}
						}
						else
						{
							if(NadeList.size() > coolwhile)
							{
								NadeList.get(coolwhile).Spawn();
							}
						}
						coolwhile = coolwhile + 1;
					}
					coolwhile = 0;
					for(GRect TurretGun: TurretGunzone)
					{	
						boolean alive = true;
						if(TurretGunList.size() > coolwhile)
						{
							alive = TurretGunList.get(coolwhile).ReturnAlive();
						}
						TurretGun.move(0, 100 - Megaman.getY());
						if(Megaman.getBounds().intersects(TurretGun.getBounds()))
						{
							if(TurretGunList.size() -1 < coolwhile)
							{
								TurretGun na = new TurretGun();
								add(na);
								TurretGunList.add(na);
								na.setLocation(TurretGun.getX() + (TurretGun.getWidth()/2), TurretGun.getY() + (TurretGun.getHeight()/2));
							}
							else if(alive == false)
							{
								TurretGunList.get(coolwhile).Creation();
								TurretGunList.get(coolwhile).setLocation(TurretGun.getX() + (TurretGun.getWidth()/2), TurretGun.getY() + (TurretGun.getHeight()/2));
							}
						}
						else
						{
							if(TurretGunList.size() > coolwhile)
							{
								TurretGunList.get(coolwhile).Respawn();
							}
						}
						coolwhile = coolwhile + 1;
					}
					Megaman.move(0, 100 - Megaman.getY());
				}
			}	
		}
	}
	public void StageSelect()
	{
		State = 1;
		//If the game has just started, then create the stage select
		if(BossState == 0)
		{
			Stages = new StageSelect();
			add(Stages);
			HP = 28;
			Lives = 4;
			CheckPoint = 0;
			
		}
		//If a boss had just died to trigger this, then return to the stage select with that boss dead
		else if(bossdown == 1)
		{
		Stages.setVisible(true);
		Stages.sendToFront();
		Stages.BossKill(BossState);
		Stages.setLocation(0, 0);
		enemyclear();
		HP = 28;
		Lives = 4;
		CheckPoint = 0;
		remove(Stage);
		remove(Megaman);
		remove(Block);
		}
		//If Megaman had just run out of lives to trigger this, then return to the stage select.
		else
		{
			Stages.setVisible(true);
			Stages.sendToFront();
			Stages.BossKill(BossState);
			Stages.setLocation(0, 0);
			enemyclear();
			HP = 28;
			Lives = 4;
			CheckPoint = 0;
			remove(Stage);
			remove(Megaman);
		}
		
	}
	public void ShadowStage()
	{
		//Sets values to needed
		State = 2;
		Pain = 24;
		Direct = 2;
		//HealthBar
		Health = new Healthbar();
		add(Health);
		Health.setLocation(20, 20);
		HP = 28;
		
		//Adds the level
		ShadowStage = new ShadowLevel();
		add(ShadowStage);
		Stage = ShadowStage;
		ShadowStage.setLocation(0, 0);
		Stages.setVisible(false);
		
		Health.sendToFront();
		BossBar = new GImage(MediaTools.loadImage("spritesheets/Misc/Meter/"+ BossHP +".gif"));
		add(BossBar);
		BossBar.setVisible(false);
		BossBar.setSize(BossBar.getWidth() * 2, BossBar.getHeight() * 2);
		BossBar.setLocation(460, 20);
		if(CheckPoint == 0)
		{
		enemyclear();
		}
		
		//Connects the null Arrays to the Arrays from the Level
		Ground = ShadowStage.ReturnArray();
		Check = ShadowStage.ReturnCheck();
		FallDeath = ShadowStage.ReturnFallDeath();
		LeftNo =ShadowStage.ReturnLeft();
		RightNo = ShadowStage.ReturnRight();
		DownNo = ShadowStage.ReturnDown();
		BossCenter = ShadowStage.ReturnBoss();
		Metzone = ShadowStage.ReturnMetzone();
		
//		Creating Megaman
		Megaman = new Megaman();
		add(Megaman);
		if(CheckPoint == 0)
		{
			Megaman.setLocation(432, 403);
		}
		if(CheckPoint == 1)
		{
			Megaman.setLocation(Check.get(0).getX() + (Check.get(0).getWidth()/2), Check.get(0).getY() + (Check.get(0).getHeight()/2));
			Direct = 1;
		}
		if(CheckPoint == 2)
		{
			Megaman.setLocation(Check.get(1).getX() + (Check.get(1).getWidth()/2), Check.get(1).getY() + (Check.get(1).getHeight()/2));
			Direct = 2;
		}
		Megaman.sendToFront();
		
		
	}
	public void ElecStage()
	{
		//Sets to needed values
		State = 2;
		Pain = 24;
		Direct = 2;
		//HealthBar
		Health = new Healthbar();
		add(Health);
		Health.setLocation(20, 20);
		HP = 28;
		
		
		//Adds the level
		ElecStage = new ElecLevel();
		add(ElecStage);
		Stage = ElecStage;
		ElecStage.setLocation(0, 0);
		Stages.setVisible(false);
		
		
		BossBar = new GImage(MediaTools.loadImage("spritesheets/Misc/Meter/"+ BossHP +".gif"));
		add(BossBar);
		BossBar.setVisible(false);
		BossBar.setLocation(460, 20);
		BossBar.setSize(BossBar.getWidth() * 2, BossBar.getHeight() * 2);
		Health.sendToFront();
		
		if(CheckPoint == 0)
		{
		enemyclear();
		}
		
		//Connects the null Arrays to the Arrays from the Level
		Ground = ElecStage.ReturnArray();
		Check = ElecStage.ReturnCheck();
		FallDeath = ElecStage.ReturnFallDeath();
		LeftNo = ElecStage.ReturnLeft();
		RightNo = ElecStage.ReturnRight();
		DownNo = ElecStage.ReturnDown();
		BossCenter = ElecStage.ReturnBoss();
		Metzone = ElecStage.ReturnMetzone();
		SniperJoezone = ElecStage.ReturnSniperzone();
		BallSwingzone = ElecStage.ReturnBallSwingerzone();
		Mosquitozone = ElecStage.ReturnMosquitozone();
		for(Metool Met: MetList)
		{
			Met.sendToFront();
		}
		for(SniperJoe Joe: SniperList)
		{
			Joe.sendToFront();
		}
		for(Mosquito Mos: MosquitoList)
		{
			Mos.sendToFront();
		}
		for(RunningNade Nade: NadeList)
		{
			Nade.sendToFront();
		}
//		Creating Megaman
		Megaman = new Megaman();
		add(Megaman);
		if(CheckPoint == 0)
		{
			Megaman.setLocation(82, 330);
		}
		if(CheckPoint == 1)
		{
			Megaman.setLocation(Check.get(0).getX() + (Check.get(0).getWidth()/2), Check.get(0).getY() + (Check.get(0).getHeight()/2));
			Direct = 1;
		}
		if(CheckPoint == 2)
		{
			Megaman.setLocation(Check.get(1).getX() + (Check.get(1).getWidth()/2), Check.get(1).getY() + (Check.get(1).getHeight()/2));
			Direct = 2;
		}
		Megaman.sendToFront();
		
	}
	public void QuickStage()
	{
		State = 2;
		Pain = 24;
		Direct = 2;
		BossStart = false;
		//HealthBar
		Health = new Healthbar();
		add(Health);
		Health.setLocation(20, 20);
		HP = 28;
		
		QuickStage = new QuickLevel();
		add(QuickStage);
		QuickStage.setLocation(0, 0);
		QuickMan = new QuickMan();
		QuickMan.setLocation(8570, 656);
		add(QuickMan);
		BossBar = new GImage(MediaTools.loadImage("spritesheets/Misc/Meter/"+ BossHP +".gif"));
		add(BossBar);
		BossBar.setVisible(false);
		BossBar.setLocation(472, 20);
		BossBar.setSize(BossBar.getWidth() * 2, BossBar.getHeight() * 2);
		Stages.setVisible(false);
		
		Music = new MP3("sound/Quick.mp3");
		Music.loop();
		
		Health.sendToFront();
		
		if(CheckPoint == 0)
		{
		enemyclear();
		}
		
		//Connects the null Arrays to the Arrays from the Level
		Stage = QuickStage;
		Ground = QuickStage.ReturnArray();
		Check = QuickStage.ReturnCheck();
		FallDeath = QuickStage.ReturnFall();
		LeftNo = QuickStage.ReturnLeft();
		RightNo = QuickStage.ReturnRight();
		DownNo = QuickStage.ReturnDown();
		BossCenter = QuickStage.ReturnBoss();
		
		Metzone = QuickStage.ReturnMetzone();
		SniperJoezone = QuickStage.ReturnSniperzone();
		Mosquitozone = QuickStage.ReturnMosquitozone();
		Nadezone = QuickStage.ReturnNadezone();
		
//		Creating Megaman
		Megaman = new Megaman();
		add(Megaman);
		if(CheckPoint == 0)
		{
			Megaman.setLocation(624, 275);
		}
		if(CheckPoint == 1)
		{
			Megaman.setLocation(Check.get(0).getX() + (Check.get(0).getWidth()/2), Check.get(0).getY() + (Check.get(0).getHeight()/2));
			Direct = 1;
		}
		if(CheckPoint == 2)
		{
			Megaman.setLocation(Check.get(1).getX() + (Check.get(1).getWidth()/2), Check.get(1).getY() + (Check.get(1).getHeight()/2));
			Direct = 2;
		}
		Megaman.sendToFront();
	}
	public void MetalStage()
	{
		State = 2;
		Pain = 24;
		Direct = 2;
		BossStart = false;
		//HealthBar
		Health = new Healthbar();
		add(Health);
		Health.setLocation(20, 20);
		HP = 28;
		
		BossBar = new GImage(MediaTools.loadImage("spritesheets/Misc/Meter/"+ BossHP +".gif"));
		add(BossBar);
		BossBar.setSize(BossBar.getWidth() * 2, BossBar.getHeight() * 2);
		BossBar.setVisible(false);
		
		MetalStage = new MetalLevel();
		add(MetalStage);
		MetalStage.setLocation(0, 0);
		
		MetalMan = new MetalMan();
		MetalMan.setLocation(6035, 1277);
		add(MetalMan);
		
		Stages.setVisible(false);
		
		Health.sendToFront();
		
		if(CheckPoint == 0)
		{
		enemyclear();
		}
		
		Stage = MetalStage;
		Ground = MetalStage.ReturnArray();
		FallDeath = MetalStage.ReturnFallDeath();
		LeftNo = MetalStage.ReturnLeft();
		RightNo = MetalStage.ReturnRight();
		DownNo = MetalStage.ReturnDown();
		BossCenter = MetalStage.ReturnBoss();
		
		Metzone = MetalStage.ReturnMetzone();
		FlyingShieldzone = MetalStage.ReturnFlyingShieldzone();
		TurretGunzone = MetalStage.ReturnTurretGunnerzone();
		
//		Creating Megaman
		Megaman = new Megaman();
		add(Megaman);
		if(CheckPoint == 0)
		{
			Megaman.setLocation(350, 258);
		}
		if(CheckPoint == 1)
		{
			Megaman.setLocation(Check.get(0).getX() + (Check.get(0).getWidth()/2), Check.get(0).getY() + (Check.get(0).getHeight()/2));
			Direct = 1;
		}
		if(CheckPoint == 2)
		{
			Megaman.setLocation(Check.get(1).getX() + (Check.get(1).getWidth()/2), Check.get(1).getY() + (Check.get(1).getHeight()/2));
			Direct = 2;
		}
		Megaman.sendToFront();
	}
	public void KnightStage()
	{
		State = 2;
		Pain = 24;
		Direct = 2;
		BossStart = false;
		//HealthBar
		Health = new Healthbar();
		add(Health);
		Health.setLocation(20, 20);
		HP = 28;
		
		BossBar = new GImage(MediaTools.loadImage("spritesheets/Misc/Meter/"+ BossHP +".gif"));
		add(BossBar);
		BossBar.setVisible(false);
		
		KnightStage = new KnightLevel();
		add(KnightStage);
		KnightStage.setLocation(0, 0);
		Stages.setVisible(false);
		
		Health.sendToFront();
		
		Stage = KnightStage;
		
		if(CheckPoint == 0)
		{
			enemyclear();
		}
		
		Ground = KnightStage.ReturnArray();
		Check = KnightStage.ReturnCheck();
		LeftNo = KnightStage.ReturnLeft();
		RightNo = KnightStage.ReturnRight();
		DownNo = KnightStage.ReturnDown();
		BossCenter = KnightStage.ReturnBoss();
		
		Metzone = KnightStage.ReturnMetzone();
		TurretGunzone = KnightStage.ReturnTurretzone();
		FlyingShieldzone = KnightStage.ReturnFlyingShieldzone();
//		Creating Megaman
		Megaman = new Megaman();
		add(Megaman);
		if(CheckPoint == 0)
		{
			Megaman.setLocation(350, 232);
		}
		if(CheckPoint == 1)
		{
			Megaman.setLocation(Check.get(0).getX() + (Check.get(0).getWidth()/2), Check.get(0).getY() + (Check.get(0).getHeight()/2));
			Direct = 1;
		}
		if(CheckPoint == 2)
		{
			Megaman.setLocation(Check.get(1).getX() + (Check.get(1).getWidth()/2), Check.get(1).getY() + (Check.get(1).getHeight()/2));
			Direct = 2;
		}
		Megaman.sendToFront();
	}
	public void enemyclear()
	{
		
		//Removes all of the creatures that are currently inhabiting the level.
		Metzone.removeAll(Metzone);
		SniperJoezone.removeAll(SniperJoezone);
		Mosquitozone.removeAll(Mosquitozone);
		Nadezone.removeAll(Nadezone);
		TurretGunzone.removeAll(TurretGunzone);
		FlyingShieldzone.removeAll(FlyingShieldzone);
		HoppingEyezone.removeAll(HoppingEyezone);
		BallSwingzone.removeAll(BallSwingzone);
		
		MetList.removeAll(MetList);
		SniperList.removeAll(SniperList);		
		MosquitoList.removeAll(MosquitoList);
		NadeList.removeAll(NadeList);
		TurretGunList.removeAll(TurretGunList);
		FlyingShieldList.removeAll(FlyingShieldList);
		HoppingEyeList.removeAll(HoppingEyeList);
		////BallSwingList.removeAll(BallSwingList);
	}
	
}
