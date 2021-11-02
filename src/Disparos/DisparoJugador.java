package Disparos;

import java.awt.Point;
import javax.swing.*;

import Movimiento.*;
import Jugador.*;
import Enemigos.*;
import Obstaculos.*;
import PowerUps.PowerUp;
import General.*;


public class DisparoJugador extends Disparo{
	protected int width = 9;
	protected int height = 34;
	protected int velocidad = 15; // TODO: volver a poner esto
	private boolean onBorder = false;
	protected static Icon image; // interactiveSight de sombrerito y gambeta

	public void disparar(Disparo d){}
	
    public DisparoJugador(){
        image = new ImageIcon(this.getClass().getResource("/Valhalliconos/Disparo.png"));
		pos = new Point(0,0);
		setWidth(width);
		setHeight(height);
		setVelocidad(velocidad);
		danio = 2;
	}
	
	public void disparar(int x, int y) {
		pos.x = x;
		pos.y = y;
		getGrafico().setBounds(x,y, width, height);
		DisparoMovimiento.getInstance().agregarDisparo(this);
	}

	public void refrescar(){
		if(onBorder) return;
		pos.setLocation(pos.x, pos.y - velocidad);
		getGrafico().setBounds(pos.x,pos.y, width, height);

		if(pos.y<-15){
			getGrafico().setBounds(0,0,0,0);
			onBorder = true;
			return;
		}
		onBorder = false;
	}

	public void setImage(Icon i){
		image=i;
	}
	
	public Icon getImage(){
		return image;
	}
	
    public boolean onBorder() {
        return onBorder;
    }


    public void atacarNave(Jugador j){

	}
	
	public void atacarEnemigo(Enemigo e){
		if(getAtaco()==false&&!(e.getAtacando())){
			borrar();
			e.setVida(e.getVida()-danio);
			if(e.getVida()<0)
				e.setVida(0);
			e.estrategia();
			setAtaco(true);
			System.out.println("El jugador metió " + danio + " de daño");
			System.out.println("La vida del enemigo es " + e.getVida());
			if(e.getVida()<=0)
				e.morir();
		}
	}
	
	public void atacarObstaculoEnemigo(Obstaculo o){
		DisparoMovimiento.getInstance().borrarDisparo(this);
		borrar();
		o.setVida(o.getVida()-danio);
		if(o.getVida()<0)
			o.setVida(0);
		setAtaco(true);
		System.out.println("El jugador metió " + danio + " de daño");
		System.out.println("La vida del obstáculo es " + o.getVida());
		if(o.getVida()<=0)
			o.morirObs();
	}
	
	public void atacarObstaculoJugador(Obstaculo o){
		DisparoMovimiento.getInstance().borrarDisparo(this);
		borrar();
		o.setVida(o.getVida()-danio);
		if(o.getVida()<0)
			o.setVida(0);
		setAtaco(true);
		System.out.println("El jugador metió " + danio + " de daño");
		System.out.println("La vida del obstáculo es " + o.getVida());
		if(o.getVida()<=0)
			o.morirObs();
	}

	public void serAtacado(Disparo d) {

	}


	public void disparar(int x, int y, int posx, int posy) {	}

	@Override
	protected Icon image() {
		// TODO Auto-generated method stub
		return image;
	}

	

}
