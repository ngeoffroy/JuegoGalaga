package PowerUps;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import General.Juego;
import Jugador.Jugador;

public class SuperMisil extends MagiasTemporales{
	protected int cantDisparos=10;
	 
  	public SuperMisil(){
		super();
		nombre="Super Misil";
		image = new ImageIcon(this.getClass().getResource("/Valhalliconos/Disparo 2.png"));
	}

	@Override
	public void efecto(Jugador j) {
		j.getDisparo().getGrafico().setIcon(image);
		j.getDisparo().setDanio(4);
		cantDisparos--;
		if(cantDisparos==0){
			j.setMagia(null);
		}
	}  
	
}
