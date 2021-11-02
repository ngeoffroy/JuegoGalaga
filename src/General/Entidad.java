package General;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;
import Disparos.*;


public abstract class Entidad{
	protected JLabel grafico;
	protected Icon image;
	protected int width;
	protected int height;
	protected int velocidad;
	protected Point pos;
	protected int puntaje;
	protected boolean esta_vivo;
	protected Disparo gun;
	protected String tipo;
	protected int daño;
	protected int vida;
	
	public Entidad(int v, int x, int y){
		velocidad = v;
		pos = new Point(x,y);
		esta_vivo = true;
	}

	public int getVelocidad() {
		return velocidad;
	}
	
	public String getTipo(){
		return tipo;
	}

	public Point getPos() {
		return pos;
	}
	
	public void setWidth(int n){
		width = n;
	}
	
	public void setHeight(int n){
		height = n;
	}
	
	public int getDaño(){
		return daño;
	}
	
	public void setDaño(int v){
		daño=v;
	}

	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(image);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		return this.grafico;
	}
	
	protected void cambiarGrafico(int dir){
		if(this.grafico != null){
			this.grafico.setIcon(this.image);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
	}
	
	public void mover(int dir){	
		switch (dir) {
			case 1 : //Izquierda
				pos.setLocation(pos.x - velocidad, pos.y);
				break;
			case 2 : //Derecha
				pos.setLocation(pos.x + velocidad, pos.y);
				break;
		}
		cambiarGrafico(dir);
	}
	
	public Disparo getDisparo(){
		return gun;
	}
	
	public int getPuntaje(){
		return puntaje;
	}
	
	public void setPuntaje(int p){
		puntaje=p;
	}



	public abstract void serAtacado(Disparo d);

    public void setearMuerto(){
        esta_vivo = false;
    }

    public boolean estaVivo(){
        return esta_vivo;
    }
    
    public void setDisparo(Disparo d){
    	gun=d;
    }
 
    public abstract void disparar(Disparo d);
    
    public int getWidth(){
    	return width;
    }
    
    public int getHeigth(){
    	return height;
    }
   
    public void setVida(int a){
    	vida=a;
    	}
    
    public int getVida(){
		return vida;
		}
  
	
}
