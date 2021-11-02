package PowerUps;

import javax.swing.Icon;
import javax.swing.JLabel;

import Jugador.Jugador;

public abstract class PowerUp {
	protected String nombre;
	protected Icon image;
	
	public PowerUp(){
		
	}
	
	public void setNombre(String n){
		nombre=n;
	}
	public  String getNombre(){
		return nombre;
	}
	
	public abstract void efecto(Jugador j);

	public void setImage(Icon i){
		image=i;
	}
	
	public Icon getImage(){
		return image;
	}

}
