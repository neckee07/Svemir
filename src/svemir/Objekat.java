package svemir;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Objekat{
	
	protected int x, y;
	
	protected Color boja;

	public int dohvX() {
		return x;
	}



	public int dohvY() {
		return y;
	}

	public void pomeriX(int pomeraj) {
		if(pomeraj<0) {
			return;
		}
		x += pomeraj;
	}
	
	public void pomeriY(int pomeraj) {
		if(pomeraj<0) {
			return;
		}
		
		y += pomeraj;
	}

	public Objekat(int x, int y, Color boja) {
		super();
		this.x = x;
		this.y = y;
		this.boja = boja;
	}


	


	public abstract void crtaj(Graphics g);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
