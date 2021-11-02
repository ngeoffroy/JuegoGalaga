package PowerUps;

import javax.swing.JLabel;

import Enemigos.Enemigo;
import General.Juego;
import Inteligencia.Inteligencia;
import Inteligencia.InteligenciaCongelar;
import Jugador.Jugador;
import Movimiento.DisparoMovimiento;
import Movimiento.InteligenciaEnemigo;

public class CongelaTiempo extends MagiasTemporales{

	public CongelaTiempo(){
		super();
		nombre = "Congela Tiempo";
	}

	public void efecto(Jugador j) {
		j.setMagia(this);
		Enemigo[] e = (Enemigo[]) Juego.instancia().getEnemigos();
		for(int i=0;i<e.length;i++){
			if(e[i]!=null){
				InteligenciaCongelar inte = new InteligenciaCongelar(e[i]);
				e[i].setInteligencia(inte);
			}
		}
	}
	
	


}
