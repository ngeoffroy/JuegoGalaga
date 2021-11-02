package PowerUps;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparos.Disparo;
import Jugador.*;

public class Pocion extends Instantaneos {
	protected int recuperar=10;
	protected JLabel image;
	
	public Pocion(){
		super();
		new ImageIcon(this.getClass().getResource("/Valhalliconos/corazon.png"));
		nombre="Pocion";
	}
	
	public void efecto(Jugador j){
		int v= j.getVida();
		j.setVida(v+15);
	}

}

