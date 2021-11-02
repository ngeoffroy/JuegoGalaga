package Enemigos;

import General.*;
import Inteligencia.Inteligencia;
import PowerUps.CampoKamikaze;
import PowerUps.*;

import java.util.Random;

import Disparos.*;

public abstract class Enemigo extends Entidad{

	protected int vida;
	protected boolean esta_vivo;
	protected PowerUp recompensa;
	protected Inteligencia inteligencia;
	protected boolean atacando;

	
	public Enemigo(int v, int x, int y) {
		super(v, x, y);
		setDisparo(new DisparoEnemigo());
		esta_vivo = true;
		recompensa=null;
		atacando = false;
	}
	
	public void mover(int dir){	
		inteligencia.mover(dir);
	}
	
	public int destruir(){
		return puntaje;
	}
	
	public void DisparoRecibido() {
		vida--;
	}

	
	public void disparar(Disparo d) {
		inteligencia.disparar(d);
	}
	
	


	public void serAtacado(Disparo dis)
	{
		dis.atacarEnemigo(this);
	}

	public void morir(){
		Juego.instancia().eliminarEnemigo(this);
		Random r= new Random();
		int n= r.nextInt(5);
		if(n==0){
			System.out.println("¡Enhorabuena!¡Has agarrado una pocion! Tu vida pasará a ser de 15");
			recompensa= new Pocion();
			Juego.instancia().getJugador().setMejora(recompensa);
			recompensa.efecto(Juego.instancia().getJugador());
			}
		if(n==1)
			{
			System.out.println("¡Enhorabuena!¡Has agarrado un campo kamikaze! Ahora estarás protegido ante un ataque kamikaze");
			recompensa= new CampoKamikaze();
			Juego.instancia().getJugador().setMejora(recompensa);
			recompensa.efecto(Juego.instancia().getJugador());
			}
		if(n==2){
			System.out.println("¡Enhorabuena!¡Has agarrado un super misil! Tu daño aumentarà drasticamente");
			recompensa= new SuperMisil();
			Juego.instancia().getJugador().setMagia(recompensa);
			recompensa.efecto(Juego.instancia().getJugador());
		}
		if(n==3){
			System.out.println("¡Enhorabuena!¡Has agarrado un congela tiempo! El tiempo se congelará durante 8 segundos");
			recompensa= new CongelaTiempo();
			Juego.instancia().getJugador().setMagia(recompensa);
			recompensa.efecto(Juego.instancia().getJugador());
		}
	}

	public void estrategia(){
		
	}

	public Inteligencia getInteligencia(){
		return inteligencia;
	}

	public void setInteligencia(Inteligencia i) {
		this.inteligencia = i;
		
	}
	
	public void setAtacando(boolean a){
		atacando = a;
	}
	
	public boolean getAtacando(){
		return atacando;
	}
}
