package General;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Vector;
import javax.swing.*;
import Disparos.*;
import Enemigos.*;
import GraficaPersonalizada.CustomClass;
import Jugador.*;
import Movimiento.DisparoMovimiento;
import Movimiento.InteligenciaEnemigo;
import Obstaculos.*;
import PowerUps.PowerUp;





public class Juego {
	private static Juego instancia;
	private Jugador jugador;

	private Entidad[] enemigos;
	private Mapa mapa;
	private Obstaculo[] obstaculos;
	private Vector<Obstaculo> ColisionObs;
	private JLabel score;
	private Collection<Disparo> disparos;
	private Vector<Entidad> personajes;
	private DisparoFactoryMethod disparoFactory;
	private String estado;
	private int cantidadEnemigos;
	private JLabel vida;
	private Vector<PowerUp> powers;
	private JLabel nivel;
	private JLabel nivelMuestra;
	private JLabel magiaActual;
	private JLabel mejoraActual;

	
	public Juego(Mapa m){
		estado = "Jugando";
		mapa = m;

		personajes= new Vector<Entidad>();
		ColisionObs= new Vector<Obstaculo>();
		nivel=new JLabel();
		
		agregarJugador();
		
		agregarScore();
		
		agregarVida();

		agregarObstaculos();
		
		agregarNivel();
		
		agregarMejora();
		
		agregarMagia();
		
		agregarEnemigos(1);

		disparos= new Vector<Disparo>();
		disparoFactory = new DisparoFactory();
		DisparoMovimiento.getInstance().agregarVectores(personajes);
		DisparoMovimiento.getInstance().agregarVectorObs(ColisionObs);

	}

		private void agregarJugador(){
			jugador = new Jugador(15, 120, 335);
			mapa.add(jugador.getGrafico());
			if(jugador==null)
				System.out.println("Vacio loco");
			else
				personajes.add(jugador);
		}

		private void agregarScore(){
			score = new JLabel();
			score.setText("Score: " +jugador.getScore());
			score.setBounds(0, 395, 128, 16);
			score.setVisible(true);
			score.setForeground(Color.YELLOW);
			Font fuente = new Font("Arial", Font.BOLD,16);
			score.setFont(fuente);
			mapa.add(score);
		}
		
		private void agregarNivel(){
			nivelMuestra = new JLabel();
			nivelMuestra.setText("Nivel 1");
			nivelMuestra.setBounds(230, 15, 128, 16);
			nivelMuestra.setVisible(true);
			nivelMuestra.setForeground(Color.BLUE);
			Font fuente = new Font("Arial", Font.BOLD,16);
			nivelMuestra.setFont(fuente);
			mapa.add(nivelMuestra);
		
		}
		
		private void agregarMejora(){
			mejoraActual = new JLabel();
			mejoraActual .setBounds(180, 315, 128, 16);
			mejoraActual .setVisible(true);
			mejoraActual .setForeground(Color.RED);
			Font fuente = new Font("Arial", Font.BOLD,16);
			mejoraActual .setFont(fuente);
			mapa.add(mejoraActual );
			if(jugador.getMejora()!=null){
				mejoraActual .setText("Mejora Actual: "+jugador.getMejora().getNombre());
				if(jugador.getMagia()==null)
					magiaActual .setText("Sin magia ");
			}
			else
					mejoraActual .setText("Sin mejora");
		}
		
		private void agregarMagia(){
			magiaActual = new JLabel();
			magiaActual .setVisible(true);
			magiaActual .setBounds(180, 335, 128, 16);
			magiaActual .setVisible(true);
			magiaActual .setForeground(Color.RED);
			Font fuente = new Font("Arial", Font.BOLD,16);
			magiaActual .setFont(fuente);
			mapa.add(magiaActual );
			if(jugador.getMagia()!=null){
				magiaActual .setText("Magia Actual: "+jugador.getMagia().getNombre());
				if(jugador.getMagia()==null)
					mejoraActual .setText("Sin mejora");
			}
			else
				magiaActual .setText("Sin magia");
		}
		
		private void agregarVida(){
			vida = new JLabel();
			vida.setText("Vida: "+jugador.getVida());
			vida.setBounds(0, 305, 108, 160);
			vida.setVisible(true);
			vida.setForeground(Color.RED);
			Font fuente = new Font("Arial", Font.BOLD,16);
			vida.setFont(fuente);
			mapa.add(vida);
		}

		private void agregarObstaculos(){
			obstaculos = new Obstaculo[4];
			Random r = new Random();
			for(int i=0 ; i<obstaculos.length;i++){
				int y= r.nextInt(70)+240;
				int x = r.nextInt(180)+20;
				int n= r.nextInt(2);
				if(n==0)
					obstaculos[i]=new ObstaculoEnemigo(0,x,y);
				if(n==1)
					obstaculos[i]=new ObstaculoJugador(0,x,y);
				mapa.add(obstaculos[i].getGrafico());
				ColisionObs.add(obstaculos[i]);
			}
		}

