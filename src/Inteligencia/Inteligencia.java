package Inteligencia;

import Disparos.Disparo;
import Enemigos.Enemigo;

public abstract class Inteligencia {
	protected Enemigo enemigo;
	
	public void mover(int dir){
		switch (dir) {
		case 0 : //Arriba
			enemigo.getPos().setLocation(enemigo.getPos().x, enemigo.getPos().y - enemigo.getVelocidad());
			if(enemigo.getPos().y<0)
				enemigo.getPos().setLocation(enemigo.getPos().x, 0);
			break;
		case 1 : //Abajo
			enemigo.getPos().setLocation(enemigo.getPos().x, enemigo.getPos().y + enemigo.getVelocidad());
			if(enemigo.getPos().y>175)
				enemigo.getPos().setLocation(enemigo.getPos().x, 175);
			break;
		case 2 : //Izquierda
			enemigo.getPos().setLocation(enemigo.getPos().x - enemigo.getVelocidad(), enemigo.getPos().y);
			if(enemigo.getPos().x<0)
				enemigo.getPos().setLocation(0, enemigo.getPos().y);
			break;
		case 3 : //Derecha
			enemigo.getPos().setLocation(enemigo.getPos().x + enemigo.getVelocidad(), enemigo.getPos().y);
			if(enemigo.getPos().x>220)
				enemigo.getPos().setLocation(220, enemigo.getPos().y);
			break;
		}
	
	
		enemigo.getGrafico().setBounds(enemigo.getPos().x, enemigo.getPos().y, enemigo.getWidth(), enemigo.getHeigth()); 
	}
	
	public abstract void disparar(Disparo d);
	
	
}
