package GraficaPersonalizada;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

//clase necesaria para poner la imagen de fondo (mapita)
public class CustomClass extends JPanel {
	private URL url = getClass().getResource("/Valhalliconos/Fondo.png");
    Image image = new ImageIcon(url).getImage();
    @Override

    public void paint(Graphics g){
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
   
    
}
