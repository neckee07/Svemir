package svemir;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame {

	private Button pokreni = new Button("Pokreni!");
	private Svemir svemir = new Svemir(this);
	private Generator generator = new Generator(this, svemir);
	
	private Panel donji = new Panel();
	
	
	
	private void populateWindow() {
		
//		Menu bgColorMenu = new Menu("Bg color");
//		MenuItem bgWhite = new MenuItem("white");
//		MenuItem bgGray = new MenuItem("gray");
//		
//		bgColorMenu.add(bgWhite);
//		bgColorMenu.add(bgGray);
//		
//		bgWhite.addActionListener((ae) ->{
//			scene.setBgColor(Color.white);
//			
//		});
//		
//		bgGray.addActionListener((ae)->{
//			scene.setBgColor(Color.gray);
//			
//		});
//		
//		Menu factorMenu = new Menu ("Size");
//		MenuItem small =new MenuItem("3");
//		MenuItem big = new MenuItem("5");
//		
//		factorMenu.add(small);
//		factorMenu.add(big);
//		
//		small.addActionListener((ae)->{
//			scene.setFactor(Integer.parseInt(((MenuItem)ae.getSource()).getLabel()));
//		});
//		
//		big.addActionListener((ae)->{
//			scene.setFactor(Integer.parseInt(((MenuItem)ae.getSource()).getLabel()));
//		});
//		
//		MenuItem quitMenu = new MenuItem("Quit", new MenuShortcut(KeyEvent.VK_Q));
//		
//		quitMenu.addActionListener((ae)->{
//			dispose();
//		});
//		
//		Menu file = new Menu("File");
//		file.add(bgColorMenu);
//		file.add(factorMenu);
//		file.addSeparator();
//		file.add(quitMenu);
//		
//		MenuBar menuBar = new MenuBar();
//		menuBar.add(file);
//		this.setMenuBar(menuBar);
//		
//		add(scene, BorderLayout.CENTER);
//		
//		drawButton.addActionListener((ae) -> {
//			scene.repaint();
//		});
//		
//		Panel buttonPanel = new Panel();
//		
//		Choice chooseShape = new Choice();
//		chooseShape.add("Heart");
//		chooseShape.add("Circle");
//		
//		chooseShape.addItemListener((ie) -> {
//			String name = chooseShape.getSelectedItem();
//			if(name.equals("Heart")) {
//				scene.setShape(new Heart());
//			}else if(name.equals("Circle")) {
//				scene.setShape(new Circle(15));
//			}
//		});
//		
//		List chooseColor = new List(2);
//		chooseColor.add("Black");
//		chooseColor.add("Red");
//		chooseColor.add("Green");
//		
//		chooseColor.select(0);
//		
//		chooseColor.addItemListener((ie) -> {
//			String item = chooseColor.getSelectedItem();
//			if(item.equals("Black")) {
//				scene.setColor(Color.black);
//			}else if(item.equals("Red")) {
//				scene.setColor(Color.red);
//			}else if(item.equals("Green")) {
//				scene.setColor(Color.green);
//			}
//		});
//		
//		buttonPanel.add(new Label ("Shape: "));
//		buttonPanel.add(chooseShape);
//		buttonPanel.add(new Label ("color: "));
//		buttonPanel.add(chooseColor);
//		buttonPanel.add(drawButton);
//		
//		add(buttonPanel, BorderLayout.SOUTH);
//		
//	}
	
	//////////////////////////////////////////////////
		
		pokreni.addActionListener((ae) ->{
			
			
//			Kometa k = new Kometa(10,0,10);
//			Kometa k1 = new Kometa(15,0,5);
//			Kometa k2 = new Kometa(5,0,15);
//			svemir.dodajObjekat(k);
//			svemir.dodajObjekat(k1);
//			svemir.dodajObjekat(k2);
//			
			
			svemir.pokreni();
			generator.start();
			pokreni.setEnabled(false);
		});
		
		donji.add(pokreni, BorderLayout.CENTER);
		
		add(svemir, BorderLayout.CENTER);
		add(donji, BorderLayout.SOUTH);
	}
	
	public Simulator() {
		setBounds(800, 400, 200, 400);
		setResizable(false);
		setTitle("");

		populateWindow();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				svemir.stop();
				generator.interrupt();
				dispose();
			}
			
		});
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Simulator();
	}
}
