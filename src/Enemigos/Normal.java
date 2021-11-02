package Enemigos;

import Disparos.Disparo;

import java.util.Random;

import javax.swing.ImageIcon;
import General.*;
import Inteligencia.*;

public class Normal extends Enemigo{
	private int puntaje=50;
	protected final int width = 64;
	protected final int height = 55;

	public Normal(int v, int x, int y) {
		super(v, x, y);
		image = new ImageIcon(this.getClass().getResource("/Valhalliconos/Enemigo Normal.png"));
		setPuntaje(this.puntaje);
		setWidth(width);
		setHeight(height);
		inteligencia = new inteligenciaComun(this);
		setVida(10);
	}
	
	public void estrategia(){
		Random r = new Random();
		if(vida<=vida*0.2&&r.nextInt(100)<=5){
			grafico.setIcon(new ImageIcon(this.getClass().getResource("/Valhalliconos/Buscador.png")));
			setWidth(64);
			setHeight(33);
			inteligencia = new inteligenciaBuscador(this);
		}
	}
	
}
