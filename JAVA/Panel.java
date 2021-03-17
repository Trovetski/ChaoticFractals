package chaoticFractals;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Panel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Random r = new Random();
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int i;
		for(i=0;i<App.sides;i++){
			g.setColor(Color.BLACK);
			g.drawOval(App.pts[i].x, App.pts[i].y, 5, 5);
			g.setColor(Color.RED);
			g.fillOval(App.pts[i].x, App.pts[i].y, 5, 5);
		}
		
		g.setColor(Color.BLACK);
		int x=291,y=282,t,s=App.sides;
		for(i=0;i<App.points;i++){
			g.fillOval(x, y, 2, 2);
			
			t = r.nextInt(s);
			x = (x+(s-2)*App.pts[t].x)/(s-1);
			y = (y+(s-2)*App.pts[t].y)/(s-1);
		}
	}
}
