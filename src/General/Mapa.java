 package General;

import java.awt.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import Movimiento.*;
import GraficaPersonalizada.*;






public class Mapa extends JFrame{
	
	private Juego j;
	private Movimiento mov;
	private InteligenciaEnemigo i;
	private CustomClass fondo;
	private JPanel pantalla;
	private PantallaPerder perder;
	private PantallaGanar ganar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mapa frame = new Mapa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public Mapa(){
		
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 450);
		//contentPane = new JPanelBackground();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setBackground("/Valhalliconos/Fondo.png");
		fondo= new CustomClass();
		setContentPane(fondo);
		fondo.setLayout(null);
		Juego.inicializar(this);
		j =Juego.instancia();
		mov = new Movimiento(j);
		mov.start();
		i=InteligenciaEnemigo.getInstance();
		
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(Juego.instancia().getEstado()!="Perder"&&Juego.instancia().getEstado()!="Victoria")
					moverJugador(arg0);}
		});
		
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(Juego.instancia().getEstado()!="Perder"&&Juego.instancia().getEstado()!="Victoria")
					if(arg0.getKeyCode()==KeyEvent.VK_SPACE)
						j.dispararJugador();
			}
					
				
		});

	}
	
	protected void moverJugador(KeyEvent key){
		j.moverJ(key.getKeyCode());
		this.repaint();
	}
	
	public void pantallaPerder(){
		perder= new PantallaPerder();
		setContentPane(perder);
		perder.setLayout(null);
		(getContentPane()).revalidate();
		repaint();
	}
	
	public void pantallaGanar(){
		ganar= new PantallaGanar();
		setContentPane(ganar);
		ganar.setLayout(null);
		(getContentPane()).revalidate();
		repaint();
	}
	

	/*protected void teclaEliminarEnemigo(KeyEvent key){
		j.teclaEliminarEnemigo(key.getKeyCode());
	}
	*/
}
