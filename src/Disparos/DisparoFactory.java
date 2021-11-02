package Disparos;

import Enemigos.Buscador;
import Enemigos.Enemigo;
import Enemigos.Normal;
import General.Entidad;
import Jugador.Jugador;

public class DisparoFactory implements DisparoFactoryMethod{
	
	public Disparo crearDisparo(Jugador e){
		Disparo d = new DisparoJugador();
		return d;
	}
	
	public Disparo crearDisparo(Enemigo e){
		Disparo d= new DisparoEnemigoNormal();
		return d;
	}


	
}
