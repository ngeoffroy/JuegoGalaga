package Movimiento;

import Disparos.Disparo;
import Disparos.DisparoEnemigoKamikaze;
import Disparos.DisparoEnemigoNormal;
import General.Entidad;
import General.Juego;
import Obstaculos.Obstaculo;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingDeque;

import javax.swing.JLabel;

public class DisparoMovimiento extends Thread {

	private static DisparoMovimiento instancia;
	public static DisparoMovimiento getInstance(){
		if(instancia==null)
		{
			instancia = new DisparoMovimiento();
			instancia.start();
		}
		return instancia;
	}

	private Collection<Disparo> disparos;
	private Queue<Disparo> esperanParaAgregar, esperanParaBorrar;
	private Vector<Entidad> personajes;
	private Vector<Obstaculo> obstaculos;

	public synchronized void agregarDisparo(Disparo disparo){
		esperanParaAgregar.add(disparo);
	}

	public synchronized void borrarDisparo(Disparo disparo)
	{
		esperanParaBorrar.add(disparo);
	}
	
	public synchronized void agregarVectores(Vector<Entidad> p){
		personajes = p;
	}
	
	public synchronized void agregarVectorObs(Vector<Obstaculo> o){
		obstaculos=o;
	}
	
	public void verificarColision(Disparo d){
		for(int k=0; k<personajes.size();k++)
			if(intersects(d.getGrafico(),personajes.get(k).getGrafico())){
					personajes.get(k).serAtacado(d);
			}
	}
	
	public void verificarColisionObstaculos(Disparo d){
		for(int k=0; k<obstaculos.size();k++){
			if(intersects(d.getGrafico(),obstaculos.get(k).getGrafico())){
				obstaculos.get(k).serAtacado(d);
			}
		}
	}
	
	private boolean intersects(JLabel testa, JLabel testb){
	    Area areaA = new Area(testa.getBounds());
	    Area areaB = new Area(testb.getBounds());

	    return areaA.intersects(areaB.getBounds2D());
	}


	
	private DisparoMovimiento() {
		disparos = new LinkedBlockingDeque<>();
		esperanParaAgregar = new LinkedBlockingDeque<>();
		esperanParaBorrar = new LinkedBlockingDeque<>();
		//lista optimizada para ser usada por varios hilos
	}

	private synchronized void checkQueues()
	{
		while(!esperanParaBorrar.isEmpty()){
			disparos.remove(esperanParaBorrar.remove());
		}
		while(!esperanParaAgregar.isEmpty()){
			disparos.add(esperanParaAgregar.remove());
		}
	}

	public void run(){
		boolean TRUE = true;
		while(TRUE){
			checkQueues();
			try {
				Thread.sleep(90);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(Disparo d : disparos){
				d.refrescar();
				verificarColision(d);
				verificarColisionObstaculos(d);
				if(d.onBorder()){
					esperanParaBorrar.add(d);
					d.borrar();
				}
			}
		}
	}
}
