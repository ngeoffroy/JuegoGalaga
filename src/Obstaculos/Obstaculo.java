package Obstaculos;
import General.*;
public abstract class Obstaculo extends Entidad{

	protected boolean esta_roto;
	protected final int width = 64;
	protected final int height = 26;
	protected int vida;

	
	public Obstaculo(int v, int x, int y){
			super(0, x, y);
			super.setWidth(width);
			super.setHeight(height);
			esta_roto = false;	
		}
	
	public boolean getEstaRoto(){
		return esta_roto;
	}
	
	public void setEstaRoto(boolean b){
		esta_roto = b;
	}
	
	public void morirObs(){
		Juego.instancia().borrarAlgo(this.getGrafico());
		Juego.instancia().getColObstaculos().remove(this);
		Juego.instancia().actualizarPantalla();
	}


}
