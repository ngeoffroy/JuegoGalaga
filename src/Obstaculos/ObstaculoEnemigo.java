package Obstaculos;

import javax.swing.ImageIcon;
import Disparos.*;
import General.Entidad;

//**Este obstaculo es el que puede atacar tanto Jugador.**

public class ObstaculoEnemigo extends Obstaculo{
	public ObstaculoEnemigo(int v, int x, int y) {
		super(v, x, y);
		image = new ImageIcon(this.getClass().getResource("/Valhalliconos/Nube.png"));
		setVida(6);
	}

	public Entidad entidad() {
		return this;
	}

	public void serAtacado(Disparo dis){
		dis.atacarObstaculoEnemigo(this);
	}


	@Override
	public void disparar(Disparo d) {
		
	}

	
}