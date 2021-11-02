package Inteligencia;

import Disparos.Disparo;
import Disparos.DisparoEnemigoKamikaze;
import Enemigos.Enemigo;
import General.Juego;

public class inteligenciaBuscador extends Inteligencia{

	public inteligenciaBuscador(Enemigo enemigo){
		this.enemigo = enemigo;
	}
	
	public void disparar(Disparo d) {
		if(!(enemigo.getAtacando())){
			enemigo.setAtacando(true);
			d = new DisparoEnemigoKamikaze();
			d.setProviene(enemigo);
			Juego.instancia().borrarEnemigo(enemigo);
			enemigo.setDisparo(d);
			enemigo.getDisparo().disparar(enemigo.getPos().x, enemigo.getPos().y,(int)Juego.instancia().getJugador().
																		getPos().getX(),(int)Juego.instancia().getJugador().getPos().getY());
		}
	}


	
	
}