		public void agregarEnemigos(int j){
			if (j == 2){
				enemigos= new Enemigo[7];
				nivel.setText("NIVEL 2");
				for(int i = 0; i<enemigos.length-3;i++){
					enemigos[i] = new Normal(15, 10 + (i * 35), 10);
					mapa.add(enemigos[i].getGrafico());
					personajes.add(enemigos[i]);
					cantidadEnemigos++;
					
				}
				enemigos[4] = new Randoms(15,50,150);
				mapa.add(enemigos[4].getGrafico());
				personajes.add(enemigos[4]);
				enemigos[5] = new Buscador(15,150,150);
				mapa.add(enemigos[5].getGrafico());
				personajes.add(enemigos[5]);
				enemigos[6] = new Mareado(15,100,200);
				mapa.add(enemigos[6].getGrafico());
				personajes.add(enemigos[6]);
				cantidadEnemigos+=3;
			}
			else if (j == 1){
				enemigos= new Enemigo[7];
				nivel.setText("NIVEL 1");
				for(int i=0; i<enemigos.length-1;i++){
					enemigos[i] = new Normal(15, 10 + (i * 35), 10);
					mapa.add(enemigos[i].getGrafico());
					personajes.add(enemigos[i]);
					cantidadEnemigos++;
				}
				enemigos[6] = new Randoms(15,100,200);
				mapa.add(enemigos[6].getGrafico());
				personajes.add(enemigos[6]);
				cantidadEnemigos++;
			}
		}


	public static Juego instancia() {
		assert instancia!=null;
		return instancia;
	}

	public static void inicializar(Mapa mapa) {
		instancia = new Juego(mapa);
	}
	

	public void moverJ(int dir){		
		int direccion = 0;
		
		switch (dir){
			case KeyEvent.VK_LEFT : //Izquierda
				direccion = 1;
				break;
			case KeyEvent.VK_RIGHT : //Derecha
				direccion = 2;
				break;
		}
		if(direccion==0){
			return;
		}
		jugador.mover(direccion);
	}
	
	public void teclaEliminarEnemigo(int n){
		boolean encontro = false;
		for(int i=0; i<enemigos.length&&!encontro; i++){
			if(enemigos[i]!=null){
				mapa.remove(enemigos[i].getGrafico());
				jugador.aumentarScore(enemigos[i].getPuntaje());
				score.setText("Score: " +jugador.getScore());
				mapa.getContentPane().repaint();
				enemigos[i] = null;
				encontro = true;
			}
		}
	}

	public void moverEnemigos(){
		for(int i = 0; i < enemigos.length; i++){
			Random r = new Random();
			int dir = r.nextInt(4);
			if(enemigos[i]!=null)
				enemigos[i].mover(dir);
		}
	}
	
	public Jugador getJugador(){
		return jugador;
	}
	
	public Entidad[] getEnemigos(){
		return enemigos;
	}
	
	public Entidad obtenerEnemigoEnPosicion(int d){
		return enemigos[d];
	}
	
	public Entidad[] getObstaculos(){
		return obstaculos;
	}
	
	public Vector<Obstaculo> getColObstaculos(){
		return ColisionObs;
	}
	
	public void agregarAlgo(JComponent component){
		mapa.add(component);
		mapa.getContentPane().repaint();
	}

	public void borrarAlgo(JComponent component){
		mapa.remove(component);
		mapa.getContentPane().repaint();
	}
	
	public void borrarDisparo(Disparo d){
		disparos.remove(d);
		mapa.remove(d.getGrafico());
		mapa.getContentPane().repaint();
	}
	
	public void borrarEnemigo(Enemigo e){
		personajes.remove(e);
		mapa.remove(e.getGrafico());
		mapa.getContentPane().repaint();
	}
	
	public void agregarEnemigoPantalla(Enemigo e){
		personajes.add(e);
		mapa.add(e.getGrafico());
		mapa.getContentPane().repaint();
	}

	public void dispararJugador(){
		Disparo d = disparoFactory.crearDisparo(jugador);
		jugador.disparar(d);
		mapa.add(jugador.getDisparo().getGrafico());
		disparos.add(d);
	}
	
	public void dispararEnemigo(Enemigo e){
		Disparo d = disparoFactory.crearDisparo(e);
		e.disparar(d);		
		mapa.add(e.getDisparo().getGrafico());
		disparos.add(d);
	}
	
	public void eliminarEnemigo(Enemigo e){
		borrarAlgo(e.getGrafico());
		jugador.aumentarScore(e.getPuntaje());
		actualizarPantalla();
		boolean encontre=false;
		for(int i=0; i<enemigos.length && !encontre;i++){
			if(enemigos[i]==e){
				encontre=true;
				enemigos[i]=null;
			}
		}
		personajes.remove(e);
		cantidadEnemigos--;
		verificarVictoria();
	}
	
	public void verificarVictoria(){
		if(cantidadEnemigos==0 && nivel.getText()=="NIVEL 1"){
			System.out.println("Has terminado el nivel.");
			setNivel("NIVEL 2");
			nivelMuestra.setText("Nivel 2");
			agregarEnemigos(2);
			agregarObstaculos();
		}
		if(cantidadEnemigos==0 && nivel.getText()=="NIVEL 2"){
			estado="Victoria";
			System.out.println("¡Has ganado la partida!");
			mapa.pantallaGanar();
		}
	}
	
	public void perder(){
		estado = "Perder";
		System.out.println("Has perdido la partida");
		borrarAlgo(jugador.getGrafico());
		personajes.remove(jugador);
		mapa.pantallaPerder();
	}
	
	public String getEstado(){
		return estado;
	}
	
	public void actualizarPantalla(){
		score.setText("Score: " +jugador.getScore());
		vida.setText("Vida: " +jugador.getVida());
		mapa.getContentPane().repaint();
	}
	
	public void setNivel(String s){
		nivel.setText(s);
				
	}
	
	public String getNivel(){
		return nivel.getText();
	}
	
	public void setMejora(String s){
		mejoraActual.setText(s);
	}
	
	public void setMagia(String s){
		magiaActual.setText(s);
	}
	
	
}

