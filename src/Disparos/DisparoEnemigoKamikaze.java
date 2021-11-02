package Disparos;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Enemigos.*;
import General.Juego;
import Jugador.Jugador;
import Movimiento.DisparoMovimiento;
import Obstaculos.Obstaculo;
import PowerUps.PowerUp;

public class DisparoEnemigoKamikaze extends DisparoEnemigo{
	protected int width = 64;
	protected int height = 33;
	protected int velocidad = 25; // TODO: volver a poner esto
	private int velocidadx;
	private int velocidady;
	private boolean onBorder = false;
	
	public DisparoEnemigoKamikaze(){
		super();
		image = new ImageIcon(this.getClass().getResource("/Valhalliconos/Buscador.png"));
		pos = new Point(0,0);
		setWidth(width);
		setHeight(height);
		setVelocidad(velocidad);
		danio = 2;
		setAtaco(false);
	}
	
	public void disparar(int x, int y, int posx, int posy){
		pos.x = x;
		pos.y = y;
		velocidadx = (int) (pos.x-posx)/velocidad;
		velocidady = (int) (pos.y-posy)/velocidad;
		getGrafico().setBounds(x,y, width, height);
		DisparoMovimiento.getInstance().agregarDisparo(this);
	}
	
	public void refrescar(){
		if(onBorder) return;
		
		pos.setLocation((int)pos.x-(velocidadx), (int)pos.y-(velocidady));
		getGrafico().setBounds(pos.x, pos.y, width, height);
		if(pos.y>365){
			getGrafico().setBounds(0,0,0,0);
			onBorder = true;
			return;
		}
		onBorder = false;
	}
	
	  public boolean onBorder() {
	        return onBorder;
	    }	  
	  
	  public void atacarNave(Jugador e){
			DisparoMovimiento.getInstance().borrarDisparo(this);
			DisparoMovimiento.getInstance().borrarDisparo(this);
			setAtaco(true);
			proviene.setAtacando(false);
			if(e.getMejora()!=null && e.getMejora().getNombre()=="Campo Kamikaze"){
				Juego.instancia().borrarDisparo(this);
				proviene.morir();
			}else{
				e.setVida(e.getVida()-danio);
				if(e.getVida()<0)
					e.setVida(0);
					System.out.println("El daño es " + danio);
					System.out.println("La vida del jugador es " + e.getVida());
					if(e.getVida()<=0)
						e.morir();
					Juego.instancia().borrarDisparo(this);
					Juego.instancia().agregarEnemigoPantalla(proviene);
			}
			Juego.instancia().actualizarPantalla();	
		}
		
		public void atacarObstaculoJugador(Obstaculo o){
			DisparoMovimiento.getInstance().borrarDisparo(this);
			DisparoMovimiento.getInstance().borrarDisparo(this);
			o.setVida(o.getVida()-danio);
			if(o.getVida()<0)
				o.setVida(0);
			setAtaco(true);
			System.out.println("El jugador metió " + danio + " de daño");
			System.out.println("La vida del obstáculo es " + o.getVida());
			if(o.getVida()<=0)
				o.morirObs();
			Juego.instancia().borrarDisparo(this);
			Juego.instancia().agregarEnemigoPantalla(proviene);
			proviene.setAtacando(false);
		}
	  
		public void borrar(){
			Juego.instancia().borrarDisparo(this);
			if(onBorder)
				Juego.instancia().agregarEnemigoPantalla(proviene);
			proviene.setAtacando(false);
		}
}
