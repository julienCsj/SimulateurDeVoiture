package AppliSimu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import DomaineVoiture.Voiture;

public class IHMVoiture extends JFrame implements Observer{

	private double paramatreConversionMetresPixels = 0.5;
	private Voiture maVoiture;
	private CommandeVoiture maCommandeVoiture;
	
	private void initGraphique() {
		this.setTitle("Simulateur de Voiture");
		this.setSize(505, 505);

		this.maCommandeVoiture = new CommandeVoiture(this, maVoiture);

		this.setVisible(true);
	}
	
	public IHMVoiture(Voiture maVoiture) {
		super();
		this.maVoiture = maVoiture;
		maVoiture.addObserver(this);
		initGraphique();
	}

	public IHMVoiture() {
		super();
		initGraphique();
		this.maVoiture = null;
	}
	
	public int calculerPositionPixels(int xMetres) {
		return (int) (paramatreConversionMetresPixels * xMetres);	
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}

	@Override
	public void paint(Graphics contexteGraphique) {
        int xMetres = maVoiture.getX();
        int xPixel = calculerPositionPixels(xMetres);
		super.paint(contexteGraphique);
		contexteGraphique.setColor(Color.red);
		dessinerVoiture(contexteGraphique);
        contexteGraphique.setColor(Color.black);
        dessinerRoute(contexteGraphique);
    }

    private void dessinerRoute(Graphics contexteGraphique) {
        contexteGraphique.drawRect(0, 300-15, (int) this.getSize().getWidth(), 30);
        contexteGraphique.drawRect((int) ((this.getSize().getWidth()/2)-15), 0, 30, (int) this.getSize().getHeight());
    }


    private void dessinerVoiture(Graphics contexteGraphique) {
		int xMetres = maVoiture.getX();
		int xPixel = calculerPositionPixels(xMetres);
        double angle = maVoiture.getDirection() * Math.PI / 180;

        int x1, x2, y1, y2;
        x1 = maVoiture.getX();
        y1 = maVoiture.getY();

        if (angle == 0.0) {
            x2 = x1 + 30;
            y2 = y1 + 30;
        } else {
            x2 = (int) (x1 + 30 * Math.sin(angle));
            y2 = (int) (y1 + 30 * Math.cos(angle));
        }

		contexteGraphique.drawLine(x1, y1, x2, y2);
	}
	
}
