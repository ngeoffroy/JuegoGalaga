package Disparos;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Movimiento.DisparoMovimiento;

public class DisparoEnemigoNormal extends DisparoEnemigo {
	protected int width = 11;
	protected int height = 11;
	protected int velocidad = 5; // TODO: volver a poner esto
	private boolean onBorder = false;
	
	public DisparoEnemigoNormal(){
		super();
        image = new ImageIcon(this.getClass().getResource("/Valhalliconos/Disparo enemigo.png"));
		pos = new Point(0,0);
		setWidth(width);
		setHeight(height);
		setVelocidad(velocidad);
		danio = 2;
		setAtaco(false);
	}
	
	public void disparar(int x, int y){
		pos.x = x;
		pos.y = y;
		getGrafico().setBounds(x,y, width, height);
		DisparoMovimiento.getInstance().agregarDisparo(this);
	}
	
	public void refrescar(){
		if(onBorder) return;
		pos.setLocation(pos.x, pos.y + velocidad);
		getGrafico().setBounds(pos.x,pos.y, width, height);
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
	
	  
	  
}
