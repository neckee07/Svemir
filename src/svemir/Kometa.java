package svemir;

import java.awt.Color;
import java.awt.Graphics;

public class Kometa extends NebeskoTelo {
	
	int nizx [] = new int[5], nizy [] = new int[5];
	
	public Kometa(int x, int y, int poluprecnik) {
		super(x, y, Color.GRAY, poluprecnik);
		
		double ugao = 2*Math.PI/5;
		double pomeraj = Math.random() * 2*Math.PI;
		for(int i = 0; i<5 ;i++) {
			nizx[i] = x + (int) (poluprecnik * Math.cos(i*ugao + pomeraj));
			nizy[i] = y +(int) (poluprecnik * Math.sin(i*ugao + pomeraj));
		}
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(x).append(" ").append(y).append("\n");
		for (int i = 0; i<5 ; i++) {
			sb.append(nizx[i]).append(" ");
		}
		sb.append("\n");
		for (int i = 0; i<5 ; i++) {
			sb.append(nizy[i]).append(" ");
		}
		sb.append("\n");
		return sb.toString();
	}
	
	@Override
	public void crtaj(Graphics g) {
		
		
		g.translate(0, y);
		g.setColor(boja);
		g.fillPolygon(nizx, nizy, 5);
		g.translate(0, -y);
		
	}
	
	public static void main(String[] args) {
		Kometa k = new Kometa(10,5,15);
		
		System.out.println(k.x + " " + k.y + " " + k.boja + " " + k.poluprecnik + "\n");
		System.out.println(k.toString());
		k.pomeriX(4);
		k.pomeriY(5);
		System.out.println(k.x +" " + k.y);
	}
}


