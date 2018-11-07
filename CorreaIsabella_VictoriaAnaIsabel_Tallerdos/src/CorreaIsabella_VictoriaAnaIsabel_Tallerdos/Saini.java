package CorreaIsabella_VictoriaAnaIsabel_Tallerdos;

import processing.core.*;

public class Saini extends Thread {

	private PVector vel;
	private PVector pos;
	private int puntaje;
	private PApplet app;
	private int camx = 0;
	private int camy = -700;
	private PImage[] sai;
	private int sain;
	private int mover;

	public Saini(PApplet app, float x, float y) {
		this.app = app;
		pos = new PVector(x, y);
		vel = new PVector(2, 2);
		mover = 0;
		// sai = app.loadImage("saini.png");
		sai = new PImage[3];
		sain = 1;
		for (int i = 0; i < sai.length; i++) {
			sai[i] = app.loadImage("saini" + (i + 1) + ".png");
		}

	}

	public void pintar() {
		app.fill(255);
		// app.ellipse(pos.x, pos.y, 50, 50);
		switch (sain) {
		case 1:
			app.image(sai[0], pos.x, pos.y);
			break;
		case 2:
			app.image(sai[1], pos.x, pos.y);
			break;
		case 3:
			app.image(sai[2], pos.x, pos.y);
			break;
		}
		switch (mover) {
		case 0 :
			break;
		case 1:
			if (pos.y - 40 >= 40) {
			pos.y -= 2;
			}else {
				if(camy<=-40)
				camy += 2;
			}
			break;
		case 2:
			if (pos.y + 40 <= app.height - 80) {
			pos.y += 2;
			}else {
				if(camy>=1400)
				camy -= 2;
			}
			break;
		case 3:
			if (pos.x - 50 >= 0) {
			pos.x -= 2;
			}else {
				if(camx<= -5)
				camx += 2;
		}
			break;
		case 4:
			if (pos.x + 50 <= app.width - 50) {
			pos.x += 2;
			}else {
				if(camx>= -1200)
				camx -= 2;
			}
			break;
		}
//		app.image(sai[2], pos.x, pos.y);
	}

	public void mover() {
	
		switch (app.keyCode) {
		case PApplet.UP:
			sain = 1;
			mover=1;
			break;
		case PApplet.DOWN:
			sain = 1;
			mover=2;
			break;
		case PApplet.RIGHT:
			sain = 2;
			mover=4;
			break;
		case PApplet.LEFT:
			sain = 3;
			mover=3;
			break;
		}
		
//		if (app.keyPressed == true) {
//			if (app.keyCode == app.UP) {
//				sain = 1;
//				if (pos.y - 40 >= 40) {
//					pos.y -= vel.y;
//				} else {
//					camy += 2;
//				}
//
//			}
//			if (app.keyCode == app.DOWN) {
//				sain = 1;
//				if (pos.y + 40 <= app.height - 40) {
//					pos.y += vel.y;
//				} else {
//					camy -= 2;
//				}
//			}
//			if (app.keyCode == app.LEFT) {
//				sain = 3;
//				if (pos.x - 50 >= 50) {
//					pos.x -= vel.x;
//				} else {
//					camx += 2;
//				}
//			}
//			if (app.keyCode == app.RIGHT) {
//				sain = 2;
//				if (pos.x + 50 <= app.width - 50) {
//					pos.x += vel.x;
//
//				} else {
//					camx -= 2;
//				}
//			}
//		}
	}
	public void noMover() {
if(app.keyPressed ==false)
		mover = 0;
	}

	public void run() {

	}

	public int getCamx() {
		return camx;
	}

	public void setCamx(int camx) {
		this.camx = camx;
	}

	public int getCamy() {
		return camy;
	}

	public void setCamy(int camy) {
		this.camy = camy;
	}

	
}
