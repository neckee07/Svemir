package svemir;

import java.awt.Color;
import java.awt.Graphics;

public class NebeskoTelo extends Objekat {
	
	protected int poluprecnik;

	public NebeskoTelo(int x, int y, Color boja, int poluprecnik) {
		super(x, y, boja);
		this.poluprecnik = poluprecnik;
		
		
	}

	@Override
	public void crtaj(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
