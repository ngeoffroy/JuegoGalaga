package PowerUps;

import javax.swing.JLabel;

import Disparos.Disparo;
import Jugador.Jugador;

public class CampoKamikaze extends Instantaneos{
	
	public CampoKamikaze(){
		super();
		nombre="Campo Kamikaze";
	}
	
	public void efecto(Jugador j) {
		j.setMejora(this);
	}
}


