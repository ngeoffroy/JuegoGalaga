package Obstaculos;

import javax.swing.ImageIcon;

import Disparos.*;
import General.Entidad;
import General.*;

//**Este obstaculo es el que puede atacar tanto Jugador como Enemigo**

public class ObstaculoJugador extends Obstaculo { 

	public ObstaculoJugador(int v, int x, int y) {
		super(v, x, y);
		image = new ImageIcon(this.getClass().getResource("/Valhalliconos/Nube 2.png"));
		grafico = getGrafico();
		setVida(6);
	}

	public Entidad entidad() {
		return this;
	}

	public void serAtacado(Disparo dis){
		dis.atacarObstaculoJugador(this);
	}


	@Override
	public void disparar(Disparo d) {
		// TODO Auto-generated method stub
		
	}

}
