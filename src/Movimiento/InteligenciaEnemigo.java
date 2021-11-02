package Movimiento;

import java.util.Random;

import javax.swing.Icon;

import Enemigos.Enemigo;
import General.Juego;

public class InteligenciaEnemigo extends Thread{

	private static Juego j;
	private static InteligenciaEnemigo instancia;
	
	public static InteligenciaEnemigo getInstance(){
		if(instancia==null)
		{
			instancia = new InteligenciaEnemigo();
			j= Juego.instancia();
			instancia.start();
		}
		return instancia;
	}

	
	public void run(){
		while(Juego.instancia().getEstado()=="Jugando"){
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i=0; i<j.getEnemigos().length;i++){
				if(j.obtenerEnemigoEnPosicion(i)!=null){
					Random r= new Random();
					int n= r.nextInt(3);
					if(n==1)
						j.dispararEnemigo((Enemigo)j.obtenerEnemigoEnPosicion(i));
				}
			}
		}
	}
	
}
