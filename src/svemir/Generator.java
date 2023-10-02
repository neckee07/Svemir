package svemir;

public class Generator extends Thread {
	
	private Svemir svemir;
	private Simulator owner;
	
	public Generator(Simulator owner,Svemir ovaj) {
		this.owner = owner;
		this.svemir = ovaj;
	}
	
	
	@Override
	public void run() {
		try {
			while(!isInterrupted()) {
				
					sleep(900);
					Kometa k = new Kometa((int)(Math.random()*200), 0,(int) (Math.random()*(30-10) + 10));
					
					svemir.dodajObjekat(k);
					//svemir.repaint();
					
//					System.out.println(k.x +" " + k.y + k.boja.toString());
//					System.out.println(k.toString());
//					//svemir.pomeri();
//					//svemir.repaint();
//					System.out.println(svemir.toString());
				
			}
		} catch (InterruptedException e) {}
		
		
		
	}
	
	

}
