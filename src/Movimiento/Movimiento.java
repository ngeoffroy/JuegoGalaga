package Movimiento;

import General.*;

public class Movimiento extends Thread{

		private Juego juego;

		public Movimiento(Juego j) {
			this.juego = j;
		}

		public void run() {
			while(Juego.instancia().getEstado()=="Jugando"){
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				juego.moverEnemigos();
			}
		}

}

