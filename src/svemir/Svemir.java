package svemir;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Svemir extends Canvas implements Runnable {
	
	private Color bgBoja = Color.BLACK;
	private ArrayList<NebeskoTelo> niztela = new ArrayList<>();
	private Thread thread;
	private NebeskoTelo telo;
	private Simulator owner;
	
	
	public Svemir(Simulator o) {
		this.setBackground(bgBoja);
		this.owner = o;
		
	}
	
	public synchronized void dodajObjekat(NebeskoTelo nt) {
		niztela.add(nt);
		
	}
	
	public synchronized void pomeri() {
		for(NebeskoTelo nt:niztela) {
			nt.pomeriY(5);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		
		
		
		
		synchronized(this) {
			for(NebeskoTelo k : niztela) {
			
				
				//g.translate(0, k.dohvY());
				//g.setColor(k.boja);
				k.crtaj(g);
			}
		}
		
		
		
	}
	
	public void pokreni() {
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void finish() {
		if(thread != null) {
			thread.interrupt();
		}
		while(thread != null) {
			try {
				wait();
			} catch (InterruptedException e) { 
			}
		}
	}
	
	public void stop() {
		if(thread != null)
			thread.interrupt();
	}
	
	public void run() {
		try {
				
				while(!thread.isInterrupted()) {
					
					Thread.sleep(100);
					
					
					
					synchronized(this) {
						pomeri();
						repaint();
					}
					
					
					
				}
				
		} catch (InterruptedException e) {
		}
		
		synchronized(this) {
			thread=null;
			notify();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<niztela.size();i++) {
			sb.append(niztela.get(i).toString()).append(" ");
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		
		/*Svemir s = new Svemir();
		Kometa k = new Kometa(10,5,10);
		Kometa k1 = new Kometa(15,10,5);
		Kometa k2 = new Kometa(5,0,15);
		s.dodajObjekat(k);
		s.dodajObjekat(k1);
		s.dodajObjekat(k2);
		System.out.println(s.niztela.size() + "\n");
		System.out.println(s.toString());*/
		
		
	}
	
}
