import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import ProcessingManagers.TimeManager;
import Projectiles.*;
import Screen.Screen;
import Shapes.*;
import Constants.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int i=0;
		String line;
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ex = Integer.parseInt(st.nextToken());
		int ey = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		Vector<String> proiectil = new Vector<String>(N);
		Vector<Integer> ref = new Vector<Integer>(N);
		Vector<Integer> hour = new Vector<Integer>(N);
		Vector<Integer> minute = new Vector<Integer>(N);
		Vector<Integer> second = new Vector<Integer>(N);
		Vector<Integer> dist = new Vector<Integer>(N);
		Vector<Integer> px = new Vector<Integer>(N);
		Vector<Integer> py = new Vector<Integer>(N);
		
		while ((line = br.readLine()) != null) {
			st = new StringTokenizer(line," :");
			while (st.hasMoreElements()) {
				
				proiectil.add(i, st.nextToken());
				ref.add(i, Integer.parseInt(st.nextToken()));
				hour.add(i, Integer.parseInt(st.nextToken()));
				minute.add(i, Integer.parseInt(st.nextToken()));
				second.add(i, Integer.parseInt(st.nextToken()));
				dist.add(i, Integer.parseInt(st.nextToken()));
				px.add(i, Integer.parseInt(st.nextToken()));
				py.add(i, Integer.parseInt(st.nextToken()));
				i++;
				
			}
		}
		br.close();
		
		Screen screen = new Screen(ex,ey);
		for( i=0; i<N; i++ ) {
			
			Point shooterPosition = new Point(px.elementAt(i), py.elementAt(i));
			TimeManager time = new TimeManager();
			time.setHour(hour.elementAt(i));
			time.setMinute(minute.elementAt(i));
			time.setSecond(second.elementAt(i));
			
			switch(proiectil.elementAt(i)) {
			case ProjectileNames.CANNISTER_SHOT : {
				Dreptunghi dreptunghi = new Dreptunghi();
				CanisterShot cs = new CanisterShot(screen, ref.elementAt(i), time, dreptunghi, shooterPosition);
				cs.changeProjectile(dist.elementAt(i));
				break;
			}
			case ProjectileNames.CARCASS : {
				Patrat patrat = new Patrat();
				Carcass ca = new Carcass(screen, ref.elementAt(i), time, patrat, shooterPosition);
				ca.changeProjectile(dist.elementAt(i));
				break;
			}
			case ProjectileNames.CHAIN_SHOT : {
				Triunghi triunghi = new Triunghi();
				ChainShot chs = new ChainShot(screen, ref.elementAt(i), time, triunghi, shooterPosition);
				chs.changeProjectile(dist.elementAt(i));
				break;
			}
			case ProjectileNames.HEATED_SHOT : {
				Romb romb = new Romb();
				HeatedShot hs = new HeatedShot(screen, ref.elementAt(i), time, romb, shooterPosition);
				hs.changeProjectile(dist.elementAt(i));
				break;
			}
			case ProjectileNames.SHRAPNEL : {
				Patrat patrat = new Patrat();
				Shrapnel sh = new Shrapnel(screen, ref.elementAt(i), time, patrat, shooterPosition);
				sh.changeProjectile(dist.elementAt(i));
				break;
			}
			case ProjectileNames.SIMPLE_SHELL : {
				Punct punct = new Punct();
				SimpleShell s = new SimpleShell(screen, ref.elementAt(i), time, punct, shooterPosition);
				s.changeProjectile(dist.elementAt(i));
				break;
			}
			case ProjectileNames.SPIDER_SHOT : {
				Dreptunghi dreptunghi = new Dreptunghi();
				SpiderShot ss = new SpiderShot(screen, ref.elementAt(i), time, dreptunghi, shooterPosition);
				ss.changeProjectile(dist.elementAt(i));
				break;
			}
			case ProjectileNames.TRI_GRAPE_SHOT : {
				Triunghi triunghi = new Triunghi();
				TriGrapeShot tgs = new TriGrapeShot(screen, ref.elementAt(i), time, triunghi, shooterPosition);
				tgs.changeProjectile(dist.elementAt(i));
				break;
			}
			}
		}
		
		File newfile = new File(args[0] + "_out");
	    FileWriter fw = new FileWriter(newfile);
	    
	    for(i=0; i<ex; i++) {
	    	for(int j=0; j<ey; j++) {
	    		fw.write(screen.matrix[i][j]);
	    	}
	    	fw.write(System.getProperty("line.separator"));
	    }
	    fw.close();
	    
	}
}