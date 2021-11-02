package Disparos;

import javax.swing.*;
import java.awt.*;

import Jugador.Jugador;
import Movimiento.DisparoMovimiento;
import Obstaculos.*;
import PowerUps.PowerUp;
import Enemigos.*;
import General.Entidad;
import General.Juego;



public class DisparoEnemigo extends Disparo {

	protected static Icon image; // freedomSensation de alto rendimiento

	public void disparar(Disparo d){
	}
	
    public DisparoEnemigo(){
	}

    public void atacarEnemigo(Enemigo j){

	}
	
	public void atacarNave(Jugador e){
		DisparoMovimiento.getInstance().borrarDisparo(this);
		borrar();
		setAtaco(true);
		e.setVida(e.getVida()-danio);
		if(e.getVida()<0)
			e.setVida(0);
			System.out.println("El daño es " + danio);
			System.out.println("La vida del jugador es " + e.getVida());
			if(e.getVida()<=0)
				e.morir();
		Juego.instancia().actualizarPantalla();	
	}
	
	public void atacarObstaculoJugador(Obstaculo o){
		DisparoMovimiento.getInstance().borrarDisparo(this);
		borrar();
		o.setVida(o.getVida()-danio);
		if(o.getVida()<0)
			o.setVida(0);
		setAtaco(true);
		System.out.println("El jugador metió " + danio + " de daño");
		System.out.println("La vida del obstáculo es " + o.getVida());
		if(o.getVida()<=0)
			o.morirObs();
	}
	
	public void atacarObstaculoEnemigo(Obstaculo o){
		
	}
	
	public void recuperarPowerUp(PowerUp pu){
		
	}

	public void serAtacado(Disparo d) {
		
	}

	public void refrescar() {	}

	public boolean onBorder() {
		return false;
	}

	public void disparar(int x, int y) {	}

	public void disparar(int x, int y, int posx, int posy) {	}

	@Override
	protected Icon image() {
		// TODO Auto-generated method stub
		return image;
	}

}


