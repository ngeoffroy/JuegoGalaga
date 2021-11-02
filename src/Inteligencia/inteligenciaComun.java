package Inteligencia;

import Disparos.Disparo;
import Enemigos.*;

public class inteligenciaComun extends Inteligencia{
	

	public inteligenciaComun(Enemigo enemigo){
		this.enemigo = enemigo;
	}

	public void disparar(Disparo d) {
			enemigo.setDisparo(d);
			enemigo.getDisparo().disparar(enemigo.getPos().x,enemigo.getPos().y);
	}
	
}
