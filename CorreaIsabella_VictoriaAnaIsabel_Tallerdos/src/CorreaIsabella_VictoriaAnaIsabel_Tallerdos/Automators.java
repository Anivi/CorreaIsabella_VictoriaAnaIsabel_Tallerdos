package CorreaIsabella_VictoriaAnaIsabel_Tallerdos;

import java.util.*;

import processing.core.*;

public class Automators extends Thread{

	private PApplet app;
	private PVector pos;
	private PVector vel;
	private int puntaje;
	private int direccion;
	private PImage[] aut1;
	private PImage[] aut2;
	private PImage[] aut3;
	private int auto;
	private int tipo;
	
	public Automators(PApplet app) {
			this.app = app;
			pos = new PVector (app.random(app.width),app.random(app.height));
			vel = new PVector (2,2);
			aut1 = new PImage[3];
			aut2 = new PImage[3];
			aut3 = new PImage[3];
			auto = 1;
			for (int i = 0; i < aut1.length; i++) {
				aut1[i] = app.loadImage("azul" + (i + 1) + ".png");
				aut2[i] = app.loadImage("rojo" + (i + 1) + ".png");
				aut3[i] = app.loadImage("verde" + (i + 1) + ".png");
			}
			tipo = (int) app.random(0, 3);
			direccion = (int) app.random(1, 5);
	}
	public void pintar() {
		if(tipo == 0) {
		switch (auto) {
		case 1:
			app.image(aut1[0], pos.x, pos.y);
			break;
		case 2:
			app.image(aut1[1], pos.x, pos.y);
			break;
		case 3:
			app.image(aut1[2], pos.x, pos.y);
			break;
		}
	}
		if(tipo == 1) {
			switch (auto) {
			case 1:
				app.image(aut2[0], pos.x, pos.y);
				break;
			case 2:
				app.image(aut2[1], pos.x, pos.y);
				break;
			case 3:
				app.image(aut2[2], pos.x, pos.y);
				break;
			}
		}
		if(tipo == 2) {
			switch (auto) {
			case 1:
				app.image(aut3[0], pos.x, pos.y);
				break;
			case 2:
				app.image(aut3[1], pos.x, pos.y);
				break;
			case 3:
				app.image(aut3[2], pos.x, pos.y);
				break;
			}
		}
	}
	
	public void mover() {
		switch(direccion) {
		case 1:
			pos.y += vel.y;
			auto = 1;
			break;
		case 2:
			pos.y -= vel.y;
			auto = 1;
			break;
		case 3:
			pos.x -= vel.x;
			auto = 3;
			break;
		case 4:
			pos.x += vel.x;
			auto = 2;
			break;
			
		}
		if(app.frameCount % 30== 0) {
			direccion = (int)app.random(1,5);
		}
	}
	public void run() {
	}
	public void validar() {
		
	}
}
