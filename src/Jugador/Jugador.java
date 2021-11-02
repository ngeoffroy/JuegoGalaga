package Jugador;

import javax.swing.ImageIcon;



import General.*;
import PowerUps.PowerUp;
import Disparos.*;

public class Jugador extends Entidad{
	protected final int width = 43;
	protected final int height = 64;
	protected boolean esta_vivo;
	protected int score;
	protected PowerUp mejora;
	protected PowerUp magia;

	public Entidad entidad() {
		return this;
	}

	public Jugador(int v, int x, int y){
		super(v,x,y);
		image = new ImageIcon(this.getClass().getResource("/Valhalliconos/Jugador Rojo.png"));
		vida = 10;
		setDisparo(new DisparoJugador());
		esta_vivo = true;
		score = 0;
		setWidth(width);
		setHeight(height);
		tipo = "Jugador";
		magia=null;
		mejora=null;
	}
	
	public void mover(int dir){	
		switch (dir) {
			case 1 : //Izquierda
				pos.setLocation(pos.x - velocidad, pos.y);
				if(pos.x<0)
					pos.setLocation(0, pos.y);
				break;
			case 2 : //Derecha
				pos.setLocation(pos.x + velocidad, pos.y);
				if(pos.x>240)
					pos.setLocation(240, pos.y);
				break;
		}
		cambiarGrafico(dir);
		
	}
	
	public void DisparoRecibido() {
		vida++;
	}

	
	public void disparar(Disparo d) {
		gun = d;
		if(magia!=null && magia.getNombre()=="Super Misil"){
			magia.efecto(this);
		}
		gun.disparar(pos.x+(width/2)-4,pos.y-30);
		
	}

	public void aumentarScore(int n){
		score += n;
	}
	
	public int getScore(){
		return score;
	}
	

	public void serAtacado(Disparo dis){
		dis.atacarNave(this);
	}

	
	public void morir(){
		Juego.instancia().perder();
	}

	public void setMejora(PowerUp pu){
		mejora=pu;
		Juego.instancia().setMejora(pu.getNombre());
	}
	
	public void setMagia(PowerUp pu){
			magia=pu;
			if(magia==null)
				Juego.instancia().setMagia("Sin magia");
			else
				Juego.instancia().setMagia(pu.getNombre());
	}
	
	public PowerUp getMagia(){
		return magia;
	}

	public PowerUp getMejora(){
		return mejora;
	}
	
}
