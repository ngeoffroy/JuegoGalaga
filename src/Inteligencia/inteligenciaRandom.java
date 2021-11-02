package Inteligencia;

import java.util.Random;

import javax.swing.ImageIcon;

import Disparos.Disparo;
import Disparos.DisparoEnemigoKamikaze;
import Enemigos.Enemigo;
import General.Juego;


public class inteligenciaRandom extends Inteligencia{

	public inteligenciaRandom(Enemigo e){
		this.enemigo = e;
	}
	
	public void disparar(Disparo d) {
		if(!(enemigo.getAtacando())){
			enemigo.setAtacando(true);
			d= new DisparoEnemigoKamikaze();
			d.setProviene(enemigo);
			d.getGrafico().setIcon(new ImageIcon(this.getClass().getResource("/Valhalliconos/Random.png")));
			d.setWidth(63);
			d.setHeight(45);
			Juego.instancia().borrarEnemigo(enemigo);
			Random r = new Random();
			enemigo.setDisparo(d);
			enemigo.getDisparo().disparar(enemigo.getPos().x,enemigo.getPos().y,r.nextInt(240),365);
		}
	}

	
}
