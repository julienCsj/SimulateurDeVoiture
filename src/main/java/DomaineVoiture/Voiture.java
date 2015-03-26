package DomaineVoiture;

import java.util.Observable;

public class Voiture extends Observable {

	private int x;
	private int y;
	private int vitesseMetreSeconde;
	private int directionEnDegres;

	public Voiture(int x, int y, int vitesse, int direction) {
		this.x = x;
		this.y = y;
		this.vitesseMetreSeconde = vitesse;
        this.directionEnDegres = direction;
	}

	public void miseAJourPosition() {
		miseAJourPositionX();
		notificationObservateur();
	}

	private void miseAJourPositionX() {

        if(directionEnDegres > 0 && directionEnDegres < 180) {
            y+= vitesseMetreSeconde * Math.sin(Math.toRadians(getDirection()));
        }

        if(directionEnDegres > 90 && directionEnDegres < 270) {
            x+= vitesseMetreSeconde * Math.cos(Math.toRadians(getDirection()));;
        }

        if((directionEnDegres > 270 && directionEnDegres <= 359)
                || (directionEnDegres < 90 && directionEnDegres >= 0)) {
            x+=vitesseMetreSeconde * Math.cos(Math.toRadians(getDirection()));;
        }

        if(directionEnDegres > 180 && directionEnDegres <= 359) {
            y+= vitesseMetreSeconde * Math.sin(Math.toRadians(getDirection()));;
        }

		if (x > 1000)
			x = 1000;
		else if (x < 0)
			x = 0;
	}

	private void notificationObservateur() {
		this.setChanged();
		this.notifyObservers();
	}

	public int getX() {
		return x;
	}
    public int getY() {
        return y;
    }

    public void accelerer() {
		if (vitesseMetreSeconde < 100)
			vitesseMetreSeconde += 10;	
	}

	public int getVitesse() {
		return vitesseMetreSeconde;
	}

	public void setVitesse(int vitesse) {
		vitesseMetreSeconde = vitesse;
	}

	public void setDirection(int angleDirection) {
		this.directionEnDegres = angleDirection;
		
	}

	public void inverserDirection() {
		directionEnDegres +=180 ;
		directionEnDegres = directionEnDegres % 360;
		
	}

    public void tournerGauche() {
        setDirection((directionEnDegres+360-10)%360);
    }

    public void tournerDroite() {
        setDirection((directionEnDegres+10)%360);
    }

	public int getDirection() {
	return directionEnDegres;
	}

}
