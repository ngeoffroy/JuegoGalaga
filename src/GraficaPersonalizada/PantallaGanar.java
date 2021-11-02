package GraficaPersonalizada;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

//clase necesaria para poner la imagen de ganar (mapita)
public class PantallaGanar extends JPanel {
	private URL url = getClass().getResource("/Valhalliconos/Ganar.png");
    Image image = new ImageIcon(url).getImage();

    public void paint(Graphics g){
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
    
}
