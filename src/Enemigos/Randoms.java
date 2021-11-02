package Enemigos;

import javax.swing.ImageIcon;
import Inteligencia.inteligenciaComun;
import Inteligencia.inteligenciaRandom;

public class Randoms extends Enemigo{
	private int puntaje=50;
	protected final int width = 63;
	protected final int height = 45;
	
	public Randoms(int v, int x, int y){
		super(v,x,y);
		image = new ImageIcon(this.getClass().getResource("/Valhalliconos/Random.png"));
		setPuntaje(this.puntaje);
		setWidth(width);
		setHeight(height);
		inteligencia = new inteligenciaRandom(this);
		setVida(10);
	}

}
