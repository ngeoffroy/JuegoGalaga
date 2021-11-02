package Disparos;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;
import General.*;
import Enemigos.*;
import Obstaculos.*;
import PowerUps.PowerUp;
import Jugador.*;



public abstract class Disparo{


	protected int danio;
	protected JLabel grafico;
	protected int width;
	protected int height;
	protected int velocidad;
	protected Point pos;
	protected boolean ataco;
	protected Enemigo proviene;

	public Disparo() {
	}

	public void borrar(){
		Juego.instancia().borrarDisparo(this);
	}

	public void setDanio(int a){
		danio=a;
	}
	
	public void setWidth(int x){
		width=x;
	}
	
	public int getDanio(){
		return danio;
	}
	
	public int getWidth(){
		return width;
	}
	

	public int getVelocidad() {
		return velocidad;
	}

	public Point getPos() {
		return pos;
	}
	
	public int getHight(){
		return height;
	}
	
	public void setHeight(int n){
		height = n;
	}
	
	public void setVelocidad(int n){
		velocidad = n;
	}
	
	public void setAtaco(boolean b){
		ataco=b;
	}

	public boolean getAtaco(){
		return ataco;
	}
	

	public abstract void refrescar();

	public abstract boolean onBorder();
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(image());

    
		}
		return this.grafico;
	}

	protected abstract Icon image();

	protected void cambiarGrafico(){
		if(this.grafico != null){
			this.grafico.setIcon(this.image());
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
	}
	
	public  Enemigo getProviene(){
		return proviene;
	}
	public void setProviene(Enemigo e){
		proviene=e;
	}
	
	public abstract void disparar(int x, int y);
	public abstract void disparar(int x, int y, int posx, int posy);
	public abstract void atacarNave(Jugador j);
	public abstract void atacarEnemigo(Enemigo e);
	public abstract void atacarObstaculoJugador(Obstaculo o);
	public abstract void atacarObstaculoEnemigo(Obstaculo o);

}
