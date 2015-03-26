package DomaineVoiture;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestVoiture {
	
	private Voiture maVoiture;
	
	@Before
	public void setUp(){
		maVoiture = new Voiture (100, 0, 10, 0);
	}
	
	@Test
	public void  testEvolutionXenFonctionVitesseSurUnTopSeconde() {
		
		maVoiture.miseAJourPosition();
		
		assertEquals(110, maVoiture.getX());
	}
	
	@Test
	public void testAcceleration(){
		
		maVoiture.accelerer();
		
		assertEquals(20, maVoiture.getVitesse());
	}
	
	@Test
	public void testAccelerationLimite() {
		
		maVoiture.setVitesse(100);
		maVoiture.accelerer();
		assertEquals(100, maVoiture.getVitesse());
		
	}

	@Test
	public void testChangementDeSens() {
		
		maVoiture.setDirection(0);
		maVoiture.inverserDirection();
		assertEquals(180, maVoiture.getDirection());
		
	}
	
	@Test
	public void testChangementDeSensEtEvolutionDeX() {
		
		maVoiture.setDirection(0);
		maVoiture.inverserDirection();
		maVoiture.miseAJourPosition();
		assertEquals(90, maVoiture.getX());
		
	}
	
	@Test
	public void testPositionLimiteHaute() {
		
		maVoiture.setVitesse(1000);
		maVoiture.miseAJourPosition();
		assertEquals(1000, maVoiture.getX());
		
	}
	
	@Test
	public void testPositionLimiteBasse() {
		
		maVoiture.setVitesse(1000);
		maVoiture.inverserDirection();
		maVoiture.miseAJourPosition();
		assertEquals(0, maVoiture.getX());
		
	}

    @Test
    public void testBase2D() {

        assertEquals(0, maVoiture.getDirection());

    }

    @Test
    public void testTournerDroite() {

        maVoiture.tournerDroite();
        assertEquals(10, maVoiture.getDirection());

    }

    @Test
    public void testTournerGauche() {
        maVoiture.tournerGauche();
        assertEquals(350, maVoiture.getDirection());
    }

    @Test
    public void testAvancerAngle() {
        maVoiture.setDirection(30);
        int x = (int) (maVoiture.getVitesse() * Math.cos(Math.PI/6));
        int y = (int) (maVoiture.getVitesse() * Math.sin(Math.PI/6));
        x+=maVoiture.getX();
        y+=maVoiture.getY();
        maVoiture.miseAJourPosition();
        assertEquals(x, maVoiture.getX());
        assertEquals(y, maVoiture.getY());
    }

    @Test
    public void coordinatesToTriangle() {
       assertTrue(true);

    }
}
