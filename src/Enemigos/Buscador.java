package Enemigos;

import javax.swing.ImageIcon;

import Inteligencia.*;

public class Buscador extends Enemigo{
	
	private int puntaje=50;
	protected final int width = 64;
	protected final int height = 33;

	public Buscador(int v, int x, int y) {
		super(v, x, y);
		image = new ImageIcon(this.getClass().getResource("/Valhalliconos/Buscador.png"));
		setPuntaje(this.puntaje);
		setWidth(width);
		setHeight(height);
		inteligencia= new inteligenciaBuscador(this);
		setVida(12);
	}
	
	
}
