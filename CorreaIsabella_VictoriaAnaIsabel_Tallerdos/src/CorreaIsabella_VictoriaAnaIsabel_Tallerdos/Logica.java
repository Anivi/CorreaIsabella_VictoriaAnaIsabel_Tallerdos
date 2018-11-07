package CorreaIsabella_VictoriaAnaIsabel_Tallerdos;

import java.util.LinkedList;

import processing.core.*;

public class Logica {
	private PApplet app;
	private LinkedList<Modificadores> mod;
	private LinkedList<Automators> ors;
	private LinkedList<Elementos> ele;
	private int pantallas = 0;
	private Saini sai;
	private PImage[] pantalla;

	public Logica(PApplet app) {

		mod = new LinkedList<Modificadores>();
		ors = new LinkedList<Automators>();
		ele = new LinkedList<Elementos>();
		this.app = app;
		pantalla = new PImage[4];
		pantalla[0] = app.loadImage("comenzar1.png");
		pantalla[1] = app.loadImage("fondo.png");
		pantalla[2] = app.loadImage("perdiste.png");
		pantalla[3] = app.loadImage("ganaste.png");
		for (int i = 0; i < 6; i++) {
			ors.add(new Automators(app));
		}
		for (int i = 0; i < ors.size(); i++) {
		ors.get(i).start();	
		}
		sai = new Saini(app, 0, 0);
		sai.start();
		
	}

	public void pintar() {

		switch (pantallas) {

		case 0:
			app.imageMode(app.CORNER);
			app.image(pantalla[0], 0, 0);
			break;

		case 1:
			app.imageMode(app.CORNER);
			app.image(pantalla[1], sai.getCamx(), sai.getCamy());
			app.fill(255);
			app.ellipse(1193, 691, 80, 80);
			sai.pintar();
			for (int i = 0; i < ors.size(); i++) {
				ors.get(i).pintar();
				ors.get(i).mover();
			}

			break;
		case 2:
			app.imageMode(app.CORNER);
			app.image(pantalla[2], 0, 0);

			break;
		case 3:
			app.imageMode(app.CORNER);
			app.image(pantalla[3], 0, 0);
			app.fill(255);
			app.ellipse(1193, 691, 80, 80);
			break;

		}

	}

	public void coger() {

	}

	public void mouse() {

		if (app.mouseX >= 286 && app.mouseX <= 528 && app.mouseY >= 568 && app.mouseY <= 655 && pantallas == 0) {
			pantallas = 1;
		}
		if (app.dist(app.mouseX, app.mouseY, 1193, 691) < 40 && pantallas == 3) {
			pantallas = 2;
		}
		if (app.dist(app.mouseX, app.mouseY, 1193, 691) < 40 && pantallas == 1) {
			pantallas = 3;
		}

		System.out.println(app.mouseX + " " + app.mouseY);
	}

	public void tecla() {
		sai.mover();
	}
	
	public void soltar() {
		sai.noMover();
	}
}
