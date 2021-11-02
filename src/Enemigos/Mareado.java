package Enemigos;

import javax.swing.ImageIcon;

import Disparos.Disparo;
import General.Juego;
import Inteligencia.*;

public class Mareado extends Enemigo{
	private int puntaje=50;
	protected final int width = 64;
	protected final int height = 33;

	public Mareado(int v, int x, int y) {
		super(v, x, y);
		image = new ImageIcon(this.getClass().getResource("/Valhalliconos/Buscador.png"));
		setPuntaje(this.puntaje);
		setWidth(width);
		setHeight(height);
		inteligencia = new inteligenciaBuscador(this);
		setVida(16);
	}
	
	public void estrategia(){
		if(vida<=vida*0.5){
			inteligencia = new inteligenciaRandom(this);
			grafico.setIcon(new ImageIcon(this.getClass().getResource("/Valhalliconos/Random.png")));
			setWidth(63);
			setHeight(45);
		}		
	}
	
}
