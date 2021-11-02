package Disparos;

import Enemigos.Buscador;
import Enemigos.Enemigo;
import Enemigos.Normal;
import General.Entidad.*;
import Jugador.Jugador;

public interface DisparoFactoryMethod {
	public Disparo crearDisparo(Jugador e);
	public Disparo crearDisparo(Enemigo e);
}
