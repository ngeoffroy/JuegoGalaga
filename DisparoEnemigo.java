package Disparos;

import javax.swing.*;
import java.awt.*;

import General.Entidad;
import Jugador.Jugador;
import Movimiento.DisparoMovimiento;
import Colisiones.*;
import Obstaculos.*;
import Enemigos.*;
import Visitor.*;
import General.*;



public class DisparoEnemigo extends Disparo {

	protected static Icon image; // flyweight de bajo presupuesto
	protected Visitor miVisitor;

	public void disparar(Disparo d){
		miVisitor = new VisitorDisparoEnemigo(this);
	}
	
    public DisparoEnemigo(){
		miVisitor = new VisitorDisparoEnemigo(this);
	}

	public void reporteDeColisionCon(TieneCajita otro) {
		otro.entidad().accept(miVisitor);
	}

	public Entidad entidad() {
		return this;
	}




    protected Icon image() {
        return image;
    }

    public void atacarEnemigo(Enemigo j){

	}
	
	public void atacarNave(Jugador e){
		e.setVida(e.getVida()-danio);
	}
	
	public void atacarObstaculo(Obstaculo o){
		o.setVida(o.getVida()-danio);
	}

	public void serAtacado(Disparo d) {

	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public void refrescar() {	}

	public boolean onBorder() {
		return false;
	}

	public void disparar(int x, int y) {	}

	public void disparar(int x, int y, int posx, int posy) {	}
}

