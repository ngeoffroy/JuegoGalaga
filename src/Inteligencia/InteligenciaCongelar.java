package Inteligencia;

import Disparos.Disparo;
import Enemigos.Enemigo;

public class InteligenciaCongelar extends Inteligencia{
	protected int contador;
	protected Inteligencia anterior;
	
	public InteligenciaCongelar(Enemigo enemigo){
		this.enemigo = enemigo;
		contador = 0;
		anterior = enemigo.getInteligencia();
	}
	
	public void mover(int dir){
		if(contador==20)
			enemigo.setInteligencia(anterior);
		else
			contador++;
	}
	
	public void disparar(Disparo d) {
		enemigo.setDisparo(d);
	}
	
	public int getContador(){
		return contador;
	}
}
